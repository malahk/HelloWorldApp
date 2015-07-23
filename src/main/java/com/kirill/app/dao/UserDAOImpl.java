package com.kirill.app.dao;

import com.kirill.app.controllers.MySQLConnector;
import com.kirill.app.models.Address;
import com.kirill.app.models.MusicType;
import com.kirill.app.models.User;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.*;

/**
 * Created by Admin on 08.07.2015.
 */
@Repository
public class UserDAOImpl implements UserDAO
{
    public static final String CREATE_USER = "insert users set firstName = ?, lastName = ?, age = ?, login = ?," +
//            " password = ?, role_id = ? ";
            " password = ?";
    public static final String GET_ALL = "select * from users";
    public static final String GET_BY_ID = "select * from users where id = ?";
    public static final String GET_BY_LOGIN = "select * from users where login = ?";
    public static final String UPDATE_USER = "update users set firstName = ?, lastName = ?, age = ?, login = ?," +
            " password = ?, role_id = ? where id = ?";
    public static final String DELETE_USER = "delete from users where id = ?";
    public static final String DELETE_MUSIC_TYPE = "DELETE FROM user_music_type WHERE user_id = ?" +
            " AND user_music_type_id = ?";
    public static final String APPEND_MUSIC_TYPE = "INSERT user_music_type SET user_id = ?, user_music_type_id = ?";

    private static Connection connection;
    private AddressDAOImpl addressImpl;
    private static RoleDAOImpl roleImpl;
    private static MusicTypeDAOImpl musicImpl;

    public UserDAOImpl () {
        connection = MySQLConnector.getConn();
        addressImpl = new AddressDAOImpl();
        roleImpl = new RoleDAOImpl();
        musicImpl = new MusicTypeDAOImpl();
    }

    @Override
    public boolean create(User user) {

        boolean result = false;

        try {

            PreparedStatement createUser = connection.prepareStatement(CREATE_USER, Statement.RETURN_GENERATED_KEYS);
            createUser.setString(1, user.getFirstName());
            createUser.setString(2, user.getLastName());
            createUser.setInt(3, user.getAge());
            createUser.setString(4, user.getLogin());
            createUser.setString(5, user.getPassword());
            //TODO fix role id
//            createUser.setInt(6, user.getRole().getId());

            //TODO В адрес нужно вначале ид юзера проставить
            if(user.getAddress()!= null){
                addressImpl.create(user.getAddress());
            }

            result = createUser.execute();

            ResultSet createdUsersRS = createUser.getGeneratedKeys();
            while (createdUsersRS.next()) {
                user.setId(createdUsersRS.getInt(1));

            }

            createUser.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public List<User> getAll()
    {
        ArrayList<User> usersList = new ArrayList<User>();
        try {
            Statement getAll  = connection.createStatement();
            ResultSet allRS = getAll.executeQuery(GET_ALL);

            while (allRS.next()) {
                User user = new User();

                Integer id = allRS.getInt(1);
                String firstName = allRS.getString(2);
                String lastName = allRS.getString(3);
                String login = allRS.getString(4);
                String password = allRS.getString(5);
                //TODO fix age
//                Integer age = allRS.getInt(6);

                user.setId(id);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setLogin(login);
                user.setPassword(password);
//                user.setAge(age);

                user.setRole(roleImpl.getRole(allRS.getInt(7)));
                Address address = addressImpl.getAddress(id);
                if (address != null) {
                    user.setAddress(address);
                }
                user.setMusicTypes(new HashSet<MusicType>(musicImpl.getByUser(user)));

                usersList.add(user);
            }

            getAll.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return usersList;
    }

    @Override
    public User getUser(Integer id)
    {
        try
        {
            PreparedStatement getById = connection.prepareStatement(GET_BY_ID);
            getById.setInt(1, id);

            ResultSet getUserRS = getById.executeQuery();
            User user = null;
            while (getUserRS.next())
            {
                user = new User();

                String firstName = getUserRS.getString(2);
                String lastName = getUserRS.getString(3);
                String login = getUserRS.getString(4);
                String password = getUserRS.getString(5);
                Integer age = getUserRS.getInt(6);

                user.setId(id);
                user.setFirstName(firstName);
                user.setLastName(lastName);
                user.setAge(age);
                user.setLogin(login);
                user.setPassword(password);
                user.setRole(roleImpl.getRole(id));
                //TODO row 152
                Address address = addressImpl.getAddress(id);
                if (address != null) {
                    user.setAddress(address);
                }
                user.setMusicTypes(musicImpl.getByUser(user));
            }
            getById.close();
            return user;
        } catch (SQLException e){
            e.printStackTrace();
        }

        return null;
    }

    @Override
    //TODO fix update
    public boolean update(User user)
    {
        boolean result = false;

        try
        {
            PreparedStatement updateUser = connection.prepareStatement(UPDATE_USER);
            updateUser.setString(1, user.getFirstName());
            updateUser.setString(2, user.getLastName());
            updateUser.setInt(3, user.getAge());
            updateUser.setString(4, user.getLogin());
            updateUser.setString(5, user.getPassword());
            updateUser.setInt(6, user.getRole().getId());
            updateUser.setInt(7, user.getId());

            if (user.getAddress() != null) {
                addressImpl.update(user.getAddress());
            }

            result = updateUser.execute();

            // update music types
            Set<MusicType> oldMusic = musicImpl.getByUser(user);
            for(MusicType mt : oldMusic) {
                if (user.getMusicTypes().contains(mt)) {
                    continue;
                }

                PreparedStatement deleteMusicType = connection.prepareStatement(DELETE_MUSIC_TYPE);
                deleteMusicType.setInt(1, user.getId());
                deleteMusicType.setInt(2, mt.getId());
                deleteMusicType.execute();
            }
            for(MusicType mt : user.getMusicTypes()) {
                if (oldMusic.contains(mt)) {
                    continue;
                }

                PreparedStatement appendMusicType = connection.prepareStatement(APPEND_MUSIC_TYPE);
                appendMusicType.setInt(1, user.getId());
                appendMusicType.setInt(2, mt.getId());
                appendMusicType.execute();
            }
            updateUser.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean delete(User user) {

        boolean result = false;

        try {

            PreparedStatement deleteUser = connection.prepareStatement(DELETE_USER);
            deleteUser.setInt(1, user.getId());

            if (user.getAddress() != null) {
                addressImpl.delete(user.getAddress());
            }

            for(MusicType mt : user.getMusicTypes()) {

                PreparedStatement deleteMusicType = connection.prepareStatement(DELETE_MUSIC_TYPE);
                deleteMusicType.setInt(1, user.getId());
                deleteMusicType.setInt(2, mt.getId());
                deleteMusicType.execute();
            }

            result = deleteUser.execute();
            deleteUser.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

	public User getByLogin(String login) {

		User user = null;
		try {

			PreparedStatement getByLogin = connection
					.prepareStatement(GET_BY_LOGIN);
			getByLogin.setString(1, login);

			ResultSet getUserRS = getByLogin.executeQuery();
			while (getUserRS.next()) {

				user = new User();

				String password = getUserRS.getString(2);

				user.setLogin(login);
				user.setPassword(password);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
	}

}

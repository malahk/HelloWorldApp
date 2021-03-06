package com.kirill.app.dao;

import com.kirill.app.controllers.MySQLConnector;
import com.kirill.app.models.Role;
import com.kirill.app.models.Roles;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Admin on 08.07.2015.
 */
@Repository
public class RoleDAOImpl implements RoleDAO {

    public static final String CREATE_ROLE = "insert role set id = ?, role_name = ?";
    public static final String GET_ALL = "select * from role";
    public static final String GET_BY_ID = "select * from role where id = ?";
    public static final String GET_BY_ROLE = "select * from role where role_name = ?";
    public static final String UPDATE_ROLE = "update role set role_name = ? where id = ?";
    public static final String DELETE_ROLE = "delete from role where id = ?";

    private static Connection connection;

    public RoleDAOImpl () {
        connection = MySQLConnector.getConn();
    }

    @Override
    public boolean create(Role role) {

        boolean result = false;

        try {
            PreparedStatement createRole = connection.prepareStatement(CREATE_ROLE, Statement.RETURN_GENERATED_KEYS);
            createRole.setInt(1, role.getId());
            createRole.setString(2, role.getRoleName());

            result = createRole.execute();

            ResultSet createdRolesRS = createRole.getGeneratedKeys();
            createdRolesRS.next();
            role.setId(createdRolesRS.getInt(1));
            createRole.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Role> getAll()
    {
        ArrayList<Role> rolesList = new ArrayList<Role>();
        try
        {
            Statement getAll  = connection.createStatement();
            ResultSet allRolesRS = getAll.executeQuery(GET_ALL);
            Role role;

            while (allRolesRS.next())
            {
                role = new Role();

                Integer id = allRolesRS.getInt(1);
                String roleName = allRolesRS.getString(2);

                role.setId(id);
                role.setRoleName(roleName);

                rolesList.add(role);
            }
        getAll.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return rolesList;
    }

    @Override
    public Role getRole(Integer id)
    {
        Role role = new Role();
        try {
            PreparedStatement getById = connection.prepareStatement(GET_BY_ID);
            getById.setInt(1, id);
            ResultSet getRoleRS = getById.executeQuery();

            while (getRoleRS.next())
            {
                String roleName = getRoleRS.getString(2);
                role.setId(id);
                role.setRoleName(roleName);
            }
             getById.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return role;
    }

    @Override
    public Role getByName(Roles.RoleEnum roleEnum)
    {
        Role role = new Role();
        try {
            PreparedStatement getByName = connection.prepareStatement(GET_BY_ROLE);
            getByName.setString(1, Roles.nameMap().get(roleEnum));
            ResultSet getRoleRS = getByName.executeQuery();

            while (getRoleRS.next())
            {
                String roleName = getRoleRS.getString(2);
                role.setId(getRoleRS.getInt(1));
                role.setRoleName(roleName);
            }
             getByName.close();
        } catch (SQLException e){
            e.printStackTrace();
        }

        return role;
    }

    @Override
    public boolean update(Role role) {
        boolean result = false;

        try {

            PreparedStatement updateRole = connection.prepareStatement(UPDATE_ROLE);
            updateRole.setString(1, role.getRoleName());
            updateRole.setInt(2, role.getId());

            result = updateRole.execute();
            updateRole.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public boolean delete(Role role)
    {
        boolean result = false;

        try {
            PreparedStatement deleteRole = connection.prepareStatement(DELETE_ROLE);
            deleteRole.setInt(1, role.getId());

            result = deleteRole.execute();
            deleteRole.close();

        } catch (SQLException e){
            e.printStackTrace();
        }

        return result;
    }
}

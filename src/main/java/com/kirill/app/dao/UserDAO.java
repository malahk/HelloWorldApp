package com.kirill.app.dao;

import com.kirill.app.models.User;

import java.util.List;

/**
 * Created by Admin on 08.07.2015.
 */
public interface UserDAO {

    boolean create(User user);
    List<User> getAll();
    User getUser(Integer id);
    boolean update(User user);
    boolean delete(User user);
}



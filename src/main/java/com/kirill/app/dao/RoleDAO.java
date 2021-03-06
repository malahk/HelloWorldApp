package com.kirill.app.dao;

import com.kirill.app.models.Role;
import com.kirill.app.models.Roles;

import java.util.List;

/**
 * Created by Admin on 08.07.2015.
 */
public interface RoleDAO {

    boolean create(Role role);
    List<Role> getAll();
    Role getRole(Integer id);
    Role getByName(Roles.RoleEnum roleEnum);
    boolean update(Role role);
    boolean delete(Role role);
}

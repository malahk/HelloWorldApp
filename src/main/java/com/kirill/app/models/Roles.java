package com.kirill.app.models;

import org.springframework.stereotype.Repository;

import java.util.EnumMap;

/**
 * Created by Admin
 *
 * @author Admin
 * @since 28.07.2015
 */
@Repository
public class Roles
{
    public enum  RoleEnum {
        DEFAULT, USER, ADMIN
    }

    public static EnumMap<RoleEnum, String> nameMap()
    {
        EnumMap<RoleEnum, String> roleMap = new EnumMap<RoleEnum, String>(RoleEnum.class);
        roleMap.put(RoleEnum.USER, "user");
        roleMap.put(RoleEnum.DEFAULT, "user");
        roleMap.put(RoleEnum.ADMIN, "admin");

        return roleMap;
    }

    public static Boolean isAdmin(Role role) {
        return role.getRoleName().equalsIgnoreCase(nameMap().get(RoleEnum.ADMIN));
    }

    public static Boolean isUser(Role role) {
        return role.getRoleName().equalsIgnoreCase(nameMap().get(RoleEnum.USER));

    }

}

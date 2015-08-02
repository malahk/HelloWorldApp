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
        DEFAULT, USER, ADMIN, MODERATOR
    }

    public static EnumMap<RoleEnum, String> nameMap()
    {
        EnumMap<RoleEnum, String> roleMap = new EnumMap<RoleEnum, String>(RoleEnum.class);
        roleMap.put(RoleEnum.USER, "ROLE_USER");
        roleMap.put(RoleEnum.DEFAULT, "ROLE_USER");
        roleMap.put(RoleEnum.ADMIN, "ROLE_ADMIN");
        roleMap.put(RoleEnum.MODERATOR, "ROLE_MODERATOR");

        return roleMap;
    }

    public static Boolean isAdmin(Role role) {
        return role.getRoleName().equalsIgnoreCase(nameMap().get(RoleEnum.ADMIN));
    }

    public static Boolean isUser(Role role) {
        return role.getRoleName().equalsIgnoreCase(nameMap().get(RoleEnum.USER));

    }

}

package com.kirill.app.dao;

import com.kirill.app.models.MusicType;
import com.kirill.app.models.User;

import java.util.List;
import java.util.Set;

/**
 * Created by Admin on 08.07.2015.
 */
public interface MusicTypeDAO {

    boolean create(MusicType musicType);
    List<MusicType> getAll();
    Set<MusicType> getByUser(User user);
    MusicType getMusicType(Integer id);
    boolean update(MusicType musicType);
    boolean delete(MusicType musicType);

}

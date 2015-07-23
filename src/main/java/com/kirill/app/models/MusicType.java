package com.kirill.app.models;

/**
 * Created by Admin on 08.07.2015.
 */
public class MusicType {

    private Integer id;
    private String musicGenre;

    public MusicType() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMusicGenre() {
        return musicGenre;
    }

    public void setMusicGenre(String musicGenre) {
        this.musicGenre = musicGenre;
    }

    @Override
    public String toString() {
        return "MusicType{" +
                "id=" + id +
                ", musicGenre='" + musicGenre + '\'' +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result
                + ((musicGenre == null) ? 0 : musicGenre.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MusicType other = (MusicType) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (musicGenre == null) {
            if (other.musicGenre != null)
                return false;
        } else if (!musicGenre.equals(other.musicGenre))
            return false;
        return true;
    }


}


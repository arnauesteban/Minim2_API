package edu.upc.dsa.models;

import java.util.List;

public class User {

    private String username;
    private String avatar;
    private String name;
    private String surname;
    private List<String> badges;

    public User(String username, String avatar, String name, String surname, List<String> badges) {
        this.username = username;
        this.avatar = avatar;
        this.name = name;
        this.surname = surname;
        this.badges = badges;
    }

    public User(){}

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setAvatar(String avatar)
    {
        this.avatar = avatar;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setSurname(String surname)
    {
        this.surname = surname;
    }

    public void setBadges(List<String> badges)
    {
        this.badges = badges;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getAvatar()
    {
        return this.avatar;
    }

    public String getName()
    {
        return this.name;
    }

    public String getSurname()
    {
        return this.surname;
    }

    public List<String> getBadges()
    {
        return this.badges;
    }

}

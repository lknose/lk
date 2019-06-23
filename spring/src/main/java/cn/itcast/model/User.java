package cn.itcast.model;

import java.util.Date;

public class User {
    private String name;
    private String password;
    private Date sr;

    public User() {
    }

    public User(String name, String password, Date sr) {
        this.name = name;
        this.password = password;
        this.sr = sr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getSr() {
        return sr;
    }

    public void setSr(Date sr) {
        this.sr = sr;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", sr=" + sr +
                '}';
    }
}

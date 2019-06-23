package cn.itcast.model;

import java.util.List;

public class User {
    Integer id;
    String name;
    String pasd;
    List<Account> accounts;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasd() {
        return pasd;
    }

    public void setPasd(String pasd) {
        this.pasd = pasd;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pasd='" + pasd + '\'' +
                ", accounts=" + accounts +
                '}';
    }
}

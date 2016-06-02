package org.chance.domain;

/**
 * Created by wqg on 2015/12/10.
 */
public class User {

    long id;
    private String name;

    User() {

    }

    public User(String name) {
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

}

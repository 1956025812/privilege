package com.authorization.privilege.excel;

import java.util.Date;

/**
 * @author qjwyss
 * @date 2019/3/15
 * @description
 */
public class User {

    private String uid;
    private String name;
    private Integer age;
    private Date birthday;

    public User() {
    }

    public User(String uid, String name, Integer age, Date birthday) {
        this.uid = uid;
        this.name = name;
        this.age = age;
        this.birthday = birthday;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}

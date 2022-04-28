package com.zmy.demo.pojo;

import java.util.Date;
import java.util.List;

public class User {
    private Integer uid;

    private String uname;

    private String upassword;

    private List<Role> roles;

    private String urealname;

    private Date uaddtime;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getUname() {
        return uname;
    }

    public void setUname(String uname) {
        this.uname = uname == null ? null : uname.trim();
    }

    public String getUpassword() {
        return upassword;
    }

    public void setUpassword(String upassword) {
        this.upassword = upassword == null ? null : upassword.trim();
    }

    public String getUrealname() {
        return urealname;
    }

    public void setUrealname(String urealname) {
        this.urealname = urealname == null ? null : urealname.trim();
    }

    public Date getUaddtime() {
        return uaddtime;
    }

    public void setUaddtime(Date uaddtime) {
        this.uaddtime = uaddtime;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", uname='" + uname + '\'' +
                ", upassword='" + upassword + '\'' +
                ", roles=" + roles +
                ", urealname='" + urealname + '\'' +
                ", uaddtime=" + uaddtime +
                '}';
    }
}
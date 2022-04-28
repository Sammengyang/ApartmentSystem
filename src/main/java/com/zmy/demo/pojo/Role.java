package com.zmy.demo.pojo;

import java.util.Date;

public class Role {
    private Integer roid;

    private String roname;

    private String rodesc;

    private Date roaddtime;

    public Integer getRoid() {
        return roid;
    }

    public void setRoid(Integer roid) {
        this.roid = roid;
    }

    public String getRoname() {
        return roname;
    }

    public void setRoname(String roname) {
        this.roname = roname == null ? null : roname.trim();
    }

    public String getRodesc() {
        return rodesc;
    }

    public void setRodesc(String rodesc) {
        this.rodesc = rodesc == null ? null : rodesc.trim();
    }

    public Date getRoaddtime() {
        return roaddtime;
    }

    public void setRoaddtime(Date roaddtime) {
        this.roaddtime = roaddtime;
    }
}
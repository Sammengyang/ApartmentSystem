package com.zmy.demo.pojo;

import java.util.Date;

public class Contract {
    private Integer cid;

    private String cnum;

    private Integer chid;

    private Integer clid;

    private Date ctime;

    private Date cstarttime;

    private Date cendtime;

    private Integer ctotalmoney;

    private Integer cpaytype;

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCnum() {
        return cnum;
    }

    public void setCnum(String cnum) {
        this.cnum = cnum == null ? null : cnum.trim();
    }

    public Integer getChid() {
        return chid;
    }

    public void setChid(Integer chid) {
        this.chid = chid;
    }

    public Integer getClid() {
        return clid;
    }

    public void setClid(Integer clid) {
        this.clid = clid;
    }

    public Date getCtime() {
        return ctime;
    }

    public void setCtime(Date ctime) {
        this.ctime = ctime;
    }

    public Date getCstarttime() {
        return cstarttime;
    }

    public void setCstarttime(Date cstarttime) {
        this.cstarttime = cstarttime;
    }

    public Date getCendtime() {
        return cendtime;
    }

    public void setCendtime(Date cendtime) {
        this.cendtime = cendtime;
    }

    public Integer getCtotalmoney() {
        return ctotalmoney;
    }

    public void setCtotalmoney(Integer ctotalmoney) {
        this.ctotalmoney = ctotalmoney;
    }

    public Integer getCpaytype() {
        return cpaytype;
    }

    public void setCpaytype(Integer cpaytype) {
        this.cpaytype = cpaytype;
    }
}
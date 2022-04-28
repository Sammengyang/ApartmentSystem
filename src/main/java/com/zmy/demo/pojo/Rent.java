package com.zmy.demo.pojo;

import java.util.Date;

public class Rent {
    private Integer rid;

    private Integer rhid;

    private Integer rlid;

    private Double rprice;

    private Date rpaytime;

    public Integer getRid() {
        return rid;
    }

    public void setRid(Integer rid) {
        this.rid = rid;
    }

    public Integer getRhid() {
        return rhid;
    }

    public void setRhid(Integer rhid) {
        this.rhid = rhid;
    }

    public Integer getRlid() {
        return rlid;
    }

    public void setRlid(Integer rlid) {
        this.rlid = rlid;
    }

    public Double getRprice() {
        return rprice;
    }

    public void setRprice(Double rprice) {
        this.rprice = rprice;
    }

    public Date getRpaytime() {
        return rpaytime;
    }

    public void setRpaytime(Date rpaytime) {
        this.rpaytime = rpaytime;
    }
}
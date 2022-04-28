package com.zmy.demo.pojo;

import java.util.Date;

public class Lessee {
    private Integer lid;

    private String lname;

    private String ltel;

    private String lsex;

    private String lidcard;

    private String lnativea;

    private Date laddtime;

    private Integer lstatus;

    public Integer getLid() {
        return lid;
    }

    public void setLid(Integer lid) {
        this.lid = lid;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname == null ? null : lname.trim();
    }

    public String getLtel() {
        return ltel;
    }

    public void setLtel(String ltel) {
        this.ltel = ltel == null ? null : ltel.trim();
    }

    public String getLsex() {
        return lsex;
    }

    public void setLsex(String lsex) {
        this.lsex = lsex == null ? null : lsex.trim();
    }

    public String getLidcard() {
        return lidcard;
    }

    public void setLidcard(String lidcard) {
        this.lidcard = lidcard == null ? null : lidcard.trim();
    }

    public String getLnativea() {
        return lnativea;
    }

    public void setLnativea(String lnativea) {
        this.lnativea = lnativea == null ? null : lnativea.trim();
    }

    public Date getLaddtime() {
        return laddtime;
    }

    public void setLaddtime(Date laddtime) {
        this.laddtime = laddtime;
    }

    public Integer getLstatus() {
        return lstatus;
    }

    public void setLstatus(Integer lstatus) {
        this.lstatus = lstatus;
    }
}
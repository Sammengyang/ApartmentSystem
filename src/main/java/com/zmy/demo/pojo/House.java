package com.zmy.demo.pojo;

import java.util.Date;

public class House {
    private Integer hid;

    private String haddress;

    private String hdistrict;

    private Integer hno;

    private String hfloor;

    private Integer hroomnum;

    private String harea;

    private String hdir;

    private String hfurniture;

    private Integer hdeco;

    private Integer hair;

    private Integer hpersonnum;

    private Double hprice;

    private Integer hrentstatus;

    private String himage;

    private String hfulladdress;

    private Date haddtime;

    private Date hupdatetime;

    private Integer hstatus;


    public House(Integer hid, String haddress, String hdistrict, Integer hno, String hfloor, Integer hroomnum, String harea, String hdir, String hfurniture, Integer hdeco, Integer hair, Integer hpersonnum, Double hprice, Integer hrentstatus, String himage, String hfulladdress, Date haddtime, Date hupdatetime, Integer hstatus) {
        this.hid = hid;
        this.haddress = haddress;
        this.hdistrict = hdistrict;
        this.hno = hno;
        this.hfloor = hfloor;
        this.hroomnum = hroomnum;
        this.harea = harea;
        this.hdir = hdir;
        this.hfurniture = hfurniture;
        this.hdeco = hdeco;
        this.hair = hair;
        this.hpersonnum = hpersonnum;
        this.hprice = hprice;
        this.hrentstatus = hrentstatus;
        this.himage = himage;
        this.hfulladdress = hfulladdress;
        this.haddtime = haddtime;
        this.hupdatetime = hupdatetime;
        this.hstatus = hstatus;
    }

    public House(){

    }


    public Integer getHid() {
        return hid;
    }

    public void setHid(Integer hid) {
        this.hid = hid;
    }

    public String getHaddress() {
        return haddress;
    }

    public void setHaddress(String haddress) {
        this.haddress = haddress == null ? null : haddress.trim();
    }

    public String getHdistrict() {
        return hdistrict;
    }

    public void setHdistrict(String hdistrict) {
        this.hdistrict = hdistrict == null ? null : hdistrict.trim();
    }

    public Integer getHno() {
        return hno;
    }

    public void setHno(Integer hno) {
        this.hno = hno;
    }

    public String getHfloor() {
        return hfloor;
    }

    public void setHfloor(String hfloor) {
        this.hfloor = hfloor == null ? null : hfloor.trim();
    }

    public Integer getHroomnum() {
        return hroomnum;
    }

    public void setHroomnum(Integer hroomnum) {
        this.hroomnum = hroomnum;
    }

    public String getHarea() {
        return harea;
    }

    public void setHarea(String harea) {
        this.harea = harea == null ? null : harea.trim();
    }

    public String getHdir() {
        return hdir;
    }

    public void setHdir(String hdir) {
        this.hdir = hdir == null ? null : hdir.trim();
    }

    public String getHfurniture() {
        return hfurniture;
    }

    public void setHfurniture(String hfurniture) {
        this.hfurniture = hfurniture == null ? null : hfurniture.trim();
    }

    public Integer getHdeco() {
        return hdeco;
    }

    public void setHdeco(Integer hdeco) {
        this.hdeco = hdeco;
    }

    public Integer getHair() {
        return hair;
    }

    public void setHair(Integer hair) {
        this.hair = hair;
    }

    public Integer getHpersonnum() {
        return hpersonnum;
    }

    public void setHpersonnum(Integer hpersonnum) {
        this.hpersonnum = hpersonnum;
    }

    public Double getHprice() {
        return hprice;
    }

    public void setHprice(Double hprice) {
        this.hprice = hprice;
    }

    public Integer getHrentstatus() {
        return hrentstatus;
    }

    public void setHrentstatus(Integer hrentstatus) {
        this.hrentstatus = hrentstatus;
    }

    public String getHimage() {
        return himage;
    }

    public void setHimage(String himage) {
        this.himage = himage == null ? null : himage.trim();
    }

    public String getHfulladdress() {
        return hfulladdress;
    }

    public void setHfulladdress(String hfulladdress) {
        this.hfulladdress = hfulladdress == null ? null : hfulladdress.trim();
    }

    public Date getHaddtime() {
        return haddtime;
    }

    public void setHaddtime(Date haddtime) {
        this.haddtime = haddtime;
    }

    public Date getHupdatetime() {
        return hupdatetime;
    }

    public void setHupdatetime(Date hupdatetime) {
        this.hupdatetime = hupdatetime;
    }

    public Integer getHstatus() {
        return hstatus;
    }

    public void setHstatus(Integer hstatus) {
        this.hstatus = hstatus;
    }

    @Override
    public String toString() {
        return "House{" +
                "hid=" + hid +
                ", haddress='" + haddress + '\'' +
                ", hdistrict='" + hdistrict + '\'' +
                ", hno=" + hno +
                ", hfloor='" + hfloor + '\'' +
                ", hroomnum=" + hroomnum +
                ", harea='" + harea + '\'' +
                ", hdir='" + hdir + '\'' +
                ", hfurniture='" + hfurniture + '\'' +
                ", hdeco=" + hdeco +
                ", hair=" + hair +
                ", hpersonnum=" + hpersonnum +
                ", hprice=" + hprice +
                ", hrentstatus=" + hrentstatus +
                ", himage='" + himage + '\'' +
                ", hfulladdress='" + hfulladdress + '\'' +
                ", haddtime=" + haddtime +
                ", hupdatetime=" + hupdatetime +
                ", hstatus=" + hstatus +
                '}';
    }
}
package com.xentaurs.assm.domain;

import java.util.Date;

public class AssmProject {

    private long id;
    private String customer;
    private Date date;

    public AssmProject() {}

    public AssmProject(String customer) {
        this.id = 1;
        this.customer = customer;
        this.date = new Date();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCustomer() {
        return customer;
    }

    public void setCustomer(String customer) {
        this.customer = customer;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}

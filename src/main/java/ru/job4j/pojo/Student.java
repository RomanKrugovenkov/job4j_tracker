package ru.job4j.pojo;

import java.util.Date;

public class Student {
    private String fullName;
    private String group;
    private Date dateEnter;

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public Date getDateEnter() {
        return dateEnter;
    }

    public void setDateEnter(Date dateEnter) {
        this.dateEnter = dateEnter;
    }
}

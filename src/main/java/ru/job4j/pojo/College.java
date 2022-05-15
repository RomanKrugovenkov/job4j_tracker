package ru.job4j.pojo;

import java.util.Date;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setFullName("Petr Arsentev");
        student.setGroup("JavaDev");
        student.setDateEnter(new Date());

        System.out.println(student.getFullName() + " go to the college, to group \"" + student.getGroup() + "\"" + ". By date: " + student.getDateEnter());
    }

}

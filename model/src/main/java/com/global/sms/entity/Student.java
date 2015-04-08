package com.global.sms.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author Adnan Khan
 */

@Entity
public class Student {

    @Id @GeneratedValue
    private Long id;

    @Column(name = "first_name")
    private String firstName;

    public Student() {
    }

    public Student(String firstName) {
        this.firstName = firstName;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

}

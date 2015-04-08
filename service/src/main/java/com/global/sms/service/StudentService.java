package com.global.sms.service;

import com.global.sms.entity.Student;

import java.util.List;

public interface StudentService extends CrudService<Student, Long>{
    public List<Student> getStudentByFirstName(String firstName);
}

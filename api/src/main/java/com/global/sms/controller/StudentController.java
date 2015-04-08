package com.global.sms.controller;

import com.global.sms.entity.Student;
import com.global.sms.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @RequestMapping( method = RequestMethod.GET )
    public List< Student > findAll(){
        return studentService.findAll();
    }

    @RequestMapping( method = RequestMethod.POST )
    @ResponseStatus(HttpStatus.CREATED)
    public Student save( @RequestBody Student student){
        return studentService.save(student);
    }

    @RequestMapping(value = "/{id}" , method = RequestMethod.GET)
    public Student get( @PathVariable("id") Long id){
        System.out.println("Id is "+id);
        return studentService.get(id);
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public Student update(@RequestBody Student student){
        return studentService.save(student);
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@RequestBody Student student){
        studentService.delete(student);
    }

    @RequestMapping(value = "/search" , method = RequestMethod.GET)
    public List<Student> getStudentByFirstName( @RequestParam("firstName") String firstName){
        System.out.println("First Name is "+firstName);
        return studentService.getStudentByFirstName(firstName);
    }
}

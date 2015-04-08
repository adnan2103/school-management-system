package com.global.sms.service.impl;

import com.global.sms.entity.Student;
import com.global.sms.repository.StudentRepository;
import com.global.sms.service.CrudService;
import com.global.sms.service.StudentService;
import org.apache.commons.collections.IteratorUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{

    private static final Logger LOGGER = LoggerFactory.getLogger(StudentServiceImpl.class);

    @Resource
    StudentRepository studentRepository;

    @Override
    public List<Student> findAll(){
        return IteratorUtils.toList(studentRepository.findAll(sortByFirstNameAsc()).iterator());
    }

    private Sort sortByFirstNameAsc() {
        return new Sort(Sort.Direction.ASC, "firstName");
    }
    @Override
    public Student save(Student student){
        return studentRepository.save(student);
    }

    @Override
    public Student get(Long id){
        return studentRepository.findOne(id);
    }

    @Override
    public void delete(Student student){
        studentRepository.delete(student);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Student> getStudentByFirstName(String firstName){
        LOGGER.debug("Searching student with search criteria firstName: " + firstName);
        return studentRepository.findByFirstNameOrderByFirstNameAsc(firstName);
    }

}

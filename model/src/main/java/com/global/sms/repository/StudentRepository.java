package com.global.sms.repository;

import com.global.sms.entity.Student;
import org.springframework.data.repository.PagingAndSortingRepository;


import java.util.List;

public interface StudentRepository extends PagingAndSortingRepository<Student, Long> {

    public List<Student> findByFirstNameOrderByFirstNameAsc(String firstName);


    // Another way of doing.
   // @Query("SELECT s FROM Student s WHERE LOWER(s.firstName) = LOWER(:firstName)")
   // public List<Student> find(@Param("firstName") String firstName);
}

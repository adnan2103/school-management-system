package com.global.sms.service;

import com.global.sms.entity.Student;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

public interface CrudService<T, ID extends Serializable> {
        public List<T> findAll();
        public T save(T entity);
        public T get(ID id);
        public void delete(T entity);

}

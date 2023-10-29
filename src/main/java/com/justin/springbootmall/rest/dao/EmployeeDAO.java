package com.justin.springbootmall.rest.dao;

import com.justin.springbootmall.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    void deleteById(Long id);


}
















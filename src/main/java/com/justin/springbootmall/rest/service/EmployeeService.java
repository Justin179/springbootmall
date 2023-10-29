package com.justin.springbootmall.rest.service;

import com.justin.springbootmall.rest.entity.Employee;

import java.util.LinkedList;
import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();

    Employee findById(Long id);

    Employee save(Employee employee);

    void deleteById(Long id);
}

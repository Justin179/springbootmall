package com.justin.springbootmall.rest.dao;

import com.justin.springbootmall.rest.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}

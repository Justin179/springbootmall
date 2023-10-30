package com.justin.springbootmall.rest.jparepo;

import com.justin.springbootmall.rest.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Long> {
    // 這個可以取代dao目錄下的2隻程式
}

package com.poly.lab56.reponsitories;



import java.util.List;

import com.poly.lab56.domain.Employee;
import com.poly.lab56.domain.Major;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IEmployeeRepository extends JpaRepository<Employee,Long>{
    
    Employee findByEmail(String email);

    List<Employee> findByMajor(Major major);
}

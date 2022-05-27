package com.poly.lab56.reponsitories;



import com.poly.lab56.domain.Employee;

import org.springframework.data.jpa.repository.JpaRepository;


public interface IEmployeeRepository extends JpaRepository<Employee,Long>{
    
    Employee findByEmail(String email);
}

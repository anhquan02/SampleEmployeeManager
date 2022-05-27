package com.poly.lab56.services;

import java.util.List;

import com.poly.lab56.domain.Employee;
import com.poly.lab56.domain.Major;
import com.poly.lab56.reponsitories.IEmployeeRepository;
import com.poly.lab56.reponsitories.IMajorRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class EmployeeService {
    private final IEmployeeRepository employeeRepository;
    private final IMajorRepository majorRepository;

    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    public Employee saveMajorToEmp(String email, String majorName){
        Employee emp = this.employeeRepository.findByEmail(email);
        System.out.println(emp.getEmail());
        Major major = this.majorRepository.findByName(majorName);
        emp.setMajor(major);
        return this.employeeRepository.save(emp);
    }
    
    public Employee getEmployeeByEmail(String email){
        return this.employeeRepository.findByEmail(email);
    }

    public Employee getEmployee(Long id) {
        return this.employeeRepository.findById(id).get();
    }

    public List<Employee> getAll() {
        return this.employeeRepository.findAll();
    }

    public void removeEmployee(Long id) {

        this.employeeRepository.deleteById(id);
        
    }

    public void removeList(List<Long> ids){
        this.employeeRepository.deleteAllById(ids);
    }

}

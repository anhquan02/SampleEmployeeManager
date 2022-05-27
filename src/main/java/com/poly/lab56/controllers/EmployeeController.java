package com.poly.lab56.controllers;

import java.net.URI;
import java.util.List;

import com.poly.lab56.domain.Employee;
import com.poly.lab56.services.EmployeeService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class EmployeeController {
    private final EmployeeService service;

    @GetMapping("/employees")
    public ResponseEntity getAll(){
        return ResponseEntity.ok().body(this.service.getAll());
    }

    @GetMapping("/employee")
    public ResponseEntity<Employee> getById(@RequestParam Long id){
        return ResponseEntity.ok().body(this.service.getEmployee(id));
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/employee/store").toUriString());
        return ResponseEntity.created(uri).body(this.service.saveEmployee(employee));
    }

    @PutMapping("/employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok().body(this.service.saveEmployee(employee));
    }

    @DeleteMapping("/employee")
    public ResponseEntity<HttpStatus> deleteEmployee(@RequestParam Long id){
        try {
            this.service.removeEmployee(id);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    public ResponseEntity<HttpStatus> deleteListEmployee(@RequestParam List<Long> ids){
        try {
            this.service.removeList(ids);
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}    


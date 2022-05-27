package com.poly.lab56.reponsitories;

import com.poly.lab56.domain.Employee;
import com.poly.lab56.domain.Major;

import org.springframework.data.jpa.repository.JpaRepository;

public interface IMajorRepository extends JpaRepository<Major,Long>{
    Major findByName(String name);

}

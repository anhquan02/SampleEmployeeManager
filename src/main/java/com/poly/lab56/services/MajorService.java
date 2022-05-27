package com.poly.lab56.services;

import java.util.List;

import com.poly.lab56.domain.Major;
import com.poly.lab56.reponsitories.IMajorRepository;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class MajorService {
    private final IMajorRepository majorRepository;

    public Major saveMajor(Major major) {
        return this.majorRepository.save(major);
    }


    public Major getMajor(Long id) {
        return this.majorRepository.findById(id).get();
    }

    public List<Major> getAll(){
        return this.majorRepository.findAll();
    }
}

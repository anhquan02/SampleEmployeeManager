package com.poly.lab56.controllers;

import com.poly.lab56.domain.Major;
import com.poly.lab56.services.MajorService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@CrossOrigin("*")
public class MajorController {

    private final MajorService service;
    
    @GetMapping("/major")
    public ResponseEntity<Major> getMajor(@RequestParam Long id){
        return ResponseEntity.ok().body(service.getMajor(id));
    }

    @GetMapping("/majors")
    public ResponseEntity getAll(){
        return ResponseEntity.ok().body(service.getAll());
    }


}

package com.school.Schoolwebflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.discovery.converters.Auto;

import com.school.Schoolwebflux.entity.Student;
import com.school.Schoolwebflux.service.StudentService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class StudentController {

	
	@Autowired
	private StudentService service;
	@GetMapping("/list")
	public Flux<Student> list(){
		return service.studentlist();
	}
	@PostMapping("/save")
	public Mono<Student> save(@RequestBody Student student){
		return service.saveStudent(student);
	}
	@PutMapping("/update/{id}")
	public Mono<Student> update( @RequestBody Student student,@PathVariable String id){
		return service.updateStudent(student, id);
	}
}

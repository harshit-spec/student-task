package com.school.Schoolwebflux.service;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.school.Schoolwebflux.entity.Student;
import com.school.Schoolwebflux.repository.StudentRepository;


import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class StudentService {

	
	@Autowired
	private StudentRepository repo;
	
	
	public Flux<Student> studentlist(){
		return repo.findAll();
	} 
	
	public Mono<Student> student(String id){
		return repo.findById(id);
	}
	public Mono<Student> saveStudent(Student student){
		return repo.save(student);
		
		
	}


	public Mono<Student> updateStudent(Student student, String id) {
		// TODO Auto-generated method stub
		return repo.findById(id).map((c)->{c.setName(student.getName());
		c.setBranch(student.getBranch());
		return c;}).flatMap(c->repo.save(c));
	}

	public Flux<Student> listByBranch(String branch) {
		
		Flux<Student> students = repo.findAll();
		return students.buffer()
				.filter(studentItr -> studentItr.getBranch().equals(branch)).
				
			
	}
}

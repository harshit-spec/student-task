package com.school.Schoolwebflux.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

import com.school.Schoolwebflux.entity.Student;
@Repository
public interface StudentRepository extends ReactiveMongoRepository<Student, String>{

}

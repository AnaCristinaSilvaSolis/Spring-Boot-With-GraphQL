package com.graphql.example.springbootgraphql.persistence;

import org.springframework.data.repository.CrudRepository;

import com.graphql.example.springbootgraphql.entities.Student;

public interface IStudentDAO extends CrudRepository<Student, Long> {

}

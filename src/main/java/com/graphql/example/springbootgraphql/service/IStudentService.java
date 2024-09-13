package com.graphql.example.springbootgraphql.service;

import java.util.*;

import com.graphql.example.springbootgraphql.entities.Student;

public interface IStudentService {

  Student findById(Long id);

  List<Student> findAll();

  void createStudent(Student student);

  void deleteById(Long id);

}

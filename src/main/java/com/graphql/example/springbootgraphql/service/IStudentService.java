package com.graphql.example.springbootgraphql.service;

import java.util.*;
import org.springframework.stereotype.Service;

import com.graphql.example.springbootgraphql.entities.Student;

public interface IStudentService {

  Student findById(Long id);

  List<Student> findAll();

  void createStudent(Student student);

  void deleteById(Long id);

}

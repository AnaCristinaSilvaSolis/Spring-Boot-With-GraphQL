package com.graphql.example.springbootgraphql.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.example.springbootgraphql.entities.Student;
import com.graphql.example.springbootgraphql.service.IStudentService;

@Controller
public class GraphQLStudentController {

  @Autowired
  private IStudentService studentService;

  @QueryMapping(name = "findStudentById")
  public Student findById(@Argument(name = "studentId") String id) {
    Long studentId = Long.parseLong(id);

    return studentService.findById(studentId);

  }
}

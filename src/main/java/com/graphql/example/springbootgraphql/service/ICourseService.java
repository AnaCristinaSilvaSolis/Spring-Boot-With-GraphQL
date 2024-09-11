package com.graphql.example.springbootgraphql.service;

import java.util.*;

import com.graphql.example.springbootgraphql.entities.Course;

public interface ICourseService {

  Course findById(Long id);

  List<Course> findAll();

  void createCourse(Course course);

  void deleteById(Long id);
}

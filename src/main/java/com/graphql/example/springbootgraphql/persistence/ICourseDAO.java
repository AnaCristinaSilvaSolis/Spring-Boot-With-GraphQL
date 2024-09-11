package com.graphql.example.springbootgraphql.persistence;

import org.springframework.data.repository.CrudRepository;

import com.graphql.example.springbootgraphql.entities.Course;

public interface ICourseDAO extends CrudRepository<Course, Long> {

}

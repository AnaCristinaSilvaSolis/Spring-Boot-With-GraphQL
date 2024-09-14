package com.graphql.example.springbootgraphql.controller;

import com.graphql.example.springbootgraphql.entities.Course;
import com.graphql.example.springbootgraphql.graphql.InputStudent;
import com.graphql.example.springbootgraphql.service.ICourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import com.graphql.example.springbootgraphql.entities.Student;
import com.graphql.example.springbootgraphql.service.IStudentService;

import java.util.List;

@Controller
public class GraphQLStudentController {

  @Autowired
  private IStudentService studentService;

  @Autowired
  private ICourseService courseService;

  @QueryMapping(name = "findStudentById")
  public Student findById(@Argument(name = "studentId") String id) {
    Long studentId = Long.parseLong(id);

    return studentService.findById(studentId);

  }

  @QueryMapping(name = "findAllStudents")
  public List<Student> findAll(){
    return studentService.findAll();
  }

  @MutationMapping
  public Student createStudent(@Argument(name = "inputStudent") InputStudent inputStudent){
    Course course = courseService.findById(Long.parseLong(inputStudent.getCourseId()));

    Student student = new Student();

    student.setName(inputStudent.getName());
    student.setLast_name(inputStudent.getLast_name());
    student.setAge(inputStudent.getAge());
    student.setCourse(course);

    studentService.createStudent(student);
    return student;
  }

  // @MutationMapping porque usamos mutacion
  @MutationMapping(name = "deleteStudentById")
  public String deleteById(@Argument(name = "studentId") String id){
    studentService.deleteById(Long.parseLong(id));

    return "El estudiante con id " + id + " ha sido eliminado. ";
  }
}

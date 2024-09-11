package com.graphql.example.springbootgraphql.service.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.graphql.example.springbootgraphql.entities.Student;
import com.graphql.example.springbootgraphql.persistence.IStudentDAO;
import com.graphql.example.springbootgraphql.service.IStudentService;

@Service
public class StudentServiceImpl implements IStudentService {

  @Autowired
  private IStudentDAO studentDAO;

  @Override
  @Transactional(readOnly = true)
  public Student findById(Long id) {
    return studentDAO.findById(id).orElseThrow(); // orElseThrow() sino lo encuentra arroja un error
  }

  @Override
  @Transactional(readOnly = true)
  public List<Student> findAll() {
    return (List<Student>) studentDAO.findAll();
  }

  @Override
  @Transactional
  public void createStudent(Student student) {
    studentDAO.save(student);
  }

  @Override
  @Transactional
  public void deleteById(Long id) {
    studentDAO.deleteById(id);
  }

}

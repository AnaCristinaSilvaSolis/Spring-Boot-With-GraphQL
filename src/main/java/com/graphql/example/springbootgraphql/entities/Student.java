package com.graphql.example.springbootgraphql.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "students")
public class Student {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private String name;

  @Column(name = "last_name")
  private String lastName;
  private Integer age;

  // LAZY nos trae la informacion solo cuando nosotros la llamemos explicitamente
  // muchos estudiantes para un curso
  @ManyToOne(fetch = FetchType.LAZY, targetEntity = Course.class)
  private Course course;
}

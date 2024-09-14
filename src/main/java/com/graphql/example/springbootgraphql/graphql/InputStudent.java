package com.graphql.example.springbootgraphql.graphql;

import lombok.Data;

@Data
public class InputStudent {
    private Long id;
    private String name;
    private String last_name;
    private Integer age;
    private String courseId;
}

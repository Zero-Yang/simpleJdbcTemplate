package com.java.jdbctemplateProxy;

import com.java.jdbcTemplate.annotations.Column;
import com.java.jdbcTemplate.annotations.Id;
import com.java.jdbcTemplate.annotations.Table;

@Table(name="person2")
public class Person {
    
    private Integer id;
    
    private String name;

    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name="person_name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}

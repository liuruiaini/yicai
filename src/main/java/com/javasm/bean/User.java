package com.javasm.bean;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class User {
    private Integer id;
    private String name;
    private Integer age;

    public User(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User() {
    }
}

package com.sky.pojo;

import org.hibernate.validator.constraints.NotBlank;


import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class Users implements Serializable {

    private Integer id;
    @NotBlank
    private String name;
    @NotNull
    private Integer  age;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getAge() {
        return age;
    }
    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

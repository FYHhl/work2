package com.example.Jump;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString

public class Teacher {
    //id 主键
    private Integer id;
    //姓名
    private String name;

    public Teacher(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public Teacher(){

    }
}

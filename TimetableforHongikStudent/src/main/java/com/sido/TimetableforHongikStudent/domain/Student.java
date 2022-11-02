package com.sido.TimetableforHongikStudent.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
public class Student {

    @Id
    @GeneratedValue
    private Long id; //PK

    @OneToMany(mappedBy = "student",cascade = CascadeType.ALL)
    private List<StudentSubject> studentSubject = new ArrayList<>();

    private String name;

    private String password;

    private String major;

    private int grade;

    /**
     * 생성 매서드.
     */
    public static Student createStudent(String name,String password,String major,int grade){
        Student student = new Student();

        student.setName(name);
        student.setPassword(password);
        student.setMajor(major);
        student.setGrade(grade);

        return student;
    }
}

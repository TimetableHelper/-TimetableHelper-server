package com.sido.TimetableforHongikStudent.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
public class Student {

    @Id
    @GeneratedValue
    private Long id; //PK!!!!!!

    private String name;

    private String nickname;

    private int grade;
}

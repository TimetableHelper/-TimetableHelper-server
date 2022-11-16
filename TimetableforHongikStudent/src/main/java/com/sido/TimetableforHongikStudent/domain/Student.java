package com.sido.TimetableforHongikStudent.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Student {

    @Id
    @GeneratedValue
    private Long id; //PK!!!!!!

    private String name; // 로그인 시 사용되는 아이디

    private String nickname;

    private int grade;

    private String major;

    private String pw; // 진영 추가 (로그인 시 사용되는 비밀번호)

    public Student(String name, String nickname, int grade, String major, String pw) {
        this.name = name;
        this.nickname = nickname;
        this.grade = grade;
        this.major = major;
        this.pw = pw;
    }

}

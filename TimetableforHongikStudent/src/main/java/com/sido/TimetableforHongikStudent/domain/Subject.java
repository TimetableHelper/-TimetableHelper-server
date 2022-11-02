package com.sido.TimetableforHongikStudent.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
public class Subject {

    @Id @GeneratedValue
    @Column(name = "subject_id")
    private Long id; //PK


    private String subjectName; // 과목이름
    private String professor; // 담당교수
    private boolean division; // 이수구분
    private String classification; // 수강구분 [ 전필 , 전선 , ... ]
    private int credit; // 학점
    private String classroom; // 강의실
    private String classTime; // 수업시간


}
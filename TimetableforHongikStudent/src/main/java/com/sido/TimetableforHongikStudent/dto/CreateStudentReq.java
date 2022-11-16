package com.sido.TimetableforHongikStudent.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

// 진영 추가
@Getter
@NoArgsConstructor
public class CreateStudentReq {
    private String name;  // 로그인 시 사용되는 아이디

    private String nickname;

    private int grade;

    private String major;


    private String pw;
}

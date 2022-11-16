package com.sido.TimetableforHongikStudent.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginRes {
    private int code;
    private String message;
    private String name;
    private Long studentId;

    public static LoginRes loginSuccess(String name, Long studentId) {
        return new LoginRes(200,"로그인이 성공했습니다",name, studentId);
    }

    public static LoginRes loginFail() {
        return new LoginRes(400, "로그인이 실패했습니다", null, null );
    }

    public LoginRes(int code, String message,String name, Long studentId) {
        this.code = code;
        this.message = message;
        this.name = name;
        this.studentId = studentId;
    }
}
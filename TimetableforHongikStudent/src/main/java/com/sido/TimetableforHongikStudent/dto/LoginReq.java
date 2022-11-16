package com.sido.TimetableforHongikStudent.dto;

import com.sido.TimetableforHongikStudent.service.StudentService;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginReq {  // 진영 추가, 로그인 시 전달되는 이메일(아이디), 비밀번호
    private String name;
    private String pw;
}

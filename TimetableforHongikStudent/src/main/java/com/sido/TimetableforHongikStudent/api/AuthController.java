package com.sido.TimetableforHongikStudent.api;

import com.sido.TimetableforHongikStudent.dto.CreateStudentReq;
import com.sido.TimetableforHongikStudent.dto.LoginReq;
import com.sido.TimetableforHongikStudent.dto.LoginRes;
import com.sido.TimetableforHongikStudent.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/student")
public class AuthController {
    // 진영 추가

    private final StudentService studentService;

    @PostMapping("/create") // 진영 - 회원가입
    public void createStudent(@RequestBody CreateStudentReq createStudentReq) {
        studentService.save(createStudentReq);
    }

    @PostMapping("/login") // 로그인 기능 추가 /student/login
    public LoginRes login(@RequestBody LoginReq loginReq) {
        System.out.println(loginReq.getPw());
        return studentService.login(loginReq);
    }

}

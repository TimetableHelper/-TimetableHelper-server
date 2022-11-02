package com.sido.TimetableforHongikStudent.api;

import com.sido.TimetableforHongikStudent.domain.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sido.TimetableforHongikStudent.service.StudentService;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;


@RestController
@RequiredArgsConstructor
public class StudentApiController {

    private final StudentService studentService;

    @PostMapping("/api/students")
    public CreateStudentResponse saveStudent(@RequestBody @Valid CreateStudentRequest request){
        Student student = Student.createStudent(request.getName(),
                request.getPassword(),request.getMajor(),request.getGrade());

        Long id = studentService.join(student);
        return new CreateStudentResponse(id);
    }

    // DTO 패키지 생성 해야함.
    @Data
    static class CreateStudentRequest{
        @NotEmpty
        private String name;
        @NotEmpty
        private String password;

        private String major;
        private int grade;
    }


    @Data
    static class CreateStudentResponse{
        private Long id;
        public CreateStudentResponse(Long id){
            this.id=id;
        }


    }

}

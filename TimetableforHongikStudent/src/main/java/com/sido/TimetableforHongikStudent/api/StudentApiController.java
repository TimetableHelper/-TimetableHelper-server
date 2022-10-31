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


@RestController
@RequiredArgsConstructor
public class StudentApiController {

    private final StudentService studentService;

    @PostMapping("/api/students")
    public CreateStudentResponse saveStudent(@RequestBody @Valid CreateStudentRequest request){
        Student student = new Student();
        student.setName(request.getName());
        Long id = studentService.join(student);
        return new CreateStudentResponse(id);
    }

    // DTO 패키지 생성.
    @Data
    static class CreateStudentRequest{
        public String name;
    }


    @Data
    static class CreateStudentResponse{
        private Long id;
        public CreateStudentResponse(Long id){
            this.id=id;
        }
    }

}

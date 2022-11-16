package com.sido.TimetableforHongikStudent.service;

import com.sido.TimetableforHongikStudent.domain.Student;
import com.sido.TimetableforHongikStudent.dto.CreateStudentReq;
import com.sido.TimetableforHongikStudent.dto.LoginReq;
import com.sido.TimetableforHongikStudent.dto.LoginRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.sido.TimetableforHongikStudent.repository.StudentRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class StudentService {

    private final StudentRepository studentRepository;

    //    @Autowired // 생성자가 하나이면 생략 가능하긴함
//    public StudentService(StudentRepository studentRepository){
//        this.studentRepository = studentRepository;
//    }

    //진영 추가 - 회원가입
    @Transactional
    public void save(CreateStudentReq createStudentReq) {
        Student student = new Student(
                createStudentReq.getName(),
                createStudentReq.getNickname(),
                createStudentReq.getGrade(),
                createStudentReq.getMajor(),
                createStudentReq.getPw());
        studentRepository.save(student);
    }

    public LoginRes login(LoginReq loginReq) {
        studentRepository.findByEmail(loginReq.getName());
        Student student = studentRepository.findByEmail(loginReq.getName());
        if (!student.getPw().equals(loginReq.getPw())) {
            return LoginRes.loginFail();
        }
        return LoginRes.loginSuccess(student.getName(), student.getId());
    }

    @Transactional
    public Long join(Student student){
        studentRepository.save(student);
        return student.getId();
    }

    // 학생 전체 조회
    public List<Student> findStudents(){
        return studentRepository.findAll();
    }

    // 학생 단건 조회
    public Student findOne(Long studentId){
        return studentRepository.findOne(studentId);
    }


}

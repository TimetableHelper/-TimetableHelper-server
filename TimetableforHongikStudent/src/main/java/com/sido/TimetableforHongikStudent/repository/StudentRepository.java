package com.sido.TimetableforHongikStudent.repository;


import com.sido.TimetableforHongikStudent.domain.Student;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;


@Repository
@RequiredArgsConstructor
public class StudentRepository {

    private final EntityManager em;

    public void save(Student student){
        em.persist(student);
    }

    // 단건 조회
    public Student findOne(Long id){
        return em.find(Student.class,id);
    }
    // 다수 조회
    public List<Student> findAll(){
        return em.createQuery("select m from Student m",Student.class).getResultList();
    }
    // 이름으로 조회
    public List<Student> findByName(String name){
        return em.createQuery("select m from Student m where m.name = :name",Student.class)
                .setParameter("name",name)
                .getResultList();
    }

}

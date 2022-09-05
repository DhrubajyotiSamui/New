package com.dhruba.student.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.dhruba.student.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

Student findById(long id);

@Query(value="SELECT * FROM student WHERE c_id=:c_id ORDER BY name ASC",nativeQuery = true)
List<Student> ascendingName(@Param("c_id") long c_id);

@Query(value="SELECT * FROM student WHERE stream=:stream ORDER BY age DESC",nativeQuery = true)
List<Student> getStudentByStreamWithDescAge(@Param("stream") String  stream );
}



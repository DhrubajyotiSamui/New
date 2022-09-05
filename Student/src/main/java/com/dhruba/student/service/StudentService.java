package com.dhruba.student.service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.dhruba.student.entity.Student;
import com.dhruba.student.valueObject.ResponseTemplate;

@Service
public interface StudentService {

Student add(Student student);
List<Student> list();
Student searchById(long id);
ResponseTemplate stdWithColl(long c_id);
Student assignCollege(long studentId, long c_Id);
List<Student> getAscendingNameById(long c_id);
List<Student> getStudentByCollegeStreamWithDescAge(String stream);
}
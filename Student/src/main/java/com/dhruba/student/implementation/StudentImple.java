package com.dhruba.student.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dhruba.student.entity.Student;
import com.dhruba.student.repository.StudentRepository;
import com.dhruba.student.service.StudentService;
import com.dhruba.student.valueObject.College;
import com.dhruba.student.valueObject.ResponseTemplate;

@Component
public class StudentImple implements StudentService {

	@Autowired
	private StudentRepository studentRepo;

	@Autowired
	private RestTemplate restTemplate;

	@Override
	public Student add(Student student) {
		return studentRepo.save(student);
	}

	@Override
	public List<Student> list() {
		return studentRepo.findAll();
	}

	@Override
	public Student searchById(long id) {
		return studentRepo.findById(id);
	}

	@Override
	public ResponseTemplate stdWithColl(long stdId){
		ResponseTemplate RT = new ResponseTemplate();
		Student std = studentRepo.findById(stdId);

		long c_id = std.getC_id();
		College college= restTemplate.getForObject("http://COLLEGE-SERVICE/college/" + c_id,College.class);
		RT.setCollege(college);
		RT.setStudent(std);
		return RT;
	}

	@Override
	public Student assignCollege(long studentId, long c_Id){
		Student stud = studentRepo.findById(studentId);
		College coll = restTemplate.getForObject("http://COLLEGE-SERVICE/college/" + c_Id,College.class);
		if (stud == null || coll == null) {
			return null;
		}
		stud.setC_id(c_Id);
		studentRepo.save(stud);
		return stud;
	}

	@Override
	public List<Student> getAscendingNameById(long c_id) {
		return studentRepo.ascendingName(c_id);
	}

	@Override
	public List<Student>getStudentByCollegeStreamWithDescAge(String stream) {
		return studentRepo.getStudentByStreamWithDescAge(stream);
	}

}

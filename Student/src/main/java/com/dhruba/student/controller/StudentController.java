package com.dhruba.student.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhruba.student.entity.Student;
import com.dhruba.student.service.StudentService;
import com.dhruba.student.valueObject.ResponseTemplate;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	StudentService studentService;

	@PostMapping
	public Student add(@RequestBody Student std) {
		return studentService.add(std);
	}

	@GetMapping
	public List<Student> listStdunt() {
		return studentService.list();
	}

	@GetMapping("/{stdId}")
	public ResponseTemplate stdWithColl(@PathVariable long stdId) {
		return studentService.stdWithColl(stdId);
	}

	@PutMapping("/{stdId}/{c_Id}")
	public String updateDepartment(@PathVariable long stdId, @PathVariable long c_Id) {
		Student stud = studentService.assignCollege(stdId, c_Id);
		if (stud != null) {
			return stud.toString();
		}
		return "Sorry.College or student not found";
	}

	@GetMapping("/student-with-ascname/{c_id}")
	public List<Student> nameByAscending(@PathVariable long c_id) {
		return studentService.getAscendingNameById(c_id);
	}

	@GetMapping("/student-with-desc-age/{stream}")
	public List<Student> getEmployeeByStreamWithDescAge(@PathVariable String stream) {
		return studentService.getStudentByCollegeStreamWithDescAge(stream);
	}
}

package com.dhruba.college.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.dhruba.college.entity.College;
import com.dhruba.college.repository.CollegeRepository;
import com.dhruba.college.service.CollegeService;
import com.dhruba.college.valueObject.RequestTemplate;
import com.dhruba.college.valueObject.Student;

@Component
public class CollegeServiceImpl implements CollegeService {

@Autowired
CollegeRepository collegeRepo;
@Autowired
RestTemplate restTemplate;

@Override
public College add(College coll) {
return collegeRepo.save(coll);
}

@Override
public List<College> list() {
return collegeRepo.findAll();
}

@Override
public College update(long id, String c_name) {
College coll = collegeRepo.findById(id);
coll.setC_name(c_name);
return collegeRepo.save(coll);
}

@Override
public College searchById(long id) {
if(collegeRepo.findById(id)==null)
{
return null;
}
return collegeRepo.findById(id);
}

@Override
public List<RequestTemplate> listWithStud() {
	List<RequestTemplate> fullList = new ArrayList<RequestTemplate>();
	List<College> allColl = this.list();
	Iterator<College> ir = allColl.iterator();
	while (ir.hasNext())
	{
		College coll = ir.next();
		ResponseEntity<Student[]> response = restTemplate.getForEntity("http://STUDENT-SERVICE/student/student-with-ascname/" + coll.getC_id(), Student[].class);
		Student[] students = response.getBody();
		List<Student> stdList = Arrays.asList(students);
		RequestTemplate RTm = new RequestTemplate();
		RTm.setCollege(coll);
		RTm.setStudentList(stdList);
		fullList.add(RTm);
    }
	return fullList;
}

@Override
public RequestTemplate specificCollStudent(long c_id) {
	College college = this.searchById(c_id);
	ResponseEntity<Student[]> response = restTemplate.getForEntity("http://STUDENT-SERVICE/student/student-with-desc-age/" + college.getC_id(), Student[].class);
	Student[] students = response.getBody();
	List<Student> studList = Arrays.asList(students);
	RequestTemplate requestTemplate = new RequestTemplate();
	requestTemplate.setCollege(college);
	requestTemplate.setStudentList(studList);
	return requestTemplate;
}

}

package com.dhruba.college.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dhruba.college.entity.College;
import com.dhruba.college.service.CollegeService;
import com.dhruba.college.valueObject.RequestTemplate;

@RestController
@RequestMapping("/college")
public class CollegeController {

	@Autowired
	CollegeService collService;

	@PostMapping
	public College add(@RequestBody College coll) {
		return collService.add(coll);
	}

	@GetMapping
	public List<College> list() {
		return collService.list();
	}

	@GetMapping("/{id}")
	public College searchById(@PathVariable long id) {
		return collService.searchById(id);
	}

	@GetMapping("/all-college-student")
	public List<RequestTemplate> listWithStudent() {
		return collService.listWithStud();
	}

	@GetMapping("/college-with-student/{c_id}")
	public RequestTemplate specificCollStud(@PathVariable long c_id) {
		return collService.specificCollStudent(c_id);
	}

}
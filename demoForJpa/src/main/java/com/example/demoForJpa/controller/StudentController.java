package com.example.demoForJpa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demoForJpa.entity.Student;
import com.example.demoForJpa.repo.StudentRepo;

@RestController
public class StudentController {
	
	@Autowired
	StudentRepo studentRepo;
	
	@PostMapping("/api/students")
	public ResponseEntity<Student> saveStudent(@RequestBody Student student)
	{
		return new ResponseEntity<>(studentRepo.save(student),HttpStatus.CREATED);

	}
	
	@GetMapping("/api/students")
public ResponseEntity<List<Student>> getStudent()
{
		return new ResponseEntity<>(studentRepo.findAll(),HttpStatus.OK);
	
}
	
	@GetMapping("/api/students/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable long id){
		  Optional<Student> student = studentRepo.findById(id);
		if(student.isPresent())
		{
			return new ResponseEntity<>(student.get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
		

}

package com.example.StudentApp.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.StudentApp.Repository.StudentHistoryRepository;
import com.example.StudentApp.Repository.StudentRepository;
import com.example.StudentApp.modal.Student;
import com.example.StudentApp.modal.StudentHistory;
import com.example.StudentApp.utils.CopyNullValues;

@RestController
public class StudentController {

	@Autowired
	private StudentRepository repository;
	@Autowired
	private StudentHistoryRepository repo;
	
	@PostMapping("/save")
	public Student save(@RequestBody Student student) {
		return repository.save(student);
	}
	
	@GetMapping("/student")
	public List<Student> getAll(){
		
		return repository.findAll();
	}
	@GetMapping("student/{id}")
	public Optional<Student> getById(@PathVariable("id") Long id) {
		return repository.findById(id);
		
	}
	@PatchMapping("/student/update/{id}")
	public Student update(@PathVariable("id") Long id,@RequestBody Student student) {
		/*
		 * Student existingRecord=repository.getStudent(id);
		 * student.setStdId(existingRecord.getStdId()); return repository.save(student);
		 */
		
		Student existingStudentObject = repository.getStudent(id);
		CopyNullValues copy = new CopyNullValues();
		copy.copyNotNullProperties(student, existingStudentObject);
		Student updatedstudent= repository.save(existingStudentObject);
		StudentHistory obj=new StudentHistory();
		obj.setStatus("update");
		obj.setTime(LocalDateTime.now());
		obj.setName(updatedstudent.getName());
		obj.setSection(updatedstudent.getSection());
		obj.setCollegeName(updatedstudent.getCollegeName());
		repo.save(obj);
		return updatedstudent;

	}
	
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		 try {
			Optional<Student> deletedstudent = repository.findById(id);
			
			StudentHistory obj=new StudentHistory();
			obj.setStatus("delete");
			obj.setTime(LocalDateTime.now());
			obj.setName(deletedstudent.get().getName());
			obj.setSection(deletedstudent.get().getSection());
			obj.setCollegeName(deletedstudent.get().getCollegeName());
			repo.save(obj);
			repository.deleteById(id);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "failure";
		}
		 return "Success";
	}
	@DeleteMapping("/delete-all")
	public String delete() {
		repository.deleteAll();
		return "success";
		
		
	}
	
	
}

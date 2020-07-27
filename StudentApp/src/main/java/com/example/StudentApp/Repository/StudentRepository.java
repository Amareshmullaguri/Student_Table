package com.example.StudentApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.StudentApp.modal.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {
	

	@Query("SELECT std FROM Student std where std.stdId=?1")
	public Student getStudent(Long id);
}
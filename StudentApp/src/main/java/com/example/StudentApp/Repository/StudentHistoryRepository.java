package com.example.StudentApp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentApp.modal.StudentHistory;

public interface StudentHistoryRepository extends JpaRepository<StudentHistory, Long> {
	

}

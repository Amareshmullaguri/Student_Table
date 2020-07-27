package com.example.StudentApp.modal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Employee {
		@Id
		@GeneratedValue
		private Long stdId;
		private Long empId;
		private String Employeename;
		private String comapany;
		private String worklocation;
		
	}

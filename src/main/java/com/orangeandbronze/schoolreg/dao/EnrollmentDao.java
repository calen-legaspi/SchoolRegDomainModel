package com.orangeandbronze.schoolreg.dao;

import com.orangeandbronze.schoolreg.domain.Enrollment;
import com.orangeandbronze.schoolreg.domain.Student;

public interface EnrollmentDao {

	public Enrollment findLatestBy(Student student) ;
	
	public Enrollment findBy(Student student, String term);

}

package com.orangeandbronze.schoolreg.domain;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

public class EnrollmentTest {

	@Test
	public void enlistInFirstSection() {
		String term = "2014 1st";
		Enrollment enrollment = new Enrollment(123, new Student(456), term);
		Section section = new Section("MTH123", new Subject("ENG101"), term);
		enrollment.enlist(section);
		assertTrue( enrollment.getSections().contains(section));
	}
	
	@Test(expected = EnlistmentConflictException.class)
	public void enlistInSectionWithScheduleConflict() {
		String term = "2014 1st";
		Enrollment enrollment = new Enrollment(123, new Student(456), term);
		Section sec1 = new Section("MTH123", new Subject("ENG101"), term, new Schedule(Days.MTH, Period.AM10));
		enrollment.enlist(sec1);
		Section sec2 = new Section("TFX123", new Subject("BA101"), term, new Schedule(Days.MTH, Period.AM10));
		enrollment.enlist(sec2);
	}
	
	@Test
	public void enlistSectionIfNoScheduleSpecified() {
		String term = "2014 1st";
		Enrollment enrollment = new Enrollment(123, new Student(456), term);
		final Section sec1 = new Section("MTH123", new Subject("ENG101"), term, new Schedule(Days.MTH, Period.AM10));
		enrollment.enlist(sec1);
		final Section sec2 = new Section("TFX123", new Subject("BA101"), term);
		enrollment.enlist(sec2);
		assertThat(enrollment.getSections(), containsInAnyOrder(sec1, sec2));	//TODO replace deprecated method
	}
	
	@Test(expected = MissingPrerequisitesException.class)
	public void enlistInSectionWithoutPrerequisite() {
		final Subject math11 = new Subject("MATH 11");
		final Subject math14 = new Subject("MATH 14");
		Set<Subject> prerequisites = new HashSet<Subject>() {{ add(math11); add(math14); }};
		Subject math53 = new Subject("MATH 53", prerequisites);
		String term = "2014 1st";
		Section section = new Section("ABC123", math53, term);
		Enrollment enrollment = new Enrollment(123, new Student(456), term);
		enrollment.enlist(section);
	}
	
	@Test(expected = MissingPrerequisitesException.class)
	public void enlistInSectionWithOnlyPartialPrerequisite() {
		final Subject math11 = new Subject("MATH 11");
		final Subject math14 = new Subject("MATH 14");
		Set<Subject> prerequisitesToNewSection = new HashSet<Subject>() {{ add(math11); add(math14); }};
		Subject math53 = new Subject("MATH 53", prerequisitesToNewSection);
		Section newSection = new Section("ABC123", math53, "2014 1st");
		
		Student student = new Student(456);
		
		Enrollment previousEnrollment = new Enrollment(122, student, "2013 1st");
		Section oldSection = new Section("XXX111", math11,  "2013 1st");
		
		Enrollment enrollment = new Enrollment(123, student, "2014 1st");		
		enrollment.enlist(newSection);
	}
}

package com.orangeandbronze.schoolreg.domain;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.Test;

public class StudentTest {

	@Test
	public void getPreviousEnrollments() {
		Student student = new Student(123);
		final Enrollment enrollment1 = new Enrollment(1, student, "2012 1st");
		final Enrollment enrollment2 = new Enrollment(2, student, "2012 2nd");
		final Enrollment enrollment3 = new Enrollment(3, student, "2013 1st");
		
		Collection<Enrollment> previous = student.getPreviousEnrollmentsTo(enrollment3);
		Collection<Enrollment> expected = new ArrayList<Enrollment>() {{ add(enrollment1); add(enrollment2); }};
		assertEquals(expected, previous);
	}

}

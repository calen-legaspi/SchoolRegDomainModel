package com.orangeandbronze.schoolreg.domain;

import static org.apache.commons.lang3.Validate.notNull;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Student extends Entity {

	private final Integer studentNumber;

	private final SortedSet<Enrollment> enrollments = new TreeSet<>();

	public Student(Integer studentNumber) {
		this.studentNumber = studentNumber;
	}

	public Student(Integer studentNumber, Collection<Enrollment> enrollments) {
		this.studentNumber = studentNumber;
		this.enrollments.addAll(enrollments);
	}

	public Integer getStudentNumber() {
		return studentNumber;
	}

	public Collection<Enrollment> getEnrollments() {
		return new HashSet<>(enrollments);
	}

	void add(Enrollment e) {
		notNull(e);
		if (this.equals(e.getStudent())) {
			enrollments.add(e);
		} else {
			throw new IllegalArgumentException("Wrong Student: Tried to add Enrollment " + e + " to Student " + this
					+ " but the Student of the Enrollment was " + e.getStudent());
		}
	}

	void add(Collection<Enrollment> enrollments) {
		notNull(enrollments);
		for (Enrollment e : enrollments) {
			add(e);
		}
	}

	Collection<Enrollment> getPreviousEnrollmentsTo(Enrollment e) {
		notNull(e);
		return new ArrayList(enrollments.headSet(e));
	}

	public boolean hasTakenPrerequisites(Section newSec, Enrollment currentEnrollment) {
		notNull(newSec); notNull(currentEnrollment);
		Collection<Enrollment> prevEnrollments = getPreviousEnrollmentsTo(currentEnrollment);
		return newSec.hasAllPrerequisitesIn(prevEnrollments);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((studentNumber == null) ? 0 : studentNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (studentNumber == null) {
			if (other.studentNumber != null)
				return false;
		} else if (!studentNumber.equals(other.studentNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [studentNumber=" + studentNumber + "]";
	}

	public static final Student NONE = new Student(null);

}

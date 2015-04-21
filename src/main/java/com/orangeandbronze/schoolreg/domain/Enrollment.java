package com.orangeandbronze.schoolreg.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

public class Enrollment extends Entity implements Comparable<Enrollment>{
	
	private final int enrollmentNumber;	
	private final Student student;
	private final String term;
	private final Set<Section> sections = new HashSet<>();
	
	public Enrollment(int enrollmentNumber, Student student, String term) {
		this.enrollmentNumber = enrollmentNumber;
		this.student = student;
		this.term = term;
		if (!student.getEnrollments().contains(this)) {
			student.add(this);
		}
	}
	
	public Enrollment(int enrollmentNumber, Student student, String term, Collection<Section> enlistedSections) {
		this(enrollmentNumber, student, term);
		sections.addAll(enlistedSections);
	}
	
	public int getEnrollmentNumber() {
		return enrollmentNumber;
	}

	public Student getStudent() {
		return student;
	}
	
	/** Returns a copy of the sections in this enrollment. **/
	public Collection<Section> getSections() {
		return new ArrayList<Section>(sections);
	}

	public void enlist(Section newSec) {
		for (Section current : sections) {
			if (current.hasConflict(newSec)) {
				throw new EnlistmentConflictException("Current Section: " + current + ", New Section: " + newSec);
			}
		}		

		if (!student.hasTakenPrerequisites(newSec, this)) {
			throw new MissingPrerequisitesException("Enlisting in " + newSec + " but lacking prerequisite(s).");
		}

		sections.add(newSec);
	}

	@Override
	/** Compares based on Term **/
	public int compareTo(Enrollment other) {
		return this.term.compareTo(other.term);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + enrollmentNumber;
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
		Enrollment other = (Enrollment) obj;
		if (enrollmentNumber != other.enrollmentNumber)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Enrollment# " + enrollmentNumber;
	}

	// Only for JPA
	private Enrollment() {
		this.enrollmentNumber = 0;
		this.student = null;
		this.term = null;
	}
	
	
}

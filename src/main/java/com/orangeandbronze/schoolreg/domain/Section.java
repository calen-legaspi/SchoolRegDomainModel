package com.orangeandbronze.schoolreg.domain;

import java.util.Collection;
import java.util.HashSet;

public class Section extends Entity {

	private final String sectionNumber;
	private final Subject subject;
	private final String term;
	private Faculty instructor;
	private Schedule schedule;

	public Section(String sectionNumber, Subject subject, String term) {
		this.sectionNumber = sectionNumber;
		this.subject = subject;
		this.term = term;
		this.schedule = Schedule.TBA;
		this.instructor = Faculty.TBA;
	}

	public Section(String sectionNumber, Subject subject, String term, Schedule schedule) {
		this(sectionNumber, subject, term);
		this.schedule = schedule;
	}
	
	public Section(String sectionNumber, Subject subject, String term, Schedule schedule, Faculty instructor) {
		this(sectionNumber, subject, term, schedule);
		this.instructor = instructor;
	}

	public String getSectionNumber() {
		return sectionNumber;
	}

	public Subject getSubject() {
		return subject;
	}

	public Faculty getInstructor() {
		return instructor;
	}

	void setInstructor(Faculty instructor) {
		this.instructor = instructor;
	}

	public Schedule getSchedule() {
		return schedule;
	}

	void setSchedule(Schedule schedule) {
		this.schedule = schedule;
	}
	
	public String getTerm() {
		return term;
	}

	boolean hasConflict(Section other) {
		// using Yoda conditions to avoid null pointer
		if (Schedule.TBA == this. schedule  || Schedule.TBA == other.schedule) {	
			return false;
		}
		return this.schedule.equals(other.schedule);
	}

	Collection<Subject> getPrerequisites() {
		return subject.getPrerequisites();
	}
	
	//TODO Check if some logic can be pushed down to Subject
	boolean hasAllPrerequisitesIn(Collection<Enrollment> prevEnrollments) {
		if (subject.getPrerequisites().isEmpty()) {
			return true;
		}
		Collection<Subject> prerequisitesRequired = getPrerequisites();
		Collection<Subject> prerequisitesTaken = new HashSet<>();
		for (Enrollment prevEnrollment : prevEnrollments) {
			Collection<Section> prevSections = prevEnrollment.getSections();
			for (Section prevSection : prevSections){
				Subject subject = prevSection.getSubject();
				if (prerequisitesRequired.contains(subject)) {
					prerequisitesTaken.add(subject);
				}
			}
		}
		return prerequisitesTaken.containsAll(prerequisitesRequired);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((sectionNumber == null) ? 0 : sectionNumber.hashCode());
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
		Section other = (Section) obj;
		if (sectionNumber == null) {
			if (other.sectionNumber != null)
				return false;
		} else if (!sectionNumber.equals(other.sectionNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return sectionNumber + " {" + subject + " " + schedule + "} ";
	}
	
	/** Null Object pattern **/
	public final static Section NONE = new Section("Does Not Exist", null, null);

}

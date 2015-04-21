package com.orangeandbronze.schoolreg.service;

import com.orangeandbronze.schoolreg.domain.Section;


public class SectionInfo {
	public final String sectionNumber;
	public final String subject;
	public final String term;
	public final String instructor;
	public final String schedule;
	
	public SectionInfo(Section section) {
		this.sectionNumber = section.getSectionNumber();
		this.subject = section.getSubject().toString();
		this.term = section.getTerm();
		this.instructor = section.getInstructor().toString();
		this.schedule = section.getSchedule().toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((instructor == null) ? 0 : instructor.hashCode());
		result = prime * result + ((schedule == null) ? 0 : schedule.hashCode());
		result = prime * result + ((sectionNumber == null) ? 0 : sectionNumber.hashCode());
		result = prime * result + ((subject == null) ? 0 : subject.hashCode());
		result = prime * result + ((term == null) ? 0 : term.hashCode());
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
		SectionInfo other = (SectionInfo) obj;
		if (instructor == null) {
			if (other.instructor != null)
				return false;
		} else if (!instructor.equals(other.instructor))
			return false;
		if (schedule == null) {
			if (other.schedule != null)
				return false;
		} else if (!schedule.equals(other.schedule))
			return false;
		if (sectionNumber == null) {
			if (other.sectionNumber != null)
				return false;
		} else if (!sectionNumber.equals(other.sectionNumber))
			return false;
		if (subject == null) {
			if (other.subject != null)
				return false;
		} else if (!subject.equals(other.subject))
			return false;
		if (term == null) {
			if (other.term != null)
				return false;
		} else if (!term.equals(other.term))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "SectionInfo [sectionNumber=" + sectionNumber + ", subject=" + subject + ", term=" + term + ", instructor=" + instructor + ", schedule="
				+ schedule + "]";
	}
	
	
	
	
}

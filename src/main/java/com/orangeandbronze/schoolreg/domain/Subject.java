package com.orangeandbronze.schoolreg.domain;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Subject extends Entity {
	
	private final String subjectId;
	private final List<Subject> prerequisites = new ArrayList<>();

	public Subject(String subjectId) {
		this.subjectId = subjectId;
	}
	
	public Subject(String subjectId, Collection<Subject> prerequisites) {
		this.subjectId = subjectId;
		this.prerequisites.addAll(prerequisites);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((subjectId == null) ? 0 : subjectId.hashCode());
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
		Subject other = (Subject) obj;
		if (subjectId == null) {
			if (other.subjectId != null)
				return false;
		} else if (!subjectId.equals(other.subjectId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return subjectId;
	}

	public String getSubjectId() {
		return subjectId;
	}

	public Collection<Subject> getPrerequisites() {
		return new ArrayList<>(prerequisites);
	}
	

}

package com.orangeandbronze.schoolreg.domain;

public class Faculty extends Entity {

	public static final Faculty TBA = new Faculty(0) {

		@Override
		public String toString() {
			return "TBA";
		}
	};

	private final Integer facultyNumber;

	public Faculty(Integer facultyNumber) {
		this.facultyNumber = facultyNumber;

	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((facultyNumber == null) ? 0 : facultyNumber.hashCode());
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
		Faculty other = (Faculty) obj;
		if (facultyNumber == null) {
			if (other.facultyNumber != null)
				return false;
		} else if (!facultyNumber.equals(other.facultyNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Faculty [facultyNumber=" + facultyNumber + "]";
	}


	public Integer getFacultyNumber() {
		return facultyNumber;
	}

}

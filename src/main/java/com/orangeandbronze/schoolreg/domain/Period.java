package com.orangeandbronze.schoolreg.domain;

public enum Period {
	AM830("8:30am - 10am"), AM10("10am - 11:30am"), AM1130("11:30am - 1pm"), PM1("1pm - 2:30pm"), PM230("2:30pm - 4pm"), PM4("4pm - 5:30pm");
	
	private String readableString;
	
	private Period(String readableString) {
		this.readableString = readableString;
	}
	
	@Override
	public String toString() {
		return readableString;
	}
	
	public static Period valueOfReadableString(String readableString) {
		for(Period period : values()) {
			if (period.readableString.equalsIgnoreCase(readableString)) {
				return period;
			}
		}
		throw new IllegalArgumentException("No period maps to " + readableString);
	}
}

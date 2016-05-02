package models;

import java.time.LocalDate;
import java.util.Objects;

public final class Employee {
	private final String name;
	private final int age;
	private final String jobTitle;
	// using LocalDate as it's part of Java 8 and is immutable so no need to
	// return
	// a defensive copy
	private final LocalDate startDate;

	public Employee(String name, int age, String jobTitle, LocalDate startDate) {
		this.name = name;
		this.age = age;
		this.jobTitle = jobTitle;
		this.startDate = startDate;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getJobTitle() {
		return jobTitle;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	@Override
	public final boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Employee))
			return false;

		String name = ((Employee) obj).getName();
		int age = ((Employee) obj).getAge();
		String jobTitle = ((Employee) obj).getJobTitle();
		LocalDate startDate = ((Employee) obj).getStartDate();

		if (!(this.getName().equals(name)))
			return false;
		if ( this.getAge() != age)
			return false;
		if (!(this.getJobTitle().equals(jobTitle)))
			return false;
		if (!(this.getStartDate().isEqual(startDate)))
			return false;

		return true;
	}

	@Override
	public final int hashCode() {
		return Objects.hash(this.name, this.age, this.jobTitle, this.startDate);
	}
}

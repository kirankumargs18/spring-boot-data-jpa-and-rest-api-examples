package com.globallogic.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/*
 * @Entity annotation defines that a class can be mapped to a table
 * */

@Entity
@Table(name = "employee")
public class Employee {

	/*
	 * @Id annotation is the JPA is used for making specific variable primary key.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@NotEmpty(message = "first name should not be empty")
	@Size(min = 5, message = "Size should be minimum 5 characters")
	@Column(name = "first_name", unique = false, nullable = false)
	private String firstName;

	@NotEmpty(message = "first name should not be empty")
	@Size(min = 2, message = "Size should be minimum 2 characters")
	@Column(name = "last_name")
	private String lastName;

	@NotNull
	private double salary;

	@Min(value = 20)
	private int age;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", salary=" + salary
				+ ", age=" + age + "]";
	}

}

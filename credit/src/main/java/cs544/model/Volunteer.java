package cs544.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Volunteer {
	private long volunteerId;
	private String firstName;
	private String lastName;
	@OneToOne
	@Column(name="Task_Volunteer")
	private Task task;
	
	public Volunteer() {
		
	}
	public Volunteer(String firstName, String lastName) {
		this.firstName=firstName;
		this.lastName=lastName;
	}
	public long getVolunteerId() {
		return volunteerId;
	}
	public void setVolunteerId(long volunteerId) {
		this.volunteerId = volunteerId;
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
	public Task getTask() {
		return task;
	}
	public void setTask(Task task) {
		this.task = task;
	}
	
	
}

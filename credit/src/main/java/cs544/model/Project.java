package cs544.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Project {
	@Id
	@GeneratedValue
	private long projectId;
	private String description;
	private String location;
	@Embedded
	private TimeFrame timeframe;
	@OneToMany(mappedBy = "project", cascade=CascadeType.PERSIST)
	private List<Task> tasks;

	/* Constructors */
	public Project() {
	}
	
	public Project(String description, String location, TimeFrame timeframe, List<Task> tasks) {
		this.description=description;
		this.location=location;
		this.timeframe=timeframe;
		this.tasks=tasks;
	}

	/* Getters & Setters */

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getProjectId() {
		return projectId;
	}

	public void setProjectId(long projectId) {
		this.projectId = projectId;
	}

	public TimeFrame getTimeframe() {
		return timeframe;
	}

	public void setTimeframe(TimeFrame timeframe) {
		this.timeframe = timeframe;
	}

	public List<Task> getTasks() {
		return tasks;
	}

	public void setTasks(List<Task> tasks) {
		this.tasks = tasks;
	}

	/* Collections Methods */
	public boolean addTask(Task task) {
		boolean success = false;
		if (tasks.add(task)) {
			task.setProject(this);
			success = true;
		}
		return success;
	}

	public boolean removeTask(Task task) {
		boolean success = false;
		if (tasks.remove(task)) {
			task.setProject(null);
			success = true;
		}
		return success;
	}
}

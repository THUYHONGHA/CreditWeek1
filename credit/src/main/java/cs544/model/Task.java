package cs544.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;

@Entity
public class Task {
	@Id
	@GeneratedValue
	private long taskId;
	@Embedded
	private TimeFrame timeframe;
	@ManyToOne
	private Project project;
	@OneToOne(mappedBy = "Task_Volunteer")
	private Volunteer volunteer;
	@OneToMany(mappedBy = "task", cascade = CascadeType.PERSIST)
	@OrderBy("project")
	private List<Resource> resources;

	public Task(TimeFrame timeframe, Project project) {
		this.timeframe=timeframe;
		this.project=project;
	}

	public long getTaskId() {
		return taskId;
	}

	public void setTaskId(long taskId) {
		this.taskId = taskId;
	}

	public TimeFrame getTimeframe() {
		return timeframe;
	}

	public void setTimeframe(TimeFrame timeframe) {
		this.timeframe = timeframe;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Volunteer getVolunteer() {
		return volunteer;
	}

	public void setVolunteer(Volunteer volunteer) {
		this.volunteer = volunteer;
	}

	public List<Resource> getResources() {
		return resources;
	}

	public void setResources(List<Resource> resources) {
		this.resources = resources;
	}

	/* Constructors */
	public Task() {
	}

	/* Getters and Setters */

	/* Collection Methods */
	public boolean addResource(Resource resource) {
		boolean success = false;
		if (resources.add(resource)) {
			resource.setTask(this);
			success = true;
		}
		return success;
	}

	public boolean removeResource(Resource resource) {
		boolean success = false;
		if (resources.remove(resource)) {
			resource.setTask(null);
			success = true;
		}
		return success;
	}
}

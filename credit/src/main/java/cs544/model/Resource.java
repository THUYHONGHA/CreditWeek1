package cs544.model;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Resource {
	public enum Type {
		SKILL, ASSET
	}

	@Id
	@GeneratedValue
	private long resourceId;
	@Enumerated(EnumType.STRING)
	private Type type;
	private String description;
	@ManyToOne
	private Task task;

	/* Constructors */
	public Resource() {
	}

	public Resource(String description, Type type) {
		this.description = description;
		this.type = type;
	}

	public long getResourceId() {
		return resourceId;
	}

	public void setResourceId(long resourceId) {
		this.resourceId = resourceId;
	}

	public Type getType() {
		return type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	/* Getters & Setters */

}

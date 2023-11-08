package com.bigcorp.project.main.correction;

import java.util.Objects;

public class MonDto {

	private final Long id;

	private final String name;

	private final Boolean active;
	
	private String lastName;
	
	public MonDto(Long id, String name, Boolean active) {
		super();
		this.id = id;
		this.name = name;
		this.active = active;
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Boolean getActive() {
		return active;
	}

	@Override
	public String toString() {
		return "MonDto [id=" + id + ", name=" + name + ", active=" + active + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(active, id, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MonDto other = (MonDto) obj;
		return Objects.equals(active, other.active) && Objects.equals(id, other.id) && Objects.equals(name, other.name);
	}

}

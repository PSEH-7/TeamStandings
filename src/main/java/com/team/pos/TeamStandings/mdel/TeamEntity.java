package com.team.pos.TeamStandings.mdel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TeamTable")
public class TeamEntity {

	private String name;
	private Integer id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public TeamEntity() {
	}
	
	@Override
	public String toString() {
		return "TeamEntity [name=" + name + ", id=" + id + "]";
	}
	
}

package com.team.pos.TeamStandings.mdel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="LeagueTable")
public class LeagueEntity {

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
	public LeagueEntity() {
	}
	
	@Override
	public String toString() {
		return "LeagueEntity [name=" + name + ", id=" + id + "]";
	}
	
	
}

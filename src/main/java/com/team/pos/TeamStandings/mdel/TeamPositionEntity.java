package com.team.pos.TeamStandings.mdel;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="TeamPosTable")
public class TeamPositionEntity {

	private Integer id;
	private Integer teamId;
	private Integer leagueId;
	private Integer countryId;
	private Integer position;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getTeamId() {
		return teamId;
	}
	public void setTeamId(Integer teamId) {
		this.teamId = teamId;
	}
	public Integer getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(Integer leagueId) {
		this.leagueId = leagueId;
	}
	public Integer getCountryId() {
		return countryId;
	}
	public void setCountryId(Integer countryId) {
		this.countryId = countryId;
	}
	public Integer getPosition() {
		return position;
	}
	public void setPosition(Integer position) {
		this.position = position;
	}
	public TeamPositionEntity() {
	}
	
	@Override
	public String toString() {
		return "TeamPositionEntity [id=" + id + ", teamId=" + teamId + ", leagueId=" + leagueId + ", countryId="
				+ countryId + ", position=" + position + "]";
	}
	
	

}

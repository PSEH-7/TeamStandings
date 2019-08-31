package com.team.pos.TeamStandings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.pos.TeamStandings.mdel.TeamPositionEntity;

@Repository
public interface TeamStandingRepository extends JpaRepository<TeamPositionEntity, Integer>{
}

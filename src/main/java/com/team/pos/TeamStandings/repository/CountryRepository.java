package com.team.pos.TeamStandings.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.team.pos.TeamStandings.mdel.CountryEntity;

@Repository
public interface CountryRepository extends JpaRepository<CountryEntity, Integer>{

}

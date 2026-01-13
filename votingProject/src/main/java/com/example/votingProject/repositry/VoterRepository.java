package com.example.votingProject.repositry;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.votingProject.entity.Voter;

public interface VoterRepository extends JpaRepository<Voter, Long>{
	Optional<Voter> findByIpAddress(String ipAddress);

}

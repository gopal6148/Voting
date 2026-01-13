package com.example.votingProject.repositry;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.votingProject.entity.Candidate;

public interface CandidateRepository extends JpaRepository<Candidate, Long>{

}

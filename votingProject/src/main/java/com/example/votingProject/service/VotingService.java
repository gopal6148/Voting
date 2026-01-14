package com.example.votingProject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.votingProject.entity.Candidate;
import com.example.votingProject.entity.Voter;
import com.example.votingProject.repositry.CandidateRepository;
import com.example.votingProject.repositry.VoterRepository;


@Service
public class VotingService {
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@Autowired
	private VoterRepository voterRepo;
	
	public List<Candidate> getCandidates() {
        return candidateRepository.findAll();
    }

	 public int vote(Long candidateId, String ip) {

	        //already voted
	       if (voterRepo.findByIpAddress(ip).isPresent()) {
	            throw new RuntimeException("ALREADY_VOTED");
	        }

	        // save vote
	        Candidate c = candidateRepository.findById(candidateId)
	                .orElseThrow();

	        c.setVotes(c.getVotes() + 1);
	        candidateRepository.save(c);

	        // save voter IP
	        Voter voter = new Voter();
	        voter.setIpAddress(ip);
	        voterRepo.save(voter);

	        // return total votes
	        return candidateRepository.findAll()
	                .stream()
	                .mapToInt(Candidate::getVotes)
	                .sum();
	    }

}

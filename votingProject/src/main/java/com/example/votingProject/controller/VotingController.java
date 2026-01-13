package com.example.votingProject.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.votingProject.dto.ResultDTO;
import com.example.votingProject.entity.Candidate;
import com.example.votingProject.repositry.CandidateRepository;
import com.example.votingProject.service.VotingService;

import jakarta.servlet.http.HttpServletRequest;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api")
public class VotingController {
	
	@Autowired
    private VotingService service;
	
	@Autowired
	private CandidateRepository candidateRepository;
	
	@GetMapping("/candidates")
    public List<Candidate> getCandidates() {
        return service.getCandidates();
    }
	@GetMapping("/results")
	public List<ResultDTO> getResults() {
	    return candidateRepository.findAll()
	            .stream()
	            .map(c -> new ResultDTO(c.getName(), c.getVotes()))
	            .toList();
	}
	
	@PostMapping("/vote/{id}")
	public Map<String, Object> vote(
	        @PathVariable Long id,
	        HttpServletRequest request) {

	    String ip = request.getRemoteAddr();

	    try {
	        int totalVotes = service.vote(id, ip);
	        return Map.of(
	                "status", "SUCCESS",
	                "totalVotes", totalVotes
	        );
	    } catch (RuntimeException e) {
	        return Map.of(
	                "status", "ALREADY_VOTED"
	        );
	    }
	}

	

}

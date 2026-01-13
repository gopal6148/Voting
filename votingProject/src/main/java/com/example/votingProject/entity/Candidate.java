package com.example.votingProject.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Candidate {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String candidateImage;
    private String partyImage;
    private String symbolUrl;
    private int votes;
    
    
	public String getCandidateImage() {
		return candidateImage;
	}
	public void setCandidateImage(String candidateImage) {
		this.candidateImage = candidateImage;
	}
	public String getPartyImage() {
		return partyImage;
	}
	public void setPartyImage(String partyImage) {
		this.partyImage = partyImage;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSymbolUrl() {
		return symbolUrl;
	}
	public void setSymbolUrl(String symbolUrl) {
		this.symbolUrl = symbolUrl;
	}
	public int getVotes() {
		return votes;
	}
	public void setVotes(int votes) {
		this.votes = votes;
	}

}

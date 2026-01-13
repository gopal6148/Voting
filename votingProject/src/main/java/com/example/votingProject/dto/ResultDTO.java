package com.example.votingProject.dto;

public class ResultDTO {
	
	private String name;
    private int votes;

    public ResultDTO(String name, int votes) {
        this.name = name;
        this.votes = votes;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getVotes() {
		return votes;
	}

	public void setVotes(int votes) {
		this.votes = votes;
	}

}

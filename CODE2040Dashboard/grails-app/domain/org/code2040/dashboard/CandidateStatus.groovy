package org.code2040.dashboard;

public enum CandidateStatus {
	CANDIDATE(1), CURRENT_FELLOW(2), DENIED(3), ALUMNI(4)
	
	int status
	
	CandidateStatus() {
		this.status = 0
	}
	
	CandidateStatus(int status) {
		this.status = status
	}
}
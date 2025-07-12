// File: InterviewRound.java
package abhinav.code;

import java.time.LocalDateTime;

public class InterviewRound {
    private String companyName;
    private String roundDetails;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String roundStatus;

    public InterviewRound(String companyName, String roundDetails, LocalDateTime startTime, LocalDateTime endTime, String roundStatus) {
        this.companyName = companyName;
        this.roundDetails = roundDetails;
        this.startTime = startTime;
        this.endTime = endTime;
        this.roundStatus = roundStatus;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getRoundDetails() {
        return roundDetails;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public String getRoundStatus() {
        return roundStatus;
    }

    public void setRoundStatus(String roundStatus) {
        this.roundStatus = roundStatus;
    }

    @Override
    public String toString() {
        return "Round Details: " + roundDetails +
                ", Scheduled from: " + startTime + endTime +
                ", Status: " + roundStatus;
    }
}
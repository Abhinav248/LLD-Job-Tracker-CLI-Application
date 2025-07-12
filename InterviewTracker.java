// File: InterviewTracker.java
package abhinav.code;

import java.util.*;
import java.util.logging.Logger;

public class InterviewTracker {
    private static final Logger logger = Logger.getLogger(InterviewTracker.class.getName());
    private final Map<String, LinkedList<InterviewRound>> interviewMap;

    public InterviewTracker() {
        interviewMap = new HashMap<>();
    }

    public void addInterviewRound(String company, InterviewRound round) {
        interviewMap.putIfAbsent(company, new LinkedList<>());
        interviewMap.get(company).addLast(round);
        logger.info("Added new round for company: " + company);
    }

    public void updateLastRoundStatus(String company, String status) {
        if (!interviewMap.containsKey(company)) {
            logger.warning("No interview rounds found for company: " + company);
            return;
        }
        LinkedList<InterviewRound> rounds = interviewMap.get(company);
        if (!rounds.isEmpty()) {
            InterviewRound lastRound = rounds.getLast();
            lastRound.setRoundStatus(status);
            logger.info("Updated last round status for " + company + " to " + status);
            if ("failed".equalsIgnoreCase(status)) {
                System.out.println("❌ Interview process ended for " + company + ". No further rounds scheduled.");
            }
        }
    }

    public List<InterviewRound> getRoundsForCompany(String company) {
        return interviewMap.getOrDefault(company, new LinkedList<>());
    }

    public void printAllRoundsForAllCompanies() {
        if (interviewMap.isEmpty()) {
            System.out.println("⚠️ No interview records available.");
            return;
        }
        for (String company : interviewMap.keySet()) {
            System.out.println("\nCompany: " + company);
            LinkedList<InterviewRound> rounds = interviewMap.get(company);
            if (rounds.isEmpty()) {
                System.out.println("   ⚠️ No rounds scheduled yet.");
                continue;
            }
            int count = 1;
            for (InterviewRound round : rounds) {
                System.out.println("   Round " + count++ + ": " + round);
            }
        }
    }

    public boolean hasCompany(String company) {
        return interviewMap.containsKey(company);
    }
}
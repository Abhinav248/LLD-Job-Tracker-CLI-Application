// File: Main.java
package abhinav.code;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Main {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CompanyDirectory companyDirectory = new CompanyDirectory();
        InterviewTracker interviewTracker = new InterviewTracker();

        while (true) {
            System.out.println("\n========== INTERVIEW TRACKER CLI ==========");
            System.out.println("1️⃣  Add or Update Company");
            System.out.println("2️⃣  View Company Details");
            System.out.println("3️⃣  List All Companies");
            System.out.println("4️⃣  Filter Companies by Minimum CTC");
            System.out.println("5️⃣  Add Interview Round");
            System.out.println("6️⃣  Update Last Round Status");
            System.out.println("7️⃣  View Interview Rounds of a Company");
            System.out.println("8️⃣  View All Interview Rounds (All Companies)");
            System.out.println("9️⃣  Exit");
            System.out.print("\n👉 Enter your choice (1-9): ");

            String input = scanner.nextLine();
            int choice;
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                logger.warning("Invalid input. Please enter a number between 1 and 9.");
                continue;
            }

            switch (choice) {
                case 1:
                    System.out.print("🏢 Enter Company Name: ");
                    String name = scanner.nextLine().trim();
                    System.out.print("💼 Enter Role: ");
                    String role = scanner.nextLine().trim();
                    System.out.print("📍 Enter Location: ");
                    String location = scanner.nextLine().trim();
                    System.out.print("💰 Enter Base Salary (LPA): ");
                    double baseSalary;
                    try {
                        baseSalary = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        logger.warning("Invalid base salary input. Please enter a valid number.");
                        break;
                    }
                    System.out.print("💰 Enter CTC (LPA): ");
                    double ctc;
                    try {
                        ctc = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        logger.warning("Invalid CTC input. Please enter a valid number.");
                        break;
                    }
                    companyDirectory.addOrUpdateCompany(new Company(name, role, location, baseSalary, ctc));
                    logger.info("Company added/updated successfully.");
                    break;

                case 2:
                    System.out.print("🔍 Enter Company Name to View Details: ");
                    String searchCompany = scanner.nextLine();
                    Company found = companyDirectory.getCompany(searchCompany);
                    if (found != null) {
                        System.out.println("\n📄 Company Details:");
                        System.out.println(found);
                    } else {
                        System.out.println("⚠️ Company not found.");
                    }
                    break;

                case 3:
                    System.out.println("\n📋 Listing All Companies:");
                    companyDirectory.listAllCompanies();
                    break;

                case 4:
                    System.out.print("🔎 Enter Minimum CTC (LPA): ");
                    double minCtc;
                    try {
                        minCtc = Double.parseDouble(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        logger.warning("Invalid input. Please enter a valid number for CTC.");
                        break;
                    }
                    List<Company> filtered = companyDirectory.filterCompaniesByMinCTC(minCtc);
                    if (filtered.isEmpty()) {
                        System.out.println("⚠️ No companies found with CTC >= " + minCtc);
                    } else {
                        System.out.println("\n💡 Companies with CTC >= " + minCtc + ":");
                        filtered.forEach(System.out::println);
                    }
                    break;

                case 5:
                    System.out.print("🏢 Enter Company Name to Add Round: ");
                    String compName = scanner.nextLine();
                    if (!companyDirectory.hasCompany(compName)) {
                        System.out.println("⚠️ Company not found. Please add it first.");
                        break;
                    }
                    System.out.print("📝 Enter Round Details: ");
                    String roundDetails = scanner.nextLine();
                    System.out.print("📌 Enter Round Status: ");
                    String status = scanner.nextLine();
                    System.out.print("🕒 Enter Interview Start Date & Time (DD:MM:YYYY HH:MM): ");
                    String startDateTimeInput = scanner.nextLine().trim();
                    DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm");
                    LocalDateTime startDateTime;
                    try {
                        startDateTime = LocalDateTime.parse(startDateTimeInput, formatter1);
                    } catch (DateTimeParseException e) {
                        logger.warning("❌ Invalid date/time format. Please use DD:MM:YYYY HH:MM.");
                        break;
                    }
                    System.out.print("🕒 Enter Interview End Date & Time (DD:MM:YYYY HH:MM): ");
                    String endDateTimeInput = scanner.nextLine().trim();
                    DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("dd:MM:yyyy HH:mm");
                    LocalDateTime endDateTime;
                    try {
                        endDateTime = LocalDateTime.parse(endDateTimeInput, formatter2);
                    } catch (DateTimeParseException e) {
                        logger.warning("❌ Invalid date/time format. Please use DD:MM:YYYY HH:MM.");
                        break;
                    }
                    interviewTracker.addInterviewRound(compName, new InterviewRound(compName, roundDetails, startDateTime, endDateTime, status));
                    logger.info("Interview round added successfully.");
                    break;

                case 6:
                    System.out.print("🏢 Enter Company Name to Update Last Round: ");
                    String updateCompany = scanner.nextLine();
                    System.out.print("✏️ Enter New Status: ");
                    String newStatus = scanner.nextLine();
                    interviewTracker.updateLastRoundStatus(updateCompany, newStatus);
                    break;

                case 7:
                    System.out.print("🏢 Enter Company Name to View Rounds: ");
                    String viewRounds = scanner.nextLine();
                    List<InterviewRound> rounds = interviewTracker.getRoundsForCompany(viewRounds);
                    if (rounds.isEmpty()) {
                        System.out.println("⚠️ No rounds found for this company.");
                    } else {
                        System.out.println("\n📄 Interview Rounds:");
                        for (int i = 0; i < rounds.size(); i++) {
                            System.out.println("Round " + (i + 1) + ": " + rounds.get(i));
                        }
                    }
                    break;

                case 8:
                    System.out.println("\n📊 All Interview Rounds (All Companies):");
                    interviewTracker.printAllRoundsForAllCompanies();
                    break;

                case 9:
                    System.out.println("👋 Exiting Interview Tracker. Goodbye!");
                    logger.info("User exited the application.");
                    return;

                default:
                    System.out.println("❌ Invalid choice. Please choose a number between 1 and 9.");
            }
        }
    }
}
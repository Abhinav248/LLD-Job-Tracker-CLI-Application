# LLD-Job-Tracker-CLI-Application

# 📋 Interview Tracker CLI (Java)

A command-line Java application that helps you track interviews for multiple companies. You can add companies, track multiple interview rounds per company, update round statuses, view detailed information, and log activity — all from your terminal.

---

## 🚀 Features (Total: 19)

| #  | Feature                                                                 |
|----|-------------------------------------------------------------------------|
| 1️⃣ | Add a new company                                                      |
| 2️⃣ | View all added companies                                               |
| 3️⃣ | Get detailed company info                                              |
| 4️⃣ | Add new interview rounds to a company                                 |
| 5️⃣ | Get all interview rounds for a company                                |
| 6️⃣ | Update the status of any interview round                              |
| 7️⃣ | Mark the last round as `failed` to indicate no further rounds         |
| 8️⃣ | Show a message if no more rounds are scheduled                        |
| 9️⃣ | View all rounds across all companies                                  |
| 🔟 | View the status of the last round for any company                      |
| 1️⃣1️⃣ | Support for multiple companies with their own round lists        |
| 1️⃣2️⃣ | Round data includes: company name, round details, datetime, status |
| 1️⃣3️⃣ | Enter date & time manually (DD:MM:YYYY HH:MM format)              |
| 1️⃣4️⃣ | Logging system for important actions & errors                      |
| 1️⃣5️⃣ | Clear CLI prompts and menus                                        |
| 1️⃣6️⃣ | Handle missing or invalid inputs gracefully                        |
| 1️⃣7️⃣ | Get meaningful error messages when data isn't found                |
| 1️⃣8️⃣ | List each company's full interview timeline                        |
| 1️⃣9️⃣ | CLI loop runs until you choose to exit                             |

---

## 🛠️ Tech Stack

- **Java 17+**
- **Maven (Optional)**
- **Standard Logging API (`java.util.logging`)**
- **OOP Principles (Encapsulation, Abstraction, SOLID)**

---

## 🏗️ Project Structure

InterviewTracker/
│
├── src/main/java/abhinav/code/
│ ├── Main.java # Entry point + CLI handler
│ ├── InterviewTracker.java # Core logic & data manager
│ ├── InterviewRound.java # Model class for each interview round
│ ├── Company.java # Model class for each company
│ └── GraphNode.java # Optional - for tracking other relations
│
└── README.md # Project documentation

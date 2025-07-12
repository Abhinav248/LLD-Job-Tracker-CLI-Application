// File: Company.java
package abhinav.code;

public class Company {
    private String name;
    private String role;
    private String location;
    private double baseSalary;
    private double ctc;

    public Company(String name, String role, String location, double baseSalary, double ctc) {
        this.name = name;
        this.role = role;
        this.location = location;
        this.ctc = ctc;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public String getLocation() {
        return location;
    }

    public double getCtc() {
        return ctc;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setCtc(double ctc) {
        this.ctc = ctc;
    }

    public String toString() {
        return "Company: " + name + ", Role: " + role + ", Location: " + location + ", CTC: " + ctc + " LPA";
    }
}
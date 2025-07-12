// File: CompanyDirectory.java
package abhinav.code;

import java.util.*;
import java.util.logging.Logger;

public class CompanyDirectory {
    private static final Logger logger = Logger.getLogger(CompanyDirectory.class.getName());
    private final Map<String, Company> companyMap;

    public CompanyDirectory() {
        this.companyMap = new HashMap<>();
    }

    public void addOrUpdateCompany(Company company) {
        companyMap.put(company.getName(), company);
        logger.info("Added/Updated company: " + company.getName());
    }

    public Company getCompany(String name) {
        return companyMap.get(name);
    }

    public void listAllCompanies() {
        if (companyMap.isEmpty()) {
            System.out.println("⚠️ No companies available.");
            return;
        }
        System.out.println("\nAll Companies:");
        for (Company c : companyMap.values()) {
            System.out.println(" - " + c);
        }
    }

    public List<Company> filterCompaniesByMinCTC(double minCtc) {
        List<Company> result = new ArrayList<>();
        for (Company c : companyMap.values()) {
            if (c.getCtc() >= minCtc) {
                result.add(c);
            }
        }
        return result;
    }

    public boolean hasCompany(String name) {
        return companyMap.containsKey(name);
    }
}
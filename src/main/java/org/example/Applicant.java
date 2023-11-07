package org.example;

import java.util.List;

public class Applicant {
    private List<String> previousCompanies;
    private String currentCity;
    private String preferredLocation;
    private double expectedSalary;
    private String status;
    private String specialization;
    private String appliedJobPosition;

    public Applicant(List<String> previousCompanies, String currentCity, String preferredLocation,
                     double expectedSalary, String status, String specialization, String appliedJobPosition) {
        this.previousCompanies = previousCompanies;
        this.currentCity = currentCity;
        this.preferredLocation = preferredLocation;
        this.expectedSalary = expectedSalary;
        this.status = status;
        this.specialization = specialization;
        this.appliedJobPosition = appliedJobPosition;
    }

    public List<String> getPreviousCompanies() {
        return previousCompanies;
    }

    public void setPreviousCompanies(List<String> previousCompanies) {
        this.previousCompanies = previousCompanies;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public void setCurrentCity(String currentCity) {
        this.currentCity = currentCity;
    }

    public String getPreferredLocation() {
        return preferredLocation;
    }

    public void setPreferredLocation(String preferredLocation) {
        this.preferredLocation = preferredLocation;
    }

    public double getExpectedSalary() {
        return expectedSalary;
    }

    public void setExpectedSalary(double expectedSalary) {
        this.expectedSalary = expectedSalary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getAppliedJobPosition() {
        return appliedJobPosition;
    }

    public void setAppliedJobPosition(String appliedJobPosition) {
        this.appliedJobPosition = appliedJobPosition;
    }

    public static boolean isRelocationPreferred(String preferredLocation, String currentCity) {
        return !preferredLocation.equals(currentCity);
    }
}

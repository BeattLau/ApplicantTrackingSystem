package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HRSystem {
    private List<JobPosition> jobPositions;
    private List<Recruiter> recruiters;
    private List<Applicant> applicants;

    public HRSystem() {
        this.jobPositions = new ArrayList<>();
        this.recruiters = new ArrayList<>();
        this.applicants = new ArrayList<>();
    }


    public List<JobPosition> getJobPositions() {
        return jobPositions;
    }

    public void setJobPositions(List<JobPosition> jobPositions) {
        this.jobPositions = jobPositions;
    }

    public List<Recruiter> getRecruiters() {
        return recruiters;
    }

    public void setRecruiters(List<Recruiter> recruiters) {
        this.recruiters = recruiters;
    }

    public List<Applicant> getApplicants() {
        return applicants;
    }

    public void setApplicants(List<Applicant> applicants) {
        this.applicants = applicants;
    }

    public void addJobPosition(JobPosition jobPosition){
        if (jobPosition != null) {
            jobPositions.add(jobPosition);
            System.out.println("Job position added successfully");
        } else {
            System.out.println("Invalid job position. Please try again");
        }
    }
    public void addRecruiter(Recruiter recruiter){
        if (recruiter != null) {
            recruiters.add(recruiter);
            System.out.println("Recruiter added successfully");
        } else {
            System.out.println("Invalid recruiter. Please try again");
        }
    }
    public void addApplicant(Applicant applicant){
        if (applicant != null) {
            applicants.add(applicant);
            System.out.println("Applicant added successfully");
        } else {
            System.out.println("Invalid applicant. Please try again");
        }
    }
    public void generateReports(){
        Map<String, Integer> statusCounts = new HashMap<>();
        Map<String, Integer> jobPositionCounts = new HashMap<>();

        for (Applicant applicant : applicants) {
            String status = applicant.getStatus();
            statusCounts.put(status, statusCounts.getOrDefault(status, 0) + 1);

            String appliedJobPosition = applicant.getAppliedJobPosition();
            jobPositionCounts.put(appliedJobPosition, jobPositionCounts.getOrDefault(appliedJobPosition, 0) + 1);
        }

        System.out.println("Applicants per Status:");
        for (Map.Entry<String, Integer> entry : statusCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

        System.out.println("\nApplicants per Job Position:");
        for (Map.Entry<String, Integer> entry : jobPositionCounts.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }

    }

}
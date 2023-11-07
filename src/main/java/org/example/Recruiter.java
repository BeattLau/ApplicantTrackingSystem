package org.example;

import java.util.List;
import java.util.Set;

public class Recruiter {
    private String name;
    private List<JobPosition> jobPositionsManaged;
    private Set<String> specializedIndustries;
    private Set<String> specializedRoles;

    public Recruiter(String name, List<JobPosition> jobPositionsManaged, Set<String> specializedIndustries, Set<String> specializedRoles) {
        this.name = name;
        this.jobPositionsManaged = jobPositionsManaged;
        this.specializedIndustries = specializedIndustries;
        this.specializedRoles = specializedRoles;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<JobPosition> getJobPositionsManaged() {
        return jobPositionsManaged;
    }

    public void setJobPositionsManaged(List<JobPosition> jobPositionsManaged) {
        this.jobPositionsManaged = jobPositionsManaged;
    }

    public Set<String> getSpecializedIndustries() {
        return specializedIndustries;
    }

    public void setSpecializedIndustries(Set<String> specializedIndustries) {
        this.specializedIndustries = specializedIndustries;
    }

    public Set<String> getSpecializedRoles() {
        return specializedRoles;
    }

    public void setSpecializedRoles(Set<String> specializedRoles) {
        this.specializedRoles = specializedRoles;
    }

    void assignJobPosition(JobPosition jobPosition) {
        jobPositionsManaged.add(jobPosition);
    }

    void reviewApplicant(Applicant applicant) {
        boolean isSpecialized = false;
        JobPosition matchedJobPosition = null;

        for (JobPosition jobPosition : jobPositionsManaged) {
            if (isSpecializedFor(jobPosition, applicant)) {
                isSpecialized = true;
                matchedJobPosition = jobPosition;
                break;
            }
        }

        if (isSpecialized) {
            if (applicant.getExpectedSalary() >= matchedJobPosition.getOfferedSalaryRangeStart() &&
                    applicant.getExpectedSalary() <= matchedJobPosition.getOfferedSalaryRangeEnd()) {
                applicant.setStatus("Under Review");
            } else {
                applicant.setStatus("Salary Expectations Not Met");
            }
        } else {
            applicant.setStatus("Not a match");
        }
    }


    public boolean isSpecializedFor(JobPosition jobPosition, Applicant applicant) {
        List<String> jobRequiredSkills = jobPosition.getRequiredSkills();
        boolean isSpecialized = specializedIndustries.stream().anyMatch(jobRequiredSkills::contains) ||
                specializedRoles.stream().anyMatch(jobRequiredSkills::contains);

        return isSpecialized;
    }

}

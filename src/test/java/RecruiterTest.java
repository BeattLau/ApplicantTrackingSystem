import org.example.Applicant;
import org.example.JobPosition;
import org.example.Recruiter;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class RecruiterTest {
    @Test
    public void testIsSpecializedFor_True() {

        Set<String> specializedIndustries = new HashSet<>(Arrays.asList("IT", "Finance"));
        Set<String> specializedRoles = new HashSet<>(Arrays.asList("Manager", "Developer"));

        Recruiter recruiter = new Recruiter("John Doe", null, specializedIndustries, specializedRoles);

        JobPosition jobPosition = new JobPosition("Job title", "Description", 40000, 50000,
                Arrays.asList("Developer", "Java"), "Location", "IT", "Developer");


        Applicant applicant = new Applicant(Arrays.asList("Company1", "Company2"), "City1", "City1", 45000, "Pending", "IT", "Job title");

        assertTrue(recruiter.isSpecializedFor(jobPosition, applicant));
    }

    @Test
    public void testIsSpecializedFor_False() {

        Set<String> specializedIndustries = new HashSet<>(Arrays.asList("IT", "Finance"));
        Set<String> specializedRoles = new HashSet<>(Arrays.asList("Manager", "Developer"));

        Recruiter recruiter = new Recruiter("John Doe", null, specializedIndustries, specializedRoles);

        JobPosition jobPosition = new JobPosition("Job title", "Description", 40000, 50000,
                Arrays.asList("Sales", "Marketing"), "Location", "Business", "Sales");


        Applicant applicant = new Applicant(Arrays.asList("Company1", "Company2"), "City1", "City1", 45000, "Pending", "IT", "Job title");

        assertFalse(recruiter.isSpecializedFor(jobPosition, applicant));
    }
}
import org.example.Applicant;
import org.example.JobPosition;
import org.junit.Test;
import java.util.Arrays;
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JobPositionTest {
    @Test
    public void IsWithinBudget_True() {
        JobPosition jobPosition = new JobPosition("Job title", "Description", 40000, 50000, Arrays.asList("Skill1", "Skill2"), "Location", "Industry", "Role");
        Applicant applicant = new Applicant(Arrays.asList("Company1", "Company2"), "City1", "City1", 45000, "Pending", "IT", "Job title");

        boolean result = jobPosition.isWithinBudget(applicant, 45000);

        assertTrue(result);
    }

    @Test
    public void IsWithinBudget_False() {
        JobPosition jobPosition = new JobPosition("Job title", "Description", 40000, 50000, Arrays.asList("Skill1", "Skill2"), "Location", "Industry", "Role");
        Applicant applicant = new Applicant(Arrays.asList("Company1", "Company2"), "City1", "City1", 55000, "Pending", "IT", "Job title");
        assertFalse(jobPosition.isWithinBudget(applicant, 35000));


        assertFalse(jobPosition.isWithinBudget(applicant, 55000));


        assertTrue(jobPosition.isWithinBudget(applicant, 40000));


        assertTrue(jobPosition.isWithinBudget(applicant, 50000));
    }
}
import org.example.Applicant;
import org.example.HRSystem;
import org.example.JobPosition;
import org.example.Recruiter;

import org.junit.Test;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class HRSystemTest {
    @Test
    public void testAddJobPosition() {
        HRSystem hrSystem = new HRSystem();


        JobPosition jobPosition = new JobPosition("Software Engineer", "Description", 60000, 80000,
                Collections.singletonList("Java"), "Location", "IT", "Developer");
        hrSystem.addJobPosition(jobPosition);
        List<JobPosition> jobPositions = hrSystem.getJobPositions();
        assertEquals(1, jobPositions.size());

        hrSystem.addJobPosition(null);
        jobPositions = hrSystem.getJobPositions();
        assertEquals(1, jobPositions.size());
    }

    @Test
    public void testAddRecruiter() {
        HRSystem hrSystem = new HRSystem();


        Recruiter recruiter = new Recruiter("John Doe", null, null, null);
        hrSystem.addRecruiter(recruiter);
        List<Recruiter> recruiters = hrSystem.getRecruiters();
        assertEquals(1, recruiters.size());


        hrSystem.addRecruiter(null);
        recruiters = hrSystem.getRecruiters();
        assertEquals(1, recruiters.size());
    }

    @Test
    public void testAddApplicant() {
        HRSystem hrSystem = new HRSystem();

        Applicant applicant = new Applicant(Arrays.asList("Company1", "Company2"), "City1", "City1",
                60000, "Pending", "IT", "Software Engineer");
        hrSystem.addApplicant(applicant);
        List<Applicant> applicants = hrSystem.getApplicants();
        assertEquals(1, applicants.size());

        hrSystem.addApplicant(null);
        applicants = hrSystem.getApplicants();
        assertEquals(1, applicants.size());
    }

    @Test
    public void testGenerateReports() {
        HRSystem hrSystem = new HRSystem();


        Applicant applicant1 = new Applicant(Arrays.asList("Company1"), "City1", "City1",
                60000, "Pending", "IT", "Software Engineer");
        Applicant applicant2 = new Applicant(Arrays.asList("Company2"), "City1", "City1",
                70000, "Selected", "IT", "Software Engineer");

        hrSystem.addApplicant(applicant1);
        hrSystem.addApplicant(applicant2);

        hrSystem.generateReports();
    }
}


package org.launchcode.techjobs_oo.Tests;


import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class JobTest {
    Job testJobOne;
    Job testJobTwo;


    @Before
    public void createJobObject() {
        testJobOne = new Job();
        testJobTwo = new Job();

    }

    @Test
    public void testSettingJobId() {
        assertFalse(testJobOne.getId() == testJobTwo.getId());
        assertTrue(testJobTwo.getId() - testJobOne.getId() == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields () {
        Job newJob = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        //id int
        assertTrue(newJob.getName() instanceof String);
        assertTrue(newJob.getEmployer() instanceof Employer);
        assertTrue(newJob.getLocation() instanceof Location);
        assertTrue(newJob.getPositionType() instanceof PositionType);
        assertTrue(newJob.getCoreCompetency() instanceof CoreCompetency);


    }

    @Test
    public void testJobsForEquality () {
        Job newJobOne = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job newJobTwo = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(newJobOne.getId() == newJobTwo.getId());
    }
}

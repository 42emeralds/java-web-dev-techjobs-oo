package org.launchcode.techjobs_oo.Tests;


import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertFalse;

public class JobTest {
    Job testJobOne;
    Job testJobTwo;
    Job testJobAllFields;
    Job testJobOneEmpty;

    @Before
    public void createJobObject() {
        testJobOne = new Job();
        testJobTwo = new Job();
        testJobAllFields = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        testJobOneEmpty = new Job("", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));


    }

    //Testing equals

    @Test
    public void testSettingJobId() {
        assertFalse(testJobOne.getId() == testJobTwo.getId());
        assertTrue(testJobTwo.getId() - testJobOne.getId() == 1);
    }

    @Test
    public void testJobConstructorSetsAllFields () {

        assertTrue(testJobAllFields.getName() instanceof String);
        assertTrue(testJobAllFields.getEmployer() instanceof Employer);
        assertTrue(testJobAllFields.getLocation() instanceof Location);
        assertTrue(testJobAllFields.getPositionType() instanceof PositionType);
        assertTrue(testJobAllFields.getCoreCompetency() instanceof CoreCompetency);


    }

    @Test
    public void testJobsForEquality () {

        assertFalse(testJobOne.getId() == testJobTwo.getId());
    }

    //Testing String

    @Test
    public void jobStringHasBlankLinesBeforeAndAfter () {
       String newJobString = testJobAllFields.toString();

        assertTrue(newJobString.startsWith("\n"));
        assertTrue(newJobString.endsWith("\n"));

    }

    @Test
    public void jobContainsLabelAndContentOnNewLinesForEachField () {
        String newJobString = testJobAllFields.toString();

        assertTrue(newJobString.contains("ID: " + testJobAllFields.getId() + "\n" +
                "Name: " + testJobAllFields.getName() + "\n" +
                "Employer: " + testJobAllFields.getEmployer() + "\n" +
                "Location: " + testJobAllFields.getLocation() + "\n" +
                "Position Type: " + testJobAllFields.getPositionType() + "\n" +
                "Core Competency: " + testJobAllFields.getCoreCompetency() + "\n"));
    }

    @Test
    public void emptyJobFieldPrintsNotAvailable () {
        String newJobEmptyString = testJobOneEmpty.toString();

        assertTrue(newJobEmptyString.contains("Data not available"));

    }

    @Test
    public void allFieldsEmptyShouldReturnError () {
        String newJobNull = testJobOne.toString();

        assertTrue(newJobNull.contains("OOPS! This job does not seem to exist."));
    }

}

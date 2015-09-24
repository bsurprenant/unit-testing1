/* 
 * Copyright (C) 2014 Karl R. Wurst
 * 
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301, USA
 */
/**
 * Represents a student record for the purposes of a degree audit.
 * 
 * @author Karl R. Wurst
 * @version JUnit Lab
 */
public class Student
{
    // Information about the individual student
    private double gpa;
    private String firstName, lastName, id;
    private int currentEarnedCr; // Current earned credits (already completed)
    private int anticipatedAdditionalCr; // Anticipated additional credits (currently taking)
    private boolean lascComplete; // Has the student completed LASC requirements
    private boolean majorComplete; //Has the student completed requirements for the major

    // Minimum number of credits required to graduate
    public static final int REQUIRED_CR = 120;
    
    // Keeps track of the id number to assign to the next student to be created
    private static int nextId = 1;

    /**
     * Creates a new student given a first and last name. An id number is assigned sequentially.
     * 
     * @param firstName the student's first name
     * @param lastName the student's last name
     */
    public Student(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.id = String.format("%07d",nextId); // 7 digits wide, zero padded
        nextId++;
    }

    /**
     * Returns the number of students which have been created.
     * 
     * @return the number of students which have been created
     */
    public static int getStudentCount() {
        return nextId-1;
    }
    
    /**
     * Set the GPA of the student.
     * 
     * @param gpa the student's GPA
     */
    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    /**
     * Returns the student's GPA.
     * 
     * @return the student's GPA
     */
    public double getGpa() {
        return gpa;
    }

    /**
     * Sets the student's first name.
     * 
     * @param firstName the student's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the student's first name.
     * 
     * @returns the student's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the student's last name.
     *
     * @param lastName the student's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the student's last name.
     * 
     * @returns the student's last name
     */    
    public String getLastName() {
        return lastName;
    }
    
    /**
     * Returns the student's ID number.
     * 
     * @returns the student's ID number
     */    
    public String getId() {
        return id;
    }

    /**
     * Sets the student's current earned credits.
     * (This should really be done by looking at a 
     * list of completed courses, not by setting it directly.)
     * 
     * @param currentEarnedCr the number of current earned credits
     */
    public void setCurrentEarnedCr(int currentEarnedCr) {
        this.currentEarnedCr = currentEarnedCr;
    }

    /**
     * Returns the student's current earned credits.
     * 
     * @return the student's current earned credits
     */
    public int getCurrentEarnedCr() {
        // This should really be done by looking at a 
        // list of completed courses, not by returning a variable.
        return currentEarnedCr;
    }
    
    /**
     * Sets the student's anticipated additional credits (the 
     * courses they are currently taking).
     * (This should really be done by looking at a 
     * list of registered courses, not by setting it directly.)
     * 
     * @param anticipatedAdditionalCr the number of anticipated additional credits
     */
    public void setAnticipatedAdditionalCr(int anticipatedAdditionalCr) {
        this.anticipatedAdditionalCr = anticipatedAdditionalCr;
    }

    /**
     * Returns the student's anticipated additional credits.
     * 
     * @return the student's anticipated additional credits
     */
    public int getAnticipatedAdditionalCr() {
        // This should really be done by looking at a 
        // list of registered courses, not by returning a variable.
        return anticipatedAdditionalCr;
    }

    /**
     * Sets whether the student has completed the LASC requirements.
     * (This should really be done by looking at a 
     * list of completed courses, not by setting it directly.)
     * 
     * @param lascComplete whether LASC requirements are complete
     */
    public void setLascComplete(boolean lascComplete) {
        this.lascComplete = lascComplete;
    }

    /**
     * Returns whether the student has completed the LASC requirements.
     * 
     * @return whether the student has completed the LASC requirements
     */
    public boolean getLascComplete() {
        // This should really be done by looking at a 
        // list of complete courses, not by returning a variable.
        return lascComplete;
    }

    /**
     * Sets whether the student has completed the major requirements.
     * (This should really be done by looking at a 
     * list of completed courses, not by setting it directly.)
     * 
     * @param majorComplete whether major requirements are complete
     */
    public void setMajorComplete(boolean majorComplete) {
        this.majorComplete = majorComplete;
    }

    /**
     * Returns whether the student has completed the major requirements.
     * 
     * @return whether the student has completed the major requirements
     */
    public boolean getMajorComplete() {
        // This should really be done by looking at a 
        // list of complete courses, not by returning a variable.
        return majorComplete;
    }
    
    /**
     * Returns the student's remaining credits to graduate
     * (not including the courses they are currently taking).
     * 
     * @return the student's remaining credits to graduate
     */
    public int getCurrentRemainingCr() {
        return REQUIRED_CR - currentEarnedCr;
    }

    /**
     * Returns the student's anticipated remaining credits to graduate
     * (including the courses they are currently taking).
     * 
     * @return the student's anticipated remaining credits to graduate
     */
    public int getAnticipatedRemainingCr() {
        return getCurrentRemainingCr() - anticipatedAdditionalCr;
    }

    /**
     * Returns whether the student is ready to graduate.
     * 
     * @return whether the student is ready to graduate
     */
    public boolean readyToGraduate() {
        return getCurrentRemainingCr() <= 0 && gpa >= 2.0 && lascComplete && majorComplete;
    }
}

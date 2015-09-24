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
 * Creates student objects and calls methods on them.
 * 
 * @author Karl R. Wurst 
 * @version JUnit Lab
 */
public class DegreeAudit
{
    /**
     * Creates Student objects and calls methods on them to test the methods.
     * 
     * @param args commandline arguments (not used)
     */
    public static void main(String[] args) {
        // Check static constant representing the number of credits required to graduate.
        System.out.println("credits to graduate = " + Student.REQUIRED_CR);
        // Initial check of number of student created.
        System.out.println("Number of students " + Student.getStudentCount());
        
        // Create a student.
        Student s1 = new Student("Jane", "Smith");
        // Print the student's ID.
        System.out.println("ID " + s1.getId());
        // Check count of created students.
        System.out.println("Number of students " + Student.getStudentCount());

        // Set some characteristics of the student.
        s1.setGpa(2.5);
        s1.setCurrentEarnedCr(110);
        // Check number of credits remaining.
        System.out.println(s1.getCurrentRemainingCr());
        // Change credits.
        s1.setCurrentEarnedCr(120);
        // Check number of credits remaining.
        System.out.println(s1.getCurrentRemainingCr());
        
        // Set LASC and major requirement to be complete.
        s1.setMajorComplete(true);
        s1.setLascComplete(true);
        // Is the student ready to graduate?
        System.out.println("Ready to graduate: " + s1.readyToGraduate());
        
        // Create another student.
        Student s2 = new Student("John", "Smith");
        // Check that the ID number has gone up.
        System.out.println("ID " + s2.getId());
        //Check that the number of students has gone up.
        System.out.println("Number of students " + Student.getStudentCount());
    }
}

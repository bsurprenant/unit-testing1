import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;


public class StudentTest {
	
	private Student student1 = new Student ("Jane", "Smith");
	private int studentCT;
	
	@Before
	public void setUp() throws Exception {
		studentCT = Student.getStudentCount();
	}

	
	@Test
	public void testCurrentEarnedCr() {
		int credits = 45;
		student1.setCurrentEarnedCr(credits);
		assertEquals(credits, student1.getCurrentEarnedCr());
	}
	
	
	@Test
	public void testAnticipatedAdditionalCr() {
		int credits = 45;
		student1.setAnticipatedAdditionalCr(credits);
		assertEquals(credits, student1.getAnticipatedAdditionalCr());
	}
	
	@Test
	public void testReadyToGraduate1() {
		student1.setCurrentEarnedCr(120);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertTrue(student1.readyToGraduate());
	}
	
	@Test
	public void testReadyToGraduate2() {
		student1.setCurrentEarnedCr(130);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertTrue(student1.readyToGraduate());
	}
	
	@Test
	public void testNotReadyToGraduateCredits() {
		student1.setCurrentEarnedCr(119);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertFalse(student1.readyToGraduate());
	}
	
	@Test
	public void testNotReadyToGraduateGPA() {
		student1.setCurrentEarnedCr(120);
		student1.setGpa(1.3);
		student1.setMajorComplete(true);
		student1.setLascComplete(true);
		assertFalse(student1.readyToGraduate());
	}
	
	@Test
	public void testNotReadyToGraduateMajorReq() {
		student1.setCurrentEarnedCr(120);
		student1.setGpa(2.0);
		student1.setMajorComplete(false);
		student1.setLascComplete(true);
		assertFalse(student1.readyToGraduate());
	}
	
	@Test
	public void testNotReadyToGraduateLascReq() {
		student1.setCurrentEarnedCr(120);
		student1.setGpa(2.0);
		student1.setMajorComplete(true);
		student1.setLascComplete(false);
		assertFalse(student1.readyToGraduate());
	}

	@Test
	public void getStudentCount() {
		assertEquals(studentCT, Student.getStudentCount());
	}
	

	@Test
	public void testGpa() {
		student1.setGpa(2.1);
		assertEquals(2.1, student1.getGpa(), 0);
	}
	
	@Test
	public void testFirstName() {
		String name = "bob";
		student1.setFirstName(name);
		assertEquals(name, student1.getFirstName());
	}
	
	@Test
	public void testLastName() {
		String lname = "Johnson";
		student1.setFirstName(lname);
		assertEquals(lname, student1.getFirstName());
	}
	
	@Test
	public void testGetID() {
		String currentID = String.format("%07d",studentCT);
		assertEquals(student1.getId(), currentID);
	}

	@Test
	public void testCurrentEarnedCredits() {
		int credits = 10;
		student1.setCurrentEarnedCr(credits);
		assertEquals(credits, student1.getCurrentEarnedCr());
	}
	
	@Test
	public void testLascComplete() {
		student1.setLascComplete(true);
		assertTrue(student1.getLascComplete());
	}
	
	@Test
	public void testLascNotComplete() {
		student1.setLascComplete(false);
		assertFalse(student1.getLascComplete());
	}
	
	@Test
	public void testMajorComplete() {
		student1.setMajorComplete(true);
		assertTrue(student1.getMajorComplete());
	}
	
	@Test
	public void testMajorNotComplete() {
		student1.setMajorComplete(false);
		assertFalse(student1.getMajorComplete());
	}
	
	@Test
	public void testGetCurrentRemainingCredits() {
		assertEquals(student1.getCurrentRemainingCr(),(120 - student1.getCurrentEarnedCr()));
	}
	
	@Test
	public void testNoRemainingCredits() {
		student1.setCurrentEarnedCr(125);
		assertEquals(student1.getAnticipatedRemainingCr(), (120-student1.getCurrentEarnedCr()));
	}
	
	
	@Test
	public void testGetAnticipatedRemainingCredits() {
		assertEquals(student1.getAnticipatedRemainingCr(), (120-(student1.getCurrentEarnedCr()+student1.getAnticipatedAdditionalCr())));
	}
	
	@Test
	public void testTooManyAnticipatedRemainingCredits() {
		student1.setCurrentEarnedCr(110);
		student1.setAnticipatedAdditionalCr(30);
		assertEquals(student1.getAnticipatedRemainingCr(), (120-(student1.getCurrentEarnedCr()+student1.getAnticipatedAdditionalCr())));
	}
}

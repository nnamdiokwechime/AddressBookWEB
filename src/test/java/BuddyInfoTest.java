import static org.junit.Assert.*;

import app.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

public class BuddyInfoTest {

	BuddyInfo buddy = null;
	
	@Before
	public void setUp() {
		buddy = new BuddyInfo("Jacob","6132220092");

	}

	@Test
	public void testGetName()
	{
		assertEquals("Jacob", buddy.getName());
	}

	@Test
	public void testSetName() {
		buddy.setName("John");
		assertEquals("John", buddy.getName());
	}

	@Test
	public void testGetPhoneNumber()
	{
		assertEquals("6132220092", buddy.getPhoneNumber());
	}

	@Test
	public void testSetPhoneNumber() {
		buddy.setPhoneNumber("3435409483");
		assertEquals("3435409483", buddy.getPhoneNumber());
	}

	@Test
	public void testToString()
	{
		assertEquals("Name: Jacob. Phone Number: 6132220092\n", buddy.toString());
	}

}

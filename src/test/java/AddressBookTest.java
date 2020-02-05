import static org.junit.Assert.*;

import app.AddressBook;
import app.BuddyInfo;
import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {

	AddressBook contacts = null;
	BuddyInfo bud = null;
	BuddyInfo buddy = null;
	
	
	@Before
	public void setUp()  {
		contacts = new AddressBook();
		bud = new BuddyInfo("John","Canada");
		buddy = new BuddyInfo("Jacob", "3435409999");
		
	}

	@Test
	public void testSize() {
		assertEquals(0,contacts.size());
		contacts.addBuddy(bud);
		contacts.addBuddy(buddy);
		assertEquals(2,contacts.size());
	}
	
	@Test 
	public void testClear() {
		contacts.addBuddy(bud);
		contacts.addBuddy(buddy);
		contacts.clear();
		assertEquals(0,contacts.size());
	}

	@Test
	public void testAddBuddy() {
		contacts.addBuddy(bud);
		assertEquals(1,contacts.size());
	}

	@Test
	public void testRemoveBuddy() {
		contacts.addBuddy(bud);
		contacts.removeBuddy(0);
		assertEquals(0,contacts.size());
	}

	@Test
	public void testToString() {
		contacts.addBuddy(buddy);
		assertEquals("Name: Jacob. Phone Number: 3435409999\n", contacts.toString());
	}

}

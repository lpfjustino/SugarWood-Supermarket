package sugarwood.supermarket;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import sugarwood.supermarket.User;


public class UserTest {

	User user;
	
	@Before
	public void setUp() throws Exception {
		user = new User(10, "ze", "avenida", "123456", "email@email", "pass1234");		
	}
	
	@Test
	public void testGetId() {
		assertTrue(user.getId() == 10);
	}

	@Test
	public void testSetId() {
		user.setId(5);
		assertTrue(user.getId() == 5);
	}

}

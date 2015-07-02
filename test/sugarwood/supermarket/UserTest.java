package sugarwood.supermarket;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class UserTest {
	User user1, user2, user3, user4, user5;
	
	@Before
	public void setUp() throws Exception {
            user1 = new User (11, "jao", "alameda", "1234", "mail", "password");
            user2 = new User (10, "ze", "avenida", "1234", "mail", "password");
            user3 = new User (1, "luis", "catanduva", "4321", "lpfjustino@gmail.com", "minhasenha");
            user4 = new User (2, "biffi", "vinhedo", "1234", "rbneto@gmail.com", "segredo");
            user5 = new User (3, "adenilsoN", "sanca", "5534", "outroemail@whatever.com", "senha");
	}
	
	@Test
	public void testGetters() {
                assertTrue(user1.getId() == 11);
		assertTrue(user2.getId() == 10);
		assertTrue(user3.getName().equals("luis"));
		assertTrue(user4.getPhone().equals("1234"));
		assertTrue(user5.getMail().equals("outroemail@whatever.com"));
	}

	@Test
	public void testSetters() {
		user1.setId(5);
		assertTrue(user1.getId() == 5);
                
                user2.setAddress("outroendereco");
                assertTrue(user2.getAddress().equals("outroendereco"));
                
                user3.setName("nome novo");
                assertTrue(user3.getAddress().equals("nome novo"));
                
                user4.setPhone("1111 2222");
                assertTrue(user3.getPhone().equals("1111 2222"));
                
                user5.setPassword("usernewpwd");
                assertTrue(user5.getAddress().equals("usernewpwd"));
	}

}

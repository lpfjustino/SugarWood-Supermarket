package sugarwood.supermarket.csv;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import sugarwood.supermarket.Supermarket;
import sugarwood.supermarket.User;
import sugarwood.supermarket.product.SupermarketProduct;
import sugarwood.supermarket.product.SupplierProduct;

public class CSVManagerTest {
	
	User user, user2;
	SupermarketProduct product, product2;

	@Before
	public void setUp() throws Exception {
		user = new User (11, "jao", "alameda", "1234", "mail", "password");
		user2 = new User (10, "ze", "avenida", "1234", "mail", "password");
		product = new SupermarketProduct(new SupplierProduct("batata", "triunfo", new Date()), 13, 12.35);
		product2 = new SupermarketProduct(new SupplierProduct("bolacha", "triunfo", new Date()), 12, 12.35);
	}

	@Test
	public void testUserPersist() {
		CSVManager.persist(user);
		CSVManager.persist(user2);
		ArrayList<User> fetchUser = CSVManager.fetch(User.class);
		assertTrue((fetchUser.get(0)).getId() == 11);
		assertTrue((fetchUser.get(1)).getId() == 10);
	}

	@Test
	public void testProductPersist() {
		CSVManager.persist(product);
		CSVManager.persist(product2);
		ArrayList<SupermarketProduct> fetchProduct = CSVManager.fetch(SupermarketProduct.class);
		assertTrue((fetchProduct.get(0)).getName().equals("batata"));
		assertTrue((fetchProduct.get(1)).getName().equals("bolacha"));
	}
}

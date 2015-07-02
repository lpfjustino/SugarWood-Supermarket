package sugarwood.supermarket.csv;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Date;

import org.junit.Before;
import org.junit.Test;

import sugarwood.supermarket.User;
import sugarwood.supermarket.product.SupermarketProduct;
import sugarwood.supermarket.product.SupplierProduct;

public class CSVManagerTest {
	
	User user, user2, user3, user4, user5;
	SupermarketProduct product, product2, product3, product4, product5;

	@Before
	public void setUp() throws Exception {
		user = new User (11, "jao", "alameda", "1234", "mail", "password");
		user2 = new User (10, "ze", "avenida", "1234", "mail", "password");
		user3 = new User (1, "luis", "catanduva", "4321", "lpfjustino@gmail.com", "minhasenha");
		user4 = new User (2, "biffi", "vinhedo", "1234", "rbneto@gmail.com", "segredo");
		user5 = new User (3, "adenilsoN", "sanca", "5534", "outroemail@whatever.com", "senha");
		product = new SupermarketProduct(new SupplierProduct("batata", "triunfo", new Date()), 13, 11.35);
		product2 = new SupermarketProduct(new SupplierProduct("bolacha", "triunfo", new Date()), 12, 12.35);
		product3 = new SupermarketProduct(new SupplierProduct("pao", "frances", new Date()), 21, 15.40);
		product4 = new SupermarketProduct(new SupplierProduct("chocolate", "nestle", new Date()), 55, 22.22);
		product5 = new SupermarketProduct(new SupplierProduct("bolacha", "triunfo", new Date()), 12, 12.35);
	}

	@Test
	public void testUserPersist() {
		CSVManager.persist(user);
		CSVManager.persist(user2);
		CSVManager.persist(user3);
		CSVManager.persist(user4);
		CSVManager.persist(user5);
		ArrayList<User> fetchUser = CSVManager.fetch(User.class);
		assertTrue((fetchUser.get(0)).getId() == 11);
		assertTrue((fetchUser.get(1)).getId() == 10);
		assertTrue((fetchUser.get(2)).getName().equals("luis"));
		assertTrue((fetchUser.get(3)).getPhone().equals("1234"));
		assertTrue((fetchUser.get(4)).getMail().equals("outroemail@whatever.com"));
	}

	@Test
	public void testProductPersist() {
		CSVManager.persist(product);
		CSVManager.persist(product2);
		CSVManager.persist(product3);
		CSVManager.persist(product4);
		CSVManager.persist(product5);
		ArrayList<SupermarketProduct> fetchProduct = CSVManager.fetch(SupermarketProduct.class);
		assertTrue((fetchProduct.get(0)).getName().equals("batata"));
		assertTrue((fetchProduct.get(1)).getName().equals("bolacha"));
		assertTrue((fetchProduct.get(2)).getSupplier().equals("frances"));
		assertTrue((fetchProduct.get(3)).getId() == 55);
		assertTrue((fetchProduct.get(4)).getPrice() == 12.35);
	}
}

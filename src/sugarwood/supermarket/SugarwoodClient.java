package sugarwood.supermarket;

import java.io.IOException;
import sugarwood.supermarket.product.SupermarketProduct;

public interface SugarwoodClient {
    public void login() throws IOException;
    public void buy(SupermarketProduct product);
}
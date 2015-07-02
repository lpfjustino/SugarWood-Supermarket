package sugarwood.supermarket;

import java.net.Socket;
import sugarwood.supermarket.product.SupermarketProduct;

public interface SugarwoodClient {
    public void login(Socket socket);
    public void buy(SupermarketProduct product);
}
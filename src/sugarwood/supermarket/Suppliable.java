package sugarwood.supermarket;

import java.util.Map;
import sugarwood.supermarket.product.SupplierProduct;

public interface Suppliable {
    public void restock(Map<SupplierProduct, Integer> supply);
}

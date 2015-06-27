package sugarwood.supermarket;

import java.util.Map;
import sugarwood.supermarket.product.SupplierProduct;

public class Supply {
    Map<SupplierProduct, Integer> restock;
    
    public Supply(Map<SupplierProduct, Integer> restock) {
        this.restock = restock;
    }
}

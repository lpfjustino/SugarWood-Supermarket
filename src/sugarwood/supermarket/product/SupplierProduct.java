package sugarwood.supermarket.product;

import java.util.Date;


public class SupplierProduct extends Product {
    public SupplierProduct(String name, String supplier, Date goodThru) {
        this.setName(name);
        this.setSupplier(supplier);
        this.setGoodThru(goodThru);
    }
}

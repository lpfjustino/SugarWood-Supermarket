package sugarwood.supermarket.product;

import java.util.Date;


public abstract class Product {
    private String name;
    private Date goodThru;
    private String supplier;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getGoodThru() {
        return goodThru;
    }

    public void setGoodThru(Date goodThru) {
        this.goodThru = goodThru;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }
    
}

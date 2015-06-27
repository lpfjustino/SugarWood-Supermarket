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
    
    @Override
    public int hashCode() {
        return (getName()+getSupplier()).hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final SupplierProduct other = (SupplierProduct) obj;
        return true;
    }
    
    @Override
    public String toString() {
        String display = "Name: " + getName() + "\n" +
                "GoodThru: " + getGoodThru() + "\n" +
                "Supplier: " + getSupplier();
        
        return display;
    }
}

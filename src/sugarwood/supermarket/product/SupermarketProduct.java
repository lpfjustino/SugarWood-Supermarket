package sugarwood.supermarket.product;


public class SupermarketProduct extends Product {
    private int id;
    private double price;
    
    public SupermarketProduct(SupplierProduct product, int id, double price) {
        this.setId(id);
        this.setPrice(price);
        this.setName(product.getName());
        this.setGoodThru(product.getGoodThru());
        this.setSupplier(product.getSupplier());
    }

    public int getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }
}

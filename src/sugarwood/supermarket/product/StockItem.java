package sugarwood.supermarket.product;

import java.util.Date;
import sugarwood.supermarket.csv.AbstractModel;

public class StockItem implements AbstractModel {
    private SupermarketProduct product;
    private Integer quantity;
    
    public StockItem(SupermarketProduct smp, int qty) {
        this.product = smp;
        this.quantity = qty;
    }
    
    public StockItem() {
        product = new SupermarketProduct();
    }
    
    @Override
    public Integer getId() {
        return getProduct().getId();
    }

    @Override
    public String[] getFieldValues() {
        String[] fieldValues = new String [] {getProduct().getId().toString()
            , getProduct().getName()
            , ((Long)getProduct().getGoodThru().getTime()).toString()
            , getProduct().getSupplier()
            , getProduct().getPrice().toString()
            , getQuantity().toString() };
        return fieldValues;
    }

    @Override
    public void setFieldValues(String[] fieldValues) {
        this.getProduct().setId (Integer.parseInt(fieldValues[0]));
        this.getProduct().setName (fieldValues[1]);
        this.getProduct().setGoodThru(new Date (Long.parseLong(fieldValues[2])));
        this.getProduct().setSupplier(fieldValues[3]);
        this.getProduct().setPrice(Double.parseDouble(fieldValues[4]));
        this.setQuantity((Integer) (Integer.parseInt(fieldValues[5])));
    }

    @Override
    public String getArchiveName() {
        return "stockDatabase.csv";
    }

    public SupermarketProduct getProduct() {
        return product;
    }

    public void setProduct(SupermarketProduct product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

}

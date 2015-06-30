package sugarwood.supermarket.product;

import java.util.Date;

import sugarwood.supermarket.csv.AbstractModel;


public class SupermarketProduct extends Product implements AbstractModel{
    private int id;
    private double price;
    
    public SupermarketProduct(Product product, int id, double price) {
        this.setId(id);
        this.setPrice(price);
        this.setName(product.getName());
        this.setGoodThru(product.getGoodThru());
        this.setSupplier(product.getSupplier());
    }
    
    public SupermarketProduct() {
    	
    }
    
    public SupermarketProduct(String name, Date goodThru, String supplier,
                                                         int id, double price) {
        this.setId(id);
        this.setPrice(price);
        this.setName(name);
        this.setGoodThru(goodThru);
        this.setSupplier(supplier);
    }

    public Integer getId() {
        return id;
    }

    private void setId(int id) {
        this.id = id;
    }

    public Double getPrice() {
        return price;
    }

    private void setPrice(double price) {
        this.price = price;
    }
    
    @Override
    public String toString() {
        String display = "ID: " + getId() + "\n" +
                "Name: " + getName() + "\n" +
                "GoodThru: " + getGoodThru() + "\n" +
                "Supplier: " + getSupplier() + "\n" +
                "Price: " + getPrice();
        
        return display;
    }

	@Override
	public String[] getFieldValues() {
		
		String[] fieldValues = new String [] {getId().toString()
		, getName()
		, ((Long)getGoodThru().getTime()).toString()
		, getSupplier()
		, getPrice().toString()
		};

		return fieldValues;
	}

	@Override
	public void setFieldValues(String[] fieldValues) {
		
		setId (Integer.parseInt(fieldValues[0]));
		setName (fieldValues[1]);
		setGoodThru(new Date (Long.parseLong(fieldValues[2])));
		setSupplier(fieldValues[3]);
		setPrice(Double.parseDouble(fieldValues[4]));
		
	}

	@Override
	public String getArchiveName() {
//		TODO: criar o arquivo e passar o nome certo
		return "productDatabase.csv";
	}
}

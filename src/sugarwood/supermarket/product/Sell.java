package sugarwood.supermarket.product;

import java.util.Date;

import sugarwood.supermarket.User;
import sugarwood.supermarket.csv.AbstractModel;

public class Sell implements AbstractModel {
    private Integer id;
    private User user;
    private Product product;
    private int quantity;
    private Date sellDate;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date getSellDate() {
        return sellDate;
    }

    public void setSellDate(Date sellDate) {
        this.sellDate = sellDate;
    }

	@Override
	public Integer getId() {
		return this.id;
	}
	
	private void setId(Integer id) {
		this.id = id;
	}

	@Override
	public String[] getFieldValues() {
		
		String[] fieldValues = new String [] {getId().toString()
//		, getUser()
		, getProduct().toString()
		, getQuantity().toString()
		, ((Long)getSellDate().getTime()).toString()
		};

		return fieldValues;
	}

	@Override
	public void setFieldValues(String[] fieldValues) {
		setId (Integer.parseInt(fieldValues[0]));
//		setUser(fieldValues[1]);
		setProduct(product); //(new Date (Long.parseLong(fieldValues[2])));
		setQuantity(Integer.parseInt(fieldValues[3]));
		setSellDate(new Date (Long.parseLong(fieldValues[4])));
	}

	@Override
	public String getArchiveName() {
		return "sellDatabase.csv";
	}

}

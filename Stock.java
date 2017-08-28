import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;


@Entity(name="TBL_STOCK")
@Table(name="TBL_STOCK")
@NamedQueries({@NamedQuery(name="p_updateid",query="update TBL_STOCK set P_ID =:id where P_NAME=:name"),@NamedQuery(name="p_updatename",query="update TBL_STOCK set P_NAME =:name where P_ID=:id"),@NamedQuery(name="p_updateprice",query="update TBL_STOCK set P_PRICE =:price where P_ID=:id")})
@NamedNativeQuery(name="delete",query="delete  from TBL_STOCK where P_ID=:id")

public class Stock {
@Id
@Column(name="P_ID",nullable=false,unique=true)
private Integer product_id;
@Column(name="P_NAME")
private String product_Name;
@Column(name="P_PRICE")
private double PRICE;
@Column(name="P_QUANTITY")
private Integer quantity;
@Column(name="P_TAX")
private double tax;
public Stock()
{
	super();
}
public String getProduct_Name() {
	return product_Name;
}
public void setProduct_Name(String product_Name) {
	this.product_Name = product_Name;
}
public Integer getProduct_id() {
	return product_id;
}
public void setProduct_id(Integer product_id) {
	this.product_id = product_id;
}

public double getPRICE() {
	return PRICE;
}
public void setPRICE(double pRICE) {
	this.PRICE = pRICE;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public double getTax() {
	return this.tax;
}
public void setTax(Double double1) {
	this.tax = double1;
}

}




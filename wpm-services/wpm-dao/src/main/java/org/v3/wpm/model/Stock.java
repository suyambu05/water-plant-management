package org.v3.wpm.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the stock database table.
 * 
 */
@Entity
@NamedQuery(name="Stock.findAll", query="SELECT s FROM Stock s")
public class Stock implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="stock_id")
	private int stockId;

	@Column(name="available_stock")
	private int availableStock;

	@Temporal(TemporalType.DATE)
	@Column(name="mfg_date")
	private Date mfgDate;

	@Column(name="treshold_stock")
	private int tresholdStock;

	//bi-directional many-to-one association to Product
	@OneToMany(mappedBy="stock", fetch=FetchType.EAGER)
	private List<Product> products;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Stock() {
	}

	public int getStockId() {
		return this.stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public int getAvailableStock() {
		return this.availableStock;
	}

	public void setAvailableStock(int availableStock) {
		this.availableStock = availableStock;
	}

	public Date getMfgDate() {
		return this.mfgDate;
	}

	public void setMfgDate(Date mfgDate) {
		this.mfgDate = mfgDate;
	}

	public int getTresholdStock() {
		return this.tresholdStock;
	}

	public void setTresholdStock(int tresholdStock) {
		this.tresholdStock = tresholdStock;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setStock(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setStock(null);

		return product;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
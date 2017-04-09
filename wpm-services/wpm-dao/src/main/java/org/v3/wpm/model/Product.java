package org.v3.wpm.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the products database table.
 * 
 */
@Entity
@Table(name="products")
@NamedQuery(name="Product.findAll", query="SELECT p FROM Product p")
public class Product implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="product_id")
	private int productId;

	@Column(name="product_name")
	private String productName;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	private String variant;

	//bi-directional many-to-one association to Stock
	@ManyToOne
	@JoinColumn(name="stock_id")
	private Stock stock;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-many association to Sale
	@ManyToMany(mappedBy="products", fetch=FetchType.EAGER)
	private List<Sale> sales;

	//bi-directional many-to-one association to MaterialDeductionLookup
	@OneToMany(mappedBy="product", fetch=FetchType.EAGER)
	private List<MaterialDeductionLookup> materialDeductionLookups;

	public Product() {
	}

	public int getProductId() {
		return this.productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return this.productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public String getVariant() {
		return this.variant;
	}

	public void setVariant(String variant) {
		this.variant = variant;
	}

	public Stock getStock() {
		return this.stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Sale> getSales() {
		return this.sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	public List<MaterialDeductionLookup> getMaterialDeductionLookups() {
		return this.materialDeductionLookups;
	}

	public void setMaterialDeductionLookups(List<MaterialDeductionLookup> materialDeductionLookups) {
		this.materialDeductionLookups = materialDeductionLookups;
	}

	public MaterialDeductionLookup addMaterialDeductionLookup(MaterialDeductionLookup materialDeductionLookup) {
		getMaterialDeductionLookups().add(materialDeductionLookup);
		materialDeductionLookup.setProduct(this);

		return materialDeductionLookup;
	}

	public MaterialDeductionLookup removeMaterialDeductionLookup(MaterialDeductionLookup materialDeductionLookup) {
		getMaterialDeductionLookups().remove(materialDeductionLookup);
		materialDeductionLookup.setProduct(null);

		return materialDeductionLookup;
	}

}
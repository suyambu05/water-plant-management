package org.v3.wpm.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;

/**
 * The persistent class for the user database table.
 * 
 */
@Entity
@NamedQuery(name = "User.findAll", query = "SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "user_id")
	private int userId;

	private String name;

	private String password;

	private String role;

	@Column(name = "user_name")
	private String userName;

	// bi-directional many-to-one association to Customer
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Customer> customers;

	// bi-directional many-to-one association to Product
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Product> products;

	// bi-directional many-to-one association to RawMaterial
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<RawMaterial> rawMaterials;

	// bi-directional many-to-one association to Sale
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Sale> sales;

	// bi-directional many-to-one association to Stock
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Stock> stocks;

	// bi-directional many-to-one association to Supplier
	@OneToMany(mappedBy = "user", fetch = FetchType.EAGER)
	private List<Supplier> suppliers;

	public User() {
	}

	public int getUserId() {
		return this.userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public List<Customer> getCustomers() {
		return this.customers;
	}

	public void setCustomers(List<Customer> customers) {
		this.customers = customers;
	}

	public Customer addCustomer(Customer customer) {
		getCustomers().add(customer);
		customer.setUser(this);

		return customer;
	}

	public Customer removeCustomer(Customer customer) {
		getCustomers().remove(customer);
		customer.setUser(null);

		return customer;
	}

	public List<Product> getProducts() {
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product addProduct(Product product) {
		getProducts().add(product);
		product.setUser(this);

		return product;
	}

	public Product removeProduct(Product product) {
		getProducts().remove(product);
		product.setUser(null);

		return product;
	}

	public List<RawMaterial> getRawMaterials() {
		return this.rawMaterials;
	}

	public void setRawMaterials(List<RawMaterial> rawMaterials) {
		this.rawMaterials = rawMaterials;
	}

	public RawMaterial addRawMaterial(RawMaterial rawMaterial) {
		getRawMaterials().add(rawMaterial);
		rawMaterial.setUser(this);

		return rawMaterial;
	}

	public RawMaterial removeRawMaterial(RawMaterial rawMaterial) {
		getRawMaterials().remove(rawMaterial);
		rawMaterial.setUser(null);

		return rawMaterial;
	}

	public List<Sale> getSales() {
		return this.sales;
	}

	public void setSales(List<Sale> sales) {
		this.sales = sales;
	}

	public Sale addSale(Sale sale) {
		getSales().add(sale);
		sale.setUser(this);

		return sale;
	}

	public Sale removeSale(Sale sale) {
		getSales().remove(sale);
		sale.setUser(null);

		return sale;
	}

	public List<Stock> getStocks() {
		return this.stocks;
	}

	public void setStocks(List<Stock> stocks) {
		this.stocks = stocks;
	}

	public Stock addStock(Stock stock) {
		getStocks().add(stock);
		stock.setUser(this);

		return stock;
	}

	public Stock removeStock(Stock stock) {
		getStocks().remove(stock);
		stock.setUser(null);

		return stock;
	}

	public List<Supplier> getSuppliers() {
		return this.suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public Supplier addSupplier(Supplier supplier) {
		getSuppliers().add(supplier);
		supplier.setUser(this);

		return supplier;
	}

	public Supplier removeSupplier(Supplier supplier) {
		getSuppliers().remove(supplier);
		supplier.setUser(null);

		return supplier;
	}

}
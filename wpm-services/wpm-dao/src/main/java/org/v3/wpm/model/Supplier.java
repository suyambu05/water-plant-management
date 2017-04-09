package org.v3.wpm.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the supplier database table.
 * 
 */
@Entity
@NamedQuery(name="Supplier.findAll", query="SELECT s FROM Supplier s")
public class Supplier implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="supplier_id")
	private int supplierId;

	@Temporal(TemporalType.DATE)
	private Date date;

	@Column(name="supplier_address")
	private String supplierAddress;

	@Column(name="supplier_contact")
	private String supplierContact;

	@Column(name="supplier_name")
	private String supplierName;

	//bi-directional many-to-many association to RawMaterial
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="raw_material_has_supplier"
		, joinColumns={
			@JoinColumn(name="supplier_supplier_id")
			}
		, inverseJoinColumns={
			@JoinColumn(name="raw_material_material_id")
			}
		)
	private List<RawMaterial> rawMaterials;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	public Supplier() {
	}

	public int getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getSupplierAddress() {
		return this.supplierAddress;
	}

	public void setSupplierAddress(String supplierAddress) {
		this.supplierAddress = supplierAddress;
	}

	public String getSupplierContact() {
		return this.supplierContact;
	}

	public void setSupplierContact(String supplierContact) {
		this.supplierContact = supplierContact;
	}

	public String getSupplierName() {
		return this.supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}

	public List<RawMaterial> getRawMaterials() {
		return this.rawMaterials;
	}

	public void setRawMaterials(List<RawMaterial> rawMaterials) {
		this.rawMaterials = rawMaterials;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
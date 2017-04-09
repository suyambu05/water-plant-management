package org.v3.wpm.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the raw_material database table.
 * 
 */
@Entity
@Table(name="raw_material")
@NamedQuery(name="RawMaterial.findAll", query="SELECT r FROM RawMaterial r")
public class RawMaterial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="material_id")
	private int materialId;

	@Column(name="material_name")
	private String materialName;

	@Column(name="supplier_id")
	private int supplierId;

	@Column(name="treshold_quantity")
	private double tresholdQuantity;

	private String unit;

	@Temporal(TemporalType.DATE)
	@Column(name="updated_date")
	private Date updatedDate;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_id")
	private User user;

	//bi-directional many-to-many association to Supplier
	@ManyToMany(mappedBy="rawMaterials", fetch=FetchType.EAGER)
	private List<Supplier> suppliers;

	//bi-directional many-to-one association to MaterialDeductionLookup
	@OneToMany(mappedBy="rawMaterial", fetch=FetchType.EAGER)
	private List<MaterialDeductionLookup> materialDeductionLookups;

	public RawMaterial() {
	}

	public int getMaterialId() {
		return this.materialId;
	}

	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public String getMaterialName() {
		return this.materialName;
	}

	public void setMaterialName(String materialName) {
		this.materialName = materialName;
	}

	public int getSupplierId() {
		return this.supplierId;
	}

	public void setSupplierId(int supplierId) {
		this.supplierId = supplierId;
	}

	public double getTresholdQuantity() {
		return this.tresholdQuantity;
	}

	public void setTresholdQuantity(double tresholdQuantity) {
		this.tresholdQuantity = tresholdQuantity;
	}

	public String getUnit() {
		return this.unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public Date getUpdatedDate() {
		return this.updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Supplier> getSuppliers() {
		return this.suppliers;
	}

	public void setSuppliers(List<Supplier> suppliers) {
		this.suppliers = suppliers;
	}

	public List<MaterialDeductionLookup> getMaterialDeductionLookups() {
		return this.materialDeductionLookups;
	}

	public void setMaterialDeductionLookups(List<MaterialDeductionLookup> materialDeductionLookups) {
		this.materialDeductionLookups = materialDeductionLookups;
	}

	public MaterialDeductionLookup addMaterialDeductionLookup(MaterialDeductionLookup materialDeductionLookup) {
		getMaterialDeductionLookups().add(materialDeductionLookup);
		materialDeductionLookup.setRawMaterial(this);

		return materialDeductionLookup;
	}

	public MaterialDeductionLookup removeMaterialDeductionLookup(MaterialDeductionLookup materialDeductionLookup) {
		getMaterialDeductionLookups().remove(materialDeductionLookup);
		materialDeductionLookup.setRawMaterial(null);

		return materialDeductionLookup;
	}

}
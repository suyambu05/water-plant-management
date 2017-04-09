package org.v3.wpm.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the material_deduction_lookup database table.
 * 
 */
@Entity
@Table(name="material_deduction_lookup")
@NamedQuery(name="MaterialDeductionLookup.findAll", query="SELECT m FROM MaterialDeductionLookup m")
public class MaterialDeductionLookup implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private MaterialDeductionLookupPK id;

	@Column(name="material_duduction")
	private double materialDuduction;

	@Column(name="product_quantity")
	private int productQuantity;

	//bi-directional many-to-one association to Product
	@ManyToOne
	@JoinColumn(name="product")
	private Product product;

	//bi-directional many-to-one association to RawMaterial
	@ManyToOne
	@JoinColumn(name="material")
	private RawMaterial rawMaterial;

	public MaterialDeductionLookup() {
	}

	public MaterialDeductionLookupPK getId() {
		return this.id;
	}

	public void setId(MaterialDeductionLookupPK id) {
		this.id = id;
	}

	public double getMaterialDuduction() {
		return this.materialDuduction;
	}

	public void setMaterialDuduction(double materialDuduction) {
		this.materialDuduction = materialDuduction;
	}

	public int getProductQuantity() {
		return this.productQuantity;
	}

	public void setProductQuantity(int productQuantity) {
		this.productQuantity = productQuantity;
	}

	public Product getProduct() {
		return this.product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public RawMaterial getRawMaterial() {
		return this.rawMaterial;
	}

	public void setRawMaterial(RawMaterial rawMaterial) {
		this.rawMaterial = rawMaterial;
	}

}
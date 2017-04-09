package org.v3.wpm.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the material_deduction_lookup database table.
 * 
 */
@Embeddable
public class MaterialDeductionLookupPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="deduction_lookup_id")
	private int deductionLookupId;

	@Column(name="product_id", insertable=false, updatable=false)
	private int productId;

	@Column(name="material_id", insertable=false, updatable=false)
	private int materialId;

	public MaterialDeductionLookupPK() {
	}
	public int getDeductionLookupId() {
		return this.deductionLookupId;
	}
	public void setDeductionLookupId(int deductionLookupId) {
		this.deductionLookupId = deductionLookupId;
	}
	public int getProductId() {
		return this.productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getMaterialId() {
		return this.materialId;
	}
	public void setMaterialId(int materialId) {
		this.materialId = materialId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof MaterialDeductionLookupPK)) {
			return false;
		}
		MaterialDeductionLookupPK castOther = (MaterialDeductionLookupPK)other;
		return 
			(this.deductionLookupId == castOther.deductionLookupId)
			&& (this.productId == castOther.productId)
			&& (this.materialId == castOther.materialId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.deductionLookupId;
		hash = hash * prime + this.productId;
		hash = hash * prime + this.materialId;
		
		return hash;
	}
}
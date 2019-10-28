package com.dev.beans;



public class AssetAllocation {
private Integer allocationid;
private Integer assetid;
private Integer empno;
private String allocationdate;
private String releasedate;
private Integer quantity;
public Integer getAllocationid() {
	return allocationid;
}
public void setAllocationid(Integer allocationid) {
	this.allocationid = allocationid;
}
public Integer getAssetid() {
	return assetid;
}
public void setAssetid(Integer assetid) {
	this.assetid = assetid;
}
public Integer getEmpno() {
	return empno;
}
public void setEmpno(Integer empno) {
	this.empno = empno;
}
public String getAllocationdate() {
	return allocationdate;
}
public void setAllocationdate(String string) {
	this.allocationdate = string;
}
public String getReleasedate() {
	return releasedate;
}
public void setReleasedate(String string) {
	this.releasedate = string;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
@Override
public String toString() {
	return "AssetAllocation [allocationid=" + allocationid + ", assetid=" + assetid + ", empno=" + empno
			+ ", allocationdate=" + allocationdate + ", releasedate=" + releasedate + ", quantity=" + quantity + "]";
}


}

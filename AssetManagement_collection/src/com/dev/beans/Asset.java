package com.dev.beans;

public class Asset {
private Integer assetid;
private String assetname;
private String assetdes;
private Integer quantity;
private String status;
public Integer getAssetid() {
	return assetid;
}
public void setAssetid(Integer assetid) {
	this.assetid = assetid;
}
public String getAssetname() {
	return assetname;
}
public void setAssetname(String assetname) {
	this.assetname = assetname;
}
public String getAssetdes() {
	return assetdes;
}
public void setAssetdes(String assetdes) {
	this.assetdes = assetdes;
}
public Integer getQuantity() {
	return quantity;
}
public void setQuantity(Integer quantity) {
	this.quantity = quantity;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
@Override
public String toString() {
	return "Asset [assetid=" + assetid + ", assetname=" + assetname + ", assetdes=" + assetdes + ", quantity="
			+ quantity + ", status=" + status + "]";
}

}

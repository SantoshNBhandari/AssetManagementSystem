package com.dev.dao;

import java.util.List;

import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;

public interface DAO {
	UserMaster login(Integer userid,String password);
	Asset addAsset(Asset asset);
	Asset removeAsset(Integer aid);
	Asset updateAsset(Integer aid);
	List<Asset> getAllAsset();
	Employee addEmployee(Employee employee);
	AssetAllocation raiseAllocation(AssetAllocation assetallocation);
	List<AssetAllocation> getAllAssetAllocation();
	Boolean setStatus(Integer allocationid);
	String viewStatus(Integer allocationid);
}

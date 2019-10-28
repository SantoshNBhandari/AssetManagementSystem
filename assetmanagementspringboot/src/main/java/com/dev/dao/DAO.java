package com.dev.dao;

import java.util.List;

import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.AssetStatus;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;

public interface DAO {
	UserMaster login(Integer userid,String password);
	Asset addAsset(Asset asset);
	Asset removeAsset(Integer aid);
	 Asset updateAsset(Asset asu);
	List<Asset> getAllAsset();
	Employee addEmployee(Employee employee);
	AssetAllocation raiseAllocation(AssetAllocation assetallocation);
	List<AssetAllocation> getAllAssetAllocation();
	AssetStatus setStatus(Integer allocationid,String status);
	AssetStatus viewStatus(Integer allocationid);
	//List<Asset> getAllAllocatedAsset();
}

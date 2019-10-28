package com.dev.services;

import java.util.List;

import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.AssetStatus;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;

public interface Services {
	UserMaster loginService(Integer userid,String password);
	Asset addAssetService(Asset asset);
	Asset removeAssetService(Integer aid);
	Asset updateAssetService(Asset asu);
	List<Asset> getAllAssetService();
	Employee addEmployeeService(Employee employee);
	AssetAllocation raiseAllocationService(AssetAllocation assetallocation);
	List<AssetAllocation> getAllAssetAllocationService();
	AssetStatus setStatusService(Integer allocationid,String status);
	AssetStatus viewStatusService(Integer allocationid);
	//List<Asset> getAllAllocatedAssetService();
}

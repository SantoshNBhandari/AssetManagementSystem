package com.dev.services;


import java.util.List;

import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;

public interface Services {
	public UserMaster loginService(Integer userid,String password);
	public Boolean addAsset(Asset asset);
	public Asset removeAsset(Integer r);
	public Boolean updateAsset(int a,Asset asu);
	public List<Asset> getAllDetails();
	public boolean addEmployee(Employee emp);
	public List<AssetAllocation> getAllAssetAllocationService();
	public boolean setStatusService(Integer allocationid,String status);
	public String viewStatusService(Integer allocationid);
	public AssetAllocation serviceRaiseReq(AssetAllocation asetallocate);
}

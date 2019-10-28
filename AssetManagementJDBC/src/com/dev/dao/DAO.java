package com.dev.dao;


import java.util.List;
import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;

public interface DAO {
	public UserMaster login(Integer userid,String password);
	public Asset addAsset(Asset asset);
	public Asset removeAsset(int r);
	public Asset updateAsset(int a, Asset asu);
	public List<Asset> getAllDetails();
	public Employee addEmployee(Employee emp);
	public String viewStatus(Integer id1);
	public List<AssetAllocation> getAllAssetAllocation();
	public String setStatus(Integer allocationid, String sta);
	public AssetAllocation raiseRequest(AssetAllocation asetallocate);
}

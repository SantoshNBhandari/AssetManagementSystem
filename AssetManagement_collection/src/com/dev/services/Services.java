package com.dev.services;

import java.util.List;

import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;

public interface Services {
UserMaster loginService(Integer userid,String password);
Asset addAssetService(Asset asset);
Asset removeAssetService(Integer aid);
Asset updateAssetService(Integer aid);
List<Asset> getAllAssetService();
Employee addEmployeeService(Employee employee);
AssetAllocation raiseAllocationService(AssetAllocation assetallocation);
List<AssetAllocation> getAllAssetAllocationService();
Boolean setStatusService(Integer allocationid);
String viewStatusService(Integer allocationid);
}

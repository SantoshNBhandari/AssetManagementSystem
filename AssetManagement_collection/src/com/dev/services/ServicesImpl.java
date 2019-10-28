package com.dev.services;

import java.util.List;

import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;
import com.dev.dao.DAO;
import com.dev.dao.DAOImpl;

public class ServicesImpl implements Services {
	DAO d=new DAOImpl();
	@Override
	public UserMaster loginService(Integer userid, String password) {
		
		return d.login(userid, password);
	}
	@Override
	public Asset addAssetService(Asset asset) {
		// TODO Auto-generated method stub
		return d.addAsset(asset);
	}
	@Override
	public Asset removeAssetService(Integer aid) {
		
		return d.removeAsset(aid);
	}
	@Override
	public Asset updateAssetService(Integer aid) {
		
		return d.updateAsset(aid);
	}
	@Override
	public List<Asset> getAllAssetService() {
		// TODO Auto-generated method stub
		return d.getAllAsset();
	}
	@Override
	public Employee addEmployeeService(Employee employee) {
		
		return d.addEmployee(employee);
	}
	@Override
	public AssetAllocation raiseAllocationService(AssetAllocation assetallocation) {
				return d.raiseAllocation(assetallocation);
	}
	@Override
	public List<AssetAllocation> getAllAssetAllocationService() {
		
		return d.getAllAssetAllocation();
	}
	@Override
	public Boolean setStatusService(Integer allocationid) {
		
		return d.setStatus(allocationid);
	}
	@Override
	public String viewStatusService(Integer allocationid) {
		// TODO Auto-generated method stub
		return d.viewStatus(allocationid);
	}
	
	
	

	

}

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
	public Asset addAsset(Asset asset) {

		return d.addAsset(asset);
	}
	
	@Override
	public Asset updateAsset(int a,Asset asu) {
		
		return d.updateAsset(a,asu);
	}
	@Override
	public  List<Asset>  getAllDetails() {
		
		 
		return d.getAllDetails();
	}
	

	@Override
	public Employee addEmployee(Employee emp) {
		
		return d.addEmployee(emp);
	}
	
	

	
public List<AssetAllocation> getAllAssetAllocationService() {
		 return d.getAllAssetAllocation();
	}
	@Override
	public String setStatusService(Integer allocationid,String sta) {
		
		return d.setStatus(allocationid,sta);
	}
	
	@Override
	public AssetAllocation serviceRaiseReq(AssetAllocation asetallocate) {
		
		return d.raiseRequest(asetallocate);
	}
	@Override
	public Asset removeAsset(Integer r) {
		
		return d.removeAsset(r);
	}
	@Override
	public String viewStatusService(Integer allocationid) {
		
		
		return d.viewStatus(allocationid);
	}

	
	

	


}

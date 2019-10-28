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
	public Boolean addAsset(Asset asset) {
		if(d.addAsset(asset))
		{
			
			return true;
		}
		else
			return false;

	}

	@Override
	public Boolean updateAsset(int a,Asset asu) {

		return d.updateAsset(a,asu);
	}
	@Override
	public List<Asset> getAllDetails() {

		return d.getAllDetails();
	}


	@Override
	public boolean addEmployee(Employee emp) {

		if( d.addEmployee(emp))
		{
			return true;
		}
		else
			return false;
	}




	public List<AssetAllocation> getAllAssetAllocationService() {


		return  d.getAllAssetAllocation();
	}
	@Override
	public boolean setStatusService(Integer allocationid,String status) {

		if(d.setStatus(allocationid,status))
		{
			return true;
		}
		else
		{
			return false;
		}
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

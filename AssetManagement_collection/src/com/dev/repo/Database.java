package com.dev.repo;

import java.util.HashMap;
import java.util.Map;

import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.AssetStatus;
import com.dev.beans.Department;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;

public class Database {
	public Map<Integer,UserMaster> map;
	public Map<Integer,Employee> mape;
	public Map<Integer,Department> mapd;
	public Map<Integer,Asset> mapa;
	public Map<Integer,AssetAllocation> mapaa;
	public Map<Integer,String> mapas;
	
	public Database() {
		map = new HashMap<Integer,UserMaster>();
		UserMaster um=new UserMaster();
		um.setUserid(10);
		um.setUsername("vinyas");
		um.setUserpassword("root");
		um.setUsertype("manager");
		map.put(um.getUserid(), um);
		
		UserMaster um1=new UserMaster();
		um1.setUserid(20);
		um1.setUsername("admin");
		um1.setUserpassword("password");
		um1.setUsertype("admin");
		map.put(um1.getUserid(), um1);	
		
		mape = new HashMap<Integer,Employee>();
		Employee e=new Employee();
		e.setEmpno(100);
		e.setEname("thor");
		e.setDeptid(25);
		e.setHiredate("24-11-2019");
		e.setJob("software engineer");
		e.setMgrno(30);
		mape.put(e.getEmpno(),e);
		
		mapd = new HashMap<Integer,Department>();
		Department d=new Department();
		d.setDeptid(25);
		d.setDeptname("software department");
		mapd.put(d.getDeptid(), d);
		
		mapa = new HashMap<Integer,Asset>();
		Asset a=new Asset();
		a.setAssetid(500);
		a.setAssetname("computer");
		a.setAssetdes("aaaa");
		a.setQuantity(1);
		a.setStatus("present");
		mapa.put(a.getAssetid(),a);
		
		mapaa = new HashMap<Integer,AssetAllocation>();
		AssetAllocation all=new AssetAllocation();
		all.setAllocationid(1000);
		all.setAssetid(500);
		all.setEmpno(100);
		all.setAllocationdate("30-11-2019");
		all.setReleasedate("12-12-2019");
		all.setQuantity(20);
		mapaa.put(all.getAllocationid(), all);
		
		mapas=new HashMap<Integer,String>();
		AssetStatus as=new AssetStatus();
		as.setAllocationid(1000);
		as.setStatus("");
		mapas.put(as.getAllocationid(), as.getStatus());
}
}

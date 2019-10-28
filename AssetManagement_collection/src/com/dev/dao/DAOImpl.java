package com.dev.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;
import com.dev.exceptions.LoginException;
import com.dev.exceptions.RemoveAssetException;
import com.dev.exceptions.UpdateAssetException;
import com.dev.repo.Database;

public class DAOImpl implements DAO {
	Database db=new Database();
	Scanner sc=new Scanner(System.in);
	LoginException le=new LoginException();
	RemoveAssetException rae=new RemoveAssetException();
	UpdateAssetException uae=new UpdateAssetException();

	@Override
	public UserMaster login(Integer userid, String password) {
		
		if(db.map.containsKey(userid))
		{
			UserMaster um=db.map.get(userid);
			if(um.getUserpassword().equals(password))
			{
				return um;
			}
		}
		else
		{
			System.out.println("enter correct username and password");
		
		}

throw le;
}

	@Override
	public Asset addAsset(Asset asset) {
	
//	a.setAssetid(asset.getAssetid()); 
//	db.mapa.put(asset.getAssetid(), asset);
//	a.setAssetname(asset.getAssetname());
//	db.mapa.put(asset.getAssetid(), asset);
	//a=db.mapa.put(asset.getAssetid(), asset);
	db.mapa.put(asset.getAssetid(), asset);	
		return asset;
	}

	@Override
	public Asset removeAsset(Integer aid) {
		Asset a=new Asset();
		if(db.mapa.containsKey(aid))
		{
			a=db.mapa.remove(aid);
			return a;
		}
		else
		{
			throw rae;
		}
		
	}

	@Override
	public Asset updateAsset(Integer aid) {
		
	
		if(db.mapa.containsKey(aid))
		{
				System.out.println("1.update asset name");
				System.out.println("2. update asset des");
				System.out.println("3. update asset quantity");
				System.out.println("4. update asset status");
				Integer choice=sc.nextInt();
				switch(choice)
				{
				case 1:Asset s = db.mapa.get(aid);
				System.out.println("enter the name you want to update");
				s.setAssetname(sc.next());
				return s;
				
				case 2:Asset s1 = db.mapa.get(aid);
				System.out.println("enter the des you want to update");
				s1.setAssetdes(sc.next());
				return s1;
				
				case 3:Asset s2 = db.mapa.get(aid);
				System.out.println("enter the quantity you want to update");
				s2.setQuantity(sc.nextInt());
				return s2;
				
				case 4: Asset s3 = db.mapa.get(aid);
				System.out.println("enter the status you want to update");
				s3.setStatus(sc.next());
				return s3;
				
				}
				throw uae;
				}
		else
		{
			throw uae;
		}
//			}
//		}
//			System.out.println("enter updated asset id");
//			a.setAssetid(sc.nextInt());
//			System.out.println(" enter updated asset name ");	
//			a.setAssetname(sc.next());
//			System.out.println("enter updated asset des");
//			a.setAssetdes(sc.next());
//			System.out.println("enter updated asset quantity");
//			a.setQuantity(sc.nextInt());
//			System.out.println(" enter updated asset status ");	
//			a.setStatus(sc.next());
//			
//			
//		return a;
//	}
//		else
//		{
//			throw uae;
//		}
	}

	@Override
	public List<Asset> getAllAsset() {
		if(!db.mapa.isEmpty())
		{
			List<Asset>l=new ArrayList(db.mapa.values());
			Iterator<Asset> it=l.iterator();
			while(it.hasNext())
			{
				System.out.println(it.next());
			}
			
			
			return l;
		}
		return null;
	}

	@Override
	public Employee addEmployee(Employee employee) {
db.mape.put(employee.getEmpno(), employee);
		return employee;
	}

	@Override
	public AssetAllocation raiseAllocation(AssetAllocation assetallocation) {
		db.mapaa.put(assetallocation.getAllocationid(), assetallocation);
		return assetallocation;
	}

	@Override
	public List<AssetAllocation> getAllAssetAllocation() {
		if(!db.mapaa.isEmpty())
		{
			List<AssetAllocation>ll=new ArrayList(db.mapaa.values());
			Iterator <AssetAllocation>it=ll.iterator();
			while(it.hasNext())
			{
				System.out.println(it.next()); 
			}
			return ll;
			
		}
		else
		{
		return null;
	}
	}

	@Override
	public Boolean setStatus(Integer allocationid) {
		if(db.mapaa.containsKey(allocationid))
		{
			//AssetStatus as=new AssetStatus();
			 //String as1=db.mapas.get(allocationid);
			 
			 //as.setStatus(status);
			System.out.println("enter status");
			String status=sc.next();
			db.mapas.put(allocationid,status);
			return true;
			
		}
		else
		{
			return false;
		}
	}

	@Override
	public String viewStatus(Integer allocationid) {
		if(db.mapas.containsKey(allocationid))
		{
		
		String s=db.mapas.get(allocationid);
	//System.out.println(s);	
	//System.out.println(as.getStatus());
	return s;
		
	}
		else
		{
			return "Status not found";
		}
	}

	
	}

package com.dev.dao;

import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;
import com.dev.exceptions.CustomException;
import com.dev.exceptions.EmployeeException;
import com.dev.exceptions.InvalidDepartmentException;
import com.dev.exceptions.LoginException;
import com.dev.exceptions.RaiseRequestException;
import com.dev.exceptions.RemoveAssetException;
import com.dev.exceptions.SetStatusExcption;
import com.dev.exceptions.StatusExcpetion;
import com.dev.exceptions.UpdateAssetException;
import com.mysql.jdbc.Driver;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class DAOImpl implements DAO 
{
	UserMaster um=new  UserMaster();
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	Integer result=null;
	public DAOImpl()
	{
		try
		{
			Driver div= new Driver();
			DriverManager.registerDriver(div);
			String url="jdbc:mysql://localhost:3306/asset_management?user=root&password=root";
			conn=DriverManager.getConnection(url);
		}
		catch(SQLException e)
		{
			throw new CustomException("Connection Cannot be established");
		}
	}

	@Override
	public UserMaster login(Integer userid, String password) {
		try 
		{
			String query="select UserType from user_master where UserId=? and UserPassword=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1,userid);
			pstmt.setString(2, password);
			rs=pstmt.executeQuery();
			rs=pstmt.getResultSet();
			String s = null;
			while(rs.next())
			{
				s=rs.getString(1);
			}
			um.setUsertype(s);
			if(um.getUsertype()!=null)
			{

				return um;
			}


		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new LoginException();

		}
		return null;

	}

	@Override
	public AssetAllocation raiseRequest(AssetAllocation asetallocate) 
	{
		try {
			String query="INSERT INTO asset_allocation  VALUES (?, ?, ?, ?, ?,?)";
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1,asetallocate.getAllocationid());
			pstmt.setInt(2,asetallocate.getAssetid());
			pstmt.setInt(3, asetallocate.getEmpno());
			pstmt.setString(4, asetallocate.getAllocationdate());
			pstmt.setString(5, asetallocate.getReleasedate());
			pstmt.setInt(6, asetallocate.getQuantity());
			result=pstmt.executeUpdate();
			String q="INSERT INTO asset_status VALUES (?)";
			pstmt=conn.prepareStatement(q);
			pstmt.setInt(1, asetallocate.getAllocationid());
			result=pstmt.executeUpdate();
			return asetallocate;

		}
		catch (Exception e) 
		{
			throw new RaiseRequestException();

		}

	}



	@Override
	public Employee addEmployee(Employee emp) 
	{
		try {
			String q="select dept_id from department ";
			pstmt=conn.prepareStatement(q);
			Boolean b=pstmt.execute();
			if(b)
			{
				int temp=0;
				rs=pstmt.getResultSet();
				Integer s = null;
				while(rs.next())
				{
					s=rs.getInt(1);


					if(emp.getDeptid()==s)
					{
						temp=1;
					}

					if(temp!=1)
					{
						throw new InvalidDepartmentException();
					}
				}

				String query="insert into employee values(?, ?, ?, ?, ?, ?)";
				pstmt=conn.prepareStatement(query);

				pstmt.setInt(1,emp.getEmpno());
				pstmt.setString(2,emp.getEname());
				pstmt.setString(3, emp.getJob());
				pstmt.setInt(4, emp.getMgrno());
				pstmt.setString(5,emp.getHiredate());
				pstmt.setInt(6, emp.getDeptid());
				result=pstmt.executeUpdate();

				return emp;
			}



		}
		catch (Exception e) 
		{
			e.printStackTrace();
			throw new EmployeeException();	


		}
		return null;
	}



	@Override
	public Asset addAsset(Asset asset) 
	{
		try {

			String query="INSERT INTO asset VALUES (?, ?, ?, ?, ?)";
			pstmt=conn.prepareStatement(query);

			pstmt.setInt(1,asset.getAssetid());
			pstmt.setString(2,asset.getAssetname());
			pstmt.setString(3, asset.getAssetdes());
			pstmt.setInt(4, asset.getQuantity());
			pstmt.setString(5,asset.getStatus());

			result=pstmt.executeUpdate();
			if(result>0)
			{
				return asset;
			}

		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;

	}




	@Override
	public Asset removeAsset(int r) 
	{

		try
		{
			String query="DELETE FROM asset WHERE AssetId=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1,r);
			result=pstmt.executeUpdate();
			if(result>0)
			{
				System.out.println("ASSET DELETED");

			}
			else
			{
				throw new RemoveAssetException();

			}

		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}
	@Override
	public String viewStatus(Integer id1)
	{
		try 
		{
			String query="select * from Asset_Status where Allocationid=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setInt(1,id1);
			Boolean b=pstmt.execute();
			if(b)
			{
				rs=pstmt.getResultSet();
				while(rs.next())
				{
					if(rs.getString(2)==null)
					{
						return"Allocation ID:"+rs.getInt(1)+"Status Not Approved Yet";
					}
					else
					{
						return"Allocation ID:"+rs.getInt(1)+"  Status:"+rs.getString(2);
					}
				}

			}
			else
			{
				throw new StatusExcpetion();
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return "You entered wrong allocation ID";


	}

	@Override
	public Asset updateAsset(int a,Asset asu) 
	{
		if(asu.getAssetname()!=null)
		{

			try 
			{
				String query="UPDATE asset SET AssetName=? WHERE AssetId=?";
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,asu.getAssetname());
				pstmt.setInt(2, a);
				result=pstmt.executeUpdate();
				if(result>0)
				{
					return asu;

				}
				else
				{
					throw new UpdateAssetException();
				}

			}
			catch (Exception e) 
			{

				e.printStackTrace();
			}
		}


		if(asu.getAssetdes()!=null)
		{
			try 
			{
				String query="UPDATE asset SET AssetDes=? WHERE AssetId=?";
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,asu.getAssetdes());
				pstmt.setInt(2, a);
				result=pstmt.executeUpdate();
				if(result>0)
				{
					return asu;
				}
				else
				{
					throw new UpdateAssetException();
				}

			}
			catch (Exception e) 
			{

				e.printStackTrace();
			}
		}	
		if(asu.getQuantity()!=null)
		{
			try 
			{
				String query="UPDATE asset SET Quantity=? WHERE AssetId=?";
				pstmt=conn.prepareStatement(query);
				pstmt.setInt(1,asu.getQuantity());
				pstmt.setInt(2, a);
				result=pstmt.executeUpdate();
				if(result>0)
				{
					return asu;
				}
				else
				{
					throw new UpdateAssetException();
				}
			}


			catch (Exception e) 
			{

				e.printStackTrace();
			}

		}
		if(asu.getStatus()!=null)
		{
			try 
			{
				String query="UPDATE asset SET Status=? WHERE AssetId=?";
				pstmt=conn.prepareStatement(query);
				pstmt.setString(1,asu.getStatus());
				pstmt.setInt(2, a);
				result=pstmt.executeUpdate();
				if(result>0)
				{
					return asu;
				}
				else
				{
					throw new UpdateAssetException();
				}
			}

			catch (Exception e) 
			{

				e.printStackTrace();
			}
		}


		return null;	



	}


	@Override
	public List<Asset> getAllDetails()
	{
		try 
		{
			List<Asset> list=new ArrayList<Asset>();
			String query="select * from asset";
			pstmt=conn.prepareStatement(query);
			Boolean b=pstmt.execute();
			if(b)
			{
				rs=pstmt.getResultSet();
				while(rs.next())
				{
					Asset asset = new Asset();
					asset.setAssetid(rs.getInt(1));
					asset.setAssetname(rs.getString(2));
					asset.setAssetdes(rs.getString(3));
					asset.setQuantity(rs.getInt(4));
					asset.setStatus(rs.getString(5));
					list.add(asset);

				}
				return list;
			}
			else 
			{
				throw new CustomException("Details Not Available");
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return null;
	}



	@Override
	public List<AssetAllocation> getAllAssetAllocation()
	{
		try
		{
			String query="select * from asset_allocation";
			pstmt=conn.prepareStatement(query);
			Boolean b=pstmt.execute();
			if(b)
			{
				rs=pstmt.getResultSet();
				List<AssetAllocation> list=new ArrayList<AssetAllocation>();
				while(rs.next())
				{
					AssetAllocation assetallocation = new AssetAllocation();
					assetallocation.setAllocationid(rs.getInt(1));
					assetallocation.setAssetid(rs.getInt(2));
					assetallocation.setEmpno(rs.getInt(3));
					assetallocation.setAllocationdate(rs.getString(4));
					assetallocation.setReleasedate(rs.getString(5));
					assetallocation.setQuantity(rs.getInt(6));
					list.add(assetallocation);
				}
				return list;
			}
			else 
			{

				throw new CustomException("Details Not Available");
			}
		}
		catch (Exception e) 
		{

			e.printStackTrace();
		}
		return null;
	}                                                                                   



	@Override
	public String setStatus(Integer allocationid,String status) 
	{
		try 
		{  

			String query="UPDATE asset_status SET status=? WHERE AllocationId=?";
			pstmt=conn.prepareStatement(query);
			pstmt.setString(1, status);
			pstmt.setInt(2,allocationid);
			result=pstmt.executeUpdate();
			if(result>0)
			{
				return "Status Changed";

			}
			else
			{
				throw new SetStatusExcption();
			}
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		return null;

	}

}






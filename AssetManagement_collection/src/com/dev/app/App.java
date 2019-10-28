package com.dev.app;

import java.util.Scanner;

import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.Employee;
import com.dev.services.Services;
import com.dev.services.ServicesImpl;

public class App {
	
	public static void main(String[] args) {
		Integer count=1;
		Services s=new ServicesImpl();
		Scanner sc=new Scanner(System.in);
//		System.out.println("enter the user id");
//		Integer userid=sc.nextInt();
//		System.out.println("enter password");
//		String password=sc.next();
		
//		UserMaster um=s.loginService(userid, password);
		jump2 :while(true)
		{
			System.out.println("enter your choice ");
			System.out.println("1. Admin");
			System.out.println("2. manager");
			System.out.println("3. exit program");
			Integer id=sc.nextInt();
		
		if(id==2)
		//if(um.getUsertype().equalsIgnoreCase("manager"))
		{
			System.out.println("manager");
			
			
			jump1:	while(true)
				{
				System.out.println("enter your choice");
				System.out.println("1.Add employee");
				System.out.println("2.Raise Allocation ");
				System.out.println("3.View Status");
				System.out.println("4. Exit");
				Integer choice1=sc.nextInt();
				switch(choice1)
				{
				case 1:Employee e=new Employee();
				System.out.println("enter employee id");
				e.setEmpno(sc.nextInt());
				System.out.println("enter employee name");
				e.setEname(sc.next());
				System.out.println("enter deptid of the employee");
				e.setDeptid(sc.nextInt());
				System.out.println("enter hiredate of the employee");
				e.setHiredate(sc.next());
				System.out.println("enter job of employee");
				e.setJob(sc.next());
				System.out.println("enter mgr number");
				e.setMgrno(sc.nextInt());
				System.out.println("Added Employee :"+s.addEmployeeService(e));
				break;
				case 2:AssetAllocation aa=new AssetAllocation();
				aa.setAllocationid(count);
						System.out.println("Enter Asset id ");
						aa.setAssetid(sc.nextInt());
						System.out.println("Enter employee number");
						aa.setEmpno(sc.nextInt());
						System.out.println("Enter allocation date");
						aa.setAllocationdate(sc.next());
						System.out.println("Enter release date ");
						aa.setReleasedate(sc.next());
						System.out.println("Enter quantity");
						aa.setQuantity(sc.nextInt());
						System.out.println("Raised allocation request :"+s.raiseAllocationService(aa));
						System.out.println("Randomly generated allocation id :"+aa.getAllocationid());
						count++;
						break;
				case 3:System.out.println("enter the allocation id");
                       Integer id1=sc.nextInt();
                       System.out.println(s.viewStatusService(id1));
                       break;
				case 4: System.out.println("manager logged out successfully"); 
				break jump1;
				
				}
				
			}
			}
		
		//else if(um.getUsertype().equalsIgnoreCase("admin"))
		else if(id==1)
		{
			System.out.println("admin");
		jump:	while(true)
			{
				System.out.println("enter your choice");
				System.out.println("1.add asset");
				System.out.println("2.Remove asset");
				System.out.println("3. update asset");
				System.out.println("4. view all asset");
				System.out.println("5. view all allocation request");
				System.out.println("6. set allocation status");
				System.out.println("7. exit");
				Integer choice=sc.nextInt();
				switch(choice)
				{
				case 1:Asset a=new Asset();
					System.out.println("enter asset id");
					a.setAssetid(sc.nextInt());
					System.out.println(" enter asset name ");	
					a.setAssetname(sc.next());
					System.out.println("enter asset des");
					a.setAssetdes(sc.next());
					System.out.println("enter asset quantity");
					a.setQuantity(sc.nextInt());
					System.out.println(" enter asset status ");	
					a.setStatus(sc.next());
					
				System.out.println("Added asset :"+s.addAssetService(a));
				break;
				case 2:System.out.println("enter the asset id you want to remove");
						Asset a1=new Asset();
						a1=s.removeAssetService(sc.nextInt());
							System.out.println("removed asset is :"+a1);
					break;
				case 3: System.out.println("enter the asset id you want to update");
						System.out.println("updated asset information :"+s.updateAssetService(sc.nextInt( )));
						break;
				case 4:System.out.println("assets are");
				s.getAllAssetService();
				break;
				case 5:s.getAllAssetAllocationService();
				break;
				case 6:System.out.println("enter allocation id to set status");
						Integer allocationid=sc.nextInt();
						
						if(s.setStatusService(allocationid))
						{
							System.out.println("status changed");
						}
						else
						{
							System.out.println("status not changed");
						}
						break;
				case 7:System.out.println("admin logged out successfully");
				break jump;
				
				
				
				}
			}
		}
		else if(id==3)
		{
			System.out.println("program exitted successfully");
			sc.close();
			break jump2;
		}

}
	}
}

package com.dev.app;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;
import com.dev.exceptions.DateFormatException;
import com.dev.exceptions.IntegerValidationException;
import com.dev.exceptions.StringValidationException;
import com.dev.services.Services;
import com.dev.services.ServicesImpl;
import com.util.validations.Validate;

public class App 
{
	public static void main(String[] args) 
	{
		Services service=new ServicesImpl();
		Scanner sc=new Scanner(System.in);
		Validate validate=new Validate(); 
		StringValidationException svalidate=new StringValidationException();
		IntegerValidationException integervalidation=new IntegerValidationException();
		DateFormatException datevalidate=new DateFormatException();
		System.out.println("$$$$$*****ASSET MANAGEMENT SYSTEM:*****$$$$$$");
		System.out.println("****************************************");
		jump1: while(true)
		{
			System.out.println("----Enter Your Choice----");
			System.out.println("      1 : Manager");
			System.out.println("      2 : Admin");
			System.out.println("      3 : Exit");
			String opt = sc.next();
			Boolean zxy = validate.idValidation(opt);
			jump: while (!zxy) {
				try {
					throw integervalidation;
				} 
				catch (Exception e1) {
					System.err.println(" Enter Only Integers(numbers)");
					System.out.println("Please ReEnter again");
					opt = sc.next();
					if (validate.idValidation(opt)) {
						break jump;
					}
				}
			}
			Integer op=Integer.parseInt(opt);
			if(op== 1)
			{
				System.out.println("------LOGIN PAGE-----");
				System.out.println("****************************************");
				System.out.println("Enter the User Id");
				String uid=sc.next();
				Boolean xyz= validate.idValidation(uid);
				jump: while (!xyz) {
					try {
						throw integervalidation;
					} catch (Exception e1) {
						System.err.println(" Enter Only Integers(numbers)");
						System.out.println("Please Enter again");
						uid = sc.next();
						if (validate.idValidation(uid)) {
							break jump;
						}
					}
				}

				Integer userid=Integer.parseInt(uid);

				System.out.println("Enter Password");
				String password=sc.next();
				UserMaster um=service.loginService(userid, password);
				if(um!=null)
				{
					if(um.getUsertype().equalsIgnoreCase("manager"))
					{
						System.out.println("-----MANAGER PAGE-----");
						System.out.println("**********************");
						jp: while(true)
						{
							System.out.println("_____ENTER YOUR CHOICE______");
							System.out.println("     1  :Raise the Request");
							System.out.println("     2  :View the Stauts of Raised request");
							System.out.println("     3  :Add newly joined Employee Details"); 
							System.out.println("     4  :Get all raised request");
							System.out.println("     5  :LogOut");
							System.out.println("     6  :Exit ");
							String choice=sc.next();
							Boolean b = validate.idValidation(choice);
							jump: while (!b) {
								try {
									throw integervalidation;
								} catch (Exception e1) {
									System.err.println(" Enter Only Integers(numbers)");
									System.out.println("Please ReEnter again");
									choice = sc.next();
									if (validate.idValidation(choice)) {
										break jump;
									}
								}
							}
							Integer option=Integer.parseInt(choice);
							Employee emp=new Employee();
							switch(option)
							{
							case 1:
								AssetAllocation asetallocate=new AssetAllocation();
								System.out.println("RAISE REQUEST");
								System.out.println("Enter Asset Id");
								String assetid = sc.next();

								Boolean c = validate.idValidation(assetid);
								jump: while (!c) {
									try {
										throw integervalidation;
									} catch (Exception e1) {
										System.err.println(" Enter Only Integers(numbers)");
										System.out.println("Please ReEnter again");
										assetid = sc.next();
										if (validate.idValidation(assetid)) {
											break jump;
										}
									}
								}
								asetallocate.setAssetid(Integer.parseInt(assetid));
								System.out.println("Enter Employeee Number");
								String empno = sc.next();
								Boolean d = validate.idValidation(empno);
								jump: while (!d) {
									try {
										throw integervalidation;
									} catch (Exception e1) {
										System.err.println(" Enter Only Integers(numbers)");
										System.out.println("Please ReEnter again");
										empno = sc.next();
										if (validate.idValidation(empno)) {
											break jump;
										}
									}
								}
								asetallocate.setEmpno(Integer.parseInt(empno));
								System.out.println("Enter Allocation Date In The Form YYYY-MM-DD");
								String date = sc.next();
								Boolean e = validate.dateValidation(date);
								jump: while (!e) {
									try {
										throw datevalidate;
									} catch (Exception e1) {
										System.err.println("Please Enter Date in 'YYYY-MM-DD' Format");
										System.out.println("Enter again");
										date = sc.next();
										if (validate.dateValidation(date)) {
											break jump;
										}
									}
								}								
								asetallocate.setAllocationdate(date);

								System.out.println("Enter Release Date In The Form YYYY-MM-DD");
								String releasedate = sc.next();
								Boolean f = validate.dateValidation(releasedate);
								jump: while (!f) {
									try {
										throw datevalidate;
									} catch (Exception e1) {
										System.err.println("Please Enter Date in 'YYYY-MM-DD' Format");
										System.out.println("Enter again");
										releasedate = sc.next();
										if (validate.dateValidation(releasedate)) {
											break jump;
										}
									}
								}


								asetallocate.setReleasedate(releasedate);
								System.out.println("Enter Quantity");
								String quantity = sc.next();
								Boolean g = validate.idValidation(quantity);
								jump: while (!g) {
									try {
										throw integervalidation;
									} catch (Exception e1) {
										System.err.println(" Enter Only Integers(numbers)");
										System.out.println("Please ReEnter again");
										quantity = sc.next();
										if (validate.idValidation(quantity)) {
											break jump;
										}
									}
								}

								asetallocate.setQuantity(Integer.parseInt(quantity));
								Integer min=2000;
								Integer max=5000;
								Integer rand = (int) ((Math.random()*((max-min)+1))+min);
								asetallocate.setAllocationid(rand);
								System.out.println("Raised allocation request :"+service.serviceRaiseReq(asetallocate));
								System.out.println("Randomly Generated Allocation Id :"+asetallocate.getAllocationid());
								break;
							case 2:
								System.out.println("enter the allocation id");
								String allocationid = sc.next();

								Boolean h = validate.idValidation(allocationid);
								jump: while (!h) {
									try {
										throw  integervalidation;
									} catch (Exception e1) {
										System.err.println(" Enter Only Integers(numbers)");
										System.out.println("Please ReEnter again");
										allocationid = sc.next();
										if (validate.idValidation(allocationid)) {
											break jump;
										}
									}
								}		
								System.out.println(service.viewStatusService(Integer.parseInt(allocationid)));
								break;

							case 3:
								System.out.println("Enter Employee Number");
								String empnumber=sc.next();
								Boolean i = validate.idValidation(empnumber);
								jump: while (!i) {
									try {
										throw  integervalidation;
									} catch (Exception e1) {
										System.err.println(" Enter Only Integers(numbers)");
										System.out.println("Please ReEnter again");
										empnumber = sc.next();
										if (validate.idValidation(empnumber)) {
											break jump;
										}
									}
								}	
								emp.setEmpno(Integer.parseInt( empnumber));
								System.out.println("Employee Name");
								String name = sc.next();
								Boolean j = validate.idValidation(name);
								jumpvalidate: while (j) {
									try {
										throw svalidate;
									} catch (Exception e1) {
										System.err.println("Enter it  in String Format");
										System.out.println("Please Enter Again");
										name = sc.next();
										if (!validate.idValidation(name)) {
											break jumpvalidate;
										}
									}
								}
								emp.setEname(name);

								System.out.println("Employee Hiredate in the form YYYY-MM-DD");
								String hiredate = sc.next();
								Boolean k = validate.dateValidation(hiredate);
								jump: while (!k) {
									try {
										throw datevalidate;
									} catch (Exception e1) {
										System.err.println("Please Enter Date in 'YYYY-MM-DD' Format");
										System.out.println("Enter again");
										hiredate = sc.next();
										if (validate.dateValidation(hiredate)) {
											break jump;
										}
									}
								}


								emp.setHiredate(hiredate);


								System.out.println("Enter Job");
								String job = sc.next();
								Boolean l = validate.idValidation(job);
								jumpvalidate: while (l) {
									try {
										throw svalidate;
									} catch (Exception e1) {
										System.err.println("Enter it  in String Format");
										System.out.println("Please Enter Again");
										job = sc.next();
										if (!validate.idValidation(job)) {
											break jumpvalidate;
										}
									}
								}
								emp.setJob(job);

								System.out.println("MAnager NUmber");
								String mgrno=sc.next();
								Boolean m = validate.idValidation(mgrno);
								jumpvalidate: while (!m) {
									try {
										throw integervalidation;
									} catch (Exception e1) {
										System.err.println(" Enter Only Integers(numbers)");
										System.out.println("Please ReEnter again");
										mgrno = sc.next();
										if (validate.idValidation(mgrno)) {
											break jumpvalidate;
										}
									}
								}
								emp.setMgrno(Integer.parseInt(mgrno));

								System.out.println("Department ID");
								String dptid=sc.next();
								Boolean n = validate.idValidation(dptid);
								jumpvalidate: while (!n) {
									try {
										throw integervalidation;
									} catch (Exception e1) {
										System.err.println(" Enter Only Integers(numbers)");
										System.out.println("Please ReEnter again");
										dptid = sc.next();
										if (validate.idValidation(dptid)) {
											break jumpvalidate;
										}
									}
								}


								emp.setDeptid(Integer.parseInt(dptid));
								if(emp!=null)
								{
									System.out.println("Added Employee :"+service.addEmployee(emp));
								}
								break;
							case 5:
								System.out.println("Logged Out Sucessfully");
								break jp;
							case 6:
								sc.close();
								System.out.println("EXITED From Program ");
								break jump1;
							case 4:
								List<AssetAllocation> list=service.getAllAssetAllocationService();
								Iterator<AssetAllocation> iterator=list.iterator();
								while(iterator.hasNext())
								{
									System.out.println(iterator.next());
								}
								break;
							}

						}
					}
				}
				else
				{
					System.err.println("Enter the details correctly");
				}
			}


			if(op== 2)
			{
				System.out.println("------LOGIN PAGE-----");
				System.out.println("****************************************");
				System.out.println("Enter the User Id");
				Integer userid=sc.nextInt();
				System.out.println("Enter Password");
				String password=sc.next();
				UserMaster um=service.loginService(userid, password);
				if(um!=null)
				{
					if(um.getUsertype().equalsIgnoreCase("admin"))
					{
						System.out.println("ADMIN");
						System.out.println("ADMIN PAGE");
						System.out.println("****************************************");
						always:	while(true)
						{
							System.out.println("enter your choice");
							System.out.println("1.add assest");
							System.out.println("2.Remove asset");
							System.out.println("3. update asset");
							System.out.println("4. view all asset");
							System.out.println("5. view all allocation request");
							System.out.println("6. set allocation status");
							System.out.println("7. LogOut");
							System.out.println("8:Exit");
							String choice=sc.next();
							Boolean o = validate.idValidation(choice);
							jump: while (!o) {
								try {
									throw integervalidation;
								} catch (Exception e1) {
									System.err.println(" Enter Only Integers(numbers)");
									System.out.println("Please ReEnter again");
									choice = sc.next();
									if (validate.idValidation(choice)) {
										break jump;
									}
								}
							}
							Integer option=Integer.parseInt(choice);
							switch(option)
							{
							case 1:
								Asset as=new Asset();
								System.out.println("Enter Asset id");
								String assetid=sc.next();
								Boolean p = validate.idValidation(assetid);
								jumpvalidate: while (!p) {
									try {
										throw integervalidation;
									} catch (Exception e1) {
										System.err.println(" Enter Only Integers(numbers)");
										System.out.println("Please ReEnter again");
										assetid = sc.next();
										if (validate.idValidation(assetid)) {
											break jumpvalidate;
										}
									}
								}

								as.setAssetid(Integer.parseInt(assetid));

								System.out.println("Asset name");

								String assetname = sc.next();
								Boolean q = validate.idValidation(assetname);
								jumpvalidate: while (q) {
									try {
										throw svalidate;
									} catch (Exception e1) {
										System.err.println("Enter it  in String Format");
										System.out.println("Please Enter Again");
										assetname = sc.next();
										if (!validate.idValidation(assetname)) {
											break jumpvalidate;
										}
									}
								}
								as.setAssetname(assetname);

								System.out.println("Asset des");
								String assetdes= sc.next();
								Boolean r = validate.idValidation(assetdes);
								jumpvalidate: while (r) {
									try {
										throw svalidate;
									} catch (Exception e1) {
										System.err.println("Enter it  in String Format");
										System.out.println("Please Enter Again");
										assetdes = sc.next();
										if (!validate.idValidation(assetdes)) {
											break jumpvalidate;
										}
									}
								}
								as.setAssetdes(assetdes);

								System.out.println("Asset Quantity");
								String quantity=sc.next();
								Boolean t = validate.idValidation(quantity);
								jump: while (!t) {
									try {
										throw integervalidation;
									} catch (Exception e1) {
										System.err.println(" Enter Only Integers(numbers)");
										System.out.println("Please Enter again");
										quantity = sc.next();
										if (validate.idValidation(quantity)) {
											break jump;
										}
									}
								}
								as.setQuantity(Integer.parseInt(quantity));

								System.out.println("Status");
								String status= sc.next();
								Boolean u = validate.idValidation(status);
								jumpvalidate: while (u) {
									try {
										throw svalidate;
									} catch (Exception e1) {
										System.err.println("Enter it  in String Format");
										System.out.println("Please Enter Again");
										status = sc.next();
										if (!validate.idValidation(status)) {
											break jumpvalidate;
										}
									}
								}

								as.setStatus(status);
								System.out.println(service.addAsset(as));
								break;
							case 2:
								System.out.println("enter the asset id you want to remove");
								String asid=sc.next();
								Boolean v = validate.idValidation(asid);
								jump: while (!v) {
									try {
										throw integervalidation;
									} catch (Exception e1) {
										System.err.println(" Enter Only Integers(numbers)");
										System.out.println("Please Enter again");
										asid = sc.next();
										if (validate.idValidation(asid)) {
											break jump;
										}
									}
								}
								service.removeAsset(Integer.parseInt(asid));
								break;
							case 3:
								Asset asu=new Asset();
								System.out.println("ENTER ASSET ID YOU WANT TO Update");
								String astid=sc.next();
								Boolean w = validate.idValidation(astid);
								jump: while (!w) {
									try {
										throw integervalidation;
									} catch (Exception e1) {
										System.err.println(" Enter Only Integers(numbers)");
										System.out.println("Please Enter again");
										astid = sc.next();
										if (validate.idValidation(astid)) {
											break jump;
										}
									}
								}

								Integer a=Integer.parseInt(astid);
								System.out.println("Press 1:To update asset name");
								System.out.println("Press 2:To update assetdes");
								System.out.println("Press 3:To update Assetquantity");
								System.out.println("Press 4:To update AssetStatus");
								Integer select=sc.nextInt();
								switch(select)
								{
								case 1:
									System.out.println("Enter new Asset Name");
									String asstname=sc.next();
									Boolean x = validate.idValidation(asstname);
									jumpvalidate: while (x) {
										try {
											throw svalidate;
										} catch (Exception e1) {
											System.err.println("Enter it  in String Format");
											System.out.println("Please Enter Again");
											asstname = sc.next();
											if (!validate.idValidation(asstname)) {
												break jumpvalidate;
											}
										}
									}
									asu.setAssetname(asstname);
									service.updateAsset(a,asu);
									break;
								case 2:
									System.out.println("Enter new Asset Description");
									String asstdes=sc.next();
									Boolean y = validate.idValidation(asstdes);
									jumpvalidate: while (y) {
										try {
											throw svalidate;
										} catch (Exception e1) {
											System.err.println("Enter it  in String Format");
											System.out.println("Please Enter Again");
											asstdes = sc.next();
											if (!validate.idValidation(asstdes)) {
												break jumpvalidate;
											}
										}
									}
									asu.setAssetdes(asstdes);
									service.updateAsset(a,asu);
									break;
								case 3:
									System.out.println("Enter new Asset Quantity");

									String astq=sc.next();
									Boolean z = validate.idValidation(astq);
									jump: while (!z) {
										try {
											throw integervalidation;
										} catch (Exception e1) {
											System.err.println(" Enter Only Integers(numbers)");
											System.out.println("Please Enter again");
											astq = sc.next();
											if (validate.idValidation(astq)) {
												break jump;
											}
										}
									}
									asu.setQuantity(Integer.parseInt( astq));
									service.updateAsset(a,asu);
									break;
								case 4:
									System.out.println("Enter new Asset Status");
									String asststatus=sc.next();
									Boolean zz = validate.idValidation(asststatus);
									jumpvalidate: while (zz) {
										try {
											throw svalidate;
										} catch (Exception e1) {
											System.err.println("Enter it  in String Format");
											System.out.println("Please Enter Again");
											asststatus = sc.next();
											if (!validate.idValidation(asststatus)) {
												break jumpvalidate;
											}
										}
									}
									asu.setStatus(sc.next());
									service.updateAsset(a,asu);
									break;
								default:
									System.out.println("Wrong choice");

								}

								break;
							case 4:

								List<Asset>	rs=service.getAllDetails();
								Iterator<Asset> iterator=rs.iterator();
								while(iterator.hasNext())
								{

									System.out.println(iterator.next());
								}

								break;
							case 5:
								List<AssetAllocation>	list=service.getAllAssetAllocationService();
								Iterator<AssetAllocation> iteratorassetallocation=list.iterator();
								while(iteratorassetallocation.hasNext())
								{

									System.out.println(iteratorassetallocation.next());
								}
								break;
							case 6:
								System.out.println("enter allocation id to set status");
								String allocatid=sc.next();
								Boolean zy = validate.idValidation(allocatid);
								jump: while (!zy) {
									try {
										throw integervalidation;
									} 
									catch (Exception e1) {
										System.err.println(" Enter Only Integers(numbers)");
										System.out.println("Please Enter again");
										allocatid = sc.next();
										if (validate.idValidation(allocatid)) {
											break jump;
										}
									}
								}
								Integer allocatioid=Integer.parseInt(allocatid);
								System.out.println("enter status");
								String stas=sc.next();
								System.out.println( service.setStatusService(allocatioid,stas));
								break;
							case 7:
								System.out.println("Logged Out Sucessully");
								break always;
							case 8:
								System.out.println("EXITED FROM PROGRAM");
								break jump1;
							}
						}
					}
				}
				else
				{
					System.err.println("Enter the details correctly");
				}
			}
			if(op==3)
			{
				System.out.println("EXited Sucessfully");
			}
		}
	}
}

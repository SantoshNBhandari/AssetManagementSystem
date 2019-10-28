
package com.dev.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;
import com.dev.beans.Asset;
import com.dev.beans.AssetAllocation;
import com.dev.beans.AssetStatus;
import com.dev.beans.Employee;
import com.dev.beans.UserMaster;
import com.dev.exceptions.AddAssetException;
import com.dev.exceptions.AddEmployeeException;
import com.dev.exceptions.CustomException;
import com.dev.exceptions.InvalidDepartmentException;
import com.dev.exceptions.LoginException;
import com.dev.exceptions.RaiseAllocationException;
import com.dev.exceptions.RemoveAssetException;
import com.dev.exceptions.SetStatusExcption;
import com.dev.exceptions.StatusException;
import com.dev.exceptions.UpdateAssetException;

public class DAOImpl implements DAO {


	Asset asset = new Asset();
	UserMaster um = new UserMaster();

	@Override
	public UserMaster login(Integer userid, String password) {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("asset_management_JPA");
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		try {

			String jpql = "select usertype from UserMaster where userid=:uid and userpassword=:upwd";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("uid", userid);
			query.setParameter("upwd", password);
			String lst = (String) query.getSingleResult();
			if (lst == null) {
				throw new LoginException();
			} else {
				um.setUsertype(lst);
				return um;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return null;
	}

	@Override
	public AssetAllocation raiseRequest(AssetAllocation asetallocate) {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("asset_management_JPA");
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		try {
			Integer min=2000;
			Integer max=5000;
			Integer rand = (int) ((Math.random()*((max-min)+1))+min);
			asetallocate.setAllocationid(rand);
			AssetAllocation assetallocation1 = entityManager.find(AssetAllocation.class,
					asetallocate.getAllocationid());
			if (assetallocation1 == null) {
				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.persist(asetallocate);
				AssetStatus assetstatus = new AssetStatus();
				assetstatus.setAllocationid(asetallocate.getAllocationid());
				entityManager.persist(assetstatus);
				entityTransaction.commit();
				return asetallocate;
			} else {
				throw new RaiseAllocationException();

			}
			
		}
		
		catch (Exception e) {
			throw new CustomException("Request Not Raised because you entered the wrong asset id or employee number");
		}
	
	}

	@Override
	public boolean addEmployee(Employee emp) {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("asset_management_JPA");
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		try {

			Employee employee1 = entityManager.find(Employee.class, emp.getEmpno());
			if (employee1 == null) {
				String q = "select deptid from Department ";
				Query query = entityManager.createQuery(q);
				@SuppressWarnings({ "unchecked" })
				List<Integer> list = query.getResultList();
				Integer f = 0;
				for (Integer dpt : list) {
					if (emp.getDeptid() == dpt) {
						f = 1;
					}
				}
				if (f != 1) {
					entityManager.close();
					throw new InvalidDepartmentException();
				} else {
					EntityTransaction entityTransaction = entityManager.getTransaction();
					entityTransaction.begin();
					entityManager.persist(emp);
					entityTransaction.commit();
					return true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			throw new AddEmployeeException();

		}
		entityManager.close();
		return false;
	}

	@Override
	public boolean addAsset(Asset asset) {

		EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("asset_management_JPA");
		EntityManager entityManager=entityManagerFactory.createEntityManager();	
		try {

			Asset asset1 = entityManager.find(Asset.class, asset.getAssetid());
			if (asset1 == null) {
				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				entityManager.persist(asset);
				entityTransaction.commit();
				return true;
			}

			else {
				throw new AddAssetException();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		entityManager.close();
		return false;
	}

	@Override
	public Asset removeAsset(int r) {
		try {

			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("asset_management_JPA");
			EntityManager entityManager=entityManagerFactory.createEntityManager();	
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			String jpql = "Delete from Asset where assetid=:asi";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("asi", r);
			Integer i = query.executeUpdate();

			if (i > 0) {
				entityTransaction.commit();
				return asset;
			} else {
				throw new RemoveAssetException();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String viewStatus(Integer id1) {
		try {

			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("asset_management_JPA");
			EntityManager entityManager=entityManagerFactory.createEntityManager();	
			String jpql = "from AssetStatus where allocationid=:aid";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("aid", id1);
			@SuppressWarnings("unchecked")
			List<AssetStatus> list = query.getResultList();
			for (AssetStatus stud : list) {

				if (stud.getStatus() == null) {
					return "Status not updated till now";
				} else {
					return ("status: " + stud.getStatus());
				}
			}
		} catch (Exception e) {
			throw new StatusException();
		}
		return "Wrong Allocation Id";
	}

	@Override
	public Boolean updateAsset(int a, Asset asu) {
		if (asu.getAssetname() != null) {

			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("asset_management_JPA");
			EntityManager entityManager=entityManagerFactory.createEntityManager();	
			try {

				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				String jpql = "UPDATE Asset SET assetname=:asname WHERE assetid=:aid";
				Query query = entityManager.createQuery(jpql);
				query.setParameter("asname", asu.getAssetname());
				query.setParameter("aid", a);
				Integer i = query.executeUpdate();
				entityTransaction.commit();
				if (i > 0) {
					return true;
				} else {
					throw new UpdateAssetException();
				}
			} catch (Exception e) {

				e.printStackTrace();
			}
			entityManager.close();
		}

		if (asu.getAssetdes() != null) {

			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("asset_management_JPA");
			EntityManager entityManager=entityManagerFactory.createEntityManager();	
			try {

				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				String jpql = "UPDATE Asset SET assetdes=:asdes WHERE assetid=:aid";
				Query query = entityManager.createQuery(jpql);
				query.setParameter("asdes", asu.getAssetdes());
				query.setParameter("aid", a);
				Integer i = query.executeUpdate();
				entityTransaction.commit();
				if (i > 0) {
					return true;
				} else {
					throw new UpdateAssetException();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			entityManager.close();
		}
		if (asu.getQuantity() != null) {

			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("asset_management_JPA");
			EntityManager entityManager=entityManagerFactory.createEntityManager();	
			try {

				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				String jpql = "UPDATE Asset SET quantity=:asname WHERE assetid=:aid";
				Query query = entityManager.createQuery(jpql);
				query.setParameter("asname", asu.getQuantity());
				query.setParameter("aid", a);
				Integer i = query.executeUpdate();
				entityTransaction.commit();
				if (i > 0) {
					return true;

				} else {
					throw new UpdateAssetException();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			entityManager.close();
		}

		if (asu.getStatus() != null) {

			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("asset_management_JPA");
			EntityManager entityManager=entityManagerFactory.createEntityManager();	
			try {

				EntityTransaction entityTransaction = entityManager.getTransaction();
				entityTransaction.begin();
				String jpql = "UPDATE Asset SET status=:asname WHERE assetid=:aid";
				Query query = entityManager.createQuery(jpql);
				query.setParameter("asname", asu.getStatus());
				query.setParameter("aid", a);
				Integer i = query.executeUpdate();
				entityTransaction.commit();
				if (i > 0) {
					return true;
				} else {

					throw new UpdateAssetException();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			entityManager.close();
		}

		return null;
	}

	@Override
	public List<Asset> getAllDetails() {
		try {

			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("asset_management_JPA");
			EntityManager entityManager=entityManagerFactory.createEntityManager();	
			String jpql = "from Asset";
			Query query = entityManager.createQuery(jpql);
			@SuppressWarnings("unchecked")
			List<Asset> list = query.getResultList();
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<AssetAllocation> getAllAssetAllocation() {
		try {

			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("asset_management_JPA");
			EntityManager entityManager=entityManagerFactory.createEntityManager();	

			String jpql = "from AssetAllocation";
			Query query = entityManager.createQuery(jpql);
			@SuppressWarnings("unchecked")
			List<AssetAllocation> list = query.getResultList();
			return list;
		}

		catch (Exception e) {

			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean setStatus(Integer allocationid, String status) {
		try {

			EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("asset_management_JPA");
			EntityManager entityManager=entityManagerFactory.createEntityManager();	
			EntityTransaction entityTransaction = entityManager.getTransaction();
			entityTransaction.begin();
			String jpql = "UPDATE AssetStatus SET status=:asname WHERE allocationid=:aid";
			Query query = entityManager.createQuery(jpql);
			query.setParameter("asname", status);
			query.setParameter("aid", allocationid);
			Integer i = query.executeUpdate();
			entityTransaction.commit();
			if (i > 0) {
				return true;
			} else {
				return false;

			}
		} catch (Exception e) {
			throw new SetStatusExcption();

		}

	}

}












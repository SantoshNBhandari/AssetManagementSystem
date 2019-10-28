package com.dev.beans;

public class Employee {
private Integer empno;
private String ename;
private String job;
private Integer mgrno;
private String hiredate;
private Integer deptid;
public Integer getEmpno() {
	return empno;
}
public void setEmpno(Integer empno) {
	this.empno = empno;
}
public String getEname() {
	return ename;
}
public void setEname(String ename) {
	this.ename = ename;
}
public String getJob() {
	return job;
}
public void setJob(String job) {
	this.job = job;
}
public Integer getMgrno() {
	return mgrno;
}
public void setMgrno(Integer mgrno) {
	this.mgrno = mgrno;
}
public String getHiredate() {
	return hiredate;
}
public void setHiredate(String hiredate) {
	this.hiredate = hiredate;
}
public Integer getDeptid() {
	return deptid;
}
public void setDeptid(Integer deptid) {
	this.deptid = deptid;
}
@Override
public String toString() {
	return "Employee [empno=" + empno + ", ename=" + ename + ", job=" + job + ", mgrno=" + mgrno + ", hiredate="
			+ hiredate + ", deptid=" + deptid + "]";
}

}

package com.dev.beans;

public class UserMaster {
private Integer userid;
private String username;
private String userpassword;
private String usertype;
public Integer getUserid() {
	return userid;
}
public void setUserid(Integer userid) {
	this.userid = userid;
}
public String getUsername() {
	return username;
}
public void setUsername(String username) {
	this.username = username;
}
public String getUserpassword() {
	return userpassword;
}
public void setUserpassword(String userpassword) {
	this.userpassword = userpassword;
}
public String getUsertype() {
	return usertype;
}
public void setUsertype(String usertype) {
	this.usertype = usertype;
}
@Override
public String toString() {
	return "UserMaster [userid=" + userid + ", username=" + username + ", userpassword=" + userpassword
			+ ", usertype=" + usertype + "]";
}

}

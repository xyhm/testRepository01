package cn.itcast.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 用户实体类
 * 
 * 实体类和数据库中的字段不对应时候使用别名 ： 
 * 		方式一：sql语句使用别名与实体类对应
 * 		方式二：实体类使用别名配置与表对应
 * 
 * @author admin
 *
 */
public class User implements Serializable {
	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 1L;

	private Integer userId;
	private String userUsername;
	private Date userBirthday;
	private String userSex;
	private String userAddress;
	//主表实体包含从表实体的集合引用
	private List<Account> accounts;
	
	public User() {
		super();
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Date getUserBirthday() {
		return userBirthday;
	}

	public void setUserBirthday(Date userBirthday) {
		this.userBirthday = userBirthday;
	}

	public String getUserSex() {
		return userSex;
	}

	public void setUserSex(String userSex) {
		this.userSex = userSex;
	}

	public String getUserAddress() {
		return userAddress;
	}

	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}

//	@Override
//	public String toString() {
//		return "User [userId=" + userId + ", userUsername=" + userUsername + ", userBirthday=" + userBirthday
//				+ ", userSex=" + userSex + ", userAddress=" + userAddress + "]";
//	}

	public String getUserUsername() {
		return userUsername;
	}

	public void setUserUsername(String userUsername) {
		this.userUsername = userUsername;
	}

}

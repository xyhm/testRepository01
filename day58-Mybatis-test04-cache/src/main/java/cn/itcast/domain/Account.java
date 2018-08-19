package cn.itcast.domain;

import java.io.Serializable;

/**
 * 账户实体类
 * 
 * @author admin
 *
 */
public class Account implements Serializable {
	/**
	 * 版本号
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer uid;
	private double money;
	//从表实体应该包含主表实体的对信息引用
	private User user;
	
	public Account() {
		super();
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUid() {
		return uid;
	}

	public void setUid(Integer uid) {
		this.uid = uid;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(double money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", uid=" + uid + ", money=" + money + "]";
	}

}

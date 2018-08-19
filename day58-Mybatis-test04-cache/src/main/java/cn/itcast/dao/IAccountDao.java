package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.Account;

/**
 * 账户的持久层接口
 * @author admin
 *
 */
public interface IAccountDao {

	/**
	 * 查询所有账户，同时包含账户的用户名称
	 * 要求用户使用延迟加载方式查询《一般不用延迟，只是练习技术点》	
	 * @return
	 */
	public abstract List<Account> findAllAccount();
}

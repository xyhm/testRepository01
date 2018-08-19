package cn.itcast.dao;

import java.util.List;

import cn.itcast.domain.User;

/**
 * 用户持久层接口
 * @author admin
 *
 */
public interface IUserDao {
	
	/**
	 * 查询所有用户,同时使用延迟加载查询每个用户下的账户信息
	 * @return
	 */
	public abstract List<User> findAll();
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return
	 */
	public abstract User findById(Integer id);

	/**
	 * 更新用户信息
	 * @param user
	 */
	public abstract void updateUser(User user);
}

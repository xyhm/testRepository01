package cn.itcast.test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Ignore;
import org.junit.Test;

import cn.itcast.dao.IUserDao;
import cn.itcast.domain.Account;
import cn.itcast.domain.User;

/**
 * 测试类
 * @author admin
 *
 */
public class UserTest {

	/**
	 * 测试二级缓存确实存在
	 */
	@Test
	public void testSecondLevelCatch() throws Exception {
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		IUserDao dao = session.getMapper(IUserDao.class);
		
		System.out.println("dao的第一次使用..." + dao);
		//第一次查询
		User user= dao.findById(46);
		//关闭session
		session.close();//一级缓存消失
		//重新获取session
		session = factory.openSession();
		//重新创建dao的代理对象
		dao = session.getMapper(IUserDao.class);
		System.out.println("dao的第二次使用..." + dao);
		
		//第二次查询
		User user1 = dao.findById(46);
		
		System.out.println("user第一次查询的对象 : " + user);
		System.out.println("user第二次查询的对象 : " + user1);
		
	} 
	
	/**
	 * 测试一级缓存确实存在
	 */
	@Test@Ignore
	public void testFindOne() throws Exception {
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		IUserDao dao = session.getMapper(IUserDao.class);
		/*//第一次查询
		User user= dao.findById(46);
		user.setUserBirthday(new Date());
		//更新  -- 会导致Mybatis的一级缓存清除
		dao.updateUser(user);
		
		//第二次查询
		User user1 = dao.findById(46);
		
		//提交事务  --- Mybatis默认手动提交事务
		session.commit();
		
		System.out.println(user);
		System.out.println(user1);*/
		
		//第一次查询
		User user= dao.findById(46);
		
		//清除一级缓存
		session.clearCache();
		
		//第二次查询
		User user1 = dao.findById(46);
		
		System.out.println(user);
		System.out.println(user1);
		
		
		
		//释放资源
//		session.close();
//		in.close();
	} 
	
	
	@Test@Ignore
	public void testFindAll() throws Exception {
		InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
		SqlSession session = factory.openSession();
		IUserDao dao = session.getMapper(IUserDao.class);
		List<User> users = dao.findAll();
		if(null == users || users.isEmpty()) {
			throw new IllegalArgumentException("集合为空");
		}
		
		System.out.println(users.size());
//		for(User user : users) {
//			System.out.println(user);
//		}
		//
		session.close();
		in.close();
	}
}

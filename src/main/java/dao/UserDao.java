package dao;

import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.T_Model;
import model.T_User;

public class UserDao {
	private SessionFactory sessionFactory;// 声明私有会话工厂对象类
	private static Session session;// 声明私有会话对象类
	private Transaction transaction;// 声明私有事务对象类
    private Configuration config;
    
	public void init() {
		// 创建配置对象
		 config = new Configuration().configure("model/Hibernate.cfg.xml");
		// 创建服务注册对象
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(config.getProperties())
				.build();
		// 创建会话工程对象
		 //sessionFactory = config.buildSessionFactory(serviceRegistry);
		sessionFactory = config.buildSessionFactory();
		//会话对象
		session = sessionFactory.openSession();
		//开启事务
		transaction=session.beginTransaction();
		//System.out.println("before");
		
	}

	public void destory() {
		// 事务提交
		transaction.commit();
		// 会话关闭
		session.close();
		// 会话工厂关闭
		sessionFactory.close();
	}

	// 增加
	public void testSaveUser() {
		init();
		T_User u = new T_User();
		Scanner scan = new Scanner(System.in);
		System.out.println("您将进行的是新增操作:");
		System.out.println("请输入用户编码");
		u.setLoginName(scan.next());
		System.out.println("请输入用户密码");
		u.setPassword(scan.next());
		System.out.println("请输入用户姓名");
		u.setUserName(scan.next());
		System.out.println("请输入性别：0表示男,1表示女");
		u.setUserSex(scan.next());
		System.out.println("请输入权限：（1表示有权限，0表示无权限。功能按顺序分别为借机登记、样机归还、客户信息维护、样机信息维护、借机明细查询、借机统计、用户信息管理。）");
		u.setFunctionPopedom(scan.next());
	
		session.save(u);
		System.out.println("新增成功！您的ID为：" + u.getUserID());
//		T_User u=new T_User(02, "01", "lily", "lily", "1",
//				"1111111");
		destory();				
	}
	
	// 修改
	public void testUpdateUser() {
		init();
		T_User u = new T_User();
		Scanner scan = new Scanner(System.in);
		System.out.println("您将进行的是修改操作:");
		System.out.println("请输入修改用户的ID");
		u = (T_User) session.get(T_User.class, scan.nextInt());

		System.out.println("您将进行的是修改操作序号:1：LoginName，2：Password，3：UserName" + 
		"4：UserSex,5:FunctionPopedom");
		String sr = scan.next();
		switch (sr) {
		case "1": {
			System.out.println("请输入新用户编码");
			u.setLoginName(scan.next());
			break;
		}
		case "2": {
			System.out.println("请输入新用户密码");
			u.setPassword(scan.next());
			break;
		}
		case "3": {
			System.out.println("请输入新用户姓名");
			u.setUserName(scan.next());
			break;
		}
		case "4": {
			System.out.println("请输入新性别：0表示男,1表示女");
			u.setUserSex(scan.next());
			break;
		}
		case "5": {
			System.out.println("请输入新权限");
			u.setFunctionPopedom(scan.next());
			break;
		}
		
		default:
			break;
		}
		session.update(u);
		System.out.println("修改成功！");
		destory();
	}
	// 删除
	public void testDeleteUser() {
		init();
		T_User u = new T_User();
		Scanner scan = new Scanner(System.in);

		System.out.println("您将进行的是删除操作:");
		System.out.println("请输入删除用户的ID");
		u = (T_User) session.get(T_User.class, scan.nextInt());
		session.delete(u);
		System.out.println("删除成功！");
		destory();
	}
	// 查询
	public void testGetUserall() {
		init();
		T_User u = new T_User();
		Scanner scan = new Scanner(System.in);

		System.out.println("您将进行的是查询操作:");
		System.out.println("请输入查询用户的ID");
		u = (T_User) session.get(T_User.class, scan.nextInt());
		System.out.println(u);
		System.out.println("查询成功！");
		destory();
	}
	// 模糊查询按LoginName
		public static List<T_User> findByLoginName(String rname) throws Exception {
			Query query = session.createQuery("from T_User as s where s.LoginName like :name");
			query.setString("name", "%" + rname + "%");
			List result = query.list();

			for (int i = 0; i < result.size(); i++) {
				T_User c = new T_User();
				T_User customer = (T_User) result.get(i);

				int modelid = customer.getUserID();
				System.out.println("id="+modelid);
				c = (T_User) session.get(T_User.class, modelid);
				System.out.println("查询成功！");
				System.out.println(c);

			}
			return result;
		}

		public void testGetUser() throws Exception {
			init();
			Scanner scan = new Scanner(System.in);
			System.out.println("您将进行的是模糊查询操作:");
			System.out.println("输入您要查询的用户登录名称");
			String sname = "";
			sname = scan.next();
			System.out.println();
			findByLoginName(sname);
			destory();
		
		}

}

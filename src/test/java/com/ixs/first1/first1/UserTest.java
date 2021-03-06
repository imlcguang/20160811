package com.ixs.first1.first1;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.T_Customer;
import model.T_User;

public class UserTest {
	private SessionFactory sessionFactory;// 声明私有会话工厂对象类
	private Session session;// 声明私有会话对象类
	private Transaction transaction;// 声明私有事务对象类
    private Configuration config;
    
	@Before
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
		System.out.println("before");
		
	}

	@After
	public void destory() {
		// 事务提交
		transaction.commit();
		// 会话关闭
		session.close();
		// 会话工厂关闭
		sessionFactory.close();
		System.out.println("after");
	}

	@Test
	// 增加
	public void testSaveUser() {
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
		System.out.println("请输入权限");
		u.setFunctionPopedom(scan.next());
	
		session.save(u);
		System.out.println("新增成功！您的ID为：" + u.getUserID());
//		T_User u=new T_User(02, "01", "lily", "lily", "1",
//				"1111111");
						
	}
	
	@Test
	// 修改
	public void testUpdateUser() {
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
	}
	@Test
	// 删除
	public void testDeleteUser() {
		T_User u = new T_User();
		Scanner scan = new Scanner(System.in);

		System.out.println("您将进行的是删除操作:");
		System.out.println("请输入删除用户的ID");
		u = (T_User) session.get(T_User.class, scan.nextInt());
		session.delete(u);
		System.out.println("删除成功！");
	}
	@Test
	// 查询
	public void testGetUser() {
		T_User u = new T_User();
		Scanner scan = new Scanner(System.in);

		System.out.println("您将进行的是查询操作:");
		System.out.println("请输入查询用户的ID");
		u = (T_User) session.get(T_User.class, scan.nextInt());
		System.out.println(u);
		System.out.println("查询成功！");
	}


}

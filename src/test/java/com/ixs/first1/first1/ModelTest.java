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

import model.T_Model;
import model.T_User;

public class ModelTest {

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
		// sessionFactory = config.buildSessionFactory(serviceRegistry);
		sessionFactory = config.buildSessionFactory();
		// 会话对象
		session = sessionFactory.openSession();
		// 开启事务
		transaction = session.beginTransaction();
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
	public void testSaveModel() {
		T_Model m = new T_Model();
		Scanner scan = new Scanner(System.in);

		System.out.println("您将进行的是新增操作:");
		System.out.println("请输入样机名称");
		m.setModelName(scan.next());
		System.out.println("请输入样机版本");
		m.setModelVersion(scan.next());
		System.out.println("请输入样机说明");
		m.setModelDesc(scan.next());

		session.save(m);
		System.out.println("新增成功！您的ID为：" + m.getModelID());

	}

	@Test
	// 修改
	public void testUpdateModel() {
		T_Model m = new T_Model();
		Scanner scan = new Scanner(System.in);
		System.out.println("您将进行的是修改操作:");
		System.out.println("请输入修改用户的ID");
		m = (T_Model) session.get(T_Model.class, scan.nextInt());

		System.out.println("您将进行的是修改操作序号:1：ModelName，2：ModelVersion，3：ModelDesc");
		String sr = scan.next();
		switch (sr) {
		case "1": {
			System.out.println("请输入新样机名称");
			m.setModelName(scan.next());
			break;
		}
		case "2": {
			System.out.println("请输入新样机版本");
			m.setModelVersion(scan.next());
			break;
		}
		case "3": {
			System.out.println("请输入新样机说明");
			m.setModelDesc(scan.next());
			break;
		}
		default:
			break;
		}
		session.update(m);
		System.out.println("修改成功！");
	}

	@Test
	// 删除
	public void testDeleteModel() {
		T_Model m = new T_Model();
		Scanner scan = new Scanner(System.in);

		System.out.println("您将进行的是删除操作:");
		System.out.println("请输入删除用户的ID");
		m = (T_Model) session.get(T_Model.class, scan.nextInt());
		session.delete(m);
		System.out.println("删除成功！");
	}

	@Test
	// 查询
	public void testGetModel() {
		T_Model m = new T_Model();
		Scanner scan = new Scanner(System.in);

		System.out.println("您将进行的是查询操作:");
		System.out.println("请输入查询用户的ID");
		m = (T_Model) session.get(T_Model.class, scan.nextInt());
		System.out.println(m);
		System.out.println("查询成功！");
	}

}

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

import model.T_Customer;
import model.T_Model;

public class ModelDao {
	private static SessionFactory sessionFactory;// 声明私有会话工厂对象类
	private static Session session;// 声明私有会话对象类
	private static Transaction transaction;// 声明私有事务对象类
	private static Configuration config;

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
		// System.out.println("before");

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
	public void testSaveModel() {
		init();
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
		destory();

	}

	// 修改
	public void testUpdateModel() {
		init();
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
		destory();
	}

	// 删除
	public void testDeleteModel() {
		init();
		T_Model m = new T_Model();
		Scanner scan = new Scanner(System.in);

		System.out.println("您将进行的是删除操作:");
		System.out.println("请输入删除用户的ID");
		m = (T_Model) session.get(T_Model.class, scan.nextInt());
		session.delete(m);
		System.out.println("删除成功！");
		destory();
	}

	// 查询
	public void testGetModelfromid() {
		init();
		T_Model m = new T_Model();
		Scanner scan = new Scanner(System.in);

		System.out.println("您将进行的是查询操作:");
		System.out.println("请输入查询用户的ID");
		m = (T_Model) session.get(T_Model.class, scan.nextInt());
		System.out.println(m);
		System.out.println("查询成功！");
		destory();
	}

	// 模糊查询按ModelName
	public static List<T_Model> findByModelName(String rname) throws Exception {
		Query query = session.createQuery("from T_Model as s where s.ModelName like :name");
		query.setString("name", "%" + rname + "%");
		List result = query.list();

		for (int i = 0; i < result.size(); i++) {
			T_Model c = new T_Model();
			T_Model customer = (T_Model) result.get(i);

			int modelid = customer.getModelID();
			c = (T_Model) session.get(T_Model.class, modelid);
			System.out.println("查询成功！");
			System.out.println(c);

		}
		return result;
	}

	public void testGetModel() throws Exception {
		init();
		Scanner scan = new Scanner(System.in);
		System.out.println("您将进行的是模糊查询操作:");
		System.out.println("输入您要查询的样机名称");
		String sname = "";
		sname = scan.next();
		System.out.println();
		findByModelName(sname);
		destory();
	
	}

}

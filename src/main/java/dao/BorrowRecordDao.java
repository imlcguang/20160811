package dao;

import java.util.Date;
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

import model.T_BorrowRecord;
import model.T_Customer;
import model.T_Model;
import model.T_User;

public class BorrowRecordDao {
	private SessionFactory sessionFactory;// 声明私有会话工厂对象类
	private Session session;// 声明私有会话对象类
	private Transaction transaction;// 声明私有事务对象类
	private Configuration config;

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
		//System.out.println("before");

	}

	public void destory() {
		// 事务提交
		transaction.commit();
		// 会话关闭
		session.close();
		// 会话工厂关闭
		sessionFactory.close();
		System.out.println("after");
	}

	// 增加
	public void testSaveBorrowRecord() {
		init();
		T_BorrowRecord b = new T_BorrowRecord();

		Scanner scan = new Scanner(System.in);
		System.out.println("您将进行的是新增操作:");
		System.out.println("请输入客户ID");
		T_Customer c = (T_Customer) session.get(T_Customer.class, scan.nextInt());
		b.setCustomerID(c);
		// 之后要修改发货时间这句
		b.setSendDatetime(new Date());

		System.out.println("请输入批准人ID");
		T_User u = (T_User) session.get(T_User.class, scan.nextInt());
		b.setBorrowPermitPerson(u);

		System.out.println("请输入操作员ID");
		T_User u2 = (T_User) session.get(T_User.class, scan.nextInt());
		b.setBorrowOperator(u2);

		b.setBorrowOperatDatetime(new Date());

		// 预计归还时间还要改!
		b.setPlanReturnDatetime(new Date());

		System.out.println("请输入样机ID");
		T_Model m = (T_Model) session.get(T_Model.class, scan.nextInt());
		b.setModelID(m);

		System.out.println("请输入借机数量");
		b.setBorrowNo(scan.nextInt());

		System.out.println("请输入借条编号");
		b.setBorrowCheckNo(scan.nextInt());

		b.setReturnDatetime(new Date());

		System.out.println("请输入归还操作员ID");
		T_User u3 = (T_User) session.get(T_User.class, scan.nextInt());
		b.setReturnOperator(u3);

		session.save(b);
		System.out.println("新增成功！您的借机编号为：" + b.getBorrowNo());
		// T_User u=new T_User(02, "01", "lily", "lily", "1",
		// "1111111");
		destory();

	}

	// 修改
	public void testUpdateBorrowRecord() {
		init();
		T_BorrowRecord b = new T_BorrowRecord();
		Scanner scan = new Scanner(System.in);
		System.out.println("您将进行的是修改操作:");
		System.out.println("请输入要修改的借机编号");
		b = (T_BorrowRecord) session.get(T_BorrowRecord.class, scan.nextInt());

		System.out.println("您将进行的是修改操作序号: 1：CustomerID,:2： SendDatetime,3:BorrowPermitPerson,"
				+ "4:BorrowOperator, 5:BorrowOperatDatetime（不可修改）,6:PlanReturnDatetime, "
				+ "7:ModelID,8:BorrowNumber,9:BorrowCheckNo" + ", 10:ReturnDatetime,11: ReturnOperator");
		String sr = scan.next();
		switch (sr) {
		case "1": {
			System.out.println("请输入客户ID");
			T_Customer c = (T_Customer) session.get(T_Customer.class, scan.nextInt());
			b.setCustomerID(c);
			break;
		}
		case "2": {
			b.setSendDatetime(new Date());
			break;
		}
		case "3": {
			System.out.println("请输入批准人ID");
			T_User u = (T_User) session.get(T_User.class, scan.nextInt());
			b.setBorrowPermitPerson(u);
			break;
		}
		case "4": {
			System.out.println("请输入操作员ID");
			T_User u2 = (T_User) session.get(T_User.class, scan.nextInt());
			b.setBorrowOperator(u2);
			break;
		}
		case "6": {
			b.setPlanReturnDatetime(new Date());
			break;
		}
		case "7": {
			System.out.println("请输入样机ID");
			T_Model m = (T_Model) session.get(T_Model.class, scan.nextInt());
			b.setModelID(m);
			break;
		}
		case "8": {
			System.out.println("请输入借机数量");
			b.setBorrowNo(scan.nextInt());
			break;
		}
		case "9": {
			System.out.println("请输入借条编号");
			b.setBorrowCheckNo(scan.nextInt());
			break;
		}
		case "10": {
			b.setReturnDatetime(new Date());
			break;
		}
		case "11": {
			System.out.println("请输入归还操作员ID");
			T_User u3 = (T_User) session.get(T_User.class, scan.nextInt());
			b.setReturnOperator(u3);
			break;
		}

		default:
			break;
		}
		session.update(b);
		System.out.println("修改成功！");
		destory();
	}

	// 删除
	public void testDeleteBorrowRecord() {
		init();
		T_BorrowRecord b = new T_BorrowRecord();
		Scanner scan = new Scanner(System.in);

		System.out.println("您将进行的是删除操作:");
		System.out.println("请输入删除的借机编号");
		b = (T_BorrowRecord) session.get(T_BorrowRecord.class, scan.nextInt());
		session.delete(b);
		System.out.println("删除成功！");
		destory();
	}

	// 查询
	public void testGetBorrowRecord() {
		init();
		T_BorrowRecord b = new T_BorrowRecord();
		Scanner scan = new Scanner(System.in);

		System.out.println("您将进行的是查询操作:");
		System.out.println("请输入查询的借机编号");
		b = (T_BorrowRecord) session.get(T_BorrowRecord.class, scan.nextInt());
		System.out.println(b);
		System.out.println("查询成功！");
		destory();
	}
}

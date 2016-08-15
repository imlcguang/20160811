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
import org.junit.Test;

import model.T_Customer;

public class CustomerDaonew {
	private static SessionFactory sessionFactory;// 声明私有会话工厂对象类
	private static Session session;// 声明私有会话对象类
	private static Transaction transaction;// 声明私有事务对象类
	private static Configuration config;

	// @Before
	public static void init() {
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

	// @After
	public void destory() {
		// 事务提交
		transaction.commit();
		// 会话关闭
		session.close();
		// 会话工厂关闭
		sessionFactory.close();
		// System.out.println("after");
	}

	@Test
	// 增加
	public void testSaveCustomers() {
		init();
		T_Customer c = new T_Customer();
		Scanner scan = new Scanner(System.in);
		System.out.println("您将进行的是新增操作:");
		System.out.println("请输入姓名");
		c.setCustomerName(scan.next());
		System.out.println("请输入联系人姓名");
		c.setRelationName(scan.next());
		System.out.println("请输入联系电话");
		c.setRelationPhone(scan.next());
		System.out.println("请输入地址");
		c.setAddress(scan.next());
		System.out.println("请输入邮箱");
		c.setEmail(scan.next());
		System.out.println("请输入备注");
		c.setRemark(scan.next());

		session.save(c);
		System.out.println("新增成功！您的ID为：" + c.getCustomerID());
		destory();
	}

	@Test
	// 修改
	public void testUpdateCustomers() {
		init();
		T_Customer c = new T_Customer();
		Scanner scan = new Scanner(System.in);
		System.out.println("您将进行的是修改操作:");
		System.out.println("请输入修改用户的ID");
		c = (T_Customer) session.get(T_Customer.class, scan.nextInt());

		System.out.println("您将进行的是修改操作序号:1：CustomerName，2：RelationName，3：RelationPhone" + "4：Address,5:Email,6:Remark");
		String sr = scan.next();
		switch (sr) {
		case "1": {
			System.out.println("请输入新姓名");
			c.setCustomerName(scan.next());
			break;
		}
		case "2": {
			System.out.println("请输入新联系人姓名");
			c.setRelationName(scan.next());
			break;
		}
		case "3": {
			System.out.println("请输入新联系电话");
			c.setRelationPhone(scan.next());
			break;
		}
		case "4": {
			System.out.println("请输入新地址");
			c.setAddress(scan.next());
			break;
		}
		case "5": {
			System.out.println("请输入新邮箱");
			c.setEmail(scan.next());
			break;
		}
		case "6": {
			System.out.println("请输入新备注");
			c.setRemark(scan.next());
			break;
		}
		default:
			break;
		}
		session.update(c);
		System.out.println("修改成功！");
		destory();
	}

	@Test
	// 删除
	public void testDeleteCustomers() {
		init();
		T_Customer c = new T_Customer();
		Scanner scan = new Scanner(System.in);

		System.out.println("您将进行的是删除操作:");
		System.out.println("请输入删除用户的ID");
		c = (T_Customer) session.get(T_Customer.class, scan.nextInt());
		session.delete(c);
		System.out.println("删除成功！");
		destory();
	}

	@Test
	// 查询
	public void testGetCustomersfromid() {
		init();
		T_Customer c = new T_Customer();
		Scanner scan = new Scanner(System.in);
		System.out.println("您将进行的是查询操作:");
		System.out.println("请输入查询用户的ID");
		c = (T_Customer) session.get(T_Customer.class, scan.nextInt());
		System.out.println(c);
		System.out.println("查询成功！");
		destory();
	}

	// 模糊查询按名字
	public static List<T_Customer> findByCustomerName(String sname) throws Exception {

		// String strSQL = "from T_Customer as s where s.CustomerName like
		// :name";
		Query query = session.createQuery("from T_Customer as s where s.CustomerName like :name");
		query.setString("name", "%" + sname + "%");
		List result = query.list();

		for (int i = 0; i < result.size(); i++) {
			T_Customer c = new T_Customer();
			T_Customer customer = (T_Customer) result.get(i);

			int customerid = customer.getCustomerID();
			c = (T_Customer) session.get(T_Customer.class, customerid);
			System.out.println("查询成功！");
			System.out.println(c);

		}
		return result;
	}

	// 模糊查询按联系人
	public static List<T_Customer> findByRelationName(String rname) throws Exception {

		// String strSQL = "from T_Customer as s where s.CustomerName like
		// :name";
		Query query = session.createQuery("from T_Customer as s where s.RelationName like :name");
		query.setString("name", "%" + rname + "%");
		List result = query.list();

		for (int i = 0; i < result.size(); i++) {
			T_Customer c = new T_Customer();
			T_Customer customer = (T_Customer) result.get(i);

			int customerid = customer.getCustomerID();
			c = (T_Customer) session.get(T_Customer.class, customerid);
			System.out.println("查询成功！");
			System.out.println(c);

		}
		return result;
	}
	// 模糊查询按联系人
		public static List<T_Customer> findByRelationPhone(String rname) throws Exception {

			// String strSQL = "from T_Customer as s where s.CustomerName like
			// :name";
			Query query = session.createQuery("from T_Customer as s where s.RelationPhone like :name");
			query.setString("name", "%" + rname + "%");
			List result = query.list();

			for (int i = 0; i < result.size(); i++) {
				T_Customer c = new T_Customer();
				T_Customer customer = (T_Customer) result.get(i);

				int customerid = customer.getCustomerID();
				c = (T_Customer) session.get(T_Customer.class, customerid);
				System.out.println("查询成功！");
				System.out.println(c);

			}
			return result;
		}

	@Test
	public void testGetCustomers() throws Exception {
		init();
		Scanner scan = new Scanner(System.in);
		System.out.println("您将进行的是模糊查询操作:");
		System.out.println("按____查询：（1客户姓名，2联系人，3电话）");
		switch (scan.next()) {
		case "1": {
			System.out.println("输入您要查询的姓名");
			String sname = "";
			sname = scan.next();
			System.out.println();
			findByCustomerName(sname);
			destory();
			break;
		}
		case "2": {
			System.out.println("输入您要查询的联系人");
			String sname = "";
			sname = scan.next();
			System.out.println();
			findByRelationName(sname);
			destory();
			break;

		}
		case "3": {
			System.out.println("输入您要查询的电话");
			String sname = "";
			sname = scan.next();
			System.out.println();
			findByRelationPhone(sname);
			destory();
			break;
			
		}

		default:
			break;
		}

	}

}

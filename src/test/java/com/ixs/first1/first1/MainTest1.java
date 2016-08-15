package com.ixs.first1.first1;

import java.util.Scanner;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.jboss.jandex.Main;

import dao.BorrowRecordDao;
import dao.CustomerDao;
import dao.CustomerDaonew;
import dao.ModelDao;
import dao.UserDao;

public class MainTest1 {
	public static void main(String[] args) throws Exception {
		System.out.println("请输入身份：1:系统管理员,2:商务");
		Scanner scan = new Scanner(System.in);

		switch (scan.next()) {
		// 系统管理员：修改密码，用户登录→用户信息管理（各种信息的增删改）
		case "1": {
			System.out.println("请输入操作的内容：（1客户，2用户，3样机）");
			switch (scan.next()) {
			// 1客户表的增删改查
			case "1": {
				System.out.println("请输入要进行的操作：1增2删3改4查");
				switch (scan.next()) {
				case "1": {
					CustomerDaonew customert = new CustomerDaonew();
					customert.testSaveCustomers();
					break;
				}
				case "2": {
					CustomerDaonew customert = new CustomerDaonew();
					customert.testDeleteCustomers();
					break;
				}
				case "3": {
					CustomerDaonew customert = new CustomerDaonew();
					customert.testUpdateCustomers();
					break;
				}
				case "4": {
					CustomerDaonew customert = new CustomerDaonew();
					customert.testGetCustomers();
					break;
				}

				default:
					break;
				}

				break;

			}
			// 2用户
			case "2": {
				System.out.println("请输入要进行的操作：1增2删3改4查");
				switch (scan.next()) {
				case "1": {
					UserDao user = new UserDao();
					user.testSaveUser();
					break;
				}
				case "2": {
					UserDao user = new UserDao();
					user.testDeleteUser();
					break;
				}
				case "3": {
					UserDao user = new UserDao();
					user.testUpdateUser();
					break;
				}
				case "4": {
					UserDao user = new UserDao();
					user.testGetUser();
					break;
				}

				default:
					break;
				}

				break;
			}
			// 3样机
			case "3": {
				System.out.println("请输入要进行的操作：1增2删3改4查");
				switch (scan.next()) {
				case "1": {
					ModelDao model = new ModelDao();
					model.testSaveModel();
					break;
				}
				case "2": {
					ModelDao model = new ModelDao();
					model.testDeleteModel();
					break;
				}
				case "3": {
					ModelDao model = new ModelDao();
					model.testUpdateModel();
					break;
				}
				case "4": {
					ModelDao model = new ModelDao();
					model.testGetModel();
					break;
				}

				default:
					break;
				}

				break;
			}
			default:
				break;

			}

			break;
		}

		// 2商务：借机登记，归还，统计，明细查询
		case "2": {
			System.out.println("请输入操作的内容：（1借机登记，2样机归还，3借机明细查询，4借机统计）");
			switch (scan.next()) {
			//1借机登记×
			case "1": {
				BorrowRecordDao brd = new BorrowRecordDao();
				break;

			}
			//2样机归还√
			case "2": {
				BorrowRecordDao brd = new BorrowRecordDao();
				brd.testSaveReturnRecord();
				break;

			}
			//3借机明细查询√
			case "3": {
				BorrowRecordDao brd = new BorrowRecordDao();
				brd.testGetBorrowRecord();
				break;

			}
			//4借机统计×
			case "4": {
				BorrowRecordDao brd = new BorrowRecordDao();
				brd.testCountBorrowRecord();
				break;

			}

			default:
				break;
			}

			break;
		}
		default:
			break;
		}
	}
}

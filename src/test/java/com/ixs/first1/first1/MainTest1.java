package com.ixs.first1.first1;

import java.util.Scanner;

import org.jboss.jandex.Main;

public class MainTest1 {
	public static void main(String[] args) {
		System.out.println("请身份：1:系统管理员,2:商务");
		Scanner scan = new Scanner(System.in);

		switch (scan.next()) {
		// 系统管理员：修改密码，用户登录→用户信息管理（各种信息的增删改）
		case "1": {
			System.out.println("请输入需要修改的信息序号：（1客户，2用户，3样机）");
			switch (scan.next()) {
			// 1客户
			case "1": {
				System.out.println("请输入要进行的操作：1增2删3改4查");
				switch (scan.next()) {
				case "1":{
					CustomerTest customert = new CustomerTest();
					customert.testSaveCustomers();
					break;
				}
				case "2":{
					CustomerTest customert = new CustomerTest();
					customert.testDeleteCustomers();
					break;
				}
				case "3":{
					CustomerTest customert = new CustomerTest();
					customert.testUpdateCustomers();
					break;
				}
				case "4":{
					CustomerTest customert = new CustomerTest();
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

				break;
			}
			// 3样机
			case "3": {

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

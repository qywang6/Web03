package com.auto.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 连接访问数据库的工具类
 * */
public class DBUtil {
	static String url ="jdbc:mysql://localhost:3306/xinhua?useUnicode=true&characterEncoding=utf8";
	// 加载数据库的驱动包类名
	static String driver="com.mysql.jdbc.Driver";
	// 连接数据库的用户名
	static String username="root" ;
	// 连接数据库的密码
	static String password="root" ;
	
	//静态方法 ：可以由类名直接调用
	public static Connection getConnection(){
		// try里面代码是正常执行时，调用的代码块
		// catch中代码是当出现异常时，执行的代码块
		try {
			// 加载驱动
			Class.forName(driver);
			//获取数据库连接对象Connection
			Connection conn = DriverManager.getConnection(url, username, password);
			return conn;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new RuntimeException();
		}
	}
}

package com.myBlog.utils;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.mysql.jdbc.Connection;

public class JdbcTools {
	static{
   	 try {
			Class.forName(CommonValue.DRIVER);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("加载驱动失败");
		}
   }
   public static Connection getConnection(){
		Connection conn = null;
		try {
			conn = (Connection) DriverManager.getConnection(CommonValue.JDBC_URL,CommonValue.JDBC_USER,CommonValue.JDBC_PWD);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("创建数据库连接失败");
		}
		return conn;
   }
   public static void closeResource(Connection conn, PreparedStatement stmt,ResultSet rs) {
	   if(rs!= null) {
		   try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	   if(stmt!= null) {
		   try {
				stmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	   if(conn!= null) {
		   try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	   }
	   }
}

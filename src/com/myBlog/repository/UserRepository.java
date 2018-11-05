package com.myBlog.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.myBlog.models.User;
import com.myBlog.utils.JdbcTools;
import com.mysql.jdbc.Connection;

public class UserRepository {
	public User findByUsername(String username) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet tr = null;
		String sql = "select * from t_user where username=?";
		try {
			conn = JdbcTools.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, username);
		    tr = stmt.executeQuery();
			if(tr.next()) {
				User user = new User();
				user.setUsername(tr.getString("username"));
				user.setEmail(tr.getString("email"));
				user.setId(tr.getInt("id"));
				user.setPasswod(tr.getString("password"));
				user.setInfo(tr.getString("info"));
				user.setPhone(tr.getString("phone"));
				user.setQq(tr.getString("qq"));
				return user;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTools.closeResource(conn, stmt, tr);
		}
		return null;
	}
	public void Register(User u) {
		// TODO Auto-generated method stub
		String sql = "insert into t_user(username,password,email,phone,qq,info)value(?,?,?,?,?,?) ";
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = JdbcTools.getConnection();
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, u.getUsername());
			stmt.setString(2, u.getPassword());
			stmt.setString(3, u.getEmail());
			stmt.setString(4, u.getPhone());
			stmt.setString(5, u.getQq());
			stmt.setString(6, u.getInfo());
			stmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTools.closeResource(conn, stmt, null);
		}
		
	}
	public List<User> findAlluser() {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet st = null;
		
		List<User> list = new ArrayList<>();
		String sql = "select * from t_user";
		try {
			conn = JdbcTools.getConnection();
			stmt = conn.prepareStatement(sql);
			st = stmt.executeQuery();
			while(st.next()) {
			      User user = new User();
			      user.setUsername(st.getString("username"));
			      user.setEmail(st.getString("email"));
			      user.setPhone(st.getString("phone"));
			      user.setPasswod(st.getString("password"));
			      user.setQq(st.getString("qq"));
			      user.setInfo(st.getString("info"));
			      list.add(user);
			}
			return list;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTools.closeResource(conn,stmt, st);
		}
		return null;
	}
	public void updateUserInformation(User user) {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet st = null;
		String sql = "Update t_uesr set username=?,password = ?,eamil = ?, phone = ?,qq = ?, info = ? where id =?";
		try {
			 conn = JdbcTools.getConnection();
			 stmt = conn.prepareStatement(sql);
			 stmt.setString(1, user.getUsername());
			 stmt.setString(2, user.getPassword());
			 stmt.setString(3, user.getEmail());
			 stmt.setString(4, user.getPhone());
			 stmt.setString(5, user.getQq());
			 stmt.setString(6, user.getInfo());
			 stmt.setInt(7, user.getId());
			 stmt.executeUpdate();	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcTools.closeResource(conn, stmt, st);
		}
	}

}

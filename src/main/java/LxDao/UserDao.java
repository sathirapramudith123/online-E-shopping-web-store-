package LxDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import LxModel.*;

public class UserDao {
	
	private Connection con;
	private String query;
	private PreparedStatement upst;
	private ResultSet urs;
	private boolean isSuccess;
	private Statement stmt;
	
	public UserDao(Connection con) {
		this.con = con;
	}
	
	public User userLogin(String uName, String uPassword) {
		User user = null;
		
		try {
			query = "select * from user where uName=? and uPassword=?";
			upst = this.con.prepareStatement(query);
			upst.setString(1, uName);
			upst.setString(2, uPassword);
			urs = upst.executeQuery();
			
			if(urs.next()) {
				user = new User();
				user.setUid(urs.getInt("uid"));
				user.setuName(urs.getString("uName"));
				user.setuAddress(urs.getString("uAddress"));
				user.setuEmail(urs.getString("uEmail"));
				user.setuPhone(urs.getString("uPhone"));
			}
		}catch(Exception e) {
			e.printStackTrace();
			System.out.print(e.getMessage());
		}
		return user;
	}
	
	public boolean insertUser(String uName, String uPassword, String uAddress ,String uEmail, String uPhone) {
		
		boolean isSuccess = false;
		
		try {
			query = "insert into user values (0, '"+uName+"', '"+uPassword+"', '"+uAddress+"', '"+uEmail+"', '"+uPhone+"')";
			upst = this.con.prepareStatement(query);
			int rs = upst.executeUpdate(query);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public boolean validate(String uName, String uPassword) {
		
		try {
			query = "select * from user where uName=? and uPassword=? ";
			stmt = this.con.createStatement();
			urs = stmt.executeQuery(query);
			
			if(urs.next()) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public List<User> getUser(String uName){
			
		ArrayList<User> usr = new ArrayList<>();
		
		try {
			query = "select * from user where uName = '"+uName+"' ";
			stmt = this.con.createStatement();
			urs = stmt.executeQuery(query);
			
			while(urs.next()) {
				User us = new User();
			
				
				us.setUid(urs.getInt("uid"));
				us.setuName(urs.getString("uName"));
				us.setuPassword(urs.getString("uPassword"));
				us.setuAddress(urs.getString("uAddress"));
				us.setuEmail(urs.getString("uEmail"));
				us.setuPhone(urs.getString("uPhone"));
				
				usr.add(us);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return usr;
	}
	
	public boolean updateUser(String uid, String uName, String uPassword, String uAddress, String uEmail,String uPhone) {
		try {
			query = "update user set uName = '"+uName+"', uPassword = '"+uPassword+"', uAddress = '"+uAddress+"', uEmail = '"+uEmail+"', uPhone = '"+uPhone+"' where uid = '"+uid+"'";
			stmt = this.con.createStatement();
			int rs = stmt.executeUpdate(query);
			
			if(rs > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	public List<User> getUserDetails(String uid){
		int convertedID = Integer.parseInt(uid);
		
		ArrayList<User>  usr = new ArrayList<>();
		
		try {

			query = "select *from user where uid='"+ convertedID+"'";
			stmt = this.con.createStatement();
			urs = stmt.executeQuery(query);
			
			while(urs.next()) {
				User u = new User();
				
				u.setUid(urs.getInt("uid"));
				u.setuName(urs.getString("uName"));
				u.setuPassword(urs.getString("uPassword"));
				u.setuAddress(urs.getString("uAddress"));
				u.setuEmail(urs.getString("uEmail"));
				u.setuPhone(urs.getString("uPhone"));
				
				usr.add(u);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return usr;
	}
	
	public boolean deleteUser(String uid) {
		
		int convID = Integer.parseInt(uid);
		
		try {
			
			query = "delete from user  where uid ='"+convID+"'";
			stmt = this.con.createStatement();
			int r = stmt.executeUpdate(query);
			
			if(r > 0) {
				isSuccess = true;
			}else {
				isSuccess = false;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return isSuccess;
		
		
	}
	
	


}

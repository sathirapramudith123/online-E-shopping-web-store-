package LxContact;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



import LxCon.DbCon;



public class ContactUsDBUtil {
	private static boolean isSuccess ;
	private static boolean isApprove ;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null ;
	
	//create a contact
	public static boolean addMessage(int uid ,String name,String email,String message) {
		isSuccess = false ;
		
		
		try {
			
			con = DbCon.getConnection();
			stmt = con.createStatement();
			String sql = "insert into contactus (idcontactus ,userID,Name,Email,Message) values (0 ,'"+uid+"' , '"+name+"' , '"+email+"' , '"+message+"')";
			int rs = stmt.executeUpdate(sql);
			
			if(rs  >  0) {
				isSuccess = true ;
			}else {
				isSuccess = false ;
			}
			
			
		}catch(Exception e) {  
			e.printStackTrace();
		}
		
		return isSuccess;
	}
	
	//get all contact
public static List<contact> getALLMsg(int uid){
		
		ArrayList<contact> list = new ArrayList<contact>();
		
		

		
		try {
			con = DbCon.getConnection();
			stmt = con.createStatement();
			String sql = "select * from contactus where userID = '"+uid+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int idcontactus = rs.getInt(1);
				int userID = rs.getInt(2);
				 String Name = rs.getString(3);
				 String Email = rs.getString(4);
				 String message= rs.getString(5);
				
				 
				
				 contact c = new contact(idcontactus,userID,Name,Email,message);
				
				
				list.add(c);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}


//delete contact
public static boolean DeleteContact(String id){
	
	
	try {
		
		con = DbCon.getConnection();
		stmt = con.createStatement();
		String sql = "delete from contactus where idcontactus = '"+id+"'";
		int rs = stmt.executeUpdate(sql);
		
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
	
//update and exciting message 
public static boolean updateContactUS(int Rid ,int uid ,String name,String email,String Msg) {
	isSuccess = false ;
	
	
	try {
		
		con = DbCon.getConnection();
		stmt = con.createStatement();
		String sql = "update contactus set Name = '"+name+"' , Email = '"+email+"'  , Message = '"+Msg+"'  where idcontactus = '"+Rid+"'";
		int rs = stmt.executeUpdate(sql);
		
		if(rs  >  0) {
			isSuccess = true ;
		}else {
			isSuccess = false ;
		}
		
		
	}catch(Exception e) {  
		e.printStackTrace();
	}
	
	return isSuccess;
}

}

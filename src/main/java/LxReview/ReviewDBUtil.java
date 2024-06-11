package LxReview;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import LxCon.DbCon;

public class ReviewDBUtil {
	
	private static boolean isSuccess ;
	private static boolean isApprove ;
	private static Connection con = null;
	private static Statement stmt = null;
	private static ResultSet rs = null ;
	
	//create new review
	public static boolean addReview(int uid ,String name,String email,int rating,String review) {
		isSuccess = false ;
		
		
		try {
			
			con = DbCon.getConnection();
			stmt = con.createStatement();
			String sql = "insert into review (Reviewid ,userID,Name,Email,Rating,Review) values (0 ,'"+uid+"' , '"+name+"' , '"+email+"' , '"+rating+"' , '"+review+"')";
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

	//get all review
public static List<Review> getALLReviews(int uid){
		
		ArrayList<Review> list = new ArrayList<Review>();
		
		

		
		try {
			con = DbCon.getConnection();
			stmt = con.createStatement();
			String sql = "select * from review where userID = '"+uid+"'";
			rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				int Reviewid = rs.getInt(1);
				int userID = rs.getInt(2);
				 String Name = rs.getString(3);
				 String Email = rs.getString(4);
				 int Rating = rs.getInt(5);
				 String Review= rs.getString(6);
				
				 
				
				 Review review = new Review(Reviewid,userID,Name,Email,Rating,Review);
				
				
				list.add(review);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

//delete a review
public static boolean DeleteReview(String id){
	
	
	try {
		
		con = DbCon.getConnection();
		stmt = con.createStatement();
		String sql = "delete from review where Reviewid = '"+id+"'";
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
public static boolean updateReview(int Rid ,int uid ,String name,String email,int rating,String review) {
	isSuccess = false ;
	
	
	try {
		
		con = DbCon.getConnection();
		stmt = con.createStatement();
		String sql = "update review set Name = '"+name+"' , Email = '"+email+"' , Rating = '"+rating+"' , Review = '"+review+"'  where Reviewid = '"+Rid+"'";
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

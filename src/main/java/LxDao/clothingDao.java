package LxDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;


import LxModel.*;

public class clothingDao {
	
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	private Statement stmt;
	private boolean isSuccess;
	
	public clothingDao(Connection con) {
		this.con = con;
	}
	
	public List<clothing> getAllclothings(){
		List<clothing> clothings = new ArrayList<clothing>();
		
		try {
			query = "select * from clothing";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				clothing row = new clothing();
				
				row.setCid(rs.getInt("cid"));
				row.setName(rs.getString("name"));
				row.setCategory(rs.getString("category"));
				row.setPrice(rs.getDouble("price"));
				row.setImage(rs.getNString("image"));	
				
				clothings.add(row);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return clothings;
	}
	
	public  clothing getSingleclothing(int cid) {
		clothing clo = null;
		
		try {
			query = "select * from clothing where cid=?";
			
			pst = this.con.prepareStatement(query);
			pst.setInt(1, cid);
			rs = pst.executeQuery();
			 
			 while (rs.next()) {
				 clo = new clothing();
				 
				 clo.setCid(rs.getInt("cid"));
				 clo.setName(rs.getString("name"));
				 clo.setCategory(rs.getString("category"));
				 clo.setPrice(rs.getDouble("price"));
				 clo.setImage(rs.getString("image"));
			 }
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return clo;
	}
	
	
	
	public List<Cart> getCartProducts(ArrayList<Cart> cartList){
		List<Cart> clothings = new ArrayList<Cart>();
		
		try {
			
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					query = "select * from clothing where cid=?";
					pst = this.con.prepareStatement(query);
					pst.setInt(1, item.getCid());
					rs = pst.executeQuery();
					while(rs.next()) {
						Cart row = new Cart();
						row.setCid(rs.getInt("cid"));
						row.setName(rs.getString("name"));
						row.setCategory(rs.getString("category"));
						row.setPrice(rs.getDouble("price")*item.getQuantity());
						row.setQuantity(item.getQuantity());
						
						clothings.add(row);
					}
				}
				
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
		
		return clothings;
	}
	
	
	
	public double getTotalCartPrice(ArrayList<Cart> cartList) {
		double sum = 0;
		
		try {
			
			if(cartList.size()> 0) {
				for(Cart item:cartList) {
					query = "select price from clothing where cid=? ";
					pst = this.con.prepareStatement(query);
					pst.setInt(1, item.getCid());
					rs = pst.executeQuery();
					
					while(rs.next()) {
						sum += rs.getDouble("price")*item.getQuantity();
						
					}
				}
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return sum;
	}
	
	
	//product insert
	public boolean insertProduct(String name,String category,String price,String image,String status,int Cquantity ) {
		boolean isSuccess = false;
		
		try {
			query = "insert into clothing values(0,'"+name+"','"+category+"','"+price+"','"+image+"','"+status+"','"+Cquantity+"')";
			stmt = this.con.createStatement();
			int rs = stmt.executeUpdate(query);
			
			if(rs > 0) {
				isSuccess  = true;
			}else {
				isSuccess = false;
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return isSuccess;
	}
	
	//validate products
	public List<clothing> validate(String name){
		ArrayList<clothing> clo = new ArrayList<>();
		
		try {
			query = "select * from clothing where name='"+name+"'";
			stmt = this.con.createStatement();
			rs = stmt.executeQuery(query);
			
			if(rs.next()) {
				clothing dress = new clothing();
				dress.setCid(rs.getInt("cid"));
				dress.setName(rs.getString("name"));
				dress.setCategory(rs.getString("category"));
				dress.setPrice(rs.getDouble("price"));
				dress.setImage(rs.getString("image"));
				dress.setStatus(rs.getString("status"));
				dress.setcQuantity(rs.getString("Cquantity"));
				
				clo.add(dress);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return clo;
	}
	
	
	//update products
	public boolean updateProduct(String cid, String name, String category, String price,String image,String status, String Cquantity ) {
		
		 try {
			 query = "update clothing set name='"+name+"', category='"+category+"', price='"+price+"', image='"+image+"', status='"+status+"', Cquantity='"+Cquantity+"' where cid='"+cid+"'" ;
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
	
	public List<clothing>  getClothingDetails(String cid){
		
		int convertID = Integer.parseInt(cid);
		
		ArrayList<clothing> clo = new ArrayList<>();
		
		try {
			
			query = "select *from clothing where cid='"+convertID+"'";
			stmt = this.con.createStatement();
			rs = stmt.executeQuery(query);
			
			while(rs.next()) {
				clothing ca = new clothing();
				
				ca.setCid(rs.getInt("cid"));
				ca.setName(rs.getString("name"));
				ca.setCategory(rs.getString("category"));
				ca.setPrice(rs.getDouble("price"));
				ca.setImage(rs.getString("image"));
				ca.setStatus(rs.getString("status"));
				ca.setcQuantity(rs.getString("Cquantity"));
				
				clo.add(ca);
				
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return clo;
		
	}
	
	
	//delete product
	public boolean deleteProduct(String cid) {
		int convertID = Integer.parseInt(cid);
		
		try {
			
			query = "delete from clothing  where cid ='"+convertID+"'";
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

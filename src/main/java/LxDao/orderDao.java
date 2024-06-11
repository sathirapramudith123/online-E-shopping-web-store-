package LxDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import LxModel.*;

public class orderDao {
	
	private Connection con;
	private String query;
	private PreparedStatement opst;
	private ResultSet ors;
	
	public orderDao(Connection con) {
		this.con = con;
	}
	
	public boolean insertOrder(Order part) {
		boolean result = false;
		
		try {
			query = "insert into orders (c_id, u_id, oQuantity, oDate) values(?,?,?,?)";
			opst = this.con.prepareStatement(query);
			opst.setInt(1, part.getCid());
			opst.setInt(2, part.getU_id());
			opst.setInt(3, part.getoQuantity());
			opst.setString(4, part.getoDate());
			opst.executeUpdate();
			result = true;
		}catch(Exception e) {
			e.printStackTrace();
			
		}
		return result;
		
	}
	
	public List<Order> userOrders(int uid){
		List<Order> list = new ArrayList<>();
		try {
			
			query = "select *from orders where u_id=? order by orders.oid desc";
			opst = this.con.prepareStatement(query);
			opst.setInt(1, uid);
			
			ors = opst.executeQuery();
			
			while(ors.next()) {
				Order order = new Order();
				
				clothingDao cdao = new clothingDao(this.con);
				
				int pId = ors.getInt("c_id");
				
				clothing  cloth = cdao.getSingleclothing(pId);
				
				order.setOid(ors.getInt("oid"));
				order.setCid(pId);
				order.setName(cloth.getName());
				order.setCategory(cloth.getCategory());
				order.setPrice(cloth.getPrice()*ors.getInt("oQuantity"));
				order.setoQuantity(ors.getInt("oQuantity"));
				order.setoDate(ors.getString("oDate"));
				
				list.add(order);
			}
			
		}catch(Exception e) {
			 e.printStackTrace();
	         System.out.println(e.getMessage());
		}
		return list;
	}
	
	public void canceOrder(int cid) {
		
		try {
			query = "delete from orders where oid='"+cid+"' ";
			opst = this.con.prepareStatement(query);
			opst.executeUpdate(query);
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	


	
	

}

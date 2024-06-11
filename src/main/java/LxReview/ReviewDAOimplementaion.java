package LxReview;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import LxCon.DbCon;

public class ReviewDAOimplementaion implements ReviewDAO {
	
    private Connection con;
	private static boolean isSuccess ;
	private static Statement stmt = null;
	private static ResultSet rs = null ;
	
	public ReviewDAOimplementaion(Connection conn) {
		super();
		this.con = conn ;
	}

	@Override
	public List<Review> getAllEvents() {
		ArrayList<Review> list = new ArrayList<Review>();
		Review p = null;
		
	
		
		try {
			con = DbCon.getConnection();
			stmt = con.createStatement();
			String sql = "select * from review order by Reviewid desc ";
			rs = stmt.executeQuery(sql);
			int i = 1 ;
			
			while(rs.next() && i<= 3) {
				p = new Review();
				
				
				
				p.setReviewid(rs.getInt(1));
				p.setUserId(rs.getInt(2));
				p.setName(rs.getString(3));
				 p.setEmail(rs.getString(4));
				p.setRating(rs.getInt(5));
				p.setReview(rs.getString(6));
				
				i++;
				
				list.add(p);
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}

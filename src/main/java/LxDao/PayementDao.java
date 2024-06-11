package LxDao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import LxCon.DbCon;


public class PayementDao {
	
	private static Connection con;
	private static ResultSet prs;
	private static Statement pstmt;
	private  static boolean isSuccess;
	
	
	public static boolean addPayement(String name,String email, String address,String city, String country, int zip, String card , String number, String exp , int year, int cvv) {
		isSuccess = false;
		
		try {
			con = DbCon.getConnection();
			pstmt = con.createStatement();
			String query = "insert into payement (pid , pname, pemail, paddress, pcity, pcountry, pzip, pcard, pnumber, pexp, pyear, pcvv) values (0 , '"+name+"', '"+email+"', '"+address+"', '"+city+"', '"+country+"', '"+zip+"', '"+card+"', '"+number+"', '"+exp+"', '"+year+"', '"+cvv+"')";
			int rs = pstmt.executeUpdate(query);
			
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
	

	
	
	

}

package LxModel;

public class Order extends clothing {
	
	private int oid;
	private int u_id;
	private int oQuantity;
	private String oDate;
	
	
	public Order() {
		
	}


	public Order(int oid, int u_id, int oQuantity, String oDate) {
	
		this.oid = oid;
		this.u_id = u_id;
		this.oQuantity = oQuantity;
		this.oDate = oDate;
	}


	public int getOid() {
		return oid;
	}


	public void setOid(int oid) {
		this.oid = oid;
	}


	public int getU_id() {
		return u_id;
	}


	public void setU_id(int u_id) {
		this.u_id = u_id;
	}


	public int getoQuantity() {
		return oQuantity;
	}


	public void setoQuantity(int oQuantity) {
		this.oQuantity = oQuantity;
	}


	public String getoDate() {
		return oDate;
	}


	public void setoDate(String oDate) {
		this.oDate = oDate;
	}


	@Override
	public String toString() {
		return "Order [oid=" + oid + ", u_id=" + u_id + ", oQuantity=" + oQuantity + ", oDate=" + oDate + "]";
	}
	
	
	
	
	

}

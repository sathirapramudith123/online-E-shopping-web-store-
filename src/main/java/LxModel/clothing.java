package LxModel;

public class clothing  {
	
	private int cid;
	private String name;
	private String category;
	private double price;
	private String image;
	private String status;
	private String Cquantity;
	
	public clothing() {
		
	}

	public clothing(int cid, String name, String category, double price, String image, String status, String Cquantity) {
		this.cid = cid;
		this.name = name;
		this.category = category;
		this.price = price;
		this.image = image;
		this.status = status;
		this.Cquantity = Cquantity;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public String getcQuantity() {
		return Cquantity;
	}

	public void setcQuantity(String Cquantity) {
		this.Cquantity = Cquantity;
	}

	@Override
	public String toString() {
		return "clothing [cid=" + cid + ", name=" + name + ", category=" + category + ", price=" + price + ", image="
				+ image + ", status=" + status + ", Cquantity=" + Cquantity + "]";
	}

	

	
	
	
	
	
	

}

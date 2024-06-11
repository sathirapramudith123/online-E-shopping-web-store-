package LxModel;

public class User {
	
	private int uid;
	private String uName;
	private String uPassword;
	private String uAddress;
	private String uEmail;
	private String uPhone;
	
	public User() {
		
	}

	public User(int uid, String uName,String uPassword, String uAddress, String uEmail, String uPhone) {
	
		this.uid = uid;
		this.uName = uName;
		this.uPassword = uPassword;
		this.uAddress = uAddress;
		this.uEmail = uEmail;
		this.uPhone = uPhone;
	}

	public int getuid() {
		return uid;
	}

	public void setUid(int uid) {
		this.uid = uid;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuPassword() {
		return uPassword;
	}

	public void setuPassword(String uPassword) {
		this.uPassword = uPassword;
	}

	public String getuAddress() {
		return uAddress;
	}

	public void setuAddress(String uAddress) {
		this.uAddress = uAddress;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}

	public String getuPhone() {
		return uPhone;
	}

	public void setuPhone(String uPhone) {
		this.uPhone = uPhone;
	}

	@Override
	public String toString() {
		return "User [uid=" + uid + ", uName=" + uName + ", uPassword=" + uPassword + ", uAddress=" + uAddress
				+ ", uEmail=" + uEmail + ", uPhone=" + uPhone + "]";
	}

	
	
	
	
	
	
	

}

package LxContact;

public class contact {
	
	private int idcontactus;
	private int userId;
	private String Name;
	private String Email;
	private String Message;
	
	public contact() {
		
	}
	
	

	public contact(int idcontactus, int userId, String name, String email, String message) {
		super();
		this.idcontactus = idcontactus;
		this.userId = userId;
		Name = name;
		Email = email;
		Message = message;
	}



	public int getIdcontactus() {
		return idcontactus;
	}

	public void setIdcontactus(int idcontactus) {
		this.idcontactus = idcontactus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMessage() {
		return Message;
	}

	public void setMessage(String message) {
		Message = message;
	}
	
	

}

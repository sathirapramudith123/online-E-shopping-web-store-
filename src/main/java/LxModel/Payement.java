package LxModel;

public class Payement  {
	
	private int pid;
	private String pname;
	private String pemail;
	private String paddress;
	private String pcity;
	private String pcountry;
	private int pzip;
	private String pcard;
	private String pnumber;
	private String pexp;
	private int pyear;
	private int pcvv;
	
	
	public Payement() {
		
	}


	public Payement(int pid,  String pname, String pemail, String paddress, String pcity, String pcountry,
			int pzip, String pcard, String pnumber, String pexp, int pyear, int pcvv) {
		super();
		
		this.pid = pid;
		this.pname = pname;
		this.pemail = pemail;
		this.paddress = paddress;
		this.pcity = pcity;
		this.pcountry = pcountry;
		this.pzip = pzip;
		this.pcard = pcard;
		this.pnumber = pnumber;
		this.pexp = pexp;
		this.pyear = pyear;
		this.pcvv = pcvv;
	}


	public int getPid() {
		return pid;
	}


	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}


	public void setPname(String pname) {
		this.pname = pname;
	}


	public String getPemail() {
		return pemail;
	}


	public void setPemail(String pemail) {
		this.pemail = pemail;
	}


	public String getPaddress() {
		return paddress;
	}


	public void setPaddress(String paddress) {
		this.paddress = paddress;
	}


	public String getPcity() {
		return pcity;
	}


	public void setPcity(String pcity) {
		this.pcity = pcity;
	}


	public String getPcountry() {
		return pcountry;
	}


	public void setPcountry(String pcountry) {
		this.pcountry = pcountry;
	}


	public int getPzip() {
		return pzip;
	}


	public void setPzip(int pzip) {
		this.pzip = pzip;
	}


	public String getPcard() {
		return pcard;
	}


	public void setPcard(String pcard) {
		this.pcard = pcard;
	}


	public String getPnumber() {
		return pnumber;
	}


	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}


	public String getPexp() {
		return pexp;
	}


	public void setPexp(String pexp) {
		this.pexp = pexp;
	}


	public int getPyear() {
		return pyear;
	}


	public void setPyear(int pyear) {
		this.pyear = pyear;
	}


	public int getPcvv() {
		return pcvv;
	}


	public void setPcvv(int pcvv) {
		this.pcvv = pcvv;
	}






	
	
	
	
	

}

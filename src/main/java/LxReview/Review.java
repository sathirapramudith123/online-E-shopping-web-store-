package LxReview;

public class Review {
	
	private int Reviewid;
	private int userId;
	private String Name;
	private String Email;
	private int Rating;
	private String Review;
	
	public Review() {
		
	}
	
	
	
	public Review(int reviewid, int userId, String name, String email, int rating, String review) {
		super();
		Reviewid = reviewid;
		this.userId = userId;
		Name = name;
		Email = email;
		Rating = rating;
		Review = review;
	}
	
	public int getReviewid() {
		return Reviewid;
	}
	public void setReviewid(int reviewid) {
		Reviewid = reviewid;
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
	public int getRating() {
		return Rating;
	}
	public void setRating(int rating) {
		Rating = rating;
	}
	public String getReview() {
		return Review;
	}
	public void setReview(String review) {
		Review = review;
	}

}

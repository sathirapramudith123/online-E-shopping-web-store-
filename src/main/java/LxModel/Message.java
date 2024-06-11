package LxModel;

public class Message {
    private int id;
    private String name;
    private String email;
    private String message;
    private int userId;

    // Default constructor
    public Message() {
    }

    // Constructor with all fields
    public Message(int id, String name, String email, String message, int userId) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.message = message;
        this.userId = userId;
    }

    // Getters and setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", userId=" + userId +
                '}';
    }
}

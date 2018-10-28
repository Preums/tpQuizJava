package login;

public class User {
	
	int id;
	private String firstname;
	private String lastname;
	private String function = "guest";
	private String email;
	private String userMessage;
	
	public User() {
	}
	public User(int id, String firstname, String lastname, String function, String userMessage) {
		super();
		this.id = id;
		this.firstname = firstname;
		this.lastname = lastname;
		this.function = function;
	}
	public int getId() {
		return id;
	}
	public String getFirstname() {
		return firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public String getFunction() {
		return function;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public void setFunction(String function) {
		this.function = function;
	}
	public String getUserMessage() {
		return userMessage;
	}
	public void setUserMessage(String userMessage) {
		this.userMessage = userMessage;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
}

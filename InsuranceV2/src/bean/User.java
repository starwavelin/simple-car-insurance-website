package bean;

public class User {
	
	private String username;
	private String password;
	private boolean flag;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void setValid(boolean flag) {
		this.flag = flag;
	}
	public boolean isValid() {
		return flag;
	}
	
}

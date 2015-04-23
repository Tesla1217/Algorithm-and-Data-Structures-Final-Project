import java.util.Scanner;


public class User {
	
	String username;
	String password;
	String email;
	
	public User(String u, String p, String e) {
		username = u;
		password = p;
		email = e;
		
	}
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void printInfo(){
		System.out.println(username + " " + password + " " + email);
	}	
}

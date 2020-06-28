package dongduk.cs.ssd.controller.user;

//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;

public class LoginForm { //command class

//	@NotBlank @Email
	private String email;
//	@NotBlank
	private String password;

	public LoginForm() {
		
	}

	public LoginForm(String email, String password) {
		this.email = email;
		this.password = password;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginForm [email=" + email + ", password=" + password + "]";
	}
}


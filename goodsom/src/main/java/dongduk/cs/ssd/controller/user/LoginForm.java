package dongduk.cs.ssd.controller.user;

//import javax.validation.constraints.Email;
//import javax.validation.constraints.NotBlank;

public class LoginForm {

//	@NotBlank @Email
	private String id;
//	@NotBlank
	private String password;

	public LoginForm() {
		
	}

	public LoginForm(String id, String password) {
		this.id = id;
		this.password = password;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}


package BDJTBack;

public class UsersDO {
	private String id;
	private String name;
	private String password;
	private String confirm;
	private String birthdate;
	private String github;

	public UsersDO() {
		// TODO Auto-generated constructor stub
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getConfirm() {
		return password;
	}
	public void setConfirm(String confirm) {
		this.confirm = confirm;
	}
	public String getPassword() {
		return confirm;
	}
	public void setPassword(String confirm) {
		this.confirm = confirm;
	}
	public String getBirthdate() {
		return birthdate;
	}
	public void setBirthdate(String birthdate) {
		this.birthdate = birthdate;
	}
	public String getGithub() {
		return github;
	}
	public void setGithub(String github) {
		this.github = github;
	}
}

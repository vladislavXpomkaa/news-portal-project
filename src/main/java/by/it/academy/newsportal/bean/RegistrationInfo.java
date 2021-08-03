package by.it.academy.newsportal.bean;

import jakarta.servlet.http.HttpServletRequest;

public class RegistrationInfo {
	private String name;
	private int age;
	private String surname;
	private String email;
	private	String role;
	private String login;
	private String password;

	
	public RegistrationInfo(HttpServletRequest request) {
		this.login = request.getParameter("login");
		this.password = request.getParameter("password");
		this.role = request.getParameter("role");
		this.name = request.getParameter("name");
		this.email = request.getParameter("email");
		this.surname = request.getParameter("surname");
		this.age = Integer.parseInt(request.getParameter("age"));
	}

	public String getRole() {
		return role;
	}

	public String getLogin() {
		return login;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getEmail() {
		return email;
	}
	
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RegistrationInfo [name=");
		builder.append(name);
		builder.append(", surname=");
		builder.append(surname);
		builder.append(", email=");
		builder.append(email);
		builder.append(", role=");
		builder.append(role);
		builder.append(", login=");
		builder.append(login);
		builder.append(", password=");
		builder.append(password);
		builder.append("]");
		return builder.toString();
	}

	

}

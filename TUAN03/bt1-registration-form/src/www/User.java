package www;

import java.util.List;
import java.util.Vector;

public class User {
	private String firstName;
	private String lastName;
	private String email;
	private String pnumber;
	private String address;
	private List<String> hobbies = new Vector<String>();
	private String course;

	public User() {
		super();
	}

	public User(String firstName, String lastName, String email, String pnumber, String address, List<String> hobbies,
			String course) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.pnumber = pnumber;
		this.address = address;
		this.hobbies = hobbies;
		this.course = course;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPnumber() {
		return pnumber;
	}

	public void setPnumber(String pnumber) {
		this.pnumber = pnumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<String> getHobbies() {
		return hobbies;
	}

	public void setHobbies(List<String> hobbies) {
		this.hobbies = hobbies;
	}

	public String getCourse() {
		return course;
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String showHobbies() {
		StringBuilder sb = new StringBuilder();
		for (String hb : this.hobbies) {
			sb.append(hb + ",");
		}
		return sb.toString();

	}
}

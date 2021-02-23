package gr.hua.katanemimena.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Entity
@Table (name = "myusers")
public class MyUsers {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "username")
    private String username;
	
	@Column(name = "password")
    private String password;

	@Column(name = "firstname")
	private String firstName;
	
	@Column(name = "lastname")
	private String lastName;

	@Column(name = "email")
	private String email;

	@Column(name = "authority")
    private String authority;
	
	@Column(name = "enabled")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean enabled;

	public MyUsers(String username, String password, String firstName, String lastName, String email, String authority,
			boolean enabled) {
		super();
		this.username = username;
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		this.password = encoder.encode(password);
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.authority = authority;
		this.enabled = enabled;
	}	
	
	public MyUsers() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		this.password = encoder.encode(password);
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

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	@Override
	public String toString() {
		return "MyUsers [id=" + id + ", username=" + username + ", password=" + password + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", email=" + email + ", authority=" + authority + ", enabled=" + enabled
				+ "]";
	}	
	
	@OneToMany(mappedBy="dhmotisID",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                                   CascadeType.DETACH, CascadeType.REFRESH})
	private List<Application> applications;

	public List<Application> getApplications() {
		return applications;
	}

	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

	public void addApplication(Application aapplication) {
	     if(applications == null) {
	    	 applications = new ArrayList<>();
	     }
	     applications.add(aapplication);
	     aapplication.setDhmotisID(this);
	}
	
	
	
	
}

package gr.hua.katanemimena.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table (name = "students")
public class Students {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "firstname")
    private String firstname;
	
	@Column(name = "lastname")
    private String lastname;

	@Column(name = "parent1")
    private String parent1;
	
	@Column(name = "parent2")
    private String parent2;
	
	@Column(name = "contactinfo")
    private String contactinfo;
	
	@Column(name = "age")
    private int age;
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH},fetch = FetchType.EAGER)
	@JoinColumn(name="class_id")
	private Classes classID;

	public Students(String firstname, String lastname, String parent1, String parent2, String contactinfo, int age, Classes classID) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.parent1 = parent1;
		this.parent2 = parent2;
		this.contactinfo = contactinfo;
		this.age = age;
		this.classID = classID;
	}
	
	public Students() {}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getParent1() {
		return parent1;
	}

	public void setParent1(String parent1) {
		this.parent1 = parent1;
	}
	
	public String getParent2() {
		return parent2;
	}

	public void setParent2(String parent2) {
		this.parent2 = parent2;
	}

	public String getContactinfo() {
		return contactinfo;
	}

	public void setContactinfo(String contactinfo) {
		this.contactinfo = contactinfo;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Classes getClassID() {
		return classID;
	}

	public void setClassID(Classes classID) {
		this.classID = classID;
	}

	@Override
	public String toString() {
		return "Students [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", parent1=" + parent1
				+ ", parent2=" + parent2 + ", contactinfo=" + contactinfo + ", age=" + age + ", classID=" + classID
				+ "]";
	}
	
	
}




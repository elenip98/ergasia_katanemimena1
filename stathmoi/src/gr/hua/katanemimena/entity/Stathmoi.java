package gr.hua.katanemimena.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;


@Entity
@Table (name = "stathmoi")
public class Stathmoi {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
    private String name;
	

	@Column(name = "capacity")
    private int capacity;
	

	@Column(name = "address")
    private String address;
	

	@Column(name = "phone")
    private int phone;
	

	@Column(name = "info")
    private String info;

	@Column(name = "enabled")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private boolean enabled;
	
	
	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinColumn(name="diefthidis_id")
	private MyUsers diefthidisID;


	public Stathmoi(String name, int capacity, String address, int phone, String info, boolean enabled,
			MyUsers diefthidisID) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.address = address;
		this.phone = phone;
		this.info = info;
		this.enabled = enabled;
		this.diefthidisID = diefthidisID;
	}
	
	
	public Stathmoi() {}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCapacity() {
		return capacity;
	}


	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public void setCapacity(String capacity) {
		this.capacity = Integer.parseInt(capacity);
	}

	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public int getPhone() {
		return phone;
	}


	public void setPhone(int phone) {
		this.phone = phone;
	}

	public void setPhone(String phone) {
		this.phone = Integer.parseInt(phone);
	}
	
	public String getInfo() {
		return info;
	}


	public void setInfo(String info) {
		this.info = info;
	}


	public boolean isEnabled() {
		return enabled;
	}


	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}


	public MyUsers getDiefthidisID() {
		return diefthidisID;
	}


	public void setDiefthidisID(MyUsers diefthidisID) {
		this.diefthidisID = diefthidisID;
	}


	@Override
	public String toString() {
		return "Stathmoi [id=" + id + ", name=" + name + ", capacity=" + capacity + ", address=" + address + ", phone="
				+ phone + ", info=" + info + ", enabled=" + enabled + ", diefthidisID=" + diefthidisID.getId() + "]";
	}
	
	@OneToMany(mappedBy="stathmosID",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                                   CascadeType.DETACH, CascadeType.REFRESH})
	private List<Classes> classes;


	public List<Classes> getClasses() {
		return classes;
	}


	public void setClasses(List<Classes> classes) {
		this.classes = classes;
	}
	
	
	public void addClasses(Classes aclass) {
	     if(classes == null) {
	    	 classes = new ArrayList<>();
	     }
	     classes.add(aclass);
	     aclass.setStathmosID(this);
	}
	

	@ManyToMany(fetch=FetchType.LAZY,
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                              CascadeType.DETACH, CascadeType.REFRESH})        
	@JoinTable(
	    name="stathmoi_applications",
	    joinColumns=@JoinColumn(name="stathmos_id"),
	    inverseJoinColumns=@JoinColumn(name="application_id"))
		private List<Application> applications;


	public List<Application> getApplications() {
		return applications;
	}


	public void setApplications(List<Application> applications) {
		this.applications = applications;
	}

		
	public void addApplication(Application application) {
        if (applications == null) {
        	applications = new ArrayList<Application>();
        }
        applications.add(application);
}
	
	
}

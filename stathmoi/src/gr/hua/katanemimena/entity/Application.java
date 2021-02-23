package gr.hua.katanemimena.entity;

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
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "application")
public class Application {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "finace")
	private String finace;

	@Column(name = "socailinfo")
	private String socailinfo;

	@Column(name = "extrainfo")
	private String extrainfo;

	@Column(name = "status")
	private String status;

	@OneToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "student_id")
	private Students studentID;

	@ManyToOne(cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "dhmotis_id")
	private MyUsers dhmotisID;

	public Application() {
	}

	public Application(String finace, String socailinfo, String extrainfo, String status, Students studentID,
			MyUsers dhmotisID) {
		super();
		this.finace = finace;
		this.socailinfo = socailinfo;
		this.extrainfo = extrainfo;
		this.status = status;
		this.studentID = studentID;
		this.dhmotisID = dhmotisID;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFinace() {
		return finace;
	}

	public void setFinace(String finace) {
		this.finace = finace;
	}

	public String getSocailinfo() {
		return socailinfo;
	}

	public void setSocailinfo(String socailinfo) {
		this.socailinfo = socailinfo;
	}

	public String getExtrainfo() {
		return extrainfo;
	}

	public void setExtrainfo(String extrainfo) {
		this.extrainfo = extrainfo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Students getStudentID() {
		return studentID;
	}

	public void setStudentID(Students studentID) {
		this.studentID = studentID;
	}

	public MyUsers getDhmotisID() {
		return dhmotisID;
	}

	public void setDhmotisID(MyUsers dhmotisID) {
		this.dhmotisID = dhmotisID;
	}

	@ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH,
			CascadeType.REFRESH })
	@JoinTable(name = "stathmoi_applications", joinColumns = @JoinColumn(name = "stathmos_id"), inverseJoinColumns = @JoinColumn(name = "application_id"))
	private List<Stathmoi> stathmoi;

	public List<Stathmoi> getStathmoi() {
		return stathmoi;
	}

	public void setStathmoi(List<Stathmoi> stathmoi) {
		this.stathmoi = stathmoi;
	}

}

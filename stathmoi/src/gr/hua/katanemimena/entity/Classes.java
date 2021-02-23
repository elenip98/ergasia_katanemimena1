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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "classes")
public class Classes {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
    private String name;

	@OneToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinColumn(name="teacher_id")
	private MyUsers teacherID;

	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH}, fetch = FetchType.EAGER)
	@JoinColumn(name="stathmos_id")
	private Stathmoi stathmosID;
	
	public Classes() {}
	
	public Classes(String name, MyUsers teacherID, Stathmoi stathmosID) {
		super();
		this.name = name;
		this.teacherID = teacherID;
		this.stathmosID = stathmosID;
	}

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

	public MyUsers getTeacherID() {
		return teacherID;
	}

	public void setTeacherID(MyUsers teacherID) {
		this.teacherID = teacherID;
	}

	public Stathmoi getStathmosID() {
		return stathmosID;
	}

	public void setStathmosID(Stathmoi stathmosID) {
		this.stathmosID = stathmosID;
	}
	
	@OneToMany(mappedBy="classID",
            cascade= {CascadeType.PERSIST, CascadeType.MERGE,
                                   CascadeType.DETACH, CascadeType.REFRESH})
	private List<Students> students;

	
	public List<Students> getStudents() {
		return students;
	}

	public void setStudents(List<Students> students) {
		this.students = students;
	}

	public void addStudent(Students astudent) {
	     if(students == null) {
	    	 students = new ArrayList<>();
	     }
	     students.add(astudent);
	     astudent.setClassID(this);
	}

	@Override
	public String toString() {
		return "Classes [id=" + id + ", name=" + name + ", teacherID=" + teacherID + ", stathmosID=" + stathmosID
				+ ", students=" + students + "]";
	}		
	
	
}


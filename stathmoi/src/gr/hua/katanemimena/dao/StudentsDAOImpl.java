package gr.hua.katanemimena.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import gr.hua.katanemimena.entity.Application;
import gr.hua.katanemimena.entity.Classes;
import gr.hua.katanemimena.entity.MyUsers;
import gr.hua.katanemimena.entity.Stathmoi;
import gr.hua.katanemimena.entity.Students;
import gr.hua.katanemimena.forms.StudentForm;

@Repository
public class StudentsDAOImpl implements StudentsDAO{

	@Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
	public List<Students> getStudents() {
    	 Session currentSession = sessionFactory.getCurrentSession();
         
         Query<Students> query = currentSession.createQuery("from Students", Students.class);
         List<Students> students = query.getResultList();
                         
         return students;
	}

	@Override
    @Transactional
	public Students getStudentByID(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
    	
		Students student = currentSession.get(Students.class, id);
		return student;
	}

	@Override
    @Transactional
	public Students createStudent(StudentForm studentForm) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(MyUsers.class).addAnnotatedClass(Classes.class).addAnnotatedClass(Stathmoi.class).addAnnotatedClass(Students.class).addAnnotatedClass(Application.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();
		

		Classes myClass = session.get(Classes.class, studentForm.getClassID());
		

		Students student = studentForm.getStudent();

		student.setClassID(myClass);
		
		myClass.addStudent(student);

		session.save(student);
		session.getTransaction().commit();
		
		factory.close();
    	
    	return student;
	}
	
	@Override
    @Transactional
	public Students createStudent(Students student) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(MyUsers.class).addAnnotatedClass(Classes.class).addAnnotatedClass(Stathmoi.class).addAnnotatedClass(Students.class).addAnnotatedClass(Application.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		session.save(student);
		session.getTransaction().commit();
		
		factory.close();
    	
    	return student;
	}


	@Override
    @Transactional
	public Students updateStudent(Students student) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(MyUsers.class).addAnnotatedClass(Classes.class).addAnnotatedClass(Stathmoi.class).addAnnotatedClass(Students.class).addAnnotatedClass(Application.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();
				
		student = (Students) session.merge(student);
		
		session.getTransaction().commit();
		
		factory.close();
		
		return student;
		
	}
	

	@Override
    @Transactional
	public List<Students> getStudentsByClassID(int id){
		
		
Session currentSession = sessionFactory.getCurrentSession();
    	
    	String hql = "from Students as c where c.classID.id = :keyword";
    	@SuppressWarnings({ "unchecked" })
		Query<Students> query = currentSession.createQuery(hql);
		query.setParameter("keyword",  id );
    	
		List<Students> students = query.list();
		
	
    	return students;
	}
	

	@Override
    @Transactional
	public List<Students> getStudentsByName(String name){
		
		Session currentSession = sessionFactory.getCurrentSession();
    	
    	String hql = "from Students where firstname like :keyword or lastname like :keywordtwo";
    	@SuppressWarnings({ "unchecked" })
		Query<Students> query = currentSession.createQuery(hql);
		query.setParameter("keyword",  "%" +name+"%" );
		query.setParameter("keywordtwo",  "%" +name+"%" );
    	
		List<Students> students = query.list();
		
	
    	return students;
	}
	
}

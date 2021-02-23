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
import gr.hua.katanemimena.forms.ClassForm;

@Repository
public class ClassesDAOImpl implements ClassesDAO{

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Classes> getClasses() {
		Session currentSession = sessionFactory.getCurrentSession();
        
        Query<Classes> query = currentSession.createQuery("from Classes", Classes.class);
        List<Classes> classes = query.getResultList();
                        
        return classes;
	}

	@Override
	@Transactional
	public Classes getClassByID(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
    	
		Classes myClass = currentSession.get(Classes.class, id);
		return myClass;
	}

	@Override
	@Transactional
	public Classes createClass(ClassForm classForm) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(MyUsers.class).addAnnotatedClass(Classes.class).addAnnotatedClass(Stathmoi.class).addAnnotatedClass(Students.class).addAnnotatedClass(Application.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();
		

		MyUsers teacher = session.get(MyUsers.class, classForm.getTeacherID());
		Stathmoi stathmos = session.get(Stathmoi.class, classForm.getStathmosID());
		

		Classes myClass = classForm.getMyClass();

		myClass.setTeacherID(teacher);
		myClass.setStathmosID(stathmos);
		
		stathmos.addClasses(myClass);
		
		
		session.save(myClass);
		session.getTransaction().commit();
		
		factory.close();
    	
    	return myClass;
	}
	
	@Override
	@Transactional
	public Classes updateClass(Classes myClass) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(MyUsers.class).addAnnotatedClass(Classes.class).addAnnotatedClass(Stathmoi.class).addAnnotatedClass(Students.class).addAnnotatedClass(Application.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();
				
		myClass = (Classes) session.merge(myClass);
		
		session.getTransaction().commit();
		
		factory.close();
		
		return myClass;
	}
	

	@Override
	@Transactional
	public List<Classes> getClassesByTeacherID(int id){
    	
    	Session currentSession = sessionFactory.getCurrentSession();
    	
    	String hql = "from Classes as c where c.teacherID.id = :keyword";
    	@SuppressWarnings({ "unchecked" })
		Query<Classes> query = currentSession.createQuery(hql);
		query.setParameter("keyword",  id );
    	
		List<Classes> classes = query.list();
		
	
    	return classes;
    }
	

	@Override
	@Transactional
	public List<Classes> getClassesByName(String name){
		
Session currentSession = sessionFactory.getCurrentSession();
    	
    	String hql = "from Classes where name like :keyword";
    	@SuppressWarnings({ "unchecked" })
		Query<Classes> query = currentSession.createQuery(hql);
		query.setParameter("keyword",  "%" +name+"%" );
    	
		List<Classes> classes = query.list();
		
	
    	return classes;
		
		
	}
	
}

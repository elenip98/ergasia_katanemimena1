package gr.hua.katanemimena.dao;

import java.util.ArrayList;
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
import gr.hua.katanemimena.forms.ApplicationForm;

@Repository
public class ApplicationDAOImpl implements ApplicationDAO {
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	@Transactional
	public List<Application> getApplications() {
		Session currentSession = sessionFactory.getCurrentSession();
        
        Query<Application> query = currentSession.createQuery("from Application", Application.class);
        List<Application> application = query.getResultList();
                        
        return application;
	}

	@Override
	@Transactional
	public Application getApplicationByID(int id) {
		Session currentSession = sessionFactory.getCurrentSession();
    	
		Application application = currentSession.get(Application.class, id);
		return application;
	}

	@Override
	@Transactional
	public Application createApplication(Application application) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(MyUsers.class).addAnnotatedClass(Classes.class).addAnnotatedClass(Stathmoi.class).addAnnotatedClass(Students.class).addAnnotatedClass(Application.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();

		session.save(application);
		session.getTransaction().commit();
		
		factory.close();
    	
    	return application;
	}

	@Override
	@Transactional
	public List<Application> getApplicationByStatus(String status){
		
		Session currentSession = sessionFactory.getCurrentSession();
    	
		String hql = "from Application where status like :keyword";
		
		@SuppressWarnings({ "unchecked" })
		Query<Application> query = currentSession.createQuery(hql);
		query.setParameter("keyword",  "%" + status + "%");

		//Execute query
		List<Application> applications = query.list();
    	
    	return applications;		
		
	}

	@Override
	@Transactional
	public Application updateApplication(Application application) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(MyUsers.class).addAnnotatedClass(Classes.class).addAnnotatedClass(Stathmoi.class).addAnnotatedClass(Students.class).addAnnotatedClass(Application.class).buildSessionFactory();

		Session session = factory.getCurrentSession();

		session.beginTransaction();
		
		application = (Application) session.merge(application);
		
		session.getTransaction().commit();
		
		factory.close();
	
		return application;
	}
	
}

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
import gr.hua.katanemimena.forms.StathmoiForm;

@Repository
public class StathmoiDAOImpl implements StathmoiDAO {

	 @Autowired
	    private SessionFactory sessionFactory;
	    
	    @Override
	    @Transactional
	    public List<Stathmoi> getStathmoi() {
	            Session currentSession = sessionFactory.getCurrentSession();
	            
	            Query<Stathmoi> query = currentSession.createQuery("from Stathmoi", Stathmoi.class);
	            List<Stathmoi> stathmoi = query.getResultList();
	                            
	            return stathmoi;
	    }
	
	    @Override
	    @Transactional
		public Stathmoi getStathmoByID(int id) {
	    	
	    	Session currentSession = sessionFactory.getCurrentSession();
	    	Stathmoi stathmos = currentSession.get(Stathmoi.class, id);
	    	
	    	return stathmos;
	    }
	    

	    @Override
	    @Transactional
		public Stathmoi createStathmo(StathmoiForm stathmosForm) {
	    	
	    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(MyUsers.class).addAnnotatedClass(Classes.class).addAnnotatedClass(Stathmoi.class).addAnnotatedClass(Students.class).addAnnotatedClass(Application.class).buildSessionFactory();

			Session session = factory.getCurrentSession();

			session.beginTransaction();
			
			
			MyUsers diefthidis = session.get(MyUsers.class, stathmosForm.getDiefthidisID());

			Stathmoi stathmos = stathmosForm.getStathmos();
			
			stathmos.setDiefthidisID(diefthidis);
			
			session.save(stathmos);
			session.getTransaction().commit();
			
			factory.close();
	    	
	    	return stathmos;
	    }
	    

	    @Override
	    @Transactional
		public Stathmoi changeEnabled(int id, Boolean temp) {
	    	
	    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(MyUsers.class).addAnnotatedClass(Classes.class).addAnnotatedClass(Stathmoi.class).addAnnotatedClass(Students.class).addAnnotatedClass(Application.class).buildSessionFactory();

			Session session = factory.getCurrentSession();

			session.beginTransaction();
	    	
			Stathmoi stathmos = session.get(Stathmoi.class, id);
			
			stathmos.setEnabled(temp);
			
			stathmos = (Stathmoi) session.merge(stathmos);
			
			session.getTransaction().commit();
			
			factory.close();
	    	return stathmos;
	    }
	    
	    @Override
	    @Transactional
		public List<Stathmoi> getEnabledStathmoi(Boolean enabled){
	    	
	    	Session currentSession = sessionFactory.getCurrentSession();
	    	
			String hql = "from Stathmoi where enabled like :enabled";
			
			@SuppressWarnings({ "unchecked" })
			Query<Stathmoi> query = currentSession.createQuery(hql);
			query.setParameter("enabled",  enabled);

			//Execute query
			List<Stathmoi> stathmoi = query.list();
	    	
	    	return stathmoi;
	    }
	    

	    @Override
	    @Transactional
		public List<Stathmoi> findStathmo(String name) {

	    	Session currentSession = sessionFactory.getCurrentSession();
	    	
			String hql = "from Stathmoi where name like :keyword";
			
			@SuppressWarnings({ "unchecked" })
			Query<Stathmoi> query = currentSession.createQuery(hql);
			query.setParameter("keyword",  "%" + name + "%");

			//Execute query
			List<Stathmoi> stathmoi = query.list();
	    	
	    	return stathmoi;
	    }
	    

	    @Override
	    @Transactional
		public Stathmoi getStathmoByDiaxID(int id) {
	    	
	    	Session currentSession = sessionFactory.getCurrentSession();
	    	
	    	String hql = "from Stathmoi as c where c.diefthidisID.id = :keyword";
	    	@SuppressWarnings({ "unchecked" })
			Query<Stathmoi> query = currentSession.createQuery(hql);
			query.setParameter("keyword",  id );
	    	
			List<Stathmoi> stathmoi = query.list();
			
			Stathmoi stathmo = stathmoi.get(0);
		
	    	return stathmo;
	    }
	    

	    @Override
	    @Transactional
		public Stathmoi updateStathmo(Stathmoi stathmos) {
	    	

	    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(MyUsers.class).addAnnotatedClass(Classes.class).addAnnotatedClass(Stathmoi.class).addAnnotatedClass(Students.class).addAnnotatedClass(Application.class).buildSessionFactory();

			Session session = factory.getCurrentSession();

			session.beginTransaction();
			
			stathmos.setApplications(new ArrayList<Application>());
			
			stathmos = (Stathmoi) session.merge(stathmos);
			
			session.getTransaction().commit();
			
			factory.close();
	    	
	    	return stathmos;
	    }
	    
	    
	    

	    @Override
	    @Transactional
		public List<Stathmoi> getStathmoiByName(String name){
	    	Session currentSession = sessionFactory.getCurrentSession();
	    	
	    	String hql = "from Stathmoi where name like :keyword";
	    	@SuppressWarnings({ "unchecked" })
			Query<Stathmoi> query = currentSession.createQuery(hql);
			query.setParameter("keyword",  "%" +name+"%" );
	    	
			List<Stathmoi> stathmoi = query.list();
			
		
	    	return stathmoi;
	    	
	    	
	    }
	    
	    
	    
	    
	    
}


   
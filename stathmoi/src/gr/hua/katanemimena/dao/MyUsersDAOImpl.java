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

@Repository
public class MyUsersDAOImpl implements MyUsersDAO {
    @Autowired
    private SessionFactory sessionFactory;
    
    @Override
    @Transactional
    public List<MyUsers> getMyUsers() {
            Session currentSession = sessionFactory.getCurrentSession();
            
            Query<MyUsers> query = currentSession.createQuery("from MyUsers", MyUsers.class);
            List<MyUsers> myUsers = query.getResultList();
                            
            return myUsers;
    }
    

    @Override
    @Transactional
	public MyUsers getMyUserByID(int id) {
		
    	Session currentSession = sessionFactory.getCurrentSession();
    	
    	MyUsers myUser = currentSession.get(MyUsers.class, id);
		return myUser;
	}

    
    @Override
    @Transactional
	public int createMyUser(MyUsers myUser) {
    	
    	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(MyUsers.class).addAnnotatedClass(Classes.class).addAnnotatedClass(Stathmoi.class).addAnnotatedClass(Students.class).addAnnotatedClass(Application.class).buildSessionFactory();

    			Session session = factory.getCurrentSession();

    			session.beginTransaction();
    			session.save(myUser);
    			session.getTransaction().commit();
    			
    			factory.close();
    	
    	return 1;
    }
    
    @Override
    @Transactional
    public List<MyUsers> getDiefthides(){
    	
    	Session currentSession = sessionFactory.getCurrentSession();
    	
    	String hql = "from MyUsers where authority like :keyword";
		String keyword = "DIEF";

		
		@SuppressWarnings({ "unchecked" })
		Query<MyUsers> query = currentSession.createQuery(hql);
		query.setParameter("keyword", "%" + keyword + "%");

		//Execute query
		List<MyUsers> diefthides = query.list();
    	
    	return diefthides;
    }


	@Override
    @Transactional
	public List<MyUsers> getTeachers() {

		Session currentSession = sessionFactory.getCurrentSession();
    	
    	String hql = "from MyUsers where authority like :keyword";
		String keyword = "TEACHER";

		
		@SuppressWarnings({ "unchecked" })
		Query<MyUsers> query = currentSession.createQuery(hql);
		query.setParameter("keyword", "%" + keyword + "%");

		//Execute query
		List<MyUsers> teachers = query.list();
    	
    	return teachers;
	}

	@Override
    @Transactional
	public List<MyUsers> getMyUsersByUsername(String username){
Session currentSession = sessionFactory.getCurrentSession();
    	
    	String hql = "from MyUsers where username like :keyword";
    	@SuppressWarnings({ "unchecked" })
		Query<MyUsers> query = currentSession.createQuery(hql);
		query.setParameter("keyword",  "%" +username+"%" );
    	
		List<MyUsers> myUsers = query.list();
		
	
    	return myUsers;
		
	}
    
}

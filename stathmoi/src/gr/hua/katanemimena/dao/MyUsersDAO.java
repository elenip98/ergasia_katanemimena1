package gr.hua.katanemimena.dao;

import java.util.List;

import gr.hua.katanemimena.entity.MyUsers;


public interface MyUsersDAO {

	public List<MyUsers> getMyUsers();
	
	public MyUsers getMyUserByID(int id);
	
	public int createMyUser(MyUsers myUser);

	public List<MyUsers> getDiefthides();
	
	public List<MyUsers> getTeachers();

	public List<MyUsers> getMyUsersByUsername(String username);
	
}

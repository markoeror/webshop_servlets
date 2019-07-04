package dao;

import domen.User;

public interface RegistacijaDao {
	static final String insertUser= "insert into user(username, password, status) values (?,?,?)";
	public void insertUser(User user);
	
}

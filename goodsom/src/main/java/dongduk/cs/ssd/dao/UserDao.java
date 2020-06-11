package dongduk.cs.ssd.dao;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.User;

public interface UserDao {

	//User getUser(String emailId, String password) throws DataAccessException; // login시 필요
	
	/*
	User getUserByEmailId(String emailId) throws DataAccessException; // email로 user객체 얻어와서
	
	void createUser(User user) throws DataAccessException;

	void updateUser(User user) throws DataAccessException;

	void deleteUser(String emailId) throws DataAccessException;
	*/

}

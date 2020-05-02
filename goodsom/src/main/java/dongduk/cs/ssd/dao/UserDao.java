package dongduk.cs.ssd.dao;

import org.springframework.dao.DataAccessException;

import dongduk.cs.ssd.domain.User;

public interface UserDao {

	User getUserByEmail(String email) throws DataAccessException;
	// User getUser(String email, String password) throws DataAccessException;
	
	User getUserById(int userId) throws DataAccessException;
	
	void createUser(User user) throws DataAccessException;

	void updateUser(User user) throws DataAccessException;

	void deleteUser(int userId) throws DataAccessException;

}

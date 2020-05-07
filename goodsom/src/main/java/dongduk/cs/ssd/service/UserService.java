package dongduk.cs.ssd.service;

import dongduk.cs.ssd.domain.User;

public interface UserService {

	User getUserByEmail(String email);
	// User getUser(String email, String password) throws DataAccessException;
	
	User getUserById(int userId);
	
	void createUser(User user);

	void updateUser(User user);

	void deleteUser(int userId);
}

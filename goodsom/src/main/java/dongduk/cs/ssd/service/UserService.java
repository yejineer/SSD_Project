package dongduk.cs.ssd.service;

import dongduk.cs.ssd.domain.User;

public interface UserService {

	User getUser(String email, String passwd); // 로그인 시 사용
	
	User getUserByEmail(String email);
	
	User getUserById(int userId);
	
	void createUser(User user);

	void updateUser(User user);

	void deleteUser(int userId);
}

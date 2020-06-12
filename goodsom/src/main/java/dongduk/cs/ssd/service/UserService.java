package dongduk.cs.ssd.service;

import dongduk.cs.ssd.domain.User;

/**
 * @author kimdahyee
 * @since 2020.06.12
 */

public interface UserService {

	User getUser(String emailId, String password); // 로그인 시 사용
	
	User getUserByEmailId(String emailId);
	
	void createUser(User user);

	void updateUser(User user);

	void deleteUser(String emailId);
}

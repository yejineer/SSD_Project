package dongduk.cs.ssd.dao.mybatis.mapper;

import dongduk.cs.ssd.domain.User;

/**
 * @author kimdahyee
 * @since 2020.06.12
 */

public interface UserMapper {

	User getUser(String email, String passwd);
	
	User getUserByEmailId(String emailId);
	
	void createUser(User user);

	void updateUser(User user);

	void deleteUser(String emailId);
}

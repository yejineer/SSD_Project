package dongduk.cs.ssd.dao.mybatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.dao.UserDao;
import dongduk.cs.ssd.dao.mybatis.mapper.UserMapper;

/**
 * @author kimdahyee
 * @since 2020.06.12
 */

@Repository
public class MybatisUserDao implements UserDao {
	
	@Autowired
	private UserMapper userMapper;
	
	public User getUser(String email, String passwd) throws DataAccessException {
		return userMapper.getUser(email, passwd);
	}
	
	public User getUserByEmailId(String emailId) throws DataAccessException {
		return userMapper.getUserByEmailId(emailId);
	}
	
	public void createUser(User user) throws DataAccessException {
		userMapper.createUser(user);
	}

	public void updateUser(User user) throws DataAccessException {
		userMapper.updateUser(user);
	}

	public void deleteUser(String emailId) throws DataAccessException {
		userMapper.deleteUser(emailId);
	}
	
}

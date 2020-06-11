package dongduk.cs.ssd.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Repository;

import dongduk.cs.ssd.dao.UserDao;
import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.UserService;

/**
 * @author Yejin Lee
 * @since 2020.05.02
 */

/*
@Repository
@Service("userServiceImpl")
*/
public class UserServiceImpl implements UserService {
	
	/*
	@Autowired
	private UserDao userDao;
	
	public User getUser(String email, String passwd) {
		return userDao.getUser(email, passwd);
	}*/
	
	/*
	@Autowired
	private UserDao userDao;
	
	@Override
	public User getUser(String email, String passwd) {
		return userDao.getUser(email, passwd);
	}

	@Override
	public User getUserByEmailId(String emailId) {
		return userDao.getUserByEmailId(emailId);
	}

	@Override
	public void createUser(User user) {
		userDao.createUser(user);
	}

	@Override
	public void updateUser(User user) {
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(String emailId) {
		userDao.deleteUser(emailId);
	}
	*/
}

package dongduk.cs.ssd.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.UserService;

/**
 * @author Seonmi Hwang
 * @since 2020.06.28
 */

@Component
public class AuthenticatorImpl implements Authenticator {

	@Autowired
	private UserService userService;
	
	@Override
	public void authenticate(LoginForm loginForm) {
		User realUser = userService.getUserByEmail(loginForm.getEmail());
		
		// email에 해당하는 user가 없을 경우
		if (realUser == null) {
			throw new AuthenticationException("noSuchUser");
		}
		
		// email과 비밀번호가 일치하지 않는 경우
		if (!realUser.matchPassword(loginForm.getPassword())) {
			throw new AuthenticationException("notMatchPassword");
		}
	}
	
}

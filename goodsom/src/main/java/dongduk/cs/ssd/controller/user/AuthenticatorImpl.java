package dongduk.cs.ssd.controller.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import dongduk.cs.ssd.domain.User;
import dongduk.cs.ssd.service.UserService;

@Component
public class AuthenticatorImpl implements Authenticator {

	@Autowired
	private UserService userService;
	
	@Override
	public void authenticate(LoginForm loginForm) {
		String email = loginForm.getEmail();
		// login한 email과 password가 맞는지 검증
		User realUser = userService.getUserByEmail(email);
		
		System.out.println("[REALUSER : ]" + realUser);
		
		// email에 해당하는 user가 없을 경우
		if (realUser == null) {
			throw new AuthenticationException("noSuchUser");
		}
		
		//  비밀번호가 일치하지 않는 경우
		if (!realUser.matchPassword(loginForm.getPassword())) {
			throw new AuthenticationException("notMatchPassword");
		}
	}
	
}

package dongduk.cs.ssd.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import dongduk.cs.ssd.service.UserService;

/**
 * @author kimdahyee
 * @since 2020.06.14
 */

@Controller
@RequestMapping("/user/register.do")
public class RegisterUserFormController {
	
	@Value("/user/register")
	private String formViewName;
	@Value("/user/login")
	private String successViewName;
	
	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	/*@Autowired
	private UserFormValidator validator;
	public void setValidator(UserFormValidator validator) {
		this.validator = validator;
	}*/
	
	@ModelAttribute("userForm")
	public UserForm formBackingObject(HttpServletRequest request) throws Exception {
		return new UserForm();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("userForm") UserForm userForm, BindingResult result) throws Exception {
		
		//validator.validate(userForm, result);
		
		if (result.hasErrors()) {
			return formViewName;
		} else {
			userService.createUser(userForm.getUser());
			
			System.out.println("은행 선택 값 출력 =======================" + userForm.getUser().getRefundBank());
			
			UserSession userSession = new UserSession(userService.getUserByEmailId(userForm.getUser().getEmailId()));
			session.setAttribute("userSession", userSession);
			return successViewName;
		}
	}
	
	/*
	@Value("register")
	private String formViewName;
	@Value("login")
	private String successViewName;
	
	@Autowired
	private UserService userService;
	public void setUserService(UserService userService) {
		this.userService = userService;
	}
	
	@Autowired
	private UserFormValidator validator;
	public void setValidator(UserFormValidator validator) {
		this.validator = validator;
	}
	
	@ModelAttribute("userForm")
	public UserForm formBackingObject(HttpServletRequest request) throws Exception {
		return new UserForm();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String onSubmit(HttpServletRequest request, HttpSession session,
			@ModelAttribute("userForm") UserForm userForm, BindingResult result) throws Exception {
		validator.validate(userForm, result);
		
		if (result.hasErrors()) return formViewName;
		try {
			userService.createUser(userForm.getUser());
		} catch (DataIntegrityViolationException ex) {
			result.rejectValue("user.email", "EMAIL_ID_ALREADY_EXISTS", "Email ID already exists: choose a different Email.");
			return formViewName;
		}
		
		UserSession userSession = new UserSession(userService.getUserByEmailId(userForm.getUser().getEmailId()));
		session.setAttribute("userSession", userSession);
		return successViewName;
	}
	*/
}

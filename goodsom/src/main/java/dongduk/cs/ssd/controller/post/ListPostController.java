package dongduk.cs.ssd.controller.post;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import dongduk.cs.ssd.controller.user.UserSession;
import dongduk.cs.ssd.service.PostService;

/**
 * @author kimdahyee
 * @since 05.08.2020
 */

/*
@Controller
@SessionAttributes("userSession")
*/
public class ListPostController {
	/*
	@Autowired
	PostService postService;
	
	@RequestMapping("/post/list.do")
	public ModelAndView handleRequest(
			@ModelAttribute("userSession") UserSession userSession) {
		ModelAndView mav = new ModelAndView();
		mav.setViewName("post/community_list");
		mav.addObject("postList", postService.getPostList());
		return mav;
	}
	*/
}

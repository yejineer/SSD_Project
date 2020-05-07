package dongduk.cs.ssd.controller.comment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import dongduk.cs.ssd.service.CommentService;

/**
 * @author kimdahyee
 * @since 05.08.2020
 */

@Controller
@RequestMapping({"/comment_p/create.do", "/comment_p/update.do",
	"/comment_q/create.do", "/comment_q/update.do"})
public class CommentFormController {
	
	@Autowired
	private CommentService commentService;
	
	private final String formViewName_p = "post/community_detail";
	private final String detailViewName_p = "post/community_detail";
	
	private final String formViewName_q = "question/question_detail";
	private final String detailViewName_q = "question/question_detail";

}

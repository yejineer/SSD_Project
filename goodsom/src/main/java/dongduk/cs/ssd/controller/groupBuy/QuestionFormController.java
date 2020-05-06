package dongduk.cs.ssd.controller.groupBuy;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import dongduk.cs.ssd.service.QuestionService;

/**
 * @author Seonmi Hwang
 * @since 2020.05.07
 */

@Controller
@SessionAttributes("groupBuySession")
@RequestMapping({"/question/create.do", "/question/update.do"})
public class QuestionFormController {
	@Autowired
	private QuestionService questionService;
	
	private final String formViewName = "question/question_form";
	private final String detailViewName = "question/question_detail";

	@ModelAttribute("questionForm")
	public QuestionForm formBacking(HttpServletRequest request,
									@RequestParam("questionId") int questionId) // request가 안넘어오면 어떻게 되나? null?
			throws Exception {
		String reqPage = request.getServletPath();

		if (reqPage.trim().equals("/question_form") && request.getMethod().equals("GET")) {
			return new QuestionForm(); // create a new GroupBuy
		} else { // update or show GroupBuy
			return new QuestionForm(questionService.getQuestion(questionId));
		}
	}
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(HttpServletRequest request,
						QuestionForm questionForm) {
		String reqPage = request.getServletPath();
		
		if (reqPage.trim().equals("groupBuy_form")) { // update
			questionService.updateQuestion(questionForm.getQuestion());
			return formViewName;
		} else { // show after create
			questionService.createQuestion(questionForm.getQuestion());
			return detailViewName;
		}
	}
	
	public void setQuestionService(QuestionService questionService) {
		this.questionService = questionService;
	}
}

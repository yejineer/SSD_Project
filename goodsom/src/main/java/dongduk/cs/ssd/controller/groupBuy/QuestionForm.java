package dongduk.cs.ssd.controller.groupBuy;

import dongduk.cs.ssd.domain.Question;

/**
 * @author Seonmi Hwang
 * @since 2020.05.07
 */

public class QuestionForm {
	private Question question;
	
	private boolean newQuestion;
	
	public QuestionForm() {
		this.question = new Question();
		this.newQuestion = true;
	}
	
	public QuestionForm(Question question) {
		this.question = question;
		this.newQuestion = false;
	}
	
	public Question getQuestion() {
		return question;
	}

	public boolean isNewQuestion() {
		return newQuestion;
	}
	
	public void setQuestion(Question question) {
		this.question = question;
	}
}

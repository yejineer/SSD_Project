package dongduk.cs.ssd.service;

import org.springframework.beans.factory.annotation.Autowired;

import dongduk.cs.ssd.dao.QuestionDao;
import dongduk.cs.ssd.domain.Question;

/**
 * @author Seonmi Hwang
 * @since 2020.05.07
 */

public class QuestionServiceImpl implements QuestionService {
	
	@Autowired
	private QuestionDao questionDao;
	
	public void createQuestion(Question question) {
		questionDao.createQuestion(question);
	}
	
	public void updateQuestion(Question question) {
		questionDao.updateQuestion(question);
	}
	
	public void deleteQuestion(int questionId) {
		questionDao.deleteQuestion(questionId);
	}
	
	public Question getQuestion(int questionId) {
		return questionDao.getQuestion(questionId);
	}

}

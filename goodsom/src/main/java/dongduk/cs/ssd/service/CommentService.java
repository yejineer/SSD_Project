package dongduk.cs.ssd.service;

import java.util.List;

import org.springframework.stereotype.Service;

import dongduk.cs.ssd.domain.Comment_p;
import dongduk.cs.ssd.domain.Comment_q;

/**
 * @author kimdahyee
 * @since 05.06.2020
 */

@Service("commentServiceImpl")
public interface CommentService {
	
	List<Comment_p> getComment_pList(int postId);
	
	Comment_q getComment_q(int questionId);
	
	Comment_p createCommnet_p(Comment_p comment);
	
	Comment_q createComment_q(Comment_q comment);
	
	void updateComment_p(Comment_p comment);
	
	void updateComment_q(Comment_q comment);
	
	void deleteComment_p(int commentId);
	
	void deleteComment_q(int commentId);
}

package dongduk.cs.ssd.service;

import java.util.List;
import org.springframework.stereotype.Service;
import dongduk.cs.ssd.domain.Post;

/**
 * @author kimdahyee
 * @since 05.06.2020
 */

@Service("postServiceImpl")
public interface PostService {

	List<Post> getPostList();
	
	Post getPost(int postId);
	
	Post createPost(Post post);
	
	void updatePost(Post post);
	
	void deletePost(int postId);
	
	List<Post> getPostByKeyword(String keyword);
}

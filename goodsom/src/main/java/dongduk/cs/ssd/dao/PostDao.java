package dongduk.cs.ssd.dao;

import dongduk.cs.ssd.domain.Post;
import java.util.*;
import org.springframework.dao.DataAccessException;

public interface PostDao {
	
	List<Post> getPostList(int menuId) throws DataAccessException;
	
	Post getDetailPost(int postId) throws DataAccessException;
	
	Post createPost(Post post) throws DataAccessException;
	
	void updatePost(Post post) throws DataAccessException;
	
	void deletePost(int postId) throws DataAccessException;
	
	List<Post> getPostByKeyword(String keyword) throws DataAccessException;
	
}

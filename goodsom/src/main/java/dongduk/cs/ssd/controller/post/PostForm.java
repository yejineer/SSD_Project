package dongduk.cs.ssd.controller.post;

import java.io.Serializable;

import dongduk.cs.ssd.domain.Post;

/**
 * @author kimdahyee
 * @since 05.08.2020
 */

@SuppressWarnings("serial")
public class PostForm implements Serializable {
	
	private Post post;
	
	private boolean newPost;
	
	public Post getPost() {
		return post;
	}
	
	public PostForm() { 
		this.post = new Post();
		this.newPost = true;
	}
	
	public PostForm(Post post) {
		this.post = post;
		this.newPost = false;
	}
	
	public boolean isNewPost() {
		return newPost;
	}
}

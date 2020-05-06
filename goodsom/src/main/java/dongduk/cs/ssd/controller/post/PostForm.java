package dongduk.cs.ssd.controller.post;

import java.io.Serializable;

import dongduk.cs.ssd.domain.Post;

/**
 * @author kimdahyee
 * @since 05.06.2020
 */

@SuppressWarnings("serial")
public class PostForm implements Serializable {
	
	private Post post;
	
	public Post getPost() {
		return post;
	}
}

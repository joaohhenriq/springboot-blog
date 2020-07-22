package br.com.blog.service;

import java.util.List;

import br.com.blog.model.Post;

public interface PostService {

	List<Post> findAll();
	Post findById(long id);
	Post save(Post post);
}

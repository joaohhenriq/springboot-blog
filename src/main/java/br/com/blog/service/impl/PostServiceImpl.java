package br.com.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.blog.model.Post;
import br.com.blog.repository.PostRepository;
import br.com.blog.service.PostService;

@Service
public class PostServiceImpl implements PostService {
	
	@Autowired
	PostRepository postRepository;

	@Override
	public List<Post> findAll() {
		return postRepository.findAll();
	}

	@Override
	public Post findById(long id) {
		return postRepository.findById(id).get();
	}

	@Override
	public Post save(Post post) {
		return postRepository.save(post);
	}

}

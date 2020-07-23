package br.com.blog.controller;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.blog.model.Post;
import br.com.blog.service.PostService;

@Controller
public class PostController {
	
	@Autowired
	PostService postService;
	
	@RequestMapping(value = "/posts", method = RequestMethod.GET)
	public ModelAndView getPosts() {
		ModelAndView mv = new ModelAndView("posts");
		List<Post> posts = postService.findAll();
		mv.addObject("posts", posts);
		return mv;
	}
	
	@RequestMapping(value = "/posts/{id}", method = RequestMethod.GET)
	public ModelAndView getPostDetails(@PathVariable("id") long id) {
		ModelAndView mv = new ModelAndView("postDetail");
		Post post = postService.findById(id);
		mv.addObject("post", post);
		return mv;
	}
	
	
	@RequestMapping(value = "/newpost", method = RequestMethod.GET)
	public String getPostForm() {
		return "postForm";
	}
	
	@RequestMapping(value = "/newpost", method = RequestMethod.POST)
	public String savePost(Post post, BindingResult result, RedirectAttributes attributes) {
		
		if(post.getAuthor().trim().equals("") || post.getText().trim().equals("") || post.getTitle().trim().equals("")) {
			attributes.addFlashAttribute("message", "You need to fill all the needed fields.");
			return "redirect:/newpost";
		}
		
		post.setDate(LocalDate.now());
		
		postService.save(post);
		
		return "redirect:/posts";
	}
}

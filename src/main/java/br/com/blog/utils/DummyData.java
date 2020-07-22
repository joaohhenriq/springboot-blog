package br.com.blog.utils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.blog.model.Post;
import br.com.blog.repository.PostRepository;

@Component
public class DummyData {
	
	@Autowired
	PostRepository postRepository;
	
//	@PostConstruct
	public void savePosts() {
		
		List<Post> postList = new ArrayList<>();
		
		Post post1 = new Post();
		post1.setAuthor("João Henrique Camargo");
		post1.setDate(LocalDate.now());
		post1.setTitle("Flutter - Fast Development");
		post1.setText("Paint your app to life in milliseconds with Stateful Hot Reload. Use a rich set of fully-customizable widgets to build native interfaces in minutes.");
		postList.add(post1);
		
		Post post2 = new Post();
		post2.setAuthor("João Henrique Camargo");
		post2.setDate(LocalDate.now());
		post2.setTitle("Flutter - Expressive and Flexible UI");
		post2.setText("Quickly ship features with a focus on native end-user experiences. Layered architecture allows for full customization, which results in incredibly fast rendering and expressive and flexible designs.");
		postList.add(post2);
		
		Post post3 = new Post();
		post3.setAuthor("João Henrique Camargo");
		post3.setDate(LocalDate.now());
		post3.setTitle("Flutter - Native Performance");
		post3.setText("Flutter’s widgets incorporate all critical platform differences such as scrolling, navigation, icons and fonts, and your Flutter code is compiled to native ARM machine code using Dart's native compilers.");
		postList.add(post3);
		
		Post post4 = new Post();
		post4.setAuthor("João Henrique Camargo");
		post4.setDate(LocalDate.now());
		post4.setTitle("Flutter");
		post4.setText("Flutter's hot reload helps you quickly and easily experiment, build UIs, add features, and fix bugs faster. Experience sub-second reload times without losing state on emulators, simulators, and hardware.");
		postList.add(post4);
		
		Post post5 = new Post();
		post5.setAuthor("João Henrique Camargo");
		post5.setDate(LocalDate.now());
		post5.setTitle("Flutter");
		post5.setText("Delight your users with Flutter's built-in beautiful Material Design and Cupertino (iOS-flavor) widgets, rich motion APIs, smooth natural scrolling, and platform awareness.");
		postList.add(post5);
		
		for(Post post: postList) {
			Post postSaved = postRepository.save(post);
			System.out.println("Post ID: " + postSaved.getId());
		}
	}

}

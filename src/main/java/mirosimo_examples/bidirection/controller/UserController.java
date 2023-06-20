package mirosimo_examples.bidirection.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mirosimo_examples.bidirection.model.User;

@RestController
public class UserController {
	
	@PostMapping("/show-content")
	public User showContent(@RequestBody User user) {
		System.out.println("**** BEGIN ****");
		System.out.println("User Id : " + user.id);
		System.out.println("User name: " + user.name);
		return user;
	}
}

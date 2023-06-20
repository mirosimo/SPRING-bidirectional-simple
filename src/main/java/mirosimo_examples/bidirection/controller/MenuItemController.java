package mirosimo_examples.bidirection.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mirosimo_examples.bidirection.model.MenuItem;

@RestController
public class MenuItemController {
	
	@PostMapping("/menu-items")
	public MenuItem showItems(@RequestBody MenuItem item) {
		System.out.println("Child item: " + item.getId() + " - " + item.getName());
		System.out.println("Parent item: " + item.getParentItem().getId() + " - " + item.getParentItem().getName());		
		return item;
	}
}

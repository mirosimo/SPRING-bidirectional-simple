package mirosimo_examples.bidirection.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mirosimo_examples.bidirection.model.Item;

@RestController
public class ItemController {
	@PostMapping("/show-item")
	public Item postItem(@RequestBody Item item) {
		System.out.println("Item id:" + item.getId());
		System.out.println("Item name: " + item.getItemName());
		
		System.out.println("Parent item: " + item.getOwner().getId() + " + " + item.getOwner().getName());
		return item;
	}
}

package com.springboot.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.springboot.model.User;
import com.springboot.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@GetMapping(value="/users/new")
	public String addPage(Model model) {
		model.addAttribute("user", new User());
		return "addUser";
	}
	
	@PostMapping(value="/")
	public String create(@ModelAttribute("user") User user) {
		userService.save(user);
		return "redirect:/users";
	}
	
	@GetMapping(value="/users")
	public String show(Model model) {
		model.addAttribute("users", userService.getAllUsers());
		return "users";
	}
	
	@GetMapping(value="/users/{id}")
	public String userPage(Model model, @PathVariable("id") int id) {
		model.addAttribute("user", userService.getUserById(id));
		return "user";
	}
	
	@GetMapping(value="/users/{id}/edit")
	public String update(Model model, @PathVariable("id") int id) {
		model.addAttribute("user", userService.getUserById(id));
		return "edit";
	}
	
	@PostMapping(value="/users/{id}")
	public String saveUpdate(@ModelAttribute("user") User user, @PathVariable("id") int id) {
		userService.update(id, user);
		return "redirect:/users";
	}
	
	@PostMapping(value="/users/{id}/remove")
	public String remove(@PathVariable("id") int id) {
		userService.remove(id);
		return "redirect:/users";
	}
}

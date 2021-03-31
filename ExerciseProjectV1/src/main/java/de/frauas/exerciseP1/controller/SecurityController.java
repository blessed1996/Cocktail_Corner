package de.frauas.exerciseP1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import de.frauas.exerciseP1.security.User;
import de.frauas.exerciseP1.service.UserDetailsService;

@Controller
public class SecurityController {

	@Autowired
	private UserDetailsService userService;

	/**
	 * post-method saves given new user in the database
	 * 
	 * @param user
	 * @return view login
	 */
	@PostMapping(value = "/addUser")
	public String addUser(User user) {

		userService.save(user);
		return "login";
	}

}

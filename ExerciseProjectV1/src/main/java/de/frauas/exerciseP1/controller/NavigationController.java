package de.frauas.exerciseP1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NavigationController {
	/**
	 * get-method makes index-page available for display
	 * 
	 * @return index view
	 */
	@GetMapping("/index")
	public String index() {
		return "index.html";
	}

	/**
	 * get-method makes contact-page available for display
	 * 
	 * @return contact view
	 */
	@GetMapping("/contact")
	public String contact() {
		return "contact.html";
	}

	/**
	 * get-method makes login-page available for display
	 * 
	 * @return login view
	 */
	@GetMapping("/login")
	public String loginPage() {
		return "login.html";
	}

	/**
	 * get-method makes logout-page available for display, page does not serve a
	 * severe purpose
	 * 
	 * @return logout view, redirects further
	 */
	@GetMapping("/logout")
	public String logoutPage() {
		return "logout.html";
	}

	/**
	 * get-method makes register-page available for display
	 * 
	 * @return register view
	 */
	@GetMapping("/register")
	public String registerPage() {
		return "register.html";
	}

	/**
	 * get-method makes sessionInvalid-page available for display
	 * 
	 * @return sessionInvalid view
	 */
	@GetMapping("/sessionInvalid")
	public String invalidPage() {
		return "sessionInvalid.html";
	}

}
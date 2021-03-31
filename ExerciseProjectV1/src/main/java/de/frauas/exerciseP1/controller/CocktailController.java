package de.frauas.exerciseP1.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import de.frauas.exerciseP1.service.CocktailService;
import de.frauas.exerciseP1.sqlite.Cocktail;

@Controller
public class CocktailController {

	@Autowired
	private CocktailService cocktailService;

	/**
	 * carries data from the database to the view (protected by SpringSecurity),
	 * swallows a keyword (can be also empty, then it attaches all the data to the
	 * model), which calls the method "findByKeyowrd" from the Service-layer
	 * 
	 * @param model
	 * @param keyword - search word
	 * @return view cocktails
	 */
	@GetMapping("/cocktails")
	public String getCocktails(Model model, String keyword) {

		if (keyword != null) {
			model.addAttribute("cocktails", cocktailService.findByKeyword(keyword));
		} else {
			model.addAttribute("cocktails", cocktailService.getCocktails());
		}
		return "cocktails";

	}

	/**
	 * carries data from the database to the view (not protected by SpringSecurity
	 * and with less functionality), swallows a keyword (can be also empty, then it
	 * attaches all the data to the model), which calls the method "findByKeyowrd"
	 * from the Service-layer
	 * 
	 * @param model
	 * @param keyword - search word
	 * @return view showCocktails
	 */
	@GetMapping("/showCocktails")
	public String getNonEditCocktails(Model model, String keyword) {

		if (keyword != null) {
			model.addAttribute("cocktails", cocktailService.findByKeyword(keyword));
		} else {
			model.addAttribute("cocktails", cocktailService.getCocktails());
		}
		return "showCocktails";

	}

	/**
	 * method gets one cocktail entity (referenced by Id) if used
	 * 
	 * @param id
	 * @param model, id
	 * @return Service-ayer method "getCocktailById"
	 */
	@GetMapping("/onecocktail")
	@ResponseBody
	public Optional<Cocktail> getCocktailById(Integer id, Model model) {

		model.addAttribute("onecocktail", cocktailService.getCocktailById(id));
		return cocktailService.getCocktailById(id);

	}

	/**
	 * method updates an old cocktail from the database through the
	 * "updateCocktail"-method (Service-layer)
	 * 
	 * @param person
	 * @return
	 */
	@RequestMapping(value = "/save", method = { RequestMethod.PUT, RequestMethod.GET })
	public String updateCocktail(Cocktail person) {

		cocktailService.updateCocktail(person);
		return "redirect:/cocktails";

	}

	/**
	 * method adds a new cocktail to the database through the "addCocktail"-method
	 * (Service-layer)
	 * 
	 * @param cocktail
	 * @return view cocktails
	 */
	@RequestMapping(value = "/addNew", method = { RequestMethod.POST, RequestMethod.GET })
	public String addCocktail(Cocktail cocktail) {

		cocktailService.addCocktail(cocktail);
		return "redirect:/cocktails";

	}

	/**
	 * method deletes an old cocktail from the database through the "delete"-method
	 * (Service-layer)
	 * 
	 * @param cocktail
	 * @return
	 */
	@RequestMapping(value = "/delete", method = { RequestMethod.DELETE, RequestMethod.GET })
	public String deleteCocktail(Cocktail cocktail) {
		cocktailService.delete(cocktail);
		return "redirect:/cocktails";

	}

}

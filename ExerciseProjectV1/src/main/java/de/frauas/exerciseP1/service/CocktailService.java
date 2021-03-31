package de.frauas.exerciseP1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import de.frauas.exerciseP1.repository.CocktailRepository;
import de.frauas.exerciseP1.sqlite.Cocktail;

@Service
public class CocktailService {

	@Autowired
	private CocktailRepository cocktailRepository;

	public List<Cocktail> getCocktails() {

		return (List<Cocktail>) cocktailRepository.findAll();

	}

	/*
	 * selects and a cocktail entity by its id - needed for correct update
	 * functionality
	 */
	public Optional<Cocktail> getCocktailById(Integer id) {

		return cocktailRepository.findById(id);

	}

	/**
	 * update cocktail from the database, repository method
	 * 
	 * @param cocktail
	 */
	public void updateCocktail(Cocktail cocktail) {

		cocktailRepository.save(cocktail);

	}

	/**
	 * add new cocktail to the database, repository method
	 * 
	 * @param cocktail
	 */
	public void addCocktail(Cocktail cocktail) {

		cocktailRepository.save(cocktail);

	}

	/**
	 * delete cocktail from the database, repository method
	 * 
	 * @param cocktail
	 */
	public void delete(Cocktail cocktail) {

		cocktailRepository.delete(cocktail);

	}

	/**
	 * implements the search functionality with the help of a keyword in the
	 * Service-layer
	 * 
	 * @param keyword - search word
	 * @return "findByKeyword"- repository query
	 */
	public List<Cocktail> findByKeyword(String keyword) {
		return cocktailRepository.findByKeyword(keyword);
	}

}

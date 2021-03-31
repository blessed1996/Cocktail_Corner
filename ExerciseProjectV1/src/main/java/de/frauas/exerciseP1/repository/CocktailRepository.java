package de.frauas.exerciseP1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import de.frauas.exerciseP1.sqlite.Cocktail;

/**
 * repository that interacts with the database (cocktail) through
 * CrudRespository functionalities
 * 
 * @author david kirsner - 1298772
 *
 */
@Repository
public interface CocktailRepository extends CrudRepository<Cocktail, Integer> {

	/**
	 * this custom query is used to implement the search functionality through a
	 * simple SQL-request forwarded to the database
	 * 
	 * @param keyword - search word
	 */
	@Query(value = "select * from Cocktail e where e.name like %:keyword% or e.message like %:keyword%", nativeQuery = true)
	List<Cocktail> findByKeyword(@Param("keyword") String keyword); // custom query noetig!
																	// (keyword-suche!)

}

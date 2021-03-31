package de.frauas.exerciseP1.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import de.frauas.exerciseP1.security.User;

/**
 * repository that interacts with the database (user) through CrudRespository
 * functionalities
 * 
 * @author david kirsner - 1298772
 *
 */
@Repository
public interface UserRepository extends CrudRepository<User, Integer> {

	User findByUsername(String username);

}

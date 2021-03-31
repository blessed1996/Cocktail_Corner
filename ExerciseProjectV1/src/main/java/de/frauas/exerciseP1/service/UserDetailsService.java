package de.frauas.exerciseP1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import de.frauas.exerciseP1.repository.UserRepository;
import de.frauas.exerciseP1.security.User;
import de.frauas.exerciseP1.security.UserStore;

@Service
public class UserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Autowired
	private UserRepository userRepository;

	/**
	 * we can not return UserDetails objects here, therefore we need to create a
	 * class named UserStore. This will make it possible to return those details in
	 * the form we need.
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByUsername(username);

		if (user == null) {
			throw new UsernameNotFoundException("User nicht gefunden!");
		}

		return new UserStore(user);
	}

	/**
	 * method encrypts the password with the help of the encoder before it is stored
	 * in the database.
	 * 
	 * @param user
	 */
	public void save(User user) {

		user.setPassword(encoder.encode(user.getPassword()));

		userRepository.save(user);

	}

}

package de.frauas.exerciseP1.security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserStore implements UserDetails {

	private static final long serialVersionUID = 1L;

	private User user;

	/**
	 * enables the UserDetailsService to be able to return the UserDetails. Also
	 * implements other methods (not all are used in this project and therefore set
	 * to true).
	 * 
	 * @param user
	 */
	public UserStore(User user) {
		super();
		this.user = user;
	}

	/**
	 * this method handles the roles of a user - in this application we only have a
	 * simple user role, but there could be also e.g. an admin
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return Collections.singleton(new SimpleGrantedAuthority("User"));
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	/**
	 * unused.
	 */
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * unused.
	 */
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * unused.
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	/**
	 * unused.
	 */
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}

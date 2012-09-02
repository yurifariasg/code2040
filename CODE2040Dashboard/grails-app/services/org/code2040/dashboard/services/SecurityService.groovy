package org.code2040.dashboard.services

import org.code2040.dashboard.Candidate
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.Authentication
import org.springframework.security.core.context.SecurityContextHolder
//import org.springframework.security.core.userdetails.UserDetails
//import org.springframework.security.adapters.PrincipalSpringSecurityUserToken

public class SecurityService{
	
	/**
	 * Automatic login after successful registration.
	 * @param username
	 */
	public boolean autoLogin(String username, String password) {
	 try {
	  //Candidate userDetails = Candidate.findByUsername(username)
	  Authentication authentication = new UsernamePasswordAuthenticationToken(username,
		  password)//userDetails.getPassword())
	
	  // Place the new Authentication object in the security context.
	  SecurityContextHolder.getContext().setAuthentication(authentication);
	  println "Done!"
	 }
	 catch (Exception e) {
		SecurityContextHolder.getContext().setAuthentication(null);
		return false;
	 }
	 return true;
	}

}

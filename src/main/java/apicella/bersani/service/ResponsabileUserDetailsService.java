package apicella.bersani.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import apicella.bersani.model.Responsabile;
import apicella.bersani.repository.ResponsabileRepository;

@Service
public class ResponsabileUserDetailsService  implements UserDetailsService {

	@Autowired
	ResponsabileRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		Responsabile responsabile= repo.findByEmail(email);

	    UserBuilder builder = null;
	    if (responsabile!=null) {
	      builder = org.springframework.security.core.userdetails.User.withUsername(email);
	      builder.password(responsabile.getPassword());
	      builder.roles(responsabile.getRuolo());
	    } else {
	      throw new UsernameNotFoundException("User not found.");
	    }

	    return builder.build();
	}

}

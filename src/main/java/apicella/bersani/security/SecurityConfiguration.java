package apicella.bersani.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;

import apicella.bersani.service.ResponsabileUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Bean
	public UserDetailsService userDetailsService() {
		return new ResponsabileUserDetailsService();
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
	}


	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers("/css/**","/images/**","/fonts/**","/js/**","/vendor/**").permitAll()
		.antMatchers("/login").permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.oauth2Login()
		.loginPage("/login")
		.defaultSuccessUrl("/index")
		.failureUrl("/login")
		.and()
		.formLogin().loginPage("/login")
		.defaultSuccessUrl("/index")
		.failureUrl("/login")
		.and()
		.logout().permitAll().logoutSuccessUrl("/login").deleteCookies("JSESSIONID")
		.invalidateHttpSession(true)
		.and()
		.csrf().disable();
	}

	@Bean
	public AuthorizationRequestRepository<OAuth2AuthorizationRequest> authorizationRequestRepository() {

		return new HttpSessionOAuth2AuthorizationRequestRepository();
	}

}

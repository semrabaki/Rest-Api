package rest_api04_controller_service_repository_basic_auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity //if you do not put this annotation it will be like based annotation
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.
			authorizeRequests().antMatchers("/","index","/css/*","/js/*").
			permitAll().
			anyRequest().
			authenticated().
			and().
			httpBasic(); //Basic authentication, uses username and password for every request.
	}


	@Override
	@Bean
	protected UserDetailsService userDetailsService() { // this is how we set the password in code 
		
		UserDetails student= User.
									builder().
									username("techpro").
									password(passwordEncoder.encode("12345")).
									roles("STUDENT").
									build();
		
		return new InMemoryUserDetailsManager (student);
		
		
	}
	
	private final PasswordEncoder passwordEncoder;
	@Autowired
	public ApplicationSecurityConfig(PasswordEncoder passwordEncoder) {
		
		this.passwordEncoder=passwordEncoder;
	}
	
	
	

}

package movietickets.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class TicketsWebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {		
		http
		.formLogin()
			.loginPage("/login")
			.permitAll()  // Unrestricted access to the login page
			.and()
		.exceptionHandling()
			.accessDeniedPage("/denied")
			.and()
			.authorizeRequests()
			.antMatchers("/login").permitAll()
			.antMatchers("/").permitAll()
			.antMatchers(HttpMethod.GET, "/book").hasRole("SYSREP")
			.antMatchers(HttpMethod.GET, "/screening").hasRole("SYSREP")
			.antMatchers(HttpMethod.GET, "/printTicket").hasRole("SYSREP")
			.antMatchers(HttpMethod.GET, "/schedule").hasRole("SYSAD")
			.antMatchers(HttpMethod.GET, "/newschedule").hasRole("SYSAD")
			.antMatchers(HttpMethod.GET, "/management").hasRole("MANAGER")
			.and()
		.logout()
			.permitAll()
			.logoutSuccessUrl("/");
	}

	@Autowired
	public void configureGlobal(
			AuthenticationManagerBuilder auth) throws Exception {
		auth
		.inMemoryAuthentication()
			.withUser("sysrep").password("123").roles("SYSREP").and()
			.withUser("sysad").password("123").roles("SYSAD").and()
			.withUser("manager").password("123").roles("MANAGER");
		
	}

}

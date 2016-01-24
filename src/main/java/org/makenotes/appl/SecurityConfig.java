package org.makenotes.appl;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.httpBasic().and().authorizeRequests()
				.antMatchers(HttpMethod.GET, "/makenotes/**").permitAll()
				.antMatchers(HttpMethod.PUT, "/makenotes/**").permitAll()
				.antMatchers(HttpMethod.DELETE, "/makenotes/**").permitAll()
				.antMatchers(HttpMethod.POST, "/makenotes/**").permitAll()
				.and()
				.csrf().disable();
	}

}
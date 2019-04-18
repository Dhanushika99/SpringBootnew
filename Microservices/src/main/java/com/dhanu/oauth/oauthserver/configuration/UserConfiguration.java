package com.dhanu.oauth.oauthserver.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
public class UserConfiguration extends GlobalAuthenticationConfigurerAdapter {
	PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	
	public void init(AuthenticationManagerBuilder auth) throws Exception{
		auth.inMemoryAuthentication().withUser("dhanu").password(passwordEncoder.encode("pass")).roles("Admin","User").authorities("CAN_READ","CAN_DELETE").
		and().withUser("saman").password(passwordEncoder.encode("pass")).roles("Admin").authorities("CAN_READ","CAN_DELETE");
	}

}

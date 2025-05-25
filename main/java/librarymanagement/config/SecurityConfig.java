package librarymanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity

public class SecurityConfig {
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		 http
         .csrf(csrf -> csrf.disable())
         .authorizeHttpRequests(auth -> auth
             .anyRequest().permitAll()  // ← This allows ALL requests
         );
     return http.build();
		
//		 http.csrf().disable()
//         .authorizeHttpRequests(auth -> auth
//             .requestMatchers(
//            		 "/api/signup",
//     				"/api/addbook",
//     				"/api/books"     
//             ).permitAll()
//             .anyRequest().authenticated()
//         )
//         .httpBasic();
//     return http.build();
	}
	
	@Bean 
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}

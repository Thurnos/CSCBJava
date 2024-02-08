package informatics.logisticcompany.security;

import informatics.logisticcompany.users.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration class for the application.
 * Defines beans and configurations related to Spring Security, including password encoding,
 * authentication provider setup, and HTTP security rules.
 */
@Configuration
public class SecurityConfig {

//    @Bean
//    public InMemoryUserDetailsManager userDetailsManager() {
//
//        UserDetails john = User.builder()
//                .username("john")
//                .password("{noop}john")
//                .roles("ADMIN")
//                .build();
//
//        UserDetails mary = User.builder()
//                .username("mary")
//                .password("{noop}mary")
//                .roles("EMPLOYEE")
//                .build();
//
//        return new InMemoryUserDetailsManager(john, mary);
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public DaoAuthenticationProvider authenticationProvider(UserService userService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService); // set the custom user details service
        authenticationProvider.setPasswordEncoder(passwordEncoder()); // set the password encode - bcrypt
        return authenticationProvider;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {

        httpSecurity.authorizeHttpRequests(configurer ->
                configurer
                        .requestMatchers("/users/**").hasAuthority("ADMIN")
                        .requestMatchers("/system/**").hasAuthority("ADMIN")
                        .requestMatchers("/auth/register/**").permitAll()
                        .anyRequest().authenticated()
        )
                .formLogin(form ->
                        form
                                .loginPage("/auth/login")
                                .loginProcessingUrl("/authenticateTheUser")
                                .permitAll()
                )
                .logout(logout -> logout.permitAll()
                )
                .exceptionHandling(configurer ->
                        configurer.accessDeniedPage("/auth/access-denied")
                );

        return httpSecurity.build();
    }

}
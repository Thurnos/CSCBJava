package informatics.logisticcompany.security;

import informatics.logisticcompany.users.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractAuthenticationFilterConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

/**
 * Security configuration class for the application.
 * Defines beans and configurations related to Spring Security, including password encoding,
 * authentication provider setup, and HTTP security rules.
 */
@Configuration
public class SecurityConfig {

    /**
     * Defines a BCryptPasswordEncoder bean to be used for password encoding throughout the application.
     * @return A BCryptPasswordEncoder instance.
     */
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    /**
     * Configures a custom authentication provider using the provided UserService for user details retrieval
     * and a BCryptPasswordEncoder for password encoding.
     * @param userService The UserService to use for loading user details.
     * @return A configured DaoAuthenticationProvider.
     */
    public DaoAuthenticationProvider authenticationProvider(UserService userService) {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userService); // set the custom user details service
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }


    /**
     * Configures the HTTP security for the application, specifying URL access rules,
     * form login configurations, and logout settings.
     * @param http The HttpSecurity to configure.
     * @return The SecurityFilterChain resulting from the configuration.
     * @throws Exception if an error occurs during configuration.
     */
    // Spring handles authenticateTheUser for us, we don't need a controller
    // TODO: Configure Request Matchers Based On Roles
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(configurer ->
                        configurer
                                .requestMatchers("/user/registration").permitAll()
                                .requestMatchers("/**").permitAll()
//                                .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .loginPage("/user/login")
                        .loginProcessingUrl("/authenticateTheUser")
                        .usernameParameter("email")
                        .passwordParameter("password")
                        .permitAll()
                );

        return http.build();
    }

}
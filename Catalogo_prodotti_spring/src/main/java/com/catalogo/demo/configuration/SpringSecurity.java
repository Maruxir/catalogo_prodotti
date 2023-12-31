package com.catalogo.demo.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SpringSecurity{
	@Autowired
    private UserDetailsService userDetailsService;

    @Bean
    public static PasswordEncoder passwordEncoder(){
        //return new BCryptPasswordEncoder();
    	return new PasswordEncoder() {
            @Override
            public String encode(CharSequence rawPassword) {
                return rawPassword.toString();
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return rawPassword.toString().equals(encodedPassword);
            }
        };
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests((authorize) ->
                        authorize.requestMatchers("home").permitAll()
                        	   
                        	   .requestMatchers("/style.css").permitAll()
                              
                        	   .requestMatchers("/static/**").permitAll()
                        	   .requestMatchers("/addProduct").hasRole("ADMINISTRATOR")
                               .requestMatchers("/addProductCall").hasRole("ADMINISTRATOR")
                               .requestMatchers("/addProductSupplier").hasRole("ADMINISTRATOR")
                               .requestMatchers("/addProductSupplierCall/{id}").hasRole("ADMINISTRATOR")
                               .requestMatchers("/addSupplier").hasRole("ADMINISTRATOR")
                               .requestMatchers("/addSupplierCall").hasRole("ADMINISTRATOR")
                               .requestMatchers("/deleteProduct/{id}").hasRole("ADMINISTRATOR")
                               .requestMatchers("/deletePs/{id}").hasRole("ADMINISTRATOR")
                               .requestMatchers("/deleteSupplier/{id}").hasRole("ADMINISTRATOR")
                               .requestMatchers("/detailsAdministrator/{id}").hasRole("ADMINISTRATOR")
                               .requestMatchers("/homeAdministrator").hasRole("ADMINISTRATOR")
                               .requestMatchers("/updateProductDescription").hasRole("ADMINISTRATOR")
                               .requestMatchers("/updateProductDescriptionCall").hasRole("ADMINISTRATOR")
                               .requestMatchers("/updateProductName").hasRole("ADMINISTRATOR")
                               .requestMatchers("/updateProductNameCall").hasRole("ADMINISTRATOR")
                               .requestMatchers("/updateProductPrice").hasRole("ADMINISTRATOR")
                               .requestMatchers("/updateProductPriceCall").hasRole("ADMINISTRATOR")
                               .requestMatchers("/updateSupplierAddress").hasRole("ADMINISTRATOR")
                               .requestMatchers("/updateSupplierAddressCall").hasRole("ADMINISTRATOR")
                               .requestMatchers("/updateSupplierEmail").hasRole("ADMINISTRATOR")
                               .requestMatchers("/updateSupplierEmailCall").hasRole("ADMINISTRATOR")
                               
                               .requestMatchers("/addReview").hasRole("CUSTOMER")
                               .requestMatchers("/cercaFornitore/{name}").hasRole("CUSTOMER")
                               .requestMatchers("/cercaNome/{name}").hasRole("CUSTOMER")
                               .requestMatchers("/createReview").hasRole("CUSTOMER")
                               .requestMatchers("/details/{id}/{email}").hasRole("CUSTOMER")
                               .requestMatchers("/homeCustomer").hasRole("CUSTOMER")
                               .requestMatchers("/updateReview").hasRole("CUSTOMER")
                               .requestMatchers("/updateReviewPage").hasRole("CUSTOMER")
                               
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                                .logoutSuccessUrl("/home")
                                .permitAll()
                );
        			
			        
        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }
}
		
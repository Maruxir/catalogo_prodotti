package com.catalogo.demo.configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
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
                        authorize.requestMatchers("/Customer").permitAll()
                        		.requestMatchers("Reindirizzazione.html").permitAll()
                                .requestMatchers("/updateReviewPage").permitAll()
                                .requestMatchers("/updateReview").permitAll()
                                .requestMatchers("/prova/{email}").permitAll()
                                .requestMatchers("/addProductSupplier").permitAll()
                                .requestMatchers("/addProductSupplierCall").permitAll()
                                .requestMatchers("/updateProductName").permitAll()
                                .requestMatchers("/updateProductDescription").permitAll()
                                .requestMatchers("/updateProductPrice").permitAll()
                                .requestMatchers("/updateProductNameCall").permitAll()
                                .requestMatchers("/updateProductDescriptionCall").permitAll()
                                .requestMatchers("/updateProductPriceCall").permitAll()
                                .requestMatchers("/updateSupplierAddress").permitAll()
                                .requestMatchers("/updateSupplierAddressCall").permitAll()
                                .requestMatchers("/updateSupplierEmail").permitAll()
                                .requestMatchers("/updateSupplierEmailCall").permitAll()
                                .requestMatchers("/deleteProduct/{id}").permitAll()
                                .requestMatchers("/deleteSupplier/{id}").permitAll()
                                .requestMatchers("/addSupplier").permitAll()
                                .requestMatchers("/newSupplier").permitAll()
                                .requestMatchers("/addProduct").permitAll()
                                .requestMatchers("/addP").permitAll()
                                .requestMatchers("/deletePs/{id}").permitAll()
                                .requestMatchers("/cercaNome/{name}").permitAll()
                                .requestMatchers("/createReview").permitAll()
                                .requestMatchers("/addReview").permitAll()
                                .requestMatchers("/cercaFornitore/{name}").permitAll()
                                .requestMatchers("/suppliers/{id}/{email}").permitAll()
                                .requestMatchers("/supplier/{id}").permitAll()
                                .requestMatchers("/creater").hasRole("CUSTOMER")
                                .requestMatchers("/homeAdministrator").hasRole("ADMINISTRATOR")
                                .requestMatchers("/products").hasRole("CUSTOMER")
                ).formLogin(
                        form -> form
                                .loginPage("/login")
                                .loginProcessingUrl("/login")
                                //.defaultSuccessUrl("/users")
                                .permitAll()
                ).logout(
                        logout -> logout
                                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
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
		
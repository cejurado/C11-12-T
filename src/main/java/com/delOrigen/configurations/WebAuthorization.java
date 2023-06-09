package com.delOrigen.configurations;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;



@EnableWebSecurity
@Configuration
@EnableMethodSecurity
class WebAuthorization extends WebSecurityConfigurerAdapter {


    @Override
    protected void configure(HttpSecurity http) throws Exception {


    http.authorizeRequests()

               .antMatchers("/index.html").permitAll()

             .antMatchers("/app/login*").permitAll()
          .antMatchers( "/web/styles/index.css", "/web/scripts/index.js").permitAll()
            .antMatchers("/weba/*").hasAuthority("CLIENT")
              .antMatchers("/admin/**").hasAuthority("ADMIN")
             .antMatchers("/rest/**", "/h2-console/**").hasAuthority("ADMIN")
            .antMatchers("/api/**").permitAll();


        http.formLogin()

                .usernameParameter("email")

                .passwordParameter("password")

                .loginPage("/api/login");


        http.logout().logoutUrl("/api/logout");

       http.csrf().disable();
       http.cors();

        //disabling frameOptions so h2-console can be accessed
        http.headers().frameOptions().disable();
        // if user is not authenticated, just send an authentication failure response
        http.exceptionHandling().authenticationEntryPoint((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));
        // if login is successful, just clear the flags asking for authentication
        http.formLogin().successHandler((req, res, auth) -> clearAuthenticationAttributes(req));
        // if login fails, just send an authentication failure response
        http.formLogin().failureHandler((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));
        // if logout is successful, just send a success response
        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());
    }
    private void clearAuthenticationAttributes(HttpServletRequest request) {
        HttpSession session = request.getSession(false);
        if (session != null) {
            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
        }
    }

    public CorsConfigurationSource corsConfigurationSource(){
        ArrayList<String> lista1 = new ArrayList<>();
        ArrayList<String> lista2 = new ArrayList<>();
        ArrayList<String> lista3 = new ArrayList<>();
      //  lista1.add("edel-origen.up.railway.app");
        //lista1.add("http://localhost:8080");
        lista1.add("*");
        lista2.add("GET");
        lista2.add("POST");
        lista2.add("PUT");
        lista2.add("DELETE");
        lista3.add("Authorization");
        lista3.add("Cache-Control");
        lista3.add("Content-Type");
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(lista1);
        corsConfig.setAllowedMethods(lista2);
        corsConfig.setAllowCredentials(true);
        corsConfig.setAllowedHeaders(lista3);
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);

        return source;
    }
}

  /*  @Bean
    public WebSecurityCustomizer webSecurityCustomizer(){
        return (web)-> web.ignoring()
                .antMatchers("resources/**");
   }
*/







package com.example.backend.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Autowired
//    AccountDetailServiceImpl userDetailsService;
//
//    @Autowired
//    private AuthEntryPointJwt unauthorizedHandler;
//
//    @Autowired
//    private CustomerOAuth2UserService oAuth2UserService;
//
//    @Bean
//    public AuthTokenFilter authenticationJwtTokenFilter() {
//        return new AuthTokenFilter();
//    }



//    @Override
//    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
//        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
//    }
//
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                //C???u h??nh cho c??c ??u??ng d???n kh??ng c???n x??c th???c
                .antMatchers("/","/login", "/register", "/logout","/getDetailRoom").permitAll()
                //C???u h??nh cho c??c ???????ng d???n ????ng nh???p b???ng Role l?? Member, Admin
                .antMatchers("user/**").hasAnyRole("ROLE_USER", "ROLE_ADMIN", "ROLE_MODERATOR")
//                //c???u h??nh cho ???????ng d???n admin, ch??? c?? Role admin m???i v??o ???????c
                .antMatchers("admin/**").hasRole("ADMIN")
                .antMatchers("mod/**").hasRole("MODERATOR")
                .and()
                //formlogin
                .formLogin()
                //???????ng d???n tr??? v??? trang authentication
                .loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("password")
                //N???u authentication th??nh c??ng
                .defaultSuccessUrl("/")
                //N???u authentication th???t b???i
                .failureUrl("/login?error=true")
                .usernameParameter("username")
                .passwordParameter("password")
                //N???u authentication th??nh c??ng nh??ng v??o trang kh??ng ????ng role
                .and()
                .exceptionHandling()
                .accessDeniedPage("/403")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login").permitAll()
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
        ;

        http.authorizeRequests().and() //
                .rememberMe().tokenRepository(this.persistentTokenRepository()) //
                .tokenValiditySeconds(1 * 24 * 60 * 60); // 24h
    }

    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memory = new InMemoryTokenRepositoryImpl();
        return memory;
    }
}

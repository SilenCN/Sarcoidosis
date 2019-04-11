package cn.silen_dev.sarcoidosis.security;

import cn.silen_dev.sarcoidosis.service.MyUserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.annotation.Resource;


@Configuration
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Resource
    private MyUserDetailsService myUserDetailsService;
    @Resource
    private SuccessAuthenticationHandler successAuthenticationHandler;
    @Resource
    private FailureAuthenticationHandler failureAuthenticationHandler;
    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //super.configure(http);
        http.authorizeRequests().antMatchers("/api/**").authenticated().and().formLogin().loginPage("/user/login.html").loginProcessingUrl("/user/login").successHandler(successAuthenticationHandler).failureHandler(failureAuthenticationHandler);
        http.csrf().disable();
        http.headers().frameOptions().sameOrigin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(myUserDetailsService).passwordEncoder(new BCryptPasswordEncoder());
    }
}

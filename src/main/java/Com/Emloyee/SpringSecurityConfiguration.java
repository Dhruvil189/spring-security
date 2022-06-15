package Com.Emloyee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@EnableWebSecurity
public class SpringSecurityConfiguration extends WebSecurityConfigurerAdapter{
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private JwtFilter jwtfilter;
	@Bean
	public AuthenticationProvider authprovider()  //set userdetailservice and passwordencoder
	{
		DaoAuthenticationProvider provider=new DaoAuthenticationProvider();
		provider.setUserDetailsService(userDetailsService);
		provider.setPasswordEncoder(NoOpPasswordEncoder.getInstance());
		return provider;
	}
	
		
	
	 @Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	    @Override
	    public AuthenticationManager authenticationManagerBean() throws Exception {
	        return super.authenticationManagerBean();
	    }

	@Override
	  /*  protected void configure(HttpSecurity http) throws Exception {  //url configuration for security purpose
	        http.csrf().disable().authorizeRequests().antMatchers("/authenticate")
	                .permitAll().anyRequest().authenticated().and().sessionManagement()
	                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	                http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);;
	 }*/
	protected void configure(HttpSecurity http) throws Exception {
		 http.csrf().disable().authorizeRequests().antMatchers("/authenticate").permitAll()
	      .anyRequest().authenticated()
	     .and().httpBasic().and().sessionManagement()
         .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
         http.addFilterBefore(jwtfilter, UsernamePasswordAuthenticationFilter.class);
	}
	/* @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/admin/**").hasAuthority("ADMIN")
            .antMatchers("/user/**").hasAuthority("USER")
            .antMatchers("/**").permitAll().and().formLogin().and().csrf().disable();
            .and()
            .exceptionHandling().accessDeniedPage(accessDeniedUrl);//if any exception will create then this url will hande and redirect to error customized page



    }*/
}
	

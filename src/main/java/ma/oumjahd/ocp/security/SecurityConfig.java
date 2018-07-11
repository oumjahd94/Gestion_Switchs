package ma.oumjahd.ocp.security;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.encoding.Md5PasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration 
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Autowired // faire injecter 
	private DataSource dataSource;
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

    	/*auth.inMemoryAuthentication()
    	.withUser("med").password("8204").roles("ADMIN","GUEST");
		auth.inMemoryAuthentication()
		.withUser("hamid").password("1111").roles("GUEST");     */
		auth.jdbcAuthentication()     
       .dataSource(dataSource)           
       .usersByUsernameQuery       
       ("select nom as principal, mdp as credentials, statut from user where nom=?") 
       .authoritiesByUsernameQuery("select users as principal, roles as role from users_roles  where users=?")
       .rolePrefix("ROLE_") ;          
		
	}    
    
    @Override
    protected void configure(HttpSecurity http) throws Exception { 
    	http.formLogin().loginPage("/login");      
    	http.authorizeRequests()
    	.antMatchers("/switch","/local","/batiment","/site","/vlan").hasRole("GUEST");  
    	http.authorizeRequests()
    	.antMatchers("/user").hasRole("ADMIN");     
		http.exceptionHandling().accessDeniedPage("/403");         

    }    
    
}

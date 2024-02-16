package gob.ogti.laboratorio;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	private static final Log LOG = LogFactory.getLog(WebSecurityConfig.class);

	String[] resources = new String[] { "/include/**", "/css/**", "/icons/**", "/img/**", "/js/**", "/layer/**",
			"/scr/**" };

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(resources).permitAll()
				.antMatchers("/**/*.js", "/**/*.css", "/**/*.ico", "/**/*.png", "/**/*.jpg").permitAll()
				.antMatchers("/datosAsignacion", "/resue", "/risEsta", "/", "/index", "/esue", "/grabarEncuesta","/reporteConsololidad",
						"/reporteBioquimica", "/reporteHematologia","/reporteAnalisisTotal","/reporteMuestrasDeribadas",
						"/reporteTotAct","/tablaAnalisisClinicos")
				.permitAll().antMatchers("/", "/index").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").permitAll().defaultSuccessUrl("/hematologia").failureUrl("/login?error=true")
				.usernameParameter("username").passwordParameter("password").and().csrf().disable().logout().permitAll()
				.logoutSuccessUrl("/login?logout");

	}

	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		bCryptPasswordEncoder = new BCryptPasswordEncoder(4);
		return bCryptPasswordEncoder;
	}

	@Autowired
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) {
		try {
			auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		} catch (Exception e) {
			LOG.info("TEMPLATE: 'configureGlobal' -- LOG: '" + e.getMessage() + "'");
		}
	}

}

package gob.ogti.laboratorio.service.impl;

import java.util.HashSet;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import gob.ogti.laboratorio.entity.Role;
import gob.ogti.laboratorio.repository.UserRepository;


@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {
	
	private static final Log LOGGER = LogFactory.getLog(UserDetailsServiceImpl.class);
	
	@Autowired
	UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		gob.ogti.laboratorio.entity.User appUser = userRepository
				.findByUsername(username)
				.orElseThrow(()-> new UsernameNotFoundException("Login Username Invalido"));
		LOGGER.info("Usuario Logeado : "+username);
		
		
			Set<GrantedAuthority> grantList = new HashSet<>();
			for ( Role role: appUser.getRoles()) {
				
				GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(role.getDescription());
				grantList.add(grantedAuthority);
				LOGGER.info("Role Logeado : "+role.getName());
			}
			
			return (UserDetails) new User(username,appUser.getPassword(),grantList);
		
		
		
	}

}

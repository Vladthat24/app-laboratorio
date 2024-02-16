package gob.ogti.laboratorio.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import gob.ogti.laboratorio.dto.ChangePasswordForm;
import gob.ogti.laboratorio.entity.User;
import gob.ogti.laboratorio.exception.CustomeFieldValidationException;
import gob.ogti.laboratorio.exception.UsernameOrIdNotFound;
import gob.ogti.laboratorio.repository.UserRepository;
import gob.ogti.laboratorio.service.UserService;


@Service
public class UserServiceImpl implements UserService {

	private static final Log LOGGER = LogFactory.getLog(UserServiceImpl.class);

	@Autowired
	UserRepository repository;

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public Iterable<User> getAllUsers() {
		return repository.findAll();
	}

	@Override
	public User createUser(User user) throws CustomeFieldValidationException {

		Optional<User> userFound = repository.findByUsername(user.getUsername());

		if (userFound.isPresent()) {

			throw new CustomeFieldValidationException("Username no disponible", "username");
		} else if (user.getConfirmPassword() == null || user.getConfirmPassword().isEmpty()) {
			throw new CustomeFieldValidationException("Confirm Password es obligatorio", "confirmPassword");

		} else if (!user.getPassword().equals(user.getConfirmPassword())) {
			throw new CustomeFieldValidationException("Password y Confirm Password no son iguales", "password");
		}

		else {
			String encodePassword = bCryptPasswordEncoder.encode(user.getPassword());
			user.setPassword(encodePassword);
			user.setUsuarioRegU(getLoggedUser().getUsername());
			user.setFechaRegU(new Timestamp(Calendar.getInstance().getTimeInMillis()));
			user = repository.save(user);
		}

		return user;
	}

	@Override
	public User getUserById(Long id) throws UsernameOrIdNotFound {

		return repository.findById(id).orElseThrow(() -> new UsernameOrIdNotFound("El Id del usuario no existe."));

	}

	@Override
	public User updateUser(User fromUser) {
		User toUser = null;
		try {
			toUser = getUserById(fromUser.getId());
		} catch (UsernameOrIdNotFound e) {

			LOGGER.info("METHOD: 'updateUser' -- UsernameOrIdNotFound		: '" + e.getMessage() + "'");
		}
		mapUser(fromUser, toUser);
		return repository.save(toUser);
	}

	/**
	 * Map everything but the password.
	 * 
	 * @param from
	 * @param to
	 */

	protected void mapUser(User from, User to) {
		LOGGER.info("METHOD: 'to' -- PARAMS - USUARIO - ORIGINAL		: '" + to.getUsername() + "'");
		LOGGER.info("METHOD: 'to' -- PARAMS - FIRSTNAME - ORIGINAL	: '" + to.getFirstName() + "'");
		LOGGER.info("METHOD: 'to' -- PARAMS - LASTNAME - ORIGINAL		: '" + to.getLastName() + "'");
		LOGGER.info("METHOD: 'to' -- PARAMS - EMAIL - ORIGINAL		: '" + to.getEmail() + "'");
		LOGGER.info("METHOD: 'to' -- PARAMS - ROL - ORIGINAL			: '" + to.getRoles() + "'");
		LOGGER.info("METHOD: 'to' -- PARAMS - ESTADO - ORIGINAL		: '" + to.getEstado() + "'");
		LOGGER.info("METHOD: 'to' -- PARAMS - USUARIOMOD - ORIGINAL	: '" + to.getUsuarioModU() + "'");
		LOGGER.info("METHOD: 'to' -- PARAMS - FECHAMOD - ORIGINAL		: '" + to.getFechaModU() + "'");

		to.setUsername(from.getUsername());
		to.setFirstName(from.getFirstName());
		to.setEstablecimiento(from.getEstablecimiento());
		to.setLastName(from.getLastName());
		to.setEmail(from.getEmail());
		to.setRoles(from.getRoles());
		to.setEstado(from.getEstado());
		to.setUsuarioModU(from.getUsuarioModU());
		to.setFechaModU(from.getFechaModU());

		LOGGER.info("METHOD: 'from' -- PARAMS - USUARIO - ACTUALIZADO		: '" + from.getUsername() + "'");
		LOGGER.info("METHOD: 'from' -- PARAMS - FIRSTNAME - ACTUALIZADO		: '" + from.getFirstName() + "'");
		LOGGER.info("METHOD: 'from' -- PARAMS - LASTNAME - ACTUALIZADO		: '" + from.getLastName() + "'");
		LOGGER.info("METHOD: 'from' -- PARAMS - EMAIL -ACTUALIZADO			: '" + from.getEmail() + "'");
		LOGGER.info("METHOD: 'from' -- PARAMS - ROL - ACTUALIZADO			: '" + from.getRoles() + "'");
		LOGGER.info("METHOD: 'from' -- PARAMS - ESTADO - ACTUALIZADO		: '" + from.getEstado() + "'");
		LOGGER.info("METHOD: 'from' -- PARAMS - USUARIOMOD - ACTUALIZADO	: '" + from.getUsuarioModU() + "'");
		LOGGER.info("METHOD: 'from' -- PARAMS - FECHAMOD - ACTUALIZADO		: '" + from.getFechaModU() + "'");

	}

	@Override
	@PreAuthorize("hasAnyRole('ROLE_ADMIN')")
	public void deleteUser(Long id) throws UsernameOrIdNotFound {
		User user = getUserById(id);
		repository.delete(user);

	}

	@Override
	public User changePassword(ChangePasswordForm form) throws CustomeFieldValidationException {

		User user;
		try {
			user = getUserById(form.getId());

			if (user.getPassword().equals(form.getNewPassword())) {
				throw new CustomeFieldValidationException("Nuevo Password debe ser diferente al password actual",
						"Password");
			}
			if (!form.getNewPassword().equals(form.getConfirmPassword())) {
				throw new CustomeFieldValidationException("Nuevo Password y Current Password no coinciden",
						"confirmPassword");
			}
			String encodePassword = bCryptPasswordEncoder.encode(form.getNewPassword());
			user.setPassword(encodePassword);

			return repository.save(user);

		} catch (UsernameOrIdNotFound e) {

			LOGGER.info("METHOD: 'updateUser' -- changePassword		: '" + e.getMessage() + "'");
		}

		return null;
	}
	
	

	@Override
	public User getLoggedUser() {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		User myUser = null;

		if (principal instanceof UserDetails) {
			UserDetails loggedUser = (UserDetails) principal;

			try {
				myUser = repository.findByUsername(loggedUser.getUsername())
						.orElseThrow(() -> new Exception("Error obteniendo el usuario logeado desde la sesion."));
			} catch (Exception e) {

				LOGGER.info("METHOD: 'updateUser' -- getLoggedUser		: '" + e.getMessage() + "'");
			}
			LOGGER.info("Usuario Logeado : " + loggedUser.getUsername());
		}
		return myUser;
	}



	@Override
	public List<User> findByRoleParaAsignar() {

		return repository.findByRoleParaAsignar();
	}

	@Override
	public List<User> findByRoleCoordinador() {
		
		return repository.findByRoleCoordinador();
	}

	@Override
	public List<User> usuariosActivos() {
		
		return repository.usuariosActivos();
	}
	
	private boolean verdad = true;
	private boolean falso = false;
	
	public boolean isLoggedUserPorRol(String rolUser) {

		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

		UserDetails loggedUser = null;
		Object roles = null;
		

		if (principal instanceof UserDetails) {
			loggedUser = (UserDetails) principal;

			roles = loggedUser.getAuthorities().stream().filter(x -> rolUser.equals(x.getAuthority()))
					.findFirst().orElse(null);
		}
		LOGGER.info("isLoggedUserPorRol : " + roles);
		if (roles != null) {
			return verdad;
		}else {
			return falso;
		}
	}

	@Override
	public boolean isLoggedUserCOORDINADOR() {
		
		String rolUser = "ROLE_COORDINADOR";
		
		
		if (isLoggedUserPorRol(rolUser) == verdad) {
			return verdad;
		}else {
			return falso;
		}
	}
	
	@Override
	public boolean isLoggedUserADMIN() {
		String rolUser = "ROLE_ADMIN";
		
		
		if (isLoggedUserPorRol(rolUser)== verdad) {
			return verdad;
		}else {
			return falso;
		}
	}
	
	@Override
	public boolean isLoggedUserUSER() {
		String rolUser = "ROLE_USER";
		
		
		if (isLoggedUserPorRol(rolUser)== verdad) {
			return verdad;
		}else {
			return falso;
		}
	}
	
	@Override
	public boolean isLoggedUserESPECIALISTA(){
		String rolUser = "ROLE_ESPECIALISTA";
		
		
		if (isLoggedUserPorRol(rolUser)== verdad) {
			return verdad;
		}else {
			return falso;
		}
	}
	
	@Override
	public boolean isLoggedUserRADIOLOGO(){
		String rolUser = "ROLE_RADIOLOGO";
		
		
		if (isLoggedUserPorRol(rolUser)== verdad) {
			return verdad;
		}else {
			return falso;
		}
	}
	
	@Override
	public boolean isLoggedUserSOPORTE(){
		String rolUser = "ROLE_SOPORTE";
		
		
		if (isLoggedUserPorRol(rolUser)== verdad) {
			return verdad;
		}else {
			return falso;
		}
	}

	
}

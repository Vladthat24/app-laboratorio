package gob.ogti.laboratorio.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import gob.ogti.laboratorio.dto.ChangePasswordForm;
import gob.ogti.laboratorio.entity.Role;
import gob.ogti.laboratorio.entity.User;
import gob.ogti.laboratorio.exception.CustomeFieldValidationException;
import gob.ogti.laboratorio.exception.UsernameOrIdNotFound;
import gob.ogti.laboratorio.repository.RoleRepository;
import gob.ogti.laboratorio.service.EstablecimientoService;
import gob.ogti.laboratorio.service.UserService;
import gob.ogti.laboratorio.service.impl.UserServiceImpl;


@Controller
public class UserController {
	
	
private static final Log LOG = LogFactory.getLog(UserController.class);
	
@Autowired
UserService userService;

@Autowired
UserServiceImpl userServiceImpl;

@Autowired
RoleRepository roleRepository;

@Autowired
EstablecimientoService es;


LocalDate fecha = LocalDate.now();
LocalDateTime hora = LocalDateTime.now();
DateTimeFormatter f = DateTimeFormatter.ofPattern("hh:MM:ss");

private static final Log LOGGER= LogFactory.getLog(UserController.class);

class MainClassUser {

	private MainClassUser() {
		throw new IllegalStateException("Utility class");
	}

	public static final String METODO = "METHOD";
	public static final String USER_FORM = "userForm";
	public static final String ROLES = "roles";
	public static final String CENTRO_ASIS = "centro_asis";
	public static final String PARAM_MODELANDVIEW_USER_FORM = "user-form/user-signup";
	public static final String PARAM_MODELANDVIEW_USER_FORM_VIEW = "user-form/user-view";
	public static final String FORM_ERROR_MESSAGE = "formErrorMessage";
	public static final String PARAM_USERLIST = "userList";
	public static final String PARAM_USUARIOLOGEADO = "usuarioLogeado";
	public static final String LIST_TAB = "listTab";
	public static final String ACTIVE = "active";
	public static final String FORM_TAB = "formTab";
	public static final String EDIT_MODE = "editMode";
	public static final String PASSWORD_FORM = "passwordForm";

}

@GetMapping({ "/", "/login" })
public String index() {
	LOG.info(MainClassUser.METODO + " index()");
	return "index";
}

@GetMapping("/signup")
public String signup(Model model) {
	LOG.info(MainClassUser.METODO + " signup()");
	Role userRole = roleRepository.findByName("USER");
	List<Role> roles = Arrays.asList(userRole);
	model.addAttribute(MainClassUser.USER_FORM, new User());
	model.addAttribute(MainClassUser.ROLES, roles);
	model.addAttribute("centroasis", es.listaEstablecimientos());
	model.addAttribute("signup", true);
	model.addAttribute(MainClassUser.CENTRO_ASIS, es.listaEstablecimientos());
	return MainClassUser.PARAM_MODELANDVIEW_USER_FORM;

}

@PostMapping("/signup")
public String signupAction(@Validated @ModelAttribute("userForm") User user, BindingResult result, ModelMap model)
		throws CustomeFieldValidationException {

	Role userRole = roleRepository.findByName("USER");
	List<Role> roles = Arrays.asList(userRole);
	model.addAttribute(MainClassUser.USER_FORM, user);
	model.addAttribute(MainClassUser.ROLES, roles);
	model.addAttribute("signup", true);

	if (result.hasErrors()) {

		return MainClassUser.PARAM_MODELANDVIEW_USER_FORM;
	} else {
		try {
			userService.createUser(user);
			LOG.info("TEMPLATE: 'signup' -- DATA: '" + user + "'");
		} catch (Exception e) {
			model.addAttribute(MainClassUser.FORM_ERROR_MESSAGE, e.getMessage());
			LOG.error("Returning to user-form/user-signup");
			return MainClassUser.PARAM_MODELANDVIEW_USER_FORM;
		}
	}
	LOG.info("redirect to index");
	return index();
}

@GetMapping("/home")
public String home(Model model) {
	LOG.info(MainClassUser.METODO + " Home()");
	model.addAttribute(MainClassUser.PARAM_USERLIST, userService.getAllUsers());
	model.addAttribute(MainClassUser.PARAM_USUARIOLOGEADO,
			SecurityContextHolder.getContext().getAuthentication().getPrincipal());
	LOG.info("redirect to home");
	return "/home";
}

@GetMapping("/userForm")
public String userForm(Model model) {
	LOG.info(MainClassUser.METODO + " userForm()");

	model.addAttribute(MainClassUser.USER_FORM, new User());
	model.addAttribute(MainClassUser.PARAM_USUARIOLOGEADO,
			SecurityContextHolder.getContext().getAuthentication().getPrincipal());
	model.addAttribute(MainClassUser.PARAM_USERLIST, userService.getAllUsers());
	model.addAttribute(MainClassUser.ROLES, roleRepository.findAll());
	model.addAttribute(MainClassUser.LIST_TAB, MainClassUser.ACTIVE);
	model.addAttribute(MainClassUser.CENTRO_ASIS, es.listaEstablecimientos());

	return MainClassUser.PARAM_MODELANDVIEW_USER_FORM_VIEW;

}

@PostMapping("/userForm")
public String createUser(@Valid @ModelAttribute("userForm") User user, BindingResult result, ModelMap model) {

	if (result.hasErrors()) {
		model.addAttribute(MainClassUser.USER_FORM, user);
		model.addAttribute(MainClassUser.CENTRO_ASIS, es.listaEstablecimientos());
		model.addAttribute(MainClassUser.FORM_TAB, MainClassUser.ACTIVE);
		model.addAttribute(MainClassUser.PARAM_USUARIOLOGEADO,
				SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		LOG.error("TEMPLATE: 'userForm' -- DATA: '" + result.hasErrors() + "'");
	} else {

		try {
			userService.createUser(user);
			LOG.info("TEMPLATE: 'createUser' ");
			LOG.info("METHOD: 'username' -- PARAMS - IN		: '" + user.getUsername() + "'");
			LOG.info("METHOD: 'FirstName' -- PARAMS - IN	: '" + user.getFirstName() + "'");
			LOG.info("METHOD: 'LastName' -- PARAMS - IN		: '" + user.getLastName() + "'");
			LOG.info("METHOD: 'Email' -- PARAMS - IN		: '" + user.getEmail() + "'");
			LOG.info("METHOD: 'Rol' -- PARAMS - IN			: '" + user.getRoles() + "'");
			LOG.info("METHOD: 'UsuarioReg' -- PARAMS - IN	: '"
					+ SecurityContextHolder.getContext().getAuthentication().getName() + "'");
			LOG.info("METHOD: 'FechaReg' -- PARAMS - IN		: '" + user.getFechaRegU() + "'");

			model.addAttribute(MainClassUser.CENTRO_ASIS, es.listaEstablecimientos());
			model.addAttribute(MainClassUser.USER_FORM, new User());
			model.addAttribute(MainClassUser.LIST_TAB, MainClassUser.ACTIVE);
			model.addAttribute(MainClassUser.PARAM_USUARIOLOGEADO,
					SecurityContextHolder.getContext().getAuthentication().getPrincipal());

		} catch (CustomeFieldValidationException cfve) {
			result.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
			model.addAttribute(MainClassUser.USER_FORM, user);
			model.addAttribute(MainClassUser.FORM_TAB, MainClassUser.ACTIVE);
			model.addAttribute(MainClassUser.CENTRO_ASIS, es.listaEstablecimientos());
			model.addAttribute(MainClassUser.PARAM_USERLIST, userService.getAllUsers());
			model.addAttribute(MainClassUser.ROLES, roleRepository.findAll());
			model.addAttribute(MainClassUser.PARAM_USUARIOLOGEADO,
					SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		}

		catch (Exception e) {
			LOG.error("TEMPLATE: 'userForm' -- DATA:  e'" + e.getMessage() + "'");
			model.addAttribute(MainClassUser.FORM_ERROR_MESSAGE, e.getMessage());
			model.addAttribute(MainClassUser.USER_FORM, user);
			model.addAttribute(MainClassUser.FORM_TAB, MainClassUser.ACTIVE);
			model.addAttribute(MainClassUser.CENTRO_ASIS, es.listaEstablecimientos());
			model.addAttribute(MainClassUser.PARAM_USERLIST, userService.getAllUsers());
			model.addAttribute(MainClassUser.ROLES, roleRepository.findAll());
			model.addAttribute(MainClassUser.PARAM_USUARIOLOGEADO,
					SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		}
	}

	model.addAttribute(MainClassUser.PARAM_USERLIST, userService.getAllUsers());
	model.addAttribute(MainClassUser.ROLES, roleRepository.findAll());
	model.addAttribute(MainClassUser.CENTRO_ASIS, es.listaEstablecimientos());
	model.addAttribute(MainClassUser.PARAM_USUARIOLOGEADO,
			SecurityContextHolder.getContext().getAuthentication().getPrincipal());

	return MainClassUser.PARAM_MODELANDVIEW_USER_FORM_VIEW;

}

@GetMapping("/editUser/{id}")
public String getEditUserForm(Model model, @PathVariable(name = "id") Long id) {

	LOG.info(MainClassUser.METODO + " getEditUserForm()");
	User userToEdit = null;
	try {
		userToEdit = userService.getUserById(id);
	} catch (UsernameOrIdNotFound e) {
		
		LOG.info("TEMPLATE: '/editUser/{id}' -- LOG: '" + e.getMessage() + "'");
	}
	LOG.info("TEMPLATE: '/editUser/{id}' -- DATA: '" + userToEdit + "'");
	model.addAttribute(MainClassUser.USER_FORM, userToEdit);
	model.addAttribute(MainClassUser.PARAM_USERLIST, userService.getAllUsers());
	model.addAttribute(MainClassUser.ROLES, roleRepository.findAll());
	model.addAttribute(MainClassUser.FORM_TAB, MainClassUser.ACTIVE);
	model.addAttribute(MainClassUser.EDIT_MODE, "true");
	model.addAttribute(MainClassUser.CENTRO_ASIS,es.listaEstablecimientos());
	model.addAttribute(MainClassUser.PASSWORD_FORM, new ChangePasswordForm(id));
	model.addAttribute(MainClassUser.PARAM_USUARIOLOGEADO,
			SecurityContextHolder.getContext().getAuthentication().getPrincipal());
	LOG.info("TEMPLATE: '/editUser/{id}' -- LOG: '" + userToEdit + "'");
	return MainClassUser.PARAM_MODELANDVIEW_USER_FORM_VIEW;
}

@PostMapping("/editUser")
public String postEditUserForm(@Valid @ModelAttribute("userForm") User user, BindingResult result, ModelMap model) {
	LOG.info(MainClassUser.METODO + " postEditUserForm()");
	if (result.hasErrors()) {
		model.addAttribute(MainClassUser.USER_FORM, user);
		model.addAttribute(MainClassUser.FORM_TAB, MainClassUser.ACTIVE);
		model.addAttribute(MainClassUser.EDIT_MODE, "true");
		model.addAttribute(MainClassUser.PASSWORD_FORM, new ChangePasswordForm(user.getId()));
		model.addAttribute(MainClassUser.PARAM_USUARIOLOGEADO,
				SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		LOG.error("TEMPLATE: 'editUser' -- ERROR: '" + result.hasErrors() + "'");
	} else {
		try {
			userService.updateUser(user);
			model.addAttribute(MainClassUser.USER_FORM, new User());
			model.addAttribute(MainClassUser.LIST_TAB, MainClassUser.ACTIVE);
			model.addAttribute(MainClassUser.CENTRO_ASIS, es.listaEstablecimientos());
			model.addAttribute(MainClassUser.PARAM_USUARIOLOGEADO,
					SecurityContextHolder.getContext().getAuthentication().getPrincipal());
			LOG.info("TEMPLATE: 'editUser' -- DATA: '" + user + "'");
		} catch (Exception e) {
			model.addAttribute(MainClassUser.FORM_ERROR_MESSAGE, e.getMessage());
			model.addAttribute(MainClassUser.USER_FORM, user);
			model.addAttribute(MainClassUser.FORM_TAB, MainClassUser.ACTIVE);
			model.addAttribute(MainClassUser.PARAM_USERLIST, userService.getAllUsers());
			model.addAttribute(MainClassUser.ROLES, roleRepository.findAll());
			model.addAttribute(MainClassUser.EDIT_MODE, "true");
			model.addAttribute(MainClassUser.PASSWORD_FORM, new ChangePasswordForm(user.getId()));
			model.addAttribute(MainClassUser.PARAM_USUARIOLOGEADO,
					SecurityContextHolder.getContext().getAuthentication().getPrincipal());
			LOG.error("TEMPLATE: 'editUser' -- DATA: e '" + e + "'");
		}
	}

	model.addAttribute(MainClassUser.PARAM_USERLIST, userService.getAllUsers());
	model.addAttribute(MainClassUser.ROLES, roleRepository.findAll());
	model.addAttribute(MainClassUser.CENTRO_ASIS, es.listaEstablecimientos());
	model.addAttribute(MainClassUser.PARAM_USUARIOLOGEADO,
			SecurityContextHolder.getContext().getAuthentication().getPrincipal());

	return MainClassUser.PARAM_MODELANDVIEW_USER_FORM_VIEW;

}

@GetMapping("/userForm/cancel")
public String cancelEditUser(ModelMap model) {
	LOG.info(MainClassUser.METODO + " cancelEditUser()");
	model.addAttribute(MainClassUser.PARAM_USUARIOLOGEADO,
			SecurityContextHolder.getContext().getAuthentication().getPrincipal());
	LOG.info("redirect to userForm");
	return "redirect:/userForm";
}

@GetMapping("/deleteUser/{id}")
public String deleteUser(Model model, @PathVariable(name = "id") Long id) {
	try {
		userService.deleteUser(id);
	} catch (UsernameOrIdNotFound u) {
		model.addAttribute("listErrorMessage", u.getMessage());
	}
	return userForm(model);
}

@PostMapping("/editUser/changePassword")
public ResponseEntity<String> postEditUserChangePassword(@Valid @RequestBody ChangePasswordForm form, Errors errors,
		BindingResult results) {
	LOG.info(MainClassUser.METODO + " postEditUserChangePassword()");
	try {
		if (errors.hasErrors()) {
			String result = errors.getAllErrors().stream().map(x -> x.getDefaultMessage())
					.collect(Collectors.joining(""));
			LOG.info("TEMPLATE: 'changePassword' -- DATA: result '" + result + "'");

		}
		userService.changePassword(form);
	} catch (CustomeFieldValidationException cfve) {
		results.rejectValue(cfve.getFieldName(), null, cfve.getMessage());
		return ResponseEntity.badRequest().body(cfve.getMessage());
	}

	catch (Exception e) {
		LOG.info("TEMPLATE: 'changePassword' -- DATA: e '" + e.getMessage() + "'");
		return ResponseEntity.badRequest().body(e.getMessage());
	}
	LOG.info("redirect to userForm");
	return ResponseEntity.ok("Success");
}

}

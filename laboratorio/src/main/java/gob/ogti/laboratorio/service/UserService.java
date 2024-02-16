package gob.ogti.laboratorio.service;

import java.util.List;

import gob.ogti.laboratorio.dto.ChangePasswordForm;
import gob.ogti.laboratorio.entity.User;
import gob.ogti.laboratorio.exception.CustomeFieldValidationException;
import gob.ogti.laboratorio.exception.UsernameOrIdNotFound;



public interface UserService {
	
	public Iterable<User> getAllUsers();

	public User createUser(User user) throws CustomeFieldValidationException;

	public User getUserById(Long id) throws UsernameOrIdNotFound;

	public User updateUser(User user) ;

	public void deleteUser(Long id) throws UsernameOrIdNotFound;

	public User changePassword(ChangePasswordForm form) throws CustomeFieldValidationException;

	public boolean isLoggedUserADMIN();
	
	public User getLoggedUser();

	public boolean isLoggedUserUSER();

	public boolean isLoggedUserESPECIALISTA();

	public boolean isLoggedUserCOORDINADOR();
	
	public boolean isLoggedUserRADIOLOGO();

	public boolean isLoggedUserSOPORTE();
	
	List <User> findByRoleParaAsignar();
	
	List <User> findByRoleCoordinador();
	
	List <User> usuariosActivos();



}

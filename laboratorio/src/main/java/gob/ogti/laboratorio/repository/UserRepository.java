package gob.ogti.laboratorio.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import gob.ogti.laboratorio.entity.User;



@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	public Optional<User> findByUsername(String username);
	
	@Query("select u from User u where u.estado='1'")
	public Optional<User> findByEstado();

	public Optional<User> findByLastName(String lastName);

	@Query(value = "select * from CENATE_USER T inner join CENATE_USER_ROLES U "
			+ "	ON U.USER_ID=T.ID where U.ROLE_ID in ('5','2') and T.estado='1' ", nativeQuery = true)
	List<User> findByRoleParaAsignar();
	
	@Query(value = "select * from CENATE_USER T inner join CENATE_USER_ROLES U "
			+ "	ON U.USER_ID=T.ID where U.ROLE_ID='3' and T.estado='1' ", nativeQuery = true)
	List<User> findByRoleCoordinador();
	
	@Query("select u from User u where u.estado='1'")
	List <User> usuariosActivos();

}

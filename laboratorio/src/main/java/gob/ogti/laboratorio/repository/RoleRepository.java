package gob.ogti.laboratorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import gob.ogti.laboratorio.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	public Role findByName (String name);

}

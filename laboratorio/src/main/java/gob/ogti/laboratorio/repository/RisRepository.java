package gob.ogti.laboratorio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.ogti.laboratorio.entity.Ris;


@Repository
public interface RisRepository extends JpaRepository<Ris, Long> {
	
	@Query("select r.descripcionRis from Ris r where r.idRis=:id")
	String buscarNomRis (@Param ("id") String id);
	
	

}

package gob.ogti.laboratorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.ogti.laboratorio.entity.Establecimiento;

@Repository
public interface EstablecimientoRepository extends JpaRepository<Establecimiento, Long> {
	
	@Query("select e from Establecimiento e order by descripcionEstablecimiento")
	public List<Establecimiento>listaEstablecimientos();
	
	@Query("select e from Establecimiento e where e.ris.codRis=:ris order by descripcionEstablecimiento")
	public List<Establecimiento>listaEstablecimientosRis(@Param("ris")String ris);
	
	@Query("select e.ris.codRis from Establecimiento e where e.codEstablecimiento=:esta")
	String buscarRisEsta (@Param ("esta") String esta);
	
	@Query("select e.descripcionEstablecimiento from Establecimiento e where e.codEstablecimiento=:esta")
	String buscarNomEsta (@Param ("esta") String esta);

}
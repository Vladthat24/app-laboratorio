package gob.ogti.laboratorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.ogti.laboratorio.entity.Bioquimica;
import gob.ogti.laboratorio.entity.Hematologia;

@Repository
public interface HematologiaRepository extends JpaRepository<Hematologia, Long> {
	
	@Query(value = "select \r\n"
			+ "e.descripcion_establecimiento,\r\n"
			+ "IFNULL((select sum(h.total_hema) from ogti_laboratorio_hematologia h\r\n"
			+ "where date_format(concat('0000-',h.mes_hem,'-00'),'%m') >=:mes "
			+ " and date_format(concat('0000-',h.mes_hem,'-00'),'%m')<=:mes2 and h.ano_hem=:ano and h.cod_estado='1'\r\n"
			+ "and h.cod_establecimiento=e.cod_establecimiento),0)as total_hema\r\n"
			+ "from ogti_laboratorio_establecimiento e\r\n"
			+ "inner join ogti_laboratorio_ris r on r.cod_ris=e.cod_ris\r\n"
			+ "where r.cod_ris=:ris and e.laboratorio='1'\r\n"
			+ "group by e.descripcion_establecimiento,e.cod_establecimiento\r\n"
			+ "order by e.descripcion_establecimiento asc", nativeQuery = true)
	List<Object[]> reporteHematologia(@Param("ano") String ano, @Param("mes") String mes,@Param("ris") String ris,@Param("mes2") String mes2);
	
	@Query("select b from Hematologia b")
	List<Object[]> reporteConsololidad();
	
	@Query("select h from Hematologia h where h.idHematologia=:id")
	Hematologia buscarHematologia(long id);
	
	@Query("select h from Hematologia h where h.anoHem=:ano and h.mesHem=:mes")
	List <Hematologia> listaHematologia(@Param("ano") String ano, @Param("mes") String mes);

}

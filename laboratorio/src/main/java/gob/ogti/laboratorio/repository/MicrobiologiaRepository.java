package gob.ogti.laboratorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.ogti.laboratorio.entity.Microbiologia;

@Repository
public interface MicrobiologiaRepository extends JpaRepository<Microbiologia, Long> {

	@Query(value = "select " + "e.descripcion_establecimiento, "
			+ "IFNULL((select sum(m.total_mic) from ogti_laboratorio_microbiologia m "
			+ "where date_format(concat('0000-',m.mes_mic,'-00'),'%m') >=:mes"
			+ " and date_format(concat('0000-',m.mes_mic,'-00'),'%m')<=:mes2 and m.ano_mic=:ano and m.cod_estado='1' "
			+ "and m.cod_establecimiento=e.cod_establecimiento),0)as total_micro "
			+ "from ogti_laboratorio_establecimiento e " + "inner join ogti_laboratorio_ris r on r.cod_ris=e.cod_ris "
			+ "where r.cod_ris=:ris and e.laboratorio='1' "
			+ "group by e.descripcion_establecimiento,e.cod_establecimiento "
			+ "order by e.descripcion_establecimiento asc", nativeQuery = true)
	List<Object[]> reporteMicrobiologia(@Param("ano") String ano, @Param("mes") String mes, @Param("ris") String ris,
			@Param("mes2") String mes2);

	@Query("select m from Microbiologia m")
	List<Object[]> reporteConsololidad();

	@Query("select m from Microbiologia m where m.anoMic=:ano and m.mesMic=:mes")
	List<Microbiologia> listaMicrobiologia(String ano, String mes);

	@Query("select m from Microbiologia m where m.idMicrobiologia=:id")
	Microbiologia buscarMicrobiologia(long id);

}

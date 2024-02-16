package gob.ogti.laboratorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.ogti.laboratorio.entity.ControlCalidad;

@Repository
public interface ControlCalidadRepository extends JpaRepository<ControlCalidad, Long> {
	
	@Query(value = "select " + "e.descripcion_establecimiento, "
			+ "IFNULL((select sum(i.total_control) from ogti_laboratorio_control_calidad i "
			+ "where date_format(concat('0000-', i.mes_control,'-00'),'%m')>=:mes"
			+ " and  date_format(concat('0000-', i.mes_control,'-00'),'%m')<=:mes2 and i.ano_control=:ano and i.cod_estado='1' "
			+ "and i.cod_establecimiento=e.cod_establecimiento),0)as total_hema "
			+ "from ogti_laboratorio_establecimiento e " + "inner join ogti_laboratorio_ris r on r.cod_ris=e.cod_ris "
			+ "where r.cod_ris=:ris and e.laboratorio='1' "
			+ "group by e.descripcion_establecimiento,e.cod_establecimiento "
			+ "order by e.descripcion_establecimiento asc", nativeQuery = true)
	List<Object[]> reporteControlCalidad(@Param("ano") String ano, @Param("mes") String mes, @Param("ris") String ris, 
			@Param("mes2") String mes2);

	@Query("select cc from ControlCalidad cc where cc.anoControl=:ano and cc.mesControl=:mes")
	List<ControlCalidad> listaControlCalidad(String ano, String mes);

	@Query("select cc from ControlCalidad cc where cc.idControl=:id")
	ControlCalidad buscarControl(long id);

}

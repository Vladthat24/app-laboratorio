package gob.ogti.laboratorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.ogti.laboratorio.entity.TomaPruebaCovid19;

@Repository
public interface TomaPruebaCovid19Repository extends JpaRepository<TomaPruebaCovid19, Long>{
	
	@Query(value = "select " + "e.descripcion_establecimiento, "
			+ "IFNULL((select sum(m.total_tp_covid-m.ingreso_datos_siscovid) from ogti_laboratorio_toma_prueba_covid m "
			+ "where date_format(concat('0000-',m.mes_tpc,'-00'),'%m') >=:mes"
			+ " and date_format(concat('0000-',m.mes_tpc,'-00'),'%m')<=:mes2 and m.ano_tpc=:ano and m.cod_estado='1' "
			+ "and m.cod_establecimiento=e.cod_establecimiento),0)as total_micro "
			+ "from ogti_laboratorio_establecimiento e " + "inner join ogti_laboratorio_ris r on r.cod_ris=e.cod_ris "
			+ "where r.cod_ris=:ris and e.laboratorio='1' "
			+ "group by e.descripcion_establecimiento,e.cod_establecimiento "
			+ "order by e.descripcion_establecimiento asc", nativeQuery = true)
	List<Object[]> reporteTomaMuestrasCovid19(@Param("ano") String ano, @Param("mes") String mes, @Param("ris") String ris,
			@Param("mes2") String mes2);
	
	@Query(value = "select " + "e.descripcion_establecimiento, "
			+ "IFNULL((select sum(m.ingreso_datos_siscovid) from ogti_laboratorio_toma_prueba_covid m "
			+ "where date_format(concat('0000-',m.mes_tpc,'-00'),'%m')>=:mes "
			+ " and date_format(concat('0000-',m.mes_tpc,'-00'),'%m')<=:mes2 and m.ano_tpc=:ano and m.cod_estado='1' "
			+ "and m.cod_establecimiento=e.cod_establecimiento),0)as total_micro "
			+ "from ogti_laboratorio_establecimiento e " + "inner join ogti_laboratorio_ris r on r.cod_ris=e.cod_ris "
			+ "where r.cod_ris=:ris and e.laboratorio='1' "
			+ "group by e.descripcion_establecimiento,e.cod_establecimiento "
			+ "order by e.descripcion_establecimiento asc", nativeQuery = true)
	List<Object[]> reporteRegistroSisCovid19(@Param("ano") String ano, @Param("mes") String mes, @Param("ris") String ris,
			@Param("mes2") String mes2);

	@Query("select m from TomaPruebaCovid19 m where m.anoTpc=:ano and m.mesTpc=:mes")
	List<TomaPruebaCovid19> listaMpcovid19(@Param("ano") String ano, @Param("mes") String mes);
	
	@Query("select m from TomaPruebaCovid19 m where m.idTpCovid=:id")
	TomaPruebaCovid19 buscarMpcovid19(@Param("id") long id);

}

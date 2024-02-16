package gob.ogti.laboratorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.ogti.laboratorio.entity.Inmunologia;

@Repository
public interface InmunologiaRepository extends JpaRepository<Inmunologia, Long> {

	@Query(value = "select " + "e.descripcion_establecimiento, "
			+ "IFNULL((select sum(i.total_inm) from ogti_laboratorio_inmunologia i "
			+ "where date_format(concat('0000-',i.mes_inm,'-00'),'%m') >=:mes"
			+ " and date_format(concat('0000-',i.mes_inm,'-00'),'%m')<=:mes2 and i.ano_inm=:ano and i.cod_estado='1' "
			+ "and i.cod_establecimiento=e.cod_establecimiento),0)as total_hema "
			+ "from ogti_laboratorio_establecimiento e " + "inner join ogti_laboratorio_ris r on r.cod_ris=e.cod_ris "
			+ "where r.cod_ris=:ris and e.laboratorio='1' "
			+ "group by e.descripcion_establecimiento,e.cod_establecimiento "
			+ "order by e.descripcion_establecimiento asc", nativeQuery = true)
	List<Object[]> reporteInmunologia(@Param("ano") String ano, @Param("mes") String mes, @Param("ris") String ris,
			@Param("mes2") String mes2);

	@Query("select b from Inmunologia b")
	List<Object[]> reporteConsololidad();

	@Query("select i from Inmunologia i where i.idInmunologia=:id")
	Inmunologia buscarInmunologia(long id);

	@Query("select i from Inmunologia i where i.anoInm=:ano and i.mesInm=:mes")
	List<Inmunologia> listaInmunologia(@Param("ano") String ano, @Param("mes") String mes);
	
	@Query("select i from Inmunologia i where i.anoInm=:ano and i.mesInm=:mes and i.estadoInm.codEstado=:estado"
			+ " and i.establecimientoInm.codEstablecimiento=:esta")
	Inmunologia verificarNewInmu(@Param("ano") String ano, @Param("mes") String mes, @Param("estado") String estado,
			@Param("esta") String esta);

}

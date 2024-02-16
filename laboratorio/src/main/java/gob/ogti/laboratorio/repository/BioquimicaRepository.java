package gob.ogti.laboratorio.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gob.ogti.laboratorio.entity.Bioquimica;

@Repository
public interface BioquimicaRepository extends JpaRepository<Bioquimica, Long> {

	@Query(value = "select " + "e.descripcion_establecimiento, "
			+ "IFNULL((select sum(b.total_bio) from ogti_laboratorio_bioquimica b "
			+ "where date_format(concat('0000-',b.mes_bio,'-00'),'%m')>=:mes and "
			+ " date_format(concat('0000-',b.mes_bio,'-00'),'%m')<=:mes2 and b.ano_bio=:ano and b.cod_estado='1' "
			+ "and b.cod_establecimiento=e.cod_establecimiento),0)as total_bio "
			+ "from ogti_laboratorio_establecimiento e " + "inner join ogti_laboratorio_ris r on r.cod_ris=e.cod_ris "
			+ "where r.cod_ris=:ris and e.laboratorio='1' "
			+ "group by e.descripcion_establecimiento,e.cod_establecimiento "
			+ "order by e.descripcion_establecimiento asc", nativeQuery = true)
	List<Object[]> reporteBioquimica(@Param("ano") String ano, @Param("mes") String mes, @Param("ris") String ris,
			@Param("mes2") String mes2);

	@Query("select b from Bioquimica b")
	List<Object[]> reporteConsololidad();

	@Query("select b from Bioquimica b where b.idBioquimica=:id")
	Bioquimica buscarBioquimica(long id);

	@Query("select b from Bioquimica b where b.anoBio=:ano and b.mesBio=:mes")
	List<Bioquimica> listaBioquimica(@Param("ano") String ano, @Param("mes") String mes);
	
	@Query(value="\r\n"
			+ "select e.descripcion_establecimiento,\r\n"
			+ "    x.mes_hem,\r\n"
			+ "    x.ano_hem,\r\n"
			+ "(IFNULL((select sum(h.total_hema) from ogti_laboratorio_hematologia h\r\n"
			+ "			where h.mes_hem=x.mes_hem and h.ano_hem=x.ano_hem and h.cod_estado='1'\r\n"
			+ "			and h.cod_establecimiento=e.cod_establecimiento),0) +\r\n"
			+ "            \r\n"
			+ "IFNULL((select sum(b.total_bio) from ogti_laboratorio_bioquimica b\r\n"
			+ "			where b.mes_bio=x.mes_hem and b.ano_bio=x.ano_hem and b.cod_estado='1'\r\n"
			+ "			and b.cod_establecimiento=e.cod_establecimiento),0) +\r\n"
			+ "            \r\n"
			+ "IFNULL((select sum(i.total_inm) from ogti_laboratorio_inmunologia i\r\n"
			+ "			where i.mes_inm=x.mes_hem and i.ano_inm=x.ano_hem and i.cod_estado='1'\r\n"
			+ "			and i.cod_establecimiento=e.cod_establecimiento),0) +\r\n"
			+ "            \r\n"
			+ "IFNULL((select sum(m.total_mic) from ogti_laboratorio_microbiologia m\r\n"
			+ "			where m.mes_mic=x.mes_hem and m.ano_mic=x.ano_hem and m.cod_estado='1'\r\n"
			+ "			and m.cod_establecimiento=e.cod_establecimiento),0) ) as ANALISIS_CLINICOS,\r\n"
			+ "            \r\n"
			+ "IFNULL((select sum(cc.total_control) from ogti_laboratorio_control_calidad cc \r\n"
			+ "			where cc.mes_control=x.mes_hem and cc.ano_control=x.ano_hem and cc.cod_estado='1' \r\n"
			+ "			and cc.cod_establecimiento=e.cod_establecimiento),0) AS CONTROL_CALIDAD,\r\n"
			+ "            \r\n"
			+ "IFNULL((select sum(md.total_mue) from ogti_laboratorio_muestras_deribadas_ins md \r\n"
			+ "			where md.mes_ins=x.mes_hem and md.ano_ins=x.ano_hem and md.cod_estado='1' \r\n"
			+ "			and md.cod_establecimiento=e.cod_establecimiento),0) as MUESTRAS_DERIVADAS,\r\n"
			+ "            \r\n"
			+ "IFNULL((select sum(tm.total_tp_covid-tm.ingreso_datos_siscovid) from ogti_laboratorio_toma_prueba_covid tm \r\n"
			+ "			where tm.mes_tpc=x.mes_hem and tm.ano_tpc=x.ano_hem and tm.cod_estado='1' \r\n"
			+ "			and tm.cod_establecimiento=e.cod_establecimiento),0) AS TOMA_PRUEBA_COVID,\r\n"
			+ "            \r\n"
			+ "IFNULL((select sum(idc.ingreso_datos_siscovid) from ogti_laboratorio_toma_prueba_covid idc \r\n"
			+ "			where idc.mes_tpc=x.mes_hem and idc.ano_tpc=x.ano_hem and idc.cod_estado='1' \r\n"
			+ "			and idc.cod_establecimiento=e.cod_establecimiento),0) AS ING_DATOS_SISCOVID\r\n"
			+ " \r\n"
			+ " from ogti_laboratorio_establecimiento e \r\n"
			+ " inner join ogti_laboratorio_ris r on r.cod_ris=e.cod_ris\r\n"
			+ " inner join ogti_laboratorio_hematologia x on x.cod_establecimiento=e.cod_establecimiento\r\n"
			+ " where e.laboratorio='1'  and r.cod_ris=:ris and e.cod_establecimiento=:esta\r\n"
			+ " and date_format(concat('0000-',x.mes_hem,'-00'),'%m')>=:mes and "
					+ " date_format(concat('0000-',x.mes_hem,'-00'),'%m')<=:mes2 and x.ano_hem=:ano\r\n"
			+ " group by x.mes_hem, x.ano_hem,e.descripcion_establecimiento,e.cod_establecimiento\r\n"
			+ " order by x.ano_hem, cast(x.mes_hem as decimal),e.descripcion_establecimiento asc", nativeQuery = true)
	List<Object[]> reporteTotAct(@Param ("ris") String ris, @Param ("esta") String esta,
			@Param ("mes") String mes, @Param ("mes2") String mes2,@Param ("ano") String ano);
	
	@Query(value="select e.descripcion_establecimiento, "
			+ "  x.mes_hem, "
			+ "   x.ano_hem, "
			+ " IFNULL((select sum(h.total_hema) from ogti_laboratorio_hematologia h "
			+ "			where h.mes_hem=x.mes_hem and h.ano_hem=x.ano_hem and h.cod_estado='1' "
			+ "			and h.cod_establecimiento=e.cod_establecimiento),0) as hema , "
			+ " IFNULL((select sum(b.total_bio) from ogti_laboratorio_bioquimica b "
			+ "			where b.mes_bio=x.mes_hem and b.ano_bio=x.ano_hem and b.cod_estado='1' "
			+ "			and b.cod_establecimiento=e.cod_establecimiento),0) as bio, "
			+ " IFNULL((select sum(i.total_inm) from ogti_laboratorio_inmunologia i "
			+ "			where i.mes_inm=x.mes_hem and i.ano_inm=x.ano_hem and i.cod_estado='1' "
			+ "			and i.cod_establecimiento=e.cod_establecimiento),0) as inmu , "
			+ " IFNULL((select sum(m.total_mic) from ogti_laboratorio_microbiologia m "
			+ "			where m.mes_mic=x.mes_hem and m.ano_mic=x.ano_hem and m.cod_estado='1'  "
			+ "			and m.cod_establecimiento=e.cod_establecimiento),0)  as micro "
			+ " from ogti_laboratorio_establecimiento e  "
			+ " inner join ogti_laboratorio_ris r on r.cod_ris=e.cod_ris "
			+ " inner join ogti_laboratorio_hematologia x on x.cod_establecimiento=e.cod_establecimiento "
			+ " where e.laboratorio='1'  and r.cod_ris=:ris and e.cod_establecimiento=:esta "
			+ " and date_format(concat('0000-',x.mes_hem,'-00'),'%m')>=:mes and "
			+ " date_format(concat('0000-',x.mes_hem,'-00'),'%m')<=:mes2 and x.ano_hem=:ano "
			+ " group by x.mes_hem, x.ano_hem,e.descripcion_establecimiento,e.cod_establecimiento "
			+ " order by x.ano_hem, cast(x.mes_hem as decimal),e.descripcion_establecimiento asc ", nativeQuery = true)
	List<Object[]> reporteTotExaCli(@Param ("ris") String ris, @Param ("esta") String esta,
			@Param ("mes") String mes, @Param ("mes2") String mes2,@Param ("ano") String ano);
	
	

}

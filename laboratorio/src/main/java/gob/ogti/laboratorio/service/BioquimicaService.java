package gob.ogti.laboratorio.service;

import java.util.List;

import gob.ogti.laboratorio.dto.ReporteGlobalActividades;
import gob.ogti.laboratorio.dto.reporteAnalisisClinicos;
import gob.ogti.laboratorio.entity.Bioquimica;

public interface BioquimicaService {

	void nuevoBioquimica(Bioquimica b, String clientIp);

	List<Object[]> reporteBioquimica(String ano, String mes, String ris, String mes2);

	List<Object[]> reporteAnalisisTotal(String ano, String mes, String ris, String mes2);

	List<Object[]> reporteConsololidad();

	void editarBioquimica(Bioquimica b, String clientIp);

	Bioquimica buscarBioquimica(long id);

	List<Bioquimica> listaBioquimica(String ano, String mes);

	List<reporteAnalisisClinicos> tablaAnalisisClinicos(String ris, String esta, String mes, String mes2, String ano);

	List<ReporteGlobalActividades> reporteTotAct(String ris, String esta, String mes, String mes2, String ano);

}

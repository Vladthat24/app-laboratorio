package gob.ogti.laboratorio.service;

import java.util.List;

import javax.validation.Valid;

import gob.ogti.laboratorio.entity.TomaPruebaCovid19;

public interface TomaMuestraCovid19Service {
	
	void nuevoTomaMuestraCovid19(TomaPruebaCovid19 tpc, String ip);
	
	List<Object[]> reporteTomaMuestrasCovid19(String ano, String mes, String ris, String mes2);
	
	List<Object[]> reporteRegistroSisCovid19(String ano, String mes, String ris, String mes2);

	List<TomaPruebaCovid19> listaMpcovid19(String ano, String mes);

	TomaPruebaCovid19 buscarMpcovid19(long id);

	void editarMpcovid19(TomaPruebaCovid19 mpcovid19, String clientIp);

}

package gob.ogti.laboratorio.service;

import java.util.List;

import javax.validation.Valid;

import gob.ogti.laboratorio.entity.ControlCalidad;
import gob.ogti.laboratorio.entity.Hematologia;

public interface HematologiaService {
	
	void nuevoHematologia (Hematologia h, String clientIp);
	
	List<Object[]> reporteHematologia(String ano, String mes, String ris, String mes2);
	
	void nuevoControlCalidad(ControlCalidad cc, String ip);
	
	List<Object[]> reporteControlCalidad(String ano, String mes, String ris, String mes2);
	
	Hematologia buscarHematologia (long id);
	
	List <Hematologia> listaHematologia(String ano, String mes);
	
	void editarHematologia (Hematologia h, String clientIp);

	List<ControlCalidad> listaControlCalidad(String ano, String mes);

	ControlCalidad buscarControl(long id);

	void editarControl(ControlCalidad controlCalidad, String clientIp);

}

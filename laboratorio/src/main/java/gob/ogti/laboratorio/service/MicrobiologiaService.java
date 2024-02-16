package gob.ogti.laboratorio.service;

import java.util.List;

import gob.ogti.laboratorio.entity.Microbiologia;

public interface MicrobiologiaService {
	
	void nuevoMicrobiologia (Microbiologia m, String rq);
	
	List<Object[]> reporteMicrobiologia(String ano, String mes, String ris, String mes2);

	List<Microbiologia> listaMicrobiologia(String ano, String mes);

	Microbiologia buscarMicrobiologia(long id);

	void editarMicrobiologia(Microbiologia microbiologia, String clientIp);

}

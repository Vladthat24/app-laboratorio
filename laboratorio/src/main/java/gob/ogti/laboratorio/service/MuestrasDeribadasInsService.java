package gob.ogti.laboratorio.service;

import java.util.List;

import gob.ogti.laboratorio.entity.MuestrasDerivadasIns;

public interface MuestrasDeribadasInsService {
	
	void nuevoMuestraDerivadaIns (MuestrasDerivadasIns md, String ip);
	
	List<Object[]> reporteMuestrasDeribadas(String ano, String mes, String ris, String mes2);

	List<MuestrasDerivadasIns> listaIns(String ano, String mes);

	MuestrasDerivadasIns buscarIns(long id);

	void editarIns(MuestrasDerivadasIns ins, String clientIp);

}

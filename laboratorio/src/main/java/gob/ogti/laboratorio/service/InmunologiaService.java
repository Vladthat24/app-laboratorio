package gob.ogti.laboratorio.service;

import java.util.List;

import gob.ogti.laboratorio.entity.Inmunologia;

public interface InmunologiaService {
	
	void nuevoInmunologia (Inmunologia i, String clientIp);
	
	List<Object[]> reporteInmunologia(String ano, String mes, String ris, String mes2);
	
	Inmunologia buscarInmunologia (long id);
	
	List <Inmunologia> listaInmunologia(String ano, String mes);
	
	void editarInmunologia (Inmunologia i, String clientIp);
	
	Inmunologia verificarNewInmu(String ano,  String mes, String estado, String esta);

}

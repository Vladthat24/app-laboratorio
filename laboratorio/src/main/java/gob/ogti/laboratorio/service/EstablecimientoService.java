package gob.ogti.laboratorio.service;

import java.util.List;

import gob.ogti.laboratorio.entity.Establecimiento;


public interface EstablecimientoService {
	
	List<Establecimiento>listaEstablecimientos();
	
	public List<Establecimiento>listaEstablecimientosRis(String ris);
	
	String buscarRisEsta (String esta);
	
	String buscarNomEsta(String esta);

}

package gob.ogti.laboratorio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.ogti.laboratorio.entity.Establecimiento;
import gob.ogti.laboratorio.repository.EstablecimientoRepository;
import gob.ogti.laboratorio.service.EstablecimientoService;


@Service
public class EstablecimientoServiceImpl implements EstablecimientoService{
	
	@Autowired
	EstablecimientoRepository er;

	@Override
	public List<Establecimiento> listaEstablecimientos() {
		
		return er.listaEstablecimientos();
	}

	@Override
	public List<Establecimiento> listaEstablecimientosRis(String ris) {
		
		return er.listaEstablecimientosRis(ris);
	}

	@Override
	public String buscarRisEsta(String esta) {
		
		return er.buscarRisEsta(esta);
	}

	@Override
	public String buscarNomEsta(String esta) {
		
		return er.buscarNomEsta(esta);
	}

}

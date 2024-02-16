package gob.ogti.laboratorio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.ogti.laboratorio.entity.Estado;
import gob.ogti.laboratorio.repository.EstadoRepository;
import gob.ogti.laboratorio.service.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService{
	
	@Autowired
	EstadoRepository er;

	@Override
	public List<Estado> estados() {
		
		return er.findAll();
	}

}

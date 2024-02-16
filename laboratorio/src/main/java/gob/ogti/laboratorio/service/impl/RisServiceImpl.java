package gob.ogti.laboratorio.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.ogti.laboratorio.entity.Ris;
import gob.ogti.laboratorio.repository.RisRepository;
import gob.ogti.laboratorio.service.RisService;


@Service
public class RisServiceImpl implements RisService{
	
	@Autowired
	RisRepository rr;
	
	@Override
	public List<Ris> listaRis() {
		
		return rr.findAll();
	}

}

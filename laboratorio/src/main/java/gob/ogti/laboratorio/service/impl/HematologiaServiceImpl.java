package gob.ogti.laboratorio.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.ogti.laboratorio.entity.ControlCalidad;
import gob.ogti.laboratorio.entity.Hematologia;
import gob.ogti.laboratorio.repository.ControlCalidadRepository;
import gob.ogti.laboratorio.repository.HematologiaRepository;
import gob.ogti.laboratorio.service.HematologiaService;
import gob.ogti.laboratorio.service.UserService;

@Service
public class HematologiaServiceImpl implements HematologiaService{
	
	@Autowired
	UserService us;
	
	@Autowired
	HematologiaRepository hr;
	
	@Autowired
	ControlCalidadRepository ccr;

	@Override
	public void nuevoHematologia(Hematologia h, String clientIp) {
		
		Hematologia hm = new Hematologia();
		hm.setAnoHem(h.getAnoHem());
		hm.setEstablecimiento(us.getLoggedUser().getEstablecimiento());
		hm.setMesHem(h.getMesHem());
		hm.setHemoglobina(h.getHemoglobina());
		hm.setHematocrito(h.getHematocrito());
		hm.setHemogramaManual(h.getHemogramaManual());
		hm.setHemogramaAutomatizado(h.getHemogramaAutomatizado());
		hm.setGotaGruesa(h.getGotaGruesa());
		hm.setVelocSedimentGlobular(h.getVelocSedimentGlobular());
		hm.setgSanguineoFactorRh(h.getgSanguineoFactorRh());
		hm.setTiempoCoagulacion(h.getTiempoCoagulacion());
		hm.setTiempoSangria(h.getTiempoSangria());
		hm.setRecuentoPlaquetas(h.getRecuentoPlaquetas());
		hm.setRecuentoReticulocitos(h.getRecuentoReticulocitos());
		hm.setTiempoTromboplastinaParcialActivado(h.getTiempoTromboplastinaParcialActivado());
		hm.setTiempoProtrombina(h.getTiempoProtrombina());
		hm.setConstantesCorpusculares(h.getConstantesCorpusculares());
		hm.setFrotisSangrePeriferica(h.getFrotisSangrePeriferica());
		hm.setTotalHema(h.getTotalHema());
		hm.setEstadoHema(h.getEstadoHema());
		hm.setOtras_pruebas(h.getOtras_pruebas());
		
		hm.setUsuarioRegHem(us.getLoggedUser().getUsername());
		hm.setFechaRegHem(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		hm.setIpRegHem(clientIp);
		hm.setHemoglobinaHemoglobimetro(h.getHemoglobinaHemoglobimetro());
		
		hr.save(hm);
		
		
	}

	@Override
	public List<Object[]> reporteHematologia(String ano, String mes,String ris, String mes2) {
		return hr.reporteHematologia(ano, mes, ris,mes2);
	}

	@Override
	public void nuevoControlCalidad(ControlCalidad cc, String ip) {
		ControlCalidad c = new ControlCalidad();
		c.setAnoControl(cc.getAnoControl());
		c.setMesControl(cc.getMesControl());
		c.setUsuarioControl(us.getLoggedUser().getUsername());
		c.setFechaRegControl(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		c.setIpRegControl(ip);
		c.setEstadoControl(cc.getEstadoControl());
		c.setTotalControl(cc.getTotalControl());
		c.setBk(cc.getBk());
		c.setGotaGruesa(cc.getGotaGruesa());
		c.setEstablecimientoControl(us.getLoggedUser().getEstablecimiento());
		c.setContrCalExtHem(cc.getContrCalExtHem());
		c.setContrCalIntHem(cc.getContrCalIntHem());
		c.setContrCalIntBio(cc.getContrCalIntBio());
		c.setContrCalExtBio(cc.getContrCalExtBio());
		c.setOtrosContrCal(cc.getOtrosContrCal());
		
		ccr.save(c);
		
	}

	@Override
	public List<Object[]> reporteControlCalidad(String ano, String mes, String ris, String mes2) {
		
		return ccr.reporteControlCalidad(ano, mes, ris,mes2);
	}

	@Override
	public Hematologia buscarHematologia(long id) {
		
		return hr.buscarHematologia(id);
	}

	@Override
	public List<Hematologia> listaHematologia(String ano, String mes) {
		
		return hr.listaHematologia(ano, mes);
	}

	@Override
	public void editarHematologia(Hematologia h, String clientIp) {
		
		Hematologia hm = buscarHematologia(h.getIdHematologia());
		hm.setAnoHem(h.getAnoHem());
		hm.setMesHem(h.getMesHem());
		hm.setHemoglobina(h.getHemoglobina());
		hm.setHematocrito(h.getHematocrito());
		hm.setHemogramaManual(h.getHemogramaManual());
		hm.setHemogramaAutomatizado(h.getHemogramaAutomatizado());
		hm.setGotaGruesa(h.getGotaGruesa());
		hm.setVelocSedimentGlobular(h.getVelocSedimentGlobular());
		hm.setgSanguineoFactorRh(h.getgSanguineoFactorRh());
		hm.setTiempoCoagulacion(h.getTiempoCoagulacion());
		hm.setTiempoSangria(h.getTiempoSangria());
		hm.setRecuentoPlaquetas(h.getRecuentoPlaquetas());
		hm.setRecuentoReticulocitos(h.getRecuentoReticulocitos());
		hm.setTiempoTromboplastinaParcialActivado(h.getTiempoTromboplastinaParcialActivado());
		hm.setTiempoProtrombina(h.getTiempoProtrombina());
		hm.setConstantesCorpusculares(h.getConstantesCorpusculares());
		hm.setFrotisSangrePeriferica(h.getFrotisSangrePeriferica());
		hm.setTotalHema(h.getTotalHema());
		hm.setEstadoHema(h.getEstadoHema());
		
		hm.setUsuarioModHem(us.getLoggedUser().getUsername());
		hm.setFechaModHem(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		hm.setIpModHem(clientIp);
		hm.setHemoglobinaHemoglobimetro(h.getHemoglobinaHemoglobimetro());
		hm.setOtras_pruebas(h.getOtras_pruebas());
		
		hr.save(hm);
	}

	@Override
	public List<ControlCalidad> listaControlCalidad(String ano, String mes) {
		
		return ccr.listaControlCalidad(ano, mes);
	}

	@Override
	public ControlCalidad buscarControl(long id) {
	
		return ccr.buscarControl(id);
	}

	@Override
	public void editarControl(ControlCalidad cc, String ip) {
		ControlCalidad c = buscarControl(cc.getIdControl());
		c.setAnoControl(cc.getAnoControl());
		c.setMesControl(cc.getMesControl());
		c.setUsuarioModControl(us.getLoggedUser().getUsername());
		c.setFechaModControl(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		c.setIpModControl(ip);
		c.setEstadoControl(cc.getEstadoControl());
		c.setTotalControl(cc.getTotalControl());
		c.setBk(cc.getBk());
		c.setGotaGruesa(cc.getGotaGruesa());
		c.setContrCalExtHem(cc.getContrCalExtHem());
		c.setContrCalIntHem(cc.getContrCalIntHem());
		c.setContrCalIntBio(cc.getContrCalIntBio());
		c.setContrCalExtBio(cc.getContrCalExtBio());
		c.setOtrosContrCal(cc.getOtrosContrCal());
		ccr.save(c);
		
	}

}

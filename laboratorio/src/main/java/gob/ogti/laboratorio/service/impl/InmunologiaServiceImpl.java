package gob.ogti.laboratorio.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.ogti.laboratorio.entity.Inmunologia;
import gob.ogti.laboratorio.repository.InmunologiaRepository;
import gob.ogti.laboratorio.service.InmunologiaService;
import gob.ogti.laboratorio.service.UserService;

@Service
public class InmunologiaServiceImpl implements InmunologiaService{
	

	@Autowired
	UserService us;
	
	@Autowired
	InmunologiaRepository ir;

	@Override
	public void nuevoInmunologia(Inmunologia i, String clientIp) {
		
		Inmunologia in = new Inmunologia();
		in.setAnoInm(i.getAnoInm());
		in.setMesInm(i.getMesInm());
		in.setUsuarioRegInm(us.getLoggedUser().getUsername());
		in.setFechaRegInm(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		in.setEstablecimientoInm(us.getLoggedUser().getEstablecimiento());
		in.setIpRegInm(clientIp);
		in.setEstadoInm(i.getEstadoInm());
		
		in.setIdentifAcTificoH(i.getIdentifAcTificoH());
		in.setIdentifAcTificoO(i.getIdentifAcTificoO());
		in.setIdentifAcParatificoA(i.getIdentifAcParatificoA());
		in.setIdentifAcParatificoB(i.getIdentifAcParatificoB());
		in.setIdentifAcBrucella(i.getIdentifAcBrucella());
		in.setTestRosaBengalaBrucella(i.getTestRosaBengalaBrucella());
		in.setIdentificacionAcHivPruebaRapida(i.getIdentificacionAcHivPruebaRapida());
		in.setIdentificacionAcHivElisa(i.getIdentificacionAcHivElisa());
		in.setTestRpr(i.getTestRpr());
		in.setTestProteinaCReactivaLatex(i.getTestProteinaCReactivaLatex());
		in.setDosajeHormonaSubUnidadBetaHcg(i.getDosajeHormonaSubUnidadBetaHcg());
		in.setTestFactorReumatoide(i.getTestFactorReumatoide());
		in.setTestAntigenoProstaticoEspecíficoPsa(i.getTestAntigenoProstaticoEspecíficoPsa());
		in.setTestAntiestreptolisinaOAso(i.getTestAntiestreptolisinaOAso());
		in.setHelicobacterPiloryElisaIgm(i.getHelicobacterPiloryElisaIgm());
		in.setTestRotavirus(i.getTestRotavirus());
		in.setHepatitisBAcContraAgSuperficie(i.getHepatitisBAcContraAgSuperficie());
		in.setTestEmbarazoPr(i.getTestEmbarazoPr());
		in.setTotalInm(i.getTotalInm());
		in.setPruebaDualHivSifilis(i.getPruebaDualHivSifilis());
		in.setPruebaRapidaSifilis(i.getPruebaRapidaSifilis());
		in.setPerfilTiroT3Libre(i.getPerfilTiroT3Libre());
		in.setPerfilTiroT4Libre(i.getPerfilTiroT4Libre());
		in.setPerfilTiroTsh(i.getPerfilTiroTsh());
		in.setPerfilHorLh(i.getPerfilHorLh());
		in.setPerfilHorFsh(i.getPerfilHorFsh());
		in.setPerfilHorEstradiol(i.getPerfilHorEstradiol());
		in.setPerfilHorTestosterona(i.getPerfilHorTestosterona());
		in.setPerfilCarCkMb(i.getPerfilCarCkMb());
		in.setPerfilCarDimeroD(i.getPerfilCarDimeroD());
		in.setPerfilCarTroponinI(i.getPerfilCarTroponinI());
		in.setPerfilCarNtProbnp(i.getPerfilCarNtProbnp());
		in.setPruebaHepatitisC(i.getPruebaHepatitisC());
		in.setCargaViralHiv(i.getCargaViralHiv());
		in.setElisaHiv(i.getElisaHiv());
		in.setPruebaHepatitisA(i.getPruebaHepatitisA());
		in.setOtras_pruebas(i.getOtras_pruebas());
		
		ir.save(in);
		
	}

	@Override
	public List<Object[]> reporteInmunologia(String ano, String mes, String ris, String mes2) {
		
		return ir.reporteInmunologia(ano, mes, ris, mes2);
	}

	@Override
	public Inmunologia buscarInmunologia(long id) {
	
		return ir.buscarInmunologia(id);
	}

	@Override
	public List<Inmunologia> listaInmunologia(String ano, String mes) {
		
		return ir.listaInmunologia(ano, mes);
	}

	@Override
	public void editarInmunologia(Inmunologia i, String clientIp) {
		Inmunologia in = buscarInmunologia(i.getIdInmunologia());
		in.setAnoInm(i.getAnoInm());
		in.setMesInm(i.getMesInm());
		in.setUsuarioModInm(us.getLoggedUser().getUsername());
		in.setFechaModInm(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		in.setIpModInm(clientIp);
		in.setEstadoInm(i.getEstadoInm());
		
		in.setIdentifAcTificoH(i.getIdentifAcTificoH());
		in.setIdentifAcTificoO(i.getIdentifAcTificoO());
		in.setIdentifAcParatificoA(i.getIdentifAcParatificoA());
		in.setIdentifAcParatificoB(i.getIdentifAcParatificoB());
		in.setIdentifAcBrucella(i.getIdentifAcBrucella());
		in.setTestRosaBengalaBrucella(i.getTestRosaBengalaBrucella());
		in.setIdentificacionAcHivPruebaRapida(i.getIdentificacionAcHivPruebaRapida());
		in.setIdentificacionAcHivElisa(i.getIdentificacionAcHivElisa());
		in.setTestRpr(i.getTestRpr());
		in.setTestProteinaCReactivaLatex(i.getTestProteinaCReactivaLatex());
		in.setDosajeHormonaSubUnidadBetaHcg(i.getDosajeHormonaSubUnidadBetaHcg());
		in.setTestFactorReumatoide(i.getTestFactorReumatoide());
		in.setTestAntigenoProstaticoEspecíficoPsa(i.getTestAntigenoProstaticoEspecíficoPsa());
		in.setTestAntiestreptolisinaOAso(i.getTestAntiestreptolisinaOAso());
		in.setHelicobacterPiloryElisaIgm(i.getHelicobacterPiloryElisaIgm());
		in.setTestRotavirus(i.getTestRotavirus());
		in.setHepatitisBAcContraAgSuperficie(i.getHepatitisBAcContraAgSuperficie());
		in.setTestEmbarazoPr(i.getTestEmbarazoPr());
		in.setTotalInm(i.getTotalInm());
		in.setPruebaDualHivSifilis(i.getPruebaDualHivSifilis());
		in.setPruebaRapidaSifilis(i.getPruebaRapidaSifilis());
		in.setPerfilTiroT3Libre(i.getPerfilTiroT3Libre());
		in.setPerfilTiroT4Libre(i.getPerfilTiroT4Libre());
		in.setPerfilTiroTsh(i.getPerfilTiroTsh());
		in.setPerfilHorLh(i.getPerfilHorLh());
		in.setPerfilHorFsh(i.getPerfilHorFsh());
		in.setPerfilHorEstradiol(i.getPerfilHorEstradiol());
		in.setPerfilHorTestosterona(i.getPerfilHorTestosterona());
		in.setPerfilCarCkMb(i.getPerfilCarCkMb());
		in.setPerfilCarDimeroD(i.getPerfilCarDimeroD());
		in.setPerfilCarTroponinI(i.getPerfilCarTroponinI());
		in.setPerfilCarNtProbnp(i.getPerfilCarNtProbnp());
		in.setPruebaHepatitisC(i.getPruebaHepatitisC());
		in.setCargaViralHiv(i.getCargaViralHiv());
		in.setElisaHiv(i.getElisaHiv());
		in.setPruebaHepatitisA(i.getPruebaHepatitisA());
		in.setOtras_pruebas(i.getOtras_pruebas());
		
		ir.save(in);
		
	}

	@Override
	public Inmunologia verificarNewInmu(String ano, String mes, String estado, String esta) {
		
		return ir.verificarNewInmu(ano, mes, estado, esta);
	}

}

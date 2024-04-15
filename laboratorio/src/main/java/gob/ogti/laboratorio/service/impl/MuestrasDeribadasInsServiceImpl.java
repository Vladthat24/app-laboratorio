package gob.ogti.laboratorio.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.ogti.laboratorio.entity.MuestrasDerivadasIns;
import gob.ogti.laboratorio.repository.MuestrasDerivadasInsRepository;
import gob.ogti.laboratorio.service.MuestrasDeribadasInsService;
import gob.ogti.laboratorio.service.UserService;

@Service
public class MuestrasDeribadasInsServiceImpl implements MuestrasDeribadasInsService{

	@Autowired
	UserService us;
	
	@Autowired
	MuestrasDerivadasInsRepository mdir;
	
	@Override
	public void nuevoMuestraDerivadaIns(MuestrasDerivadasIns md, String ip) {
		
		MuestrasDerivadasIns mdi = new MuestrasDerivadasIns();
		mdi.setAnoIns(md.getAnoIns());
		mdi.setMesIns(md.getMesIns());
		mdi.setUsuarioRegMue(us.getLoggedUser().getUsername());
		mdi.setFechaRegMue(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		mdi.setIpRegMue(ip);
		mdi.setEstablecimientoMuestras(us.getLoggedUser().getEstablecimiento());
		mdi.setEstadoMuestras(md.getEstadoMuestras());
		
		mdi.setSarampionRubeola(md.getSarampionRubeola());
		mdi.setDengueArbovirus(md.getDengueArbovirus());
		mdi.setCd4Cd8CargaViralHiv(md.getCd4Cd8CargaViralHiv());
		mdi.setSifilis(md.getSifilis());
		mdi.setHivSida(md.getHivSida());
		mdi.setBartonellaHanselae(md.getBartonellaHanselae());
		mdi.setLeishmaniasis(md.getLeishmaniasis());
		//mdi.setEnfermedadCarrión(md.getEnfermedadCarrión());
		mdi.setLeptospirosis(md.getLeptospirosis());
		mdi.setVirusRespiratoriosInfluenza(md.getVirusRespiratoriosInfluenza());
		mdi.setTosFerina(md.getTosFerina());
		mdi.setTotalMue(md.getTotalMue());
		mdi.setAntigenoProsEspePsa(md.getAntigenoProsEspePsa());
		mdi.setViruelaMono(md.getViruelaMono());
		
		mdi.setGotaGruesaMalaria(md.getGotaGruesaMalaria());
		mdi.setControlDxParasitologia(md.getControlDxParasitologia());
		mdi.setTorch(md.getTorch());
		mdi.setBartonellaBacilliformis(md.getBartonellaBacilliformis());
		mdi.setHtlv(md.getHtlv());
		mdi.setBrucelosis(md.getBrucelosis());
		mdi.setToxoplasmosis(md.getToxoplasmosis());
		mdi.setHepatitis(md.getHepatitis());
		mdi.setChicungunya(md.getChicungunya());
		mdi.setZika(md.getZika());
		mdi.setHidatidosis(md.getHidatidosis());
		mdi.setCitomegalovirus(md.getCitomegalovirus());
		mdi.setFiebreAmarilla(md.getFiebreAmarilla());
		
		mdi.setEnfManoPieCox(md.getEnfManoPieCox());
		mdi.setClamidia(md.getClamidia());
		mdi.setNeisseriaGonorrea(md.getNeisseriaGonorrea());
		mdi.setParalisis_flacida_aguda(md.getParalisis_flacida_aguda());
		mdi.setOtras_pruebas(md.getOtras_pruebas());
		
		mdir.save(mdi);
		
	}

	@Override
	public List<Object[]> reporteMuestrasDeribadas(String ano, String mes, String ris, String mes2) {
		
		return mdir.reporteMuestrasDeribadas(ano, mes, ris, mes2);
	}

	@Override
	public List<MuestrasDerivadasIns> listaIns(String ano, String mes) {
		
		return mdir.listaIns(ano,mes);
	}

	@Override
	public MuestrasDerivadasIns buscarIns(long id) {
		
		return mdir.buscarIns(id);
	}

	@Override
	public void editarIns(MuestrasDerivadasIns md, String ip) {
		
		MuestrasDerivadasIns mdi = buscarIns(md.getIdMuestras());
		mdi.setAnoIns(md.getAnoIns());
		mdi.setMesIns(md.getMesIns());
		mdi.setUsuarioModMue(us.getLoggedUser().getUsername());
		mdi.setFechaModMue(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		mdi.setIpModMue(ip);
		mdi.setEstadoMuestras(md.getEstadoMuestras());
		
		mdi.setSarampionRubeola(md.getSarampionRubeola());
		mdi.setDengueArbovirus(md.getDengueArbovirus());
		mdi.setCd4Cd8CargaViralHiv(md.getCd4Cd8CargaViralHiv());
		mdi.setSifilis(md.getSifilis());
		mdi.setHivSida(md.getHivSida());
		mdi.setBartonellaHanselae(md.getBartonellaHanselae());
		mdi.setLeishmaniasis(md.getLeishmaniasis());
		//mdi.setEnfermedadCarrión(md.getEnfermedadCarrión());
		mdi.setLeptospirosis(md.getLeptospirosis());
		mdi.setVirusRespiratoriosInfluenza(md.getVirusRespiratoriosInfluenza());
		mdi.setTosFerina(md.getTosFerina());
		mdi.setTotalMue(md.getTotalMue());
		mdi.setAntigenoProsEspePsa(md.getAntigenoProsEspePsa());
		mdi.setViruelaMono(md.getViruelaMono());
		
		mdi.setGotaGruesaMalaria(md.getGotaGruesaMalaria());
		mdi.setControlDxParasitologia(md.getControlDxParasitologia());
		mdi.setTorch(md.getTorch());
		mdi.setBartonellaBacilliformis(md.getBartonellaBacilliformis());
		mdi.setHtlv(md.getHtlv());
		mdi.setBrucelosis(md.getBrucelosis());
		mdi.setToxoplasmosis(md.getToxoplasmosis());
		mdi.setHepatitis(md.getHepatitis());
		mdi.setChicungunya(md.getChicungunya());
		mdi.setZika(md.getZika());
		mdi.setHidatidosis(md.getHidatidosis());
		mdi.setCitomegalovirus(md.getCitomegalovirus());
		mdi.setFiebreAmarilla(md.getFiebreAmarilla());
		
		mdi.setEnfManoPieCox(md.getEnfManoPieCox());
		mdi.setClamidia(md.getClamidia());
		mdi.setNeisseriaGonorrea(md.getNeisseriaGonorrea());
		mdi.setParalisis_flacida_aguda(md.getParalisis_flacida_aguda());
		mdi.setOtras_pruebas(md.getOtras_pruebas());
		mdir.save(mdi);
	}

}

package gob.ogti.laboratorio.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.ogti.laboratorio.entity.Microbiologia;
import gob.ogti.laboratorio.repository.MicrobiologiaRepository;
import gob.ogti.laboratorio.service.MicrobiologiaService;
import gob.ogti.laboratorio.service.UserService;

@Service
public class MicrobiologiaServiceImpl implements MicrobiologiaService {

	@Autowired
	UserService us;

	@Autowired
	MicrobiologiaRepository mr;

	@Override
	public void nuevoMicrobiologia(Microbiologia m, String rq) {

		Microbiologia mi = new Microbiologia();
		mi.setAnoMic(m.getAnoMic());
		mi.setMesMic(m.getMesMic());
		mi.setUsuarioRegMic(us.getLoggedUser().getUsername());
		mi.setFechaRegMic(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		mi.setEstablecimientoMic(us.getLoggedUser().getEstablecimiento());
		mi.setIpRegMic(rq);

		mi.setExamenCompletoOrina(m.getExamenCompletoOrina());
		mi.setTincionGram(m.getTincionGram());
		mi.setInvestigacionDirectaHongos(m.getInvestigacionDirectaHongos());
		mi.setTincionAzulMetileno(m.getTincionAzulMetileno());
		mi.setInvestigacionDirectaAcaros(m.getInvestigacionDirectaAcaros());
		mi.setUrocultivoIdentAntibiograma(m.getUrocultivoIdentAntibiograma());
		mi.setCoprocultivoIdentAntibiograma(m.getCoprocultivoIdentAntibiograma());
		mi.setReaccionInflamatoria(m.getReaccionInflamatoria());
		mi.setCoprologicoFuncional(m.getCoprologicoFuncional());
		mi.setTestGraham(m.getTestGraham());
		mi.setInvestigacionSangreOcultaHecesThevenon(m.getInvestigacionSangreOcultaHecesThevenon());
		mi.setExamenParasitologHecesDirecto(m.getExamenParasitologHecesDirecto());
		mi.setExamenParasitologicoSeriadoTresMuestras(m.getExamenParasitologicoSeriadoTresMuestras());
		mi.setExamenDirectoSecrecionVaginal(m.getExamenDirectoSecrecionVaginal());
		mi.setCultSecVaginal(m.getCultSecVaginal());
		mi.setCultivoSecFaringea(m.getCultivoSecFaringea());
		mi.setCultivoHeridas(m.getCultivoHeridas());
		mi.setCultHongos(m.getCultHongos());
		mi.setCultSecUretal(m.getCultSecUretal());
		mi.setBkEsputo(m.getBkEsputo());
		mi.setEstadoMic(m.getEstadoMic());
		mi.setTotalMic(m.getTotalMic());
		mi.setProteinasOrina(m.getProteinasOrina());
		mi.setTestCristalizacionHelecho(m.getTestCristalizacionHelecho());
		mi.setCultivoMycobacteriumTb(m.getCultivoMycobacteriumTb());
		mi.setOtras_pruebas(m.getOtras_pruebas());
		mr.save(mi);

	}

	@Override
	public List<Object[]> reporteMicrobiologia(String ano, String mes, String ris,String mes2) {
		
		return mr.reporteMicrobiologia(ano, mes, ris,mes2);
	}

	@Override
	public List<Microbiologia> listaMicrobiologia(String ano, String mes) {
		
		return mr.listaMicrobiologia(ano, mes);
	}

	@Override
	public Microbiologia buscarMicrobiologia(long id) {
		
		return mr.buscarMicrobiologia(id);
	}

	@Override
	public void editarMicrobiologia(Microbiologia m, String rq) {
		
		Microbiologia mi = buscarMicrobiologia(m.getIdMicrobiologia());
		mi.setAnoMic(m.getAnoMic());
		mi.setMesMic(m.getMesMic());
		mi.setUsuarioModMic(us.getLoggedUser().getUsername());
		mi.setFechaModMic(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		mi.setIpModMic(rq);

		mi.setExamenCompletoOrina(m.getExamenCompletoOrina());
		mi.setTincionGram(m.getTincionGram());
		mi.setInvestigacionDirectaHongos(m.getInvestigacionDirectaHongos());
		mi.setTincionAzulMetileno(m.getTincionAzulMetileno());
		mi.setInvestigacionDirectaAcaros(m.getInvestigacionDirectaAcaros());
		mi.setUrocultivoIdentAntibiograma(m.getUrocultivoIdentAntibiograma());
		mi.setCoprocultivoIdentAntibiograma(m.getCoprocultivoIdentAntibiograma());
		mi.setReaccionInflamatoria(m.getReaccionInflamatoria());
		mi.setCoprologicoFuncional(m.getCoprologicoFuncional());
		mi.setTestGraham(m.getTestGraham());
		mi.setInvestigacionSangreOcultaHecesThevenon(m.getInvestigacionSangreOcultaHecesThevenon());
		mi.setExamenParasitologHecesDirecto(m.getExamenParasitologHecesDirecto());
		mi.setExamenParasitologicoSeriadoTresMuestras(m.getExamenParasitologicoSeriadoTresMuestras());
		mi.setExamenDirectoSecrecionVaginal(m.getExamenDirectoSecrecionVaginal());
		mi.setCultSecVaginal(m.getCultSecVaginal());
		mi.setCultivoSecFaringea(m.getCultivoSecFaringea());
		mi.setCultivoHeridas(m.getCultivoHeridas());
		mi.setCultHongos(m.getCultHongos());
		mi.setCultSecUretal(m.getCultSecUretal());
		mi.setBkEsputo(m.getBkEsputo());
		mi.setEstadoMic(m.getEstadoMic());
		mi.setTotalMic(m.getTotalMic());
		mi.setProteinasOrina(m.getProteinasOrina());
		mi.setTestCristalizacionHelecho(m.getTestCristalizacionHelecho());
		mi.setCultivoMycobacteriumTb(m.getCultivoMycobacteriumTb());
		mi.setOtras_pruebas(m.getOtras_pruebas());
		mr.save(mi);

		
	}

}

package gob.ogti.laboratorio.service.impl;

import java.sql.Timestamp;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.ogti.laboratorio.entity.TomaPruebaCovid19;
import gob.ogti.laboratorio.repository.TomaPruebaCovid19Repository;
import gob.ogti.laboratorio.service.TomaMuestraCovid19Service;
import gob.ogti.laboratorio.service.UserService;

@Service
public class TomaMuestraCovid19ServiceImpl implements TomaMuestraCovid19Service{
	
	@Autowired
	UserService us;
	
	@Autowired
	TomaPruebaCovid19Repository tpr;

	@Override
	public void nuevoTomaMuestraCovid19(TomaPruebaCovid19 tpc, String ip) {
		
		TomaPruebaCovid19 tp = new TomaPruebaCovid19();
		tp.setAnoTpc(tpc.getAnoTpc());
		tp.setMesTpc(tpc.getMesTpc());
		tp.setUsuarioRegTpCovid(us.getLoggedUser().getUsername());
		tp.setFechaRegTpCovid(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		tp.setIpRegTpCovid(ip);
		tp.setEstablecimientoTpCovid(us.getLoggedUser().getEstablecimiento());
		tp.setEstadoTpCovid(tpc.getEstadoTpCovid());
		
		tp.setPruebaRapidaAntigenoCo(tpc.getPruebaRapidaAntigenoCo());
		tp.setTomaMuestraMolecularCo(tpc.getTomaMuestraMolecularCo());
		tp.setIngresoDatosSiscovid(tpc.getIngresoDatosSiscovid());
		tp.setTotalTpCovid(tpc.getTotalTpCovid());
		tp.setPruebaMolCovidEaif(tpc.getPruebaMolCovidEaif());
		tp.setIngresoDatosMolNetlab(tpc.getIngresoDatosMolNetlab());
		tp.setOtros_reg_prueba_covid19(tpc.getOtros_reg_prueba_covid19());
		
		tpr.save(tp);
	}

	@Override
	public List<Object[]> reporteTomaMuestrasCovid19(String ano, String mes, String ris,String mes2) {
		
		return tpr.reporteTomaMuestrasCovid19(ano, mes, ris, mes2);
	}

	@Override
	public List<Object[]> reporteRegistroSisCovid19(String ano, String mes, String ris, String mes2) {
		
		return tpr.reporteRegistroSisCovid19(ano, mes, ris, mes2);
	}

	@Override
	public List<TomaPruebaCovid19> listaMpcovid19(String ano, String mes) {
		
		return tpr.listaMpcovid19(ano,mes);
	}

	@Override
	public TomaPruebaCovid19 buscarMpcovid19(long id) {
		
		return tpr.buscarMpcovid19(id);
	}

	@Override
	public void editarMpcovid19(TomaPruebaCovid19 tpc, String ip) {
		TomaPruebaCovid19 tp = buscarMpcovid19(tpc.getIdTpCovid());
		tp.setAnoTpc(tpc.getAnoTpc());
		tp.setMesTpc(tpc.getMesTpc());
		tp.setUsuarioModTpCovid(us.getLoggedUser().getUsername());
		tp.setFechaModTpCovid(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		tp.setIpModTpCovid(ip);
		tp.setEstadoTpCovid(tpc.getEstadoTpCovid());
		
		tp.setPruebaRapidaAntigenoCo(tpc.getPruebaRapidaAntigenoCo());
		tp.setTomaMuestraMolecularCo(tpc.getTomaMuestraMolecularCo());
		tp.setIngresoDatosSiscovid(tpc.getIngresoDatosSiscovid());
		tp.setTotalTpCovid(tpc.getTotalTpCovid());
		tp.setPruebaMolCovidEaif(tpc.getPruebaMolCovidEaif());
		tp.setIngresoDatosMolNetlab(tpc.getIngresoDatosMolNetlab());
		tp.setOtros_reg_prueba_covid19(tpc.getOtros_reg_prueba_covid19());
		tpr.save(tp);
		
	}

}

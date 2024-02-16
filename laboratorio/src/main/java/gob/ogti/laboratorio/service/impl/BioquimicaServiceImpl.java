package gob.ogti.laboratorio.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gob.ogti.laboratorio.dto.ReporteGlobalActividades;
import gob.ogti.laboratorio.dto.reporteAnalisisClinicos;
import gob.ogti.laboratorio.entity.Bioquimica;
import gob.ogti.laboratorio.repository.BioquimicaRepository;
import gob.ogti.laboratorio.repository.HematologiaRepository;
import gob.ogti.laboratorio.repository.InmunologiaRepository;
import gob.ogti.laboratorio.repository.MicrobiologiaRepository;
import gob.ogti.laboratorio.repository.RisRepository;
import gob.ogti.laboratorio.service.BioquimicaService;
import gob.ogti.laboratorio.service.UserService;

@Service
public class BioquimicaServiceImpl implements BioquimicaService {

	@Autowired
	UserService us;

	@Autowired
	BioquimicaRepository br;

	@Autowired
	InmunologiaRepository ir;

	@Autowired
	HematologiaRepository hr;

	@Autowired
	MicrobiologiaRepository mr;
	
	@Autowired
	RisRepository rr;

	private static final Log LOG = LogFactory.getLog(BioquimicaService.class);

	@Override
	public void nuevoBioquimica(Bioquimica b, String clientIp) {

		Bioquimica bi = new Bioquimica();
		bi.setAnoBio(b.getAnoBio());
		bi.setMesBio(b.getMesBio());
		bi.setUsuarioRegBio(us.getLoggedUser().getUsername());
		bi.setFechaRegBio(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		bi.setEstablecimientoBio(us.getLoggedUser().getEstablecimiento());
		bi.setIpRegBio(clientIp);

		bi.setDosajeGlucosa(b.getDosajeGlucosa());
		bi.setToleranciaGlucosa(b.getToleranciaGlucosa());
		bi.setGlucosaPostPrandial(b.getGlucosaPostPrandial());
		bi.setDosajeHemoglobinaGlicosilada(b.getDosajeHemoglobinaGlicosilada());
		bi.setDosajeUrea(b.getDosajeUrea());
		bi.setDosajecreatinina(b.getDosajecreatinina());
		bi.setDosajeColesterolTotal(b.getDosajeColesterolTotal());
		bi.setDosajeColesterolHdl(b.getDosajeColesterolHdl());
		bi.setDosajeColesterolLdl(b.getDosajeColesterolLdl());
		bi.setDosajeTrigliceridos(b.getDosajeTrigliceridos());
		bi.setDosajeAcidoUrico(b.getDosajeAcidoUrico());
		bi.setDosajeBilirrubinaDirecta(b.getDosajeBilirrubinaDirecta());
		bi.setDosajeBilirrubinasTotales(b.getDosajeBilirrubinasTotales());
		bi.setDosajeProteínasTotales(b.getDosajeProteínasTotales());
		bi.setDosajeAlbumina(b.getDosajeAlbumina());
		bi.setDosajeTgoAst(b.getDosajeTgoAst());
		bi.setDosajeTgpAlt(b.getDosajeTgpAlt());
		bi.setDosajeFosfatasaAlcalina(b.getDosajeFosfatasaAlcalina());
		bi.setDosajeAmilasa(b.getDosajeAmilasa());
		bi.setDosajeGgtp(b.getDosajeGgtp());
		bi.setDosajeDeshidrogenasaLacticaLdh(b.getDosajeDeshidrogenasaLacticaLdh());
		bi.setLipidosTotales(b.getLipidosTotales());
		bi.setDosajeProteinasOrina24horas(b.getDosajeProteinasOrina24horas());
		bi.setTotalBio(b.getTotalBio());
		bi.setEstadoBio(b.getEstadoBio());
		bi.setDepuracionCreatinina(b.getDepuracionCreatinina());
		bi.setGlucosaTiraGlucometro(b.getGlucosaTiraGlucometro());

		br.save(bi);

	}

	@Override
	public List<Object[]> reporteBioquimica(String ano, String mes, String ris, String mes2) {

		return br.reporteBioquimica(ano, mes, ris, mes2);
	}

	@Override
	public List<Object[]> reporteAnalisisTotal(String ano, String mes, String ris, String mes2) {

		List<Object[]> bio = br.reporteBioquimica(ano, mes, ris,mes2);
		List<Object[]> inm = ir.reporteInmunologia(ano, mes, ris,mes2);
		List<Object[]> hem = hr.reporteHematologia(ano, mes, ris,mes2);
		List<Object[]> mic = mr.reporteMicrobiologia(ano, mes, ris,mes2);

		List<Object[]> totalExaClin = new ArrayList<>();

		for (var i = 0; i < bio.size(); i++) {
			Object[] row = (Object[]) bio.get(i);
			String nomEs = String.valueOf(row[0]);
			String total = String.valueOf(row[1]);
			Object[] row1 = (Object[]) inm.get(i);
			String total1 = String.valueOf(row1[1]);
			Object[] row2 = (Object[]) hem.get(i);
			String total2 = String.valueOf(row2[1]);
			Object[] row3 = (Object[]) mic.get(i);
			String total3 = String.valueOf(row3[1]);

			double sumtot = Double.parseDouble(total) + Double.parseDouble(total1) + Double.parseDouble(total2)
					+ Double.parseDouble(total3);

			Object[] nomEstable = { nomEs, sumtot };
			totalExaClin.add(nomEstable);

		}

		LOG.info("/GET reporteAnalisisTotal DATA : " + totalExaClin);

		return totalExaClin;
	}

	@Override
	public List<Object[]> reporteConsololidad() {
		
		
		
		return br.reporteConsololidad();
	}

	@Override
	public void editarBioquimica(Bioquimica b, String clientIp) {
		
		Bioquimica bi = buscarBioquimica(b.getIdBioquimica());
		bi.setAnoBio(b.getAnoBio());
		bi.setMesBio(b.getMesBio());
		bi.setUsuarioModBio(us.getLoggedUser().getUsername());
		bi.setFechaModBio(new Timestamp(Calendar.getInstance().getTimeInMillis()));
		bi.setIpModBio(clientIp);

		bi.setDosajeGlucosa(b.getDosajeGlucosa());
		bi.setToleranciaGlucosa(b.getToleranciaGlucosa());
		bi.setGlucosaPostPrandial(b.getGlucosaPostPrandial());
		bi.setDosajeHemoglobinaGlicosilada(b.getDosajeHemoglobinaGlicosilada());
		bi.setDosajeUrea(b.getDosajeUrea());
		bi.setDosajecreatinina(b.getDosajecreatinina());
		bi.setDosajeColesterolTotal(b.getDosajeColesterolTotal());
		bi.setDosajeColesterolHdl(b.getDosajeColesterolHdl());
		bi.setDosajeColesterolLdl(b.getDosajeColesterolLdl());
		bi.setDosajeTrigliceridos(b.getDosajeTrigliceridos());
		bi.setDosajeAcidoUrico(b.getDosajeAcidoUrico());
		bi.setDosajeBilirrubinaDirecta(b.getDosajeBilirrubinaDirecta());
		bi.setDosajeBilirrubinasTotales(b.getDosajeBilirrubinasTotales());
		bi.setDosajeProteínasTotales(b.getDosajeProteínasTotales());
		bi.setDosajeAlbumina(b.getDosajeAlbumina());
		bi.setDosajeTgoAst(b.getDosajeTgoAst());
		bi.setDosajeTgpAlt(b.getDosajeTgpAlt());
		bi.setDosajeFosfatasaAlcalina(b.getDosajeFosfatasaAlcalina());
		bi.setDosajeAmilasa(b.getDosajeAmilasa());
		bi.setDosajeGgtp(b.getDosajeGgtp());
		bi.setDosajeDeshidrogenasaLacticaLdh(b.getDosajeDeshidrogenasaLacticaLdh());
		bi.setLipidosTotales(b.getLipidosTotales());
		bi.setDosajeProteinasOrina24horas(b.getDosajeProteinasOrina24horas());
		bi.setTotalBio(b.getTotalBio());
		bi.setEstadoBio(b.getEstadoBio());
		bi.setDepuracionCreatinina(b.getDepuracionCreatinina());
		bi.setGlucosaTiraGlucometro(b.getGlucosaTiraGlucometro());

		br.save(bi);
		
	}

	@Override
	public Bioquimica buscarBioquimica(long id) {
		
		return br.buscarBioquimica(id);
	}

	@Override
	public List<Bioquimica> listaBioquimica(String ano, String mes) {
		
		return br.listaBioquimica(ano, mes);
	}

	@Override
	public List<reporteAnalisisClinicos> tablaAnalisisClinicos(String ris, String esta, String mes, String mes2, String ano) {
		List<Object[]> bio = br.reporteTotExaCli(ris, esta, mes, mes2, ano);
		LOG.info("/GET reporteTotAct DATA : " + ris + esta + ano + mes +mes2);
		LOG.info("/GET reporteTotAct DATA : " + bio);
		List<reporteAnalisisClinicos> reporteAnaCli = new ArrayList<>();
		
		double sumExaHema = 0;
		
		for (var i = 0; i < bio.size(); i++) {
			Object[] row = (Object[]) bio.get(i);
			String nomEsta = String.valueOf(row[0]);
			String mesRa = String.valueOf(row[1]);
			String anoRa = String.valueOf(row[2]);
			String total = String.valueOf(row[3]);
			String total1 = String.valueOf(row[4]);
			String total2 = String.valueOf(row[5]);
			String total3 = String.valueOf(row[6]);
			
			sumExaHema = sumExaHema + Double.parseDouble(total);
			
			
			double sumtot = Double.parseDouble(total) + Double.parseDouble(total1) + Double.parseDouble(total2)
					+ Double.parseDouble(total3);
			
			BigDecimal formatBio1 = new BigDecimal(total);
			formatBio1 = formatBio1.setScale(0, RoundingMode.DOWN);
			
			BigDecimal formatBio2 = new BigDecimal(total1);
			formatBio2 = formatBio2.setScale(0, RoundingMode.DOWN);
			
			BigDecimal formatBio3 = new BigDecimal(total2);
			formatBio3 = formatBio3.setScale(0, RoundingMode.DOWN);
			
			BigDecimal formatBio4 = new BigDecimal(total3);
			formatBio4 = formatBio4.setScale(0, RoundingMode.DOWN);
			
			BigDecimal formatBio5 = new BigDecimal(sumtot);
			formatBio5 = formatBio5.setScale(0, RoundingMode.DOWN);
			
			reporteAnalisisClinicos rac = new reporteAnalisisClinicos();
			rac.setExaNomEsta(nomEsta);
			rac.setExaAno(anoRa);
			rac.setExaMes(mesRa);
			rac.setExaHematologia(String.valueOf(formatBio1));
			rac.setExaBioquimica(String.valueOf(formatBio2));
			rac.setExaInmunologia(String.valueOf(formatBio3));
			rac.setExaMicrobiologia(String.valueOf(formatBio4));
			rac.setTotSumExa(String.valueOf(formatBio5));
			reporteAnaCli.add(rac);
		}
		LOG.info("/GET sumExaHema DATA : " + sumExaHema);
		return reporteAnaCli;
	}

	@Override
	public List<ReporteGlobalActividades> reporteTotAct(String ris, String esta, String mes, String mes2, String ano) {
		
		List<ReporteGlobalActividades> rac =  new ArrayList<>();
		
		List<Object[]> ra = br.reporteTotAct(ris, esta, mes, mes2, ano) ;
		for (var i = 0; i < ra.size(); i++) {
			Object[] row = (Object[]) ra.get(i);
			String nomEsta = String.valueOf(row[0]);
			String mesRa = String.valueOf(row[1]);
			String anoRa = String.valueOf(row[2]);
			String anaCli = String.valueOf(row[3]);
			String conCal = String.valueOf(row[4]);
			String mueDer = String.valueOf(row[5]);
			String tomPru = String.valueOf(row[6]);
			String ingDat = String.valueOf(row[7]);
			
			double sumtot = Double.parseDouble(anaCli) + Double.parseDouble(conCal) + Double.parseDouble(mueDer)
			+ Double.parseDouble(tomPru)+  Double.parseDouble(ingDat);
			
			BigDecimal formatBio1 = new BigDecimal(anaCli);
			formatBio1 = formatBio1.setScale(0, RoundingMode.DOWN);
			
			BigDecimal formatBio2 = new BigDecimal(conCal);
			formatBio2 = formatBio2.setScale(0, RoundingMode.DOWN);
			
			BigDecimal formatBio3 = new BigDecimal(mueDer);
			formatBio3 = formatBio3.setScale(0, RoundingMode.DOWN);
			
			BigDecimal formatBio4 = new BigDecimal(tomPru);
			formatBio4 = formatBio4.setScale(0, RoundingMode.DOWN);
			
			BigDecimal formatBio5 = new BigDecimal(ingDat);
			formatBio5 = formatBio5.setScale(0, RoundingMode.DOWN);
			
			BigDecimal formatBio6 = new BigDecimal(sumtot);
			formatBio6 = formatBio6.setScale(0, RoundingMode.DOWN);
			
			ReporteGlobalActividades rr = new ReporteGlobalActividades();
			rr.setNomEstableReAc(nomEsta);
			rr.setMesReAc(mesRa);
			rr.setAnoReAc(anoRa);
			rr.setAnaCliReAc(String.valueOf(formatBio1));
			rr.setConCalReAC(String.valueOf(formatBio2));
			rr.setMueDerReAc(String.valueOf(formatBio3));
			rr.setTomPruReAc(String.valueOf(formatBio4));
			rr.setIngDatReAc(String.valueOf(formatBio5));
			rr.setTotReAC(String.valueOf(formatBio6));
			 rac.add(rr);
			
		}
		
		
		return rac;
	}

}

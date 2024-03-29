package gob.ogti.laboratorio.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ogti_laboratorio_inmunologia")
public class Inmunologia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8952117604094171210L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idInmunologia;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codEstablecimiento", referencedColumnName = "codEstablecimiento")
	private Establecimiento establecimientoInm;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codEstado", referencedColumnName = "codEstado")
	private Estado estadoInm;
	
	@Column(length = 5)
	private String identifAcTificoH;
	
	@Column(length = 5)
	private String identifAcTificoO;
	
	@Column(length = 5)
	private String identifAcParatificoA;
	
	@Column(length = 5)
	private String identifAcParatificoB;
	
	@Column(length = 5)
	private String identifAcBrucella;
	
	@Column(length = 5)
	private String testRosaBengalaBrucella;
	
	@Column(length = 5)
	private String identificacionAcHivPruebaRapida;
	
	@Column(length = 5)
	private String identificacionAcHivElisa;
	
	@Column(length = 5)
	private String testRpr;
	
	@Column(length = 5)
	private String testProteinaCReactivaLatex;
	
	@Column(length = 5)
	private String dosajeHormonaSubUnidadBetaHcg;
	
	@Column(length = 5)
	private String testFactorReumatoide;
	
	@Column(length = 5)
	private String testAntigenoProstaticoEspecíficoPsa;
	
	@Column(length = 5)
	private String testAntiestreptolisinaOAso;
	
	@Column(length = 5)
	private String helicobacterPiloryElisaIgm;
	
	@Column(length = 5)
	private String testRotavirus;
	
	@Column(length = 5)
	private String hepatitisBAcContraAgSuperficie;
	
	@Column(length = 5)
	private String testEmbarazoPr;
	
	@Column(length = 10)
	private String totalInm;
	
	@Column(length = 50)
	private String usuarioRegInm;
	
	@Column(length = 50)
	private Timestamp fechaRegInm;
	
	@Column(length = 50)
	private String usuarioModInm;
	
	@Column(length = 50)
	private Timestamp fechaModInm;
	
	@Column(length = 50)
	private String ipRegInm;
	
	@Column(length = 50)
	private String ipModInm;
	
	@Column(length = 50)
	private String anoInm;
	
	@Column(length = 50)
	private String mesInm;
	
	@Column(length = 5)
	private String pruebaDualHivSifilis;
	
	@Column(length = 5)
	private String pruebaRapidaSifilis;
	
	@Column(length = 5)
	private String perfilTiroT3Libre;;
	
	@Column(length = 5)
	private String perfilTiroT4Libre;
	
	@Column(length = 5)
	private String perfilTiroTsh;
	
	@Column(length = 5)
	private String perfilHorLh;
	
	@Column(length = 5)
	private String perfilHorFsh;
	
	@Column(length = 5)
	private String perfilHorEstradiol;
	
	@Column(length = 5)
	private String perfilHorTestosterona;
	
	@Column(length = 5)
	private String perfilCarCkMb;
	
	@Column(length = 5)
	private String perfilCarDimeroD;
	
	@Column(length = 5)
	private String perfilCarTroponinI;
	
	@Column(length = 5)
	private String perfilCarNtProbnp;
	
	@Column(length = 5)
	private String pruebaHepatitisC;
	
	@Column(length = 5)
	private String cargaViralHiv;
	
	@Column(length = 5)
	private String elisaHiv;
	
	@Column(length = 5)
	private String pruebaHepatitisA;
	
	@Column(length=5)
	private String otras_pruebas;

	public String getOtras_pruebas() {
		return otras_pruebas;
	}

	public void setOtras_pruebas(String otras_pruebas) {
		this.otras_pruebas = otras_pruebas;
	}

	public String getPruebaHepatitisA() {
		return pruebaHepatitisA;
	}

	public void setPruebaHepatitisA(String pruebaHepatitisA) {
		this.pruebaHepatitisA = pruebaHepatitisA;
	}

	public Long getIdInmunologia() {
		return idInmunologia;
	}

	public void setIdInmunologia(Long idInmunologia) {
		this.idInmunologia = idInmunologia;
	}

	public Establecimiento getEstablecimientoInm() {
		return establecimientoInm;
	}

	public void setEstablecimientoInm(Establecimiento establecimientoInm) {
		this.establecimientoInm = establecimientoInm;
	}

	public Estado getEstadoInm() {
		return estadoInm;
	}

	public void setEstadoInm(Estado estadoInm) {
		this.estadoInm = estadoInm;
	}

	public String getIdentifAcTificoH() {
		return identifAcTificoH;
	}

	public void setIdentifAcTificoH(String identifAcTificoH) {
		this.identifAcTificoH = identifAcTificoH;
	}

	public String getIdentifAcTificoO() {
		return identifAcTificoO;
	}

	public void setIdentifAcTificoO(String identifAcTificoO) {
		this.identifAcTificoO = identifAcTificoO;
	}

	public String getIdentifAcParatificoA() {
		return identifAcParatificoA;
	}

	public void setIdentifAcParatificoA(String identifAcParatificoA) {
		this.identifAcParatificoA = identifAcParatificoA;
	}

	public String getIdentifAcParatificoB() {
		return identifAcParatificoB;
	}

	public void setIdentifAcParatificoB(String identifAcParatificoB) {
		this.identifAcParatificoB = identifAcParatificoB;
	}

	public String getIdentifAcBrucella() {
		return identifAcBrucella;
	}

	public void setIdentifAcBrucella(String identifAcBrucella) {
		this.identifAcBrucella = identifAcBrucella;
	}

	public String getTestRosaBengalaBrucella() {
		return testRosaBengalaBrucella;
	}

	public void setTestRosaBengalaBrucella(String testRosaBengalaBrucella) {
		this.testRosaBengalaBrucella = testRosaBengalaBrucella;
	}

	public String getIdentificacionAcHivPruebaRapida() {
		return identificacionAcHivPruebaRapida;
	}

	public void setIdentificacionAcHivPruebaRapida(String identificacionAcHivPruebaRapida) {
		this.identificacionAcHivPruebaRapida = identificacionAcHivPruebaRapida;
	}

	public String getIdentificacionAcHivElisa() {
		return identificacionAcHivElisa;
	}

	public void setIdentificacionAcHivElisa(String identificacionAcHivElisa) {
		this.identificacionAcHivElisa = identificacionAcHivElisa;
	}

	public String getTestRpr() {
		return testRpr;
	}

	public void setTestRpr(String testRpr) {
		this.testRpr = testRpr;
	}

	public String getTestProteinaCReactivaLatex() {
		return testProteinaCReactivaLatex;
	}

	public void setTestProteinaCReactivaLatex(String testProteinaCReactivaLatex) {
		this.testProteinaCReactivaLatex = testProteinaCReactivaLatex;
	}

	public String getDosajeHormonaSubUnidadBetaHcg() {
		return dosajeHormonaSubUnidadBetaHcg;
	}

	public void setDosajeHormonaSubUnidadBetaHcg(String dosajeHormonaSubUnidadBetaHcg) {
		this.dosajeHormonaSubUnidadBetaHcg = dosajeHormonaSubUnidadBetaHcg;
	}

	public String getTestFactorReumatoide() {
		return testFactorReumatoide;
	}

	public void setTestFactorReumatoide(String testFactorReumatoide) {
		this.testFactorReumatoide = testFactorReumatoide;
	}

	public String getTestAntigenoProstaticoEspecíficoPsa() {
		return testAntigenoProstaticoEspecíficoPsa;
	}

	public void setTestAntigenoProstaticoEspecíficoPsa(String testAntigenoProstaticoEspecíficoPsa) {
		this.testAntigenoProstaticoEspecíficoPsa = testAntigenoProstaticoEspecíficoPsa;
	}

	public String getTestAntiestreptolisinaOAso() {
		return testAntiestreptolisinaOAso;
	}

	public void setTestAntiestreptolisinaOAso(String testAntiestreptolisinaOAso) {
		this.testAntiestreptolisinaOAso = testAntiestreptolisinaOAso;
	}

	public String getHelicobacterPiloryElisaIgm() {
		return helicobacterPiloryElisaIgm;
	}

	public void setHelicobacterPiloryElisaIgm(String helicobacterPiloryElisaIgm) {
		this.helicobacterPiloryElisaIgm = helicobacterPiloryElisaIgm;
	}

	public String getTestRotavirus() {
		return testRotavirus;
	}

	public void setTestRotavirus(String testRotavirus) {
		this.testRotavirus = testRotavirus;
	}

	public String getHepatitisBAcContraAgSuperficie() {
		return hepatitisBAcContraAgSuperficie;
	}

	public void setHepatitisBAcContraAgSuperficie(String hepatitisBAcContraAgSuperficie) {
		this.hepatitisBAcContraAgSuperficie = hepatitisBAcContraAgSuperficie;
	}

	public String getTestEmbarazoPr() {
		return testEmbarazoPr;
	}

	public void setTestEmbarazoPr(String testEmbarazoPr) {
		this.testEmbarazoPr = testEmbarazoPr;
	}

	public String getTotalInm() {
		return totalInm;
	}

	public void setTotalInm(String totalInm) {
		this.totalInm = totalInm;
	}

	public String getUsuarioRegInm() {
		return usuarioRegInm;
	}

	public void setUsuarioRegInm(String usuarioRegInm) {
		this.usuarioRegInm = usuarioRegInm;
	}

	public Timestamp getFechaRegInm() {
		return fechaRegInm;
	}

	public void setFechaRegInm(Timestamp fechaRegInm) {
		this.fechaRegInm = fechaRegInm;
	}

	public String getUsuarioModInm() {
		return usuarioModInm;
	}

	public void setUsuarioModInm(String usuarioModInm) {
		this.usuarioModInm = usuarioModInm;
	}

	public Timestamp getFechaModInm() {
		return fechaModInm;
	}

	public void setFechaModInm(Timestamp fechaModInm) {
		this.fechaModInm = fechaModInm;
	}

	public String getIpRegInm() {
		return ipRegInm;
	}

	public void setIpRegInm(String ipRegInm) {
		this.ipRegInm = ipRegInm;
	}

	public String getIpModInm() {
		return ipModInm;
	}

	public void setIpModInm(String ipModInm) {
		this.ipModInm = ipModInm;
	}

	public String getAnoInm() {
		return anoInm;
	}

	public void setAnoInm(String anoInm) {
		this.anoInm = anoInm;
	}

	public String getMesInm() {
		return mesInm;
	}

	public void setMesInm(String mesInm) {
		this.mesInm = mesInm;
	}

	public String getPruebaDualHivSifilis() {
		return pruebaDualHivSifilis;
	}

	public void setPruebaDualHivSifilis(String pruebaDualHivSifilis) {
		this.pruebaDualHivSifilis = pruebaDualHivSifilis;
	}

	public String getPruebaRapidaSifilis() {
		return pruebaRapidaSifilis;
	}

	public void setPruebaRapidaSifilis(String pruebaRapidaSifilis) {
		this.pruebaRapidaSifilis = pruebaRapidaSifilis;
	}

	public String getPerfilTiroT3Libre() {
		return perfilTiroT3Libre;
	}

	public void setPerfilTiroT3Libre(String perfilTiroT3Libre) {
		this.perfilTiroT3Libre = perfilTiroT3Libre;
	}

	public String getPerfilTiroT4Libre() {
		return perfilTiroT4Libre;
	}

	public void setPerfilTiroT4Libre(String perfilTiroT4Libre) {
		this.perfilTiroT4Libre = perfilTiroT4Libre;
	}

	public String getPerfilTiroTsh() {
		return perfilTiroTsh;
	}

	public void setPerfilTiroTsh(String perfilTiroTsh) {
		this.perfilTiroTsh = perfilTiroTsh;
	}

	public String getPerfilHorLh() {
		return perfilHorLh;
	}

	public void setPerfilHorLh(String perfilHorLh) {
		this.perfilHorLh = perfilHorLh;
	}

	public String getPerfilHorFsh() {
		return perfilHorFsh;
	}

	public void setPerfilHorFsh(String perfilHorFsh) {
		this.perfilHorFsh = perfilHorFsh;
	}

	public String getPerfilHorEstradiol() {
		return perfilHorEstradiol;
	}

	public void setPerfilHorEstradiol(String perfilHorEstradiol) {
		this.perfilHorEstradiol = perfilHorEstradiol;
	}

	public String getPerfilHorTestosterona() {
		return perfilHorTestosterona;
	}

	public void setPerfilHorTestosterona(String perfilHorTestosterona) {
		this.perfilHorTestosterona = perfilHorTestosterona;
	}

	public String getPerfilCarCkMb() {
		return perfilCarCkMb;
	}

	public void setPerfilCarCkMb(String perfilCarCkMb) {
		this.perfilCarCkMb = perfilCarCkMb;
	}

	public String getPerfilCarDimeroD() {
		return perfilCarDimeroD;
	}

	public void setPerfilCarDimeroD(String perfilCarDimeroD) {
		this.perfilCarDimeroD = perfilCarDimeroD;
	}

	public String getPerfilCarTroponinI() {
		return perfilCarTroponinI;
	}

	public void setPerfilCarTroponinI(String perfilCarTroponinI) {
		this.perfilCarTroponinI = perfilCarTroponinI;
	}

	public String getPerfilCarNtProbnp() {
		return perfilCarNtProbnp;
	}

	public void setPerfilCarNtProbnp(String perfilCarNtProbnp) {
		this.perfilCarNtProbnp = perfilCarNtProbnp;
	}

	public String getPruebaHepatitisC() {
		return pruebaHepatitisC;
	}

	public void setPruebaHepatitisC(String pruebaHepatitisC) {
		this.pruebaHepatitisC = pruebaHepatitisC;
	}

	public String getCargaViralHiv() {
		return cargaViralHiv;
	}

	public void setCargaViralHiv(String cargaViralHiv) {
		this.cargaViralHiv = cargaViralHiv;
	}

	public String getElisaHiv() {
		return elisaHiv;
	}

	public void setElisaHiv(String elisaHiv) {
		this.elisaHiv = elisaHiv;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Inmunologia [idInmunologia=" + idInmunologia + ", establecimientoInm=" + establecimientoInm
				+ ", estadoInm=" + estadoInm + ", identifAcTificoH=" + identifAcTificoH + ", identifAcTificoO="
				+ identifAcTificoO + ", identifAcParatificoA=" + identifAcParatificoA + ", identifAcParatificoB="
				+ identifAcParatificoB + ", identifAcBrucella=" + identifAcBrucella + ", testRosaBengalaBrucella="
				+ testRosaBengalaBrucella + ", identificacionAcHivPruebaRapida=" + identificacionAcHivPruebaRapida
				+ ", identificacionAcHivElisa=" + identificacionAcHivElisa + ", testRpr=" + testRpr
				+ ", testProteinaCReactivaLatex=" + testProteinaCReactivaLatex + ", dosajeHormonaSubUnidadBetaHcg="
				+ dosajeHormonaSubUnidadBetaHcg + ", testFactorReumatoide=" + testFactorReumatoide
				+ ", testAntigenoProstaticoEspecíficoPsa=" + testAntigenoProstaticoEspecíficoPsa
				+ ", testAntiestreptolisinaOAso=" + testAntiestreptolisinaOAso + ", helicobacterPiloryElisaIgm="
				+ helicobacterPiloryElisaIgm + ", testRotavirus=" + testRotavirus + ", hepatitisBAcContraAgSuperficie="
				+ hepatitisBAcContraAgSuperficie + ", testEmbarazoPr=" + testEmbarazoPr + ", totalInm=" + totalInm
				+ ", usuarioRegInm=" + usuarioRegInm + ", fechaRegInm=" + fechaRegInm + ", usuarioModInm="
				+ usuarioModInm + ", fechaModInm=" + fechaModInm + ", ipRegInm=" + ipRegInm + ", ipModInm=" + ipModInm
				+ ", anoInm=" + anoInm + ", mesInm=" + mesInm + ", pruebaDualHivSifilis=" + pruebaDualHivSifilis
				+ ", pruebaRapidaSifilis=" + pruebaRapidaSifilis + ", perfilTiroT3Libre=" + perfilTiroT3Libre
				+ ", perfilTiroT4Libre=" + perfilTiroT4Libre + ", perfilTiroTsh=" + perfilTiroTsh + ", perfilHorLh="
				+ perfilHorLh + ", perfilHorFsh=" + perfilHorFsh + ", perfilHorEstradiol=" + perfilHorEstradiol
				+ ", perfilHorTestosterona=" + perfilHorTestosterona + ", perfilCarCkMb=" + perfilCarCkMb
				+ ", perfilCarDimeroD=" + perfilCarDimeroD + ", perfilCarTroponinI=" + perfilCarTroponinI
				+ ", perfilCarNtProbnp=" + perfilCarNtProbnp + ", pruebaHepatitisC=" + pruebaHepatitisC
				+ ", cargaViralHiv=" + cargaViralHiv + ", elisaHiv=" + elisaHiv + ", pruebaHepatitisA="
				+ pruebaHepatitisA + ", otras_pruebas=" + otras_pruebas + "]";
	}

	
}

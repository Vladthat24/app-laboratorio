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
@Table(name="ogti_laboratorio_muestras_deribadas_ins")
public class MuestrasDerivadasIns implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3848113165697063357L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idMuestras;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codEstablecimiento", referencedColumnName = "codEstablecimiento")
	private Establecimiento establecimientoMuestras;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codEstado", referencedColumnName = "codEstado")
	private Estado estadoMuestras;
	
	@Column(length = 5)
	private String sarampionRubeola;
	
	@Column(length = 5)
	private String dengueArbovirus;
	
	@Column(length = 5)
	private String cd4Cd8CargaViralHiv;
	
	@Column(length = 5)
	private String sifilis;
	
	@Column(length = 5)
	private String hivSida;
	
	@Column(length = 5)
	private String bartonellaHanselae;
	
	@Column(length = 5)
	private String leishmaniasis;
	
	@Column(length = 5)
	private String enfermedadCarrión ;
	
	@Column(length = 5)
	private String leptospirosis;
	
	@Column(length = 5)
	private String virusRespiratoriosInfluenza;
	
	@Column(length = 5)
	private String tosFerina;
	
	@Column(length = 10)
	private String totalMue;
	
	@Column(length = 50)
	private String usuarioRegMue;
	
	@Column(length = 50)
	private Timestamp fechaRegMue;
	
	@Column(length = 50)
	private String usuarioModMue;
	
	@Column(length = 50)
	private Timestamp fechaModMue;
	
	@Column(length = 50)
	private String ipRegMue;
	
	@Column(length = 50)
	private String ipModMue;
	
	@Column(length = 50)
	private String anoIns;
	
	@Column(length = 50)
	private String mesIns;
	
	@Column(length = 5)
	private String antigenoProsEspePsa ;
	
	@Column(length = 5)
	private String viruelaMono ;
	
	@Column(length = 5)
	private String gotaGruesaMalaria ;
	
	@Column(length = 5)
	private String controlDxParasitologia ;
	
	@Column(length = 5)
	private String torch ;
	
	@Column(length = 5)
	private String bartonellaBacilliformis ;
	
	@Column(length = 5)
	private String htlv ;
	
	@Column(length = 5)
	private String brucelosis ;
	
	@Column(length = 5)
	private String toxoplasmosis ;
	
	@Column(length = 5)
	private String hepatitis ;
	
	@Column(length = 5)
	private String chicungunya ;
	
	@Column(length = 5)
	private String zika ;
	
	@Column(length = 5)
	private String hidatidosis ;
	
	@Column(length = 5)
	private String citomegalovirus ;
	
	@Column(length = 5)
	private String fiebreAmarilla ;
	
	@Column(length = 5)
	private String enfManoPieCox;
	
	@Column(length = 5)
	private String clamidia;
	
	@Column(length = 5)
	private String neisseriaGonorrea;

	public Long getIdMuestras() {
		return idMuestras;
	}

	public void setIdMuestras(Long idMuestras) {
		this.idMuestras = idMuestras;
	}

	public Establecimiento getEstablecimientoMuestras() {
		return establecimientoMuestras;
	}

	public void setEstablecimientoMuestras(Establecimiento establecimientoMuestras) {
		this.establecimientoMuestras = establecimientoMuestras;
	}

	public Estado getEstadoMuestras() {
		return estadoMuestras;
	}

	public void setEstadoMuestras(Estado estadoMuestras) {
		this.estadoMuestras = estadoMuestras;
	}

	public String getSarampionRubeola() {
		return sarampionRubeola;
	}

	public void setSarampionRubeola(String sarampionRubeola) {
		this.sarampionRubeola = sarampionRubeola;
	}

	public String getDengueArbovirus() {
		return dengueArbovirus;
	}

	public void setDengueArbovirus(String dengueArbovirus) {
		this.dengueArbovirus = dengueArbovirus;
	}

	public String getCd4Cd8CargaViralHiv() {
		return cd4Cd8CargaViralHiv;
	}

	public void setCd4Cd8CargaViralHiv(String cd4Cd8CargaViralHiv) {
		this.cd4Cd8CargaViralHiv = cd4Cd8CargaViralHiv;
	}

	public String getSifilis() {
		return sifilis;
	}

	public void setSifilis(String sifilis) {
		this.sifilis = sifilis;
	}

	public String getHivSida() {
		return hivSida;
	}

	public void setHivSida(String hivSida) {
		this.hivSida = hivSida;
	}

	public String getBartonellaHanselae() {
		return bartonellaHanselae;
	}

	public void setBartonellaHanselae(String bartonellaHanselae) {
		this.bartonellaHanselae = bartonellaHanselae;
	}

	public String getLeishmaniasis() {
		return leishmaniasis;
	}

	public void setLeishmaniasis(String leishmaniasis) {
		this.leishmaniasis = leishmaniasis;
	}

	public String getEnfermedadCarrión() {
		return enfermedadCarrión;
	}

	public void setEnfermedadCarrión(String enfermedadCarrión) {
		this.enfermedadCarrión = enfermedadCarrión;
	}

	public String getLeptospirosis() {
		return leptospirosis;
	}

	public void setLeptospirosis(String leptospirosis) {
		this.leptospirosis = leptospirosis;
	}

	public String getVirusRespiratoriosInfluenza() {
		return virusRespiratoriosInfluenza;
	}

	public void setVirusRespiratoriosInfluenza(String virusRespiratoriosInfluenza) {
		this.virusRespiratoriosInfluenza = virusRespiratoriosInfluenza;
	}

	public String getTosFerina() {
		return tosFerina;
	}

	public void setTosFerina(String tosFerina) {
		this.tosFerina = tosFerina;
	}

	public String getTotalMue() {
		return totalMue;
	}

	public void setTotalMue(String totalMue) {
		this.totalMue = totalMue;
	}

	public String getUsuarioRegMue() {
		return usuarioRegMue;
	}

	public void setUsuarioRegMue(String usuarioRegMue) {
		this.usuarioRegMue = usuarioRegMue;
	}

	public Timestamp getFechaRegMue() {
		return fechaRegMue;
	}

	public void setFechaRegMue(Timestamp fechaRegMue) {
		this.fechaRegMue = fechaRegMue;
	}

	public String getUsuarioModMue() {
		return usuarioModMue;
	}

	public void setUsuarioModMue(String usuarioModMue) {
		this.usuarioModMue = usuarioModMue;
	}

	public Timestamp getFechaModMue() {
		return fechaModMue;
	}

	public void setFechaModMue(Timestamp fechaModMue) {
		this.fechaModMue = fechaModMue;
	}

	public String getIpRegMue() {
		return ipRegMue;
	}

	public void setIpRegMue(String ipRegMue) {
		this.ipRegMue = ipRegMue;
	}

	public String getIpModMue() {
		return ipModMue;
	}

	public void setIpModMue(String ipModMue) {
		this.ipModMue = ipModMue;
	}

	public String getAnoIns() {
		return anoIns;
	}

	public void setAnoIns(String anoIns) {
		this.anoIns = anoIns;
	}

	public String getMesIns() {
		return mesIns;
	}

	public void setMesIns(String mesIns) {
		this.mesIns = mesIns;
	}

	public String getAntigenoProsEspePsa() {
		return antigenoProsEspePsa;
	}

	public void setAntigenoProsEspePsa(String antigenoProsEspePsa) {
		this.antigenoProsEspePsa = antigenoProsEspePsa;
	}

	public String getViruelaMono() {
		return viruelaMono;
	}

	public void setViruelaMono(String viruelaMono) {
		this.viruelaMono = viruelaMono;
	}

	public String getGotaGruesaMalaria() {
		return gotaGruesaMalaria;
	}

	public void setGotaGruesaMalaria(String gotaGruesaMalaria) {
		this.gotaGruesaMalaria = gotaGruesaMalaria;
	}

	public String getControlDxParasitologia() {
		return controlDxParasitologia;
	}

	public void setControlDxParasitologia(String controlDxParasitologia) {
		this.controlDxParasitologia = controlDxParasitologia;
	}

	public String getTorch() {
		return torch;
	}

	public void setTorch(String torch) {
		this.torch = torch;
	}

	public String getBartonellaBacilliformis() {
		return bartonellaBacilliformis;
	}

	public void setBartonellaBacilliformis(String bartonellaBacilliformis) {
		this.bartonellaBacilliformis = bartonellaBacilliformis;
	}

	public String getHtlv() {
		return htlv;
	}

	public void setHtlv(String htlv) {
		this.htlv = htlv;
	}

	public String getBrucelosis() {
		return brucelosis;
	}

	public void setBrucelosis(String brucelosis) {
		this.brucelosis = brucelosis;
	}

	public String getToxoplasmosis() {
		return toxoplasmosis;
	}

	public void setToxoplasmosis(String toxoplasmosis) {
		this.toxoplasmosis = toxoplasmosis;
	}

	public String getHepatitis() {
		return hepatitis;
	}

	public void setHepatitis(String hepatitis) {
		this.hepatitis = hepatitis;
	}

	public String getChicungunya() {
		return chicungunya;
	}

	public void setChicungunya(String chicungunya) {
		this.chicungunya = chicungunya;
	}

	public String getZika() {
		return zika;
	}

	public void setZika(String zika) {
		this.zika = zika;
	}

	public String getHidatidosis() {
		return hidatidosis;
	}

	public void setHidatidosis(String hidatidosis) {
		this.hidatidosis = hidatidosis;
	}

	public String getCitomegalovirus() {
		return citomegalovirus;
	}

	public void setCitomegalovirus(String citomegalovirus) {
		this.citomegalovirus = citomegalovirus;
	}

	public String getFiebreAmarilla() {
		return fiebreAmarilla;
	}

	public void setFiebreAmarilla(String fiebreAmarilla) {
		this.fiebreAmarilla = fiebreAmarilla;
	}

	public String getEnfManoPieCox() {
		return enfManoPieCox;
	}

	public void setEnfManoPieCox(String enfManoPieCox) {
		this.enfManoPieCox = enfManoPieCox;
	}

	public String getClamidia() {
		return clamidia;
	}

	public void setClamidia(String clamidia) {
		this.clamidia = clamidia;
	}

	public String getNeisseriaGonorrea() {
		return neisseriaGonorrea;
	}

	public void setNeisseriaGonorrea(String neisseriaGonorrea) {
		this.neisseriaGonorrea = neisseriaGonorrea;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "MuestrasDerivadasIns [idMuestras=" + idMuestras + ", establecimientoMuestras=" + establecimientoMuestras
				+ ", estadoMuestras=" + estadoMuestras + ", sarampionRubeola=" + sarampionRubeola + ", dengueArbovirus="
				+ dengueArbovirus + ", cd4Cd8CargaViralHiv=" + cd4Cd8CargaViralHiv + ", sifilis=" + sifilis
				+ ", hivSida=" + hivSida + ", bartonellaHanselae=" + bartonellaHanselae + ", leishmaniasis="
				+ leishmaniasis + ", enfermedadCarrión=" + enfermedadCarrión + ", leptospirosis=" + leptospirosis
				+ ", virusRespiratoriosInfluenza=" + virusRespiratoriosInfluenza + ", tosFerina=" + tosFerina
				+ ", totalMue=" + totalMue + ", usuarioRegMue=" + usuarioRegMue + ", fechaRegMue=" + fechaRegMue
				+ ", usuarioModMue=" + usuarioModMue + ", fechaModMue=" + fechaModMue + ", ipRegMue=" + ipRegMue
				+ ", ipModMue=" + ipModMue + ", anoIns=" + anoIns + ", mesIns=" + mesIns + ", antigenoProsEspePsa="
				+ antigenoProsEspePsa + ", viruelaMono=" + viruelaMono + ", gotaGruesaMalaria=" + gotaGruesaMalaria
				+ ", controlDxParasitologia=" + controlDxParasitologia + ", torch=" + torch
				+ ", bartonellaBacilliformis=" + bartonellaBacilliformis + ", htlv=" + htlv + ", brucelosis="
				+ brucelosis + ", toxoplasmosis=" + toxoplasmosis + ", hepatitis=" + hepatitis + ", chicungunya="
				+ chicungunya + ", zika=" + zika + ", hidatidosis=" + hidatidosis + ", citomegalovirus="
				+ citomegalovirus + ", fiebreAmarilla=" + fiebreAmarilla + ", enfManoPieCox=" + enfManoPieCox
				+ ", clamidia=" + clamidia + ", neisseriaGonorrea=" + neisseriaGonorrea + "]";
	}
	
	
	

}

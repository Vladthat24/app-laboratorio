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
@Table(name="ogti_laboratorio_bioquimica")
public class Bioquimica implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5019258977783378587L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idBioquimica;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codEstablecimiento", referencedColumnName = "codEstablecimiento")
	private Establecimiento establecimientoBio;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codEstado", referencedColumnName = "codEstado")
	private Estado estadoBio;
	
	@Column(length = 5)
	private String dosajeGlucosa;
	
	@Column(length = 5)
	private String toleranciaGlucosa;
	
	@Column(length = 5)
	private String glucosaPostPrandial;
	
	@Column(length = 5)
	private String dosajeHemoglobinaGlicosilada;
	
	@Column(length = 5)
	private String dosajeUrea;
	
	@Column(length = 5)
	private String dosajecreatinina;
	
	@Column(length = 5)
	private String dosajeColesterolTotal;
	
	@Column(length = 5)
	private String dosajeColesterolHdl;
	
	@Column(length = 5)
	private String dosajeColesterolLdl;
	
	@Column(length = 5)
	private String dosajeTrigliceridos;
	
	@Column(length = 5)
	private String dosajeAcidoUrico;
	
	@Column(length = 5)
	private String dosajeBilirrubinasTotales;
	
	@Column(length = 5)
	private String dosajeBilirrubinaDirecta;
	
	@Column(length = 5)
	private String dosajeProteínasTotales;
	
	@Column(length = 5)
	private String dosajeAlbumina;
	
	@Column(length = 5)
	private String dosajeTgoAst;
	
	@Column(length = 5)
	private String dosajeTgpAlt;
	
	@Column(length = 5)
	private String dosajeFosfatasaAlcalina;
	
	@Column(length = 5)
	private String dosajeAmilasa;
	
	@Column(length = 5)
	private String dosajeGgtp;
	
	@Column(length = 5)
	private String dosajeDeshidrogenasaLacticaLdh;
	
	@Column(length = 5)
	private String lipidosTotales;
	
	@Column(length = 5)
	private String dosajeProteinasOrina24horas;
	
	@Column(length = 10)
	private String totalBio;
	
	@Column(length = 50)
	private String usuarioRegBio;
	
	@Column(length = 50)
	private Timestamp fechaRegBio;
	
	@Column(length = 50)
	private String usuarioModBio;
	
	@Column(length = 50)
	private Timestamp fechaModBio;
	
	@Column(length = 50)
	private String ipRegBio;
	
	@Column(length = 50)
	private String ipModBio;
	
	@Column(length = 50)
	private String anoBio;
	
	@Column(length = 50)
	private String mesBio;
	
	@Column(length = 5)
	private String depuracionCreatinina;
	
	@Column(length = 5)
	private String glucosaTiraGlucometro;
	
	@Column(length=5)
	private String tamMicroCreaOriTira;
	
	@Column(length=5)
	private String otras_pruebas;

	public String getTamMicroCreaOriTira() {
		return tamMicroCreaOriTira;
	}

	public void setTamMicroCreaOriTira(String tamMicroCreaOriTira) {
		this.tamMicroCreaOriTira = tamMicroCreaOriTira;
	}

	public String getOtras_pruebas() {
		return otras_pruebas;
	}

	public void setOtras_pruebas(String otras_pruebas) {
		this.otras_pruebas = otras_pruebas;
	}

	public Long getIdBioquimica() {
		return idBioquimica;
	}

	public void setIdBioquimica(Long idBioquimica) {
		this.idBioquimica = idBioquimica;
	}

	public Establecimiento getEstablecimientoBio() {
		return establecimientoBio;
	}

	public void setEstablecimientoBio(Establecimiento establecimientoBio) {
		this.establecimientoBio = establecimientoBio;
	}

	public Estado getEstadoBio() {
		return estadoBio;
	}

	public void setEstadoBio(Estado estadoBio) {
		this.estadoBio = estadoBio;
	}

	public String getDosajeGlucosa() {
		return dosajeGlucosa;
	}

	public void setDosajeGlucosa(String dosajeGlucosa) {
		this.dosajeGlucosa = dosajeGlucosa;
	}

	public String getToleranciaGlucosa() {
		return toleranciaGlucosa;
	}

	public void setToleranciaGlucosa(String toleranciaGlucosa) {
		this.toleranciaGlucosa = toleranciaGlucosa;
	}

	public String getGlucosaPostPrandial() {
		return glucosaPostPrandial;
	}

	public void setGlucosaPostPrandial(String glucosaPostPrandial) {
		this.glucosaPostPrandial = glucosaPostPrandial;
	}

	public String getDosajeHemoglobinaGlicosilada() {
		return dosajeHemoglobinaGlicosilada;
	}

	public void setDosajeHemoglobinaGlicosilada(String dosajeHemoglobinaGlicosilada) {
		this.dosajeHemoglobinaGlicosilada = dosajeHemoglobinaGlicosilada;
	}

	public String getDosajeUrea() {
		return dosajeUrea;
	}

	public void setDosajeUrea(String dosajeUrea) {
		this.dosajeUrea = dosajeUrea;
	}

	public String getDosajecreatinina() {
		return dosajecreatinina;
	}

	public void setDosajecreatinina(String dosajecreatinina) {
		this.dosajecreatinina = dosajecreatinina;
	}

	public String getDosajeColesterolTotal() {
		return dosajeColesterolTotal;
	}

	public void setDosajeColesterolTotal(String dosajeColesterolTotal) {
		this.dosajeColesterolTotal = dosajeColesterolTotal;
	}

	public String getDosajeColesterolHdl() {
		return dosajeColesterolHdl;
	}

	public void setDosajeColesterolHdl(String dosajeColesterolHdl) {
		this.dosajeColesterolHdl = dosajeColesterolHdl;
	}

	public String getDosajeColesterolLdl() {
		return dosajeColesterolLdl;
	}

	public void setDosajeColesterolLdl(String dosajeColesterolLdl) {
		this.dosajeColesterolLdl = dosajeColesterolLdl;
	}

	public String getDosajeTrigliceridos() {
		return dosajeTrigliceridos;
	}

	public void setDosajeTrigliceridos(String dosajeTrigliceridos) {
		this.dosajeTrigliceridos = dosajeTrigliceridos;
	}

	public String getDosajeAcidoUrico() {
		return dosajeAcidoUrico;
	}

	public void setDosajeAcidoUrico(String dosajeAcidoUrico) {
		this.dosajeAcidoUrico = dosajeAcidoUrico;
	}

	public String getDosajeBilirrubinasTotales() {
		return dosajeBilirrubinasTotales;
	}

	public void setDosajeBilirrubinasTotales(String dosajeBilirrubinasTotales) {
		this.dosajeBilirrubinasTotales = dosajeBilirrubinasTotales;
	}

	public String getDosajeBilirrubinaDirecta() {
		return dosajeBilirrubinaDirecta;
	}

	public void setDosajeBilirrubinaDirecta(String dosajeBilirrubinaDirecta) {
		this.dosajeBilirrubinaDirecta = dosajeBilirrubinaDirecta;
	}

	public String getDosajeProteínasTotales() {
		return dosajeProteínasTotales;
	}

	public void setDosajeProteínasTotales(String dosajeProteínasTotales) {
		this.dosajeProteínasTotales = dosajeProteínasTotales;
	}

	public String getDosajeAlbumina() {
		return dosajeAlbumina;
	}

	public void setDosajeAlbumina(String dosajeAlbumina) {
		this.dosajeAlbumina = dosajeAlbumina;
	}

	public String getDosajeTgoAst() {
		return dosajeTgoAst;
	}

	public void setDosajeTgoAst(String dosajeTgoAst) {
		this.dosajeTgoAst = dosajeTgoAst;
	}

	public String getDosajeTgpAlt() {
		return dosajeTgpAlt;
	}

	public void setDosajeTgpAlt(String dosajeTgpAlt) {
		this.dosajeTgpAlt = dosajeTgpAlt;
	}

	public String getDosajeFosfatasaAlcalina() {
		return dosajeFosfatasaAlcalina;
	}

	public void setDosajeFosfatasaAlcalina(String dosajeFosfatasaAlcalina) {
		this.dosajeFosfatasaAlcalina = dosajeFosfatasaAlcalina;
	}

	public String getDosajeAmilasa() {
		return dosajeAmilasa;
	}

	public void setDosajeAmilasa(String dosajeAmilasa) {
		this.dosajeAmilasa = dosajeAmilasa;
	}

	public String getDosajeGgtp() {
		return dosajeGgtp;
	}

	public void setDosajeGgtp(String dosajeGgtp) {
		this.dosajeGgtp = dosajeGgtp;
	}

	public String getDosajeDeshidrogenasaLacticaLdh() {
		return dosajeDeshidrogenasaLacticaLdh;
	}

	public void setDosajeDeshidrogenasaLacticaLdh(String dosajeDeshidrogenasaLacticaLdh) {
		this.dosajeDeshidrogenasaLacticaLdh = dosajeDeshidrogenasaLacticaLdh;
	}

	public String getLipidosTotales() {
		return lipidosTotales;
	}

	public void setLipidosTotales(String lipidosTotales) {
		this.lipidosTotales = lipidosTotales;
	}

	public String getDosajeProteinasOrina24horas() {
		return dosajeProteinasOrina24horas;
	}

	public void setDosajeProteinasOrina24horas(String dosajeProteinasOrina24horas) {
		this.dosajeProteinasOrina24horas = dosajeProteinasOrina24horas;
	}

	public String getTotalBio() {
		return totalBio;
	}

	public void setTotalBio(String totalBio) {
		this.totalBio = totalBio;
	}

	public String getUsuarioRegBio() {
		return usuarioRegBio;
	}

	public void setUsuarioRegBio(String usuarioRegBio) {
		this.usuarioRegBio = usuarioRegBio;
	}

	public Timestamp getFechaRegBio() {
		return fechaRegBio;
	}

	public void setFechaRegBio(Timestamp fechaRegBio) {
		this.fechaRegBio = fechaRegBio;
	}

	public String getUsuarioModBio() {
		return usuarioModBio;
	}

	public void setUsuarioModBio(String usuarioModBio) {
		this.usuarioModBio = usuarioModBio;
	}

	public Timestamp getFechaModBio() {
		return fechaModBio;
	}

	public void setFechaModBio(Timestamp fechaModBio) {
		this.fechaModBio = fechaModBio;
	}

	public String getIpRegBio() {
		return ipRegBio;
	}

	public void setIpRegBio(String ipRegBio) {
		this.ipRegBio = ipRegBio;
	}

	public String getIpModBio() {
		return ipModBio;
	}

	public void setIpModBio(String ipModBio) {
		this.ipModBio = ipModBio;
	}

	public String getAnoBio() {
		return anoBio;
	}

	public void setAnoBio(String anoBio) {
		this.anoBio = anoBio;
	}

	public String getMesBio() {
		return mesBio;
	}

	public void setMesBio(String mesBio) {
		this.mesBio = mesBio;
	}

	public String getDepuracionCreatinina() {
		return depuracionCreatinina;
	}

	public void setDepuracionCreatinina(String depuracionCreatinina) {
		this.depuracionCreatinina = depuracionCreatinina;
	}

	public String getGlucosaTiraGlucometro() {
		return glucosaTiraGlucometro;
	}

	public void setGlucosaTiraGlucometro(String glucosaTiraGlucometro) {
		this.glucosaTiraGlucometro = glucosaTiraGlucometro;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Bioquimica [idBioquimica=" + idBioquimica + ", establecimientoBio=" + establecimientoBio
				+ ", estadoBio=" + estadoBio + ", dosajeGlucosa=" + dosajeGlucosa + ", toleranciaGlucosa="
				+ toleranciaGlucosa + ", glucosaPostPrandial=" + glucosaPostPrandial + ", dosajeHemoglobinaGlicosilada="
				+ dosajeHemoglobinaGlicosilada + ", dosajeUrea=" + dosajeUrea + ", dosajecreatinina=" + dosajecreatinina
				+ ", dosajeColesterolTotal=" + dosajeColesterolTotal + ", dosajeColesterolHdl=" + dosajeColesterolHdl
				+ ", dosajeColesterolLdl=" + dosajeColesterolLdl + ", dosajeTrigliceridos=" + dosajeTrigliceridos
				+ ", dosajeAcidoUrico=" + dosajeAcidoUrico + ", dosajeBilirrubinasTotales=" + dosajeBilirrubinasTotales
				+ ", dosajeBilirrubinaDirecta=" + dosajeBilirrubinaDirecta + ", dosajeProteínasTotales="
				+ dosajeProteínasTotales + ", dosajeAlbumina=" + dosajeAlbumina + ", dosajeTgoAst=" + dosajeTgoAst
				+ ", dosajeTgpAlt=" + dosajeTgpAlt + ", dosajeFosfatasaAlcalina=" + dosajeFosfatasaAlcalina
				+ ", dosajeAmilasa=" + dosajeAmilasa + ", dosajeGgtp=" + dosajeGgtp
				+ ", dosajeDeshidrogenasaLacticaLdh=" + dosajeDeshidrogenasaLacticaLdh + ", lipidosTotales="
				+ lipidosTotales + ", dosajeProteinasOrina24horas=" + dosajeProteinasOrina24horas + ", totalBio="
				+ totalBio + ", usuarioRegBio=" + usuarioRegBio + ", fechaRegBio=" + fechaRegBio + ", usuarioModBio="
				+ usuarioModBio + ", fechaModBio=" + fechaModBio + ", ipRegBio=" + ipRegBio + ", ipModBio=" + ipModBio
				+ ", anoBio=" + anoBio + ", mesBio=" + mesBio + ", depuracionCreatinina=" + depuracionCreatinina
				+ ", glucosaTiraGlucometro=" + glucosaTiraGlucometro + ", tamMicroCreaOriTira=" + tamMicroCreaOriTira
				+ ", otras_pruebas=" + otras_pruebas + "]";
	}
	
	

}

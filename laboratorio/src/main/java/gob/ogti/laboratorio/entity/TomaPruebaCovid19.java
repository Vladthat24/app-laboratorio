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
@Table(name="ogti_laboratorio_toma_prueba_covid")
public class TomaPruebaCovid19 implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3302060316669098589L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idTpCovid;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codEstablecimiento", referencedColumnName = "codEstablecimiento")
	private Establecimiento establecimientoTpCovid;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codEstado", referencedColumnName = "codEstado")
	private Estado estadoTpCovid;
	
	@Column(length = 5)
	private String pruebaRapidaAcIgmIgg;
	
	@Column(length = 5)
	private String pruebaRapidaAntigenoCo;
	
	@Column(length = 5)
	private String tomaMuestraMolecularCo;
	
	@Column(length = 5)
	private String ingresoDatosSiscovid;
	
	@Column(length = 10)
	private String totalTpCovid;
	
	@Column(length = 50)
	private String usuarioRegTpCovid;
	
	@Column(length = 50)
	private Timestamp fechaRegTpCovid;
	
	@Column(length = 50)
	private String usuarioModTpCovid;
	
	@Column(length = 50)
	private Timestamp fechaModTpCovid;
	
	@Column(length = 50)
	private String ipRegTpCovid;
	
	@Column(length = 50)
	private String ipModTpCovid;
	
	@Column(length = 50)
	private String anoTpc;
	
	@Column(length = 50)
	private String mesTpc;
	
	@Column(length = 5)
	private String pruebaMolCovidEaif;
	
	@Column(length = 5)
	private String ingresoDatosMolNetlab;

	public Long getIdTpCovid() {
		return idTpCovid;
	}

	public void setIdTpCovid(Long idTpCovid) {
		this.idTpCovid = idTpCovid;
	}

	public Establecimiento getEstablecimientoTpCovid() {
		return establecimientoTpCovid;
	}

	public void setEstablecimientoTpCovid(Establecimiento establecimientoTpCovid) {
		this.establecimientoTpCovid = establecimientoTpCovid;
	}

	public Estado getEstadoTpCovid() {
		return estadoTpCovid;
	}

	public void setEstadoTpCovid(Estado estadoTpCovid) {
		this.estadoTpCovid = estadoTpCovid;
	}

	public String getPruebaRapidaAcIgmIgg() {
		return pruebaRapidaAcIgmIgg;
	}

	public void setPruebaRapidaAcIgmIgg(String pruebaRapidaAcIgmIgg) {
		this.pruebaRapidaAcIgmIgg = pruebaRapidaAcIgmIgg;
	}

	public String getPruebaRapidaAntigenoCo() {
		return pruebaRapidaAntigenoCo;
	}

	public void setPruebaRapidaAntigenoCo(String pruebaRapidaAntigenoCo) {
		this.pruebaRapidaAntigenoCo = pruebaRapidaAntigenoCo;
	}

	public String getTomaMuestraMolecularCo() {
		return tomaMuestraMolecularCo;
	}

	public void setTomaMuestraMolecularCo(String tomaMuestraMolecularCo) {
		this.tomaMuestraMolecularCo = tomaMuestraMolecularCo;
	}

	public String getIngresoDatosSiscovid() {
		return ingresoDatosSiscovid;
	}

	public void setIngresoDatosSiscovid(String ingresoDatosSiscovid) {
		this.ingresoDatosSiscovid = ingresoDatosSiscovid;
	}

	public String getTotalTpCovid() {
		return totalTpCovid;
	}

	public void setTotalTpCovid(String totalTpCovid) {
		this.totalTpCovid = totalTpCovid;
	}

	public String getUsuarioRegTpCovid() {
		return usuarioRegTpCovid;
	}

	public void setUsuarioRegTpCovid(String usuarioRegTpCovid) {
		this.usuarioRegTpCovid = usuarioRegTpCovid;
	}

	public Timestamp getFechaRegTpCovid() {
		return fechaRegTpCovid;
	}

	public void setFechaRegTpCovid(Timestamp fechaRegTpCovid) {
		this.fechaRegTpCovid = fechaRegTpCovid;
	}

	public String getUsuarioModTpCovid() {
		return usuarioModTpCovid;
	}

	public void setUsuarioModTpCovid(String usuarioModTpCovid) {
		this.usuarioModTpCovid = usuarioModTpCovid;
	}

	public Timestamp getFechaModTpCovid() {
		return fechaModTpCovid;
	}

	public void setFechaModTpCovid(Timestamp fechaModTpCovid) {
		this.fechaModTpCovid = fechaModTpCovid;
	}

	public String getIpRegTpCovid() {
		return ipRegTpCovid;
	}

	public void setIpRegTpCovid(String ipRegTpCovid) {
		this.ipRegTpCovid = ipRegTpCovid;
	}

	public String getIpModTpCovid() {
		return ipModTpCovid;
	}

	public void setIpModTpCovid(String ipModTpCovid) {
		this.ipModTpCovid = ipModTpCovid;
	}

	public String getAnoTpc() {
		return anoTpc;
	}

	public void setAnoTpc(String anoTpc) {
		this.anoTpc = anoTpc;
	}

	public String getMesTpc() {
		return mesTpc;
	}

	public void setMesTpc(String mesTpc) {
		this.mesTpc = mesTpc;
	}

	public String getPruebaMolCovidEaif() {
		return pruebaMolCovidEaif;
	}

	public void setPruebaMolCovidEaif(String pruebaMolCovidEaif) {
		this.pruebaMolCovidEaif = pruebaMolCovidEaif;
	}

	public String getIngresoDatosMolNetlab() {
		return ingresoDatosMolNetlab;
	}

	public void setIngresoDatosMolNetlab(String ingresoDatosMolNetlab) {
		this.ingresoDatosMolNetlab = ingresoDatosMolNetlab;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "TomaPruebaCovid19 [idTpCovid=" + idTpCovid + ", establecimientoTpCovid=" + establecimientoTpCovid
				+ ", estadoTpCovid=" + estadoTpCovid + ", pruebaRapidaAcIgmIgg=" + pruebaRapidaAcIgmIgg
				+ ", pruebaRapidaAntigenoCo=" + pruebaRapidaAntigenoCo + ", tomaMuestraMolecularCo="
				+ tomaMuestraMolecularCo + ", ingresoDatosSiscovid=" + ingresoDatosSiscovid + ", totalTpCovid="
				+ totalTpCovid + ", usuarioRegTpCovid=" + usuarioRegTpCovid + ", fechaRegTpCovid=" + fechaRegTpCovid
				+ ", usuarioModTpCovid=" + usuarioModTpCovid + ", fechaModTpCovid=" + fechaModTpCovid
				+ ", ipRegTpCovid=" + ipRegTpCovid + ", ipModTpCovid=" + ipModTpCovid + ", anoTpc=" + anoTpc
				+ ", mesTpc=" + mesTpc + ", pruebaMolCovidEaif=" + pruebaMolCovidEaif + ", ingresoDatosMolNetlab="
				+ ingresoDatosMolNetlab + "]";
	}
	
	

}

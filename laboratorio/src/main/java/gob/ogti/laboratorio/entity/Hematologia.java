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
@Table(name="ogti_laboratorio_hematologia")
public class Hematologia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 9074137431107075396L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idHematologia;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codEstablecimiento", referencedColumnName = "codEstablecimiento")
	private Establecimiento establecimiento;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codEstado", referencedColumnName = "codEstado")
	private Estado estadoHema;
	
	@Column(length = 5)
	private String hemoglobina;
	
	@Column(length = 5)
	private String hemoglobinaHemoglobimetro;
	
	@Column(length = 5)
	private String hematocrito;
	
	@Column(length = 5)
	private String hemogramaManual;
	
	@Column(length = 5)
	private String hemogramaAutomatizado;
	
	@Column(length = 5)
	private String gotaGruesa;
	
	@Column(length = 5)
	private String velocSedimentGlobular;
	
	@Column(length = 5)
	private String gSanguineoFactorRh;
	
	@Column(length = 5)
	private String tiempoCoagulacion;
	
	@Column(length = 5)
	private String tiempoSangria;
	
	@Column(length = 5)
	private String recuentoPlaquetas;
	
	@Column(length = 5)
	private String recuentoReticulocitos;
	
	@Column(length = 5)
	private String tiempoTromboplastinaParcialActivado ;
	
	@Column(length = 5)
	private String tiempoProtrombina;
	
	@Column(length = 5)
	private String constantesCorpusculares;
	
	@Column(length = 5)
	private String frotisSangrePeriferica;
	
	@Column(length = 10)
	private String totalHema;
	
	@Column(length = 50)
	private String usuarioRegHem;
	
	@Column(length = 50)
	private Timestamp fechaRegHem;
	
	@Column(length = 50)
	private String usuarioModHem;
	
	@Column(length = 50)
	private Timestamp fechaModHem;
	
	@Column(length = 50)
	private String ipRegHem;
	
	@Column(length = 50)
	private String ipModHem;
	
	@Column(length = 50)
	private String anoHem;
	
	@Column(length = 50)
	private String mesHem;

	public Long getIdHematologia() {
		return idHematologia;
	}

	public void setIdHematologia(Long idHematologia) {
		this.idHematologia = idHematologia;
	}

	public Establecimiento getEstablecimiento() {
		return establecimiento;
	}

	public void setEstablecimiento(Establecimiento establecimiento) {
		this.establecimiento = establecimiento;
	}

	public Estado getEstadoHema() {
		return estadoHema;
	}

	public void setEstadoHema(Estado estadoHema) {
		this.estadoHema = estadoHema;
	}

	public String getHemoglobina() {
		return hemoglobina;
	}

	public void setHemoglobina(String hemoglobina) {
		this.hemoglobina = hemoglobina;
	}

	public String getHemoglobinaHemoglobimetro() {
		return hemoglobinaHemoglobimetro;
	}

	public void setHemoglobinaHemoglobimetro(String hemoglobinaHemoglobimetro) {
		this.hemoglobinaHemoglobimetro = hemoglobinaHemoglobimetro;
	}

	public String getHematocrito() {
		return hematocrito;
	}

	public void setHematocrito(String hematocrito) {
		this.hematocrito = hematocrito;
	}

	public String getHemogramaManual() {
		return hemogramaManual;
	}

	public void setHemogramaManual(String hemogramaManual) {
		this.hemogramaManual = hemogramaManual;
	}

	public String getHemogramaAutomatizado() {
		return hemogramaAutomatizado;
	}

	public void setHemogramaAutomatizado(String hemogramaAutomatizado) {
		this.hemogramaAutomatizado = hemogramaAutomatizado;
	}

	public String getGotaGruesa() {
		return gotaGruesa;
	}

	public void setGotaGruesa(String gotaGruesa) {
		this.gotaGruesa = gotaGruesa;
	}

	public String getVelocSedimentGlobular() {
		return velocSedimentGlobular;
	}

	public void setVelocSedimentGlobular(String velocSedimentGlobular) {
		this.velocSedimentGlobular = velocSedimentGlobular;
	}

	public String getgSanguineoFactorRh() {
		return gSanguineoFactorRh;
	}

	public void setgSanguineoFactorRh(String gSanguineoFactorRh) {
		this.gSanguineoFactorRh = gSanguineoFactorRh;
	}

	public String getTiempoCoagulacion() {
		return tiempoCoagulacion;
	}

	public void setTiempoCoagulacion(String tiempoCoagulacion) {
		this.tiempoCoagulacion = tiempoCoagulacion;
	}

	public String getTiempoSangria() {
		return tiempoSangria;
	}

	public void setTiempoSangria(String tiempoSangria) {
		this.tiempoSangria = tiempoSangria;
	}

	public String getRecuentoPlaquetas() {
		return recuentoPlaquetas;
	}

	public void setRecuentoPlaquetas(String recuentoPlaquetas) {
		this.recuentoPlaquetas = recuentoPlaquetas;
	}

	public String getRecuentoReticulocitos() {
		return recuentoReticulocitos;
	}

	public void setRecuentoReticulocitos(String recuentoReticulocitos) {
		this.recuentoReticulocitos = recuentoReticulocitos;
	}

	public String getTiempoTromboplastinaParcialActivado() {
		return tiempoTromboplastinaParcialActivado;
	}

	public void setTiempoTromboplastinaParcialActivado(String tiempoTromboplastinaParcialActivado) {
		this.tiempoTromboplastinaParcialActivado = tiempoTromboplastinaParcialActivado;
	}

	public String getTiempoProtrombina() {
		return tiempoProtrombina;
	}

	public void setTiempoProtrombina(String tiempoProtrombina) {
		this.tiempoProtrombina = tiempoProtrombina;
	}

	public String getConstantesCorpusculares() {
		return constantesCorpusculares;
	}

	public void setConstantesCorpusculares(String constantesCorpusculares) {
		this.constantesCorpusculares = constantesCorpusculares;
	}

	public String getFrotisSangrePeriferica() {
		return frotisSangrePeriferica;
	}

	public void setFrotisSangrePeriferica(String frotisSangrePeriferica) {
		this.frotisSangrePeriferica = frotisSangrePeriferica;
	}

	public String getTotalHema() {
		return totalHema;
	}

	public void setTotalHema(String totalHema) {
		this.totalHema = totalHema;
	}

	public String getUsuarioRegHem() {
		return usuarioRegHem;
	}

	public void setUsuarioRegHem(String usuarioRegHem) {
		this.usuarioRegHem = usuarioRegHem;
	}

	public Timestamp getFechaRegHem() {
		return fechaRegHem;
	}

	public void setFechaRegHem(Timestamp fechaRegHem) {
		this.fechaRegHem = fechaRegHem;
	}

	public String getUsuarioModHem() {
		return usuarioModHem;
	}

	public void setUsuarioModHem(String usuarioModHem) {
		this.usuarioModHem = usuarioModHem;
	}

	public Timestamp getFechaModHem() {
		return fechaModHem;
	}

	public void setFechaModHem(Timestamp fechaModHem) {
		this.fechaModHem = fechaModHem;
	}

	public String getIpRegHem() {
		return ipRegHem;
	}

	public void setIpRegHem(String ipRegHem) {
		this.ipRegHem = ipRegHem;
	}

	public String getIpModHem() {
		return ipModHem;
	}

	public void setIpModHem(String ipModHem) {
		this.ipModHem = ipModHem;
	}

	public String getAnoHem() {
		return anoHem;
	}

	public void setAnoHem(String anoHem) {
		this.anoHem = anoHem;
	}

	public String getMesHem() {
		return mesHem;
	}

	public void setMesHem(String mesHem) {
		this.mesHem = mesHem;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Hematologia [idHematologia=" + idHematologia + ", establecimiento=" + establecimiento + ", estadoHema="
				+ estadoHema + ", hemoglobina=" + hemoglobina + ", hemoglobinaHemoglobimetro="
				+ hemoglobinaHemoglobimetro + ", hematocrito=" + hematocrito + ", hemogramaManual=" + hemogramaManual
				+ ", hemogramaAutomatizado=" + hemogramaAutomatizado + ", gotaGruesa=" + gotaGruesa
				+ ", velocSedimentGlobular=" + velocSedimentGlobular + ", gSanguineoFactorRh=" + gSanguineoFactorRh
				+ ", tiempoCoagulacion=" + tiempoCoagulacion + ", tiempoSangria=" + tiempoSangria
				+ ", recuentoPlaquetas=" + recuentoPlaquetas + ", recuentoReticulocitos=" + recuentoReticulocitos
				+ ", tiempoTromboplastinaParcialActivado=" + tiempoTromboplastinaParcialActivado
				+ ", tiempoProtrombina=" + tiempoProtrombina + ", constantesCorpusculares=" + constantesCorpusculares
				+ ", frotisSangrePeriferica=" + frotisSangrePeriferica + ", totalHema=" + totalHema + ", usuarioRegHem="
				+ usuarioRegHem + ", fechaRegHem=" + fechaRegHem + ", usuarioModHem=" + usuarioModHem + ", fechaModHem="
				+ fechaModHem + ", ipRegHem=" + ipRegHem + ", ipModHem=" + ipModHem + ", anoHem=" + anoHem + ", mesHem="
				+ mesHem + "]";
	}

	
}

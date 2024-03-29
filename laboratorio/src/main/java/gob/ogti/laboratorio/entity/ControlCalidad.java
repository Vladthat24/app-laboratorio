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
@Table(name="ogti_laboratorio_control_calidad")
public class ControlCalidad implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4268693493995921730L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idControl;
	
	@Column(length = 10)
	private String Bk;
	
	@Column(length = 10)
	private String gotaGruesa;
	
	@Column(length = 10)
	private String totalControl;
	
	@Column(length = 10)
	private String mesControl;
	
	@Column(length = 10)
	private String anoControl;
	
	@Column(length = 50)
	private String usuarioControl;
	
	@Column(length = 50)
	private Timestamp fechaRegControl;
	
	@Column(length = 50)
	private String usuarioModControl;
	
	@Column(length = 50)
	private Timestamp fechaModControl;
	
	@Column(length = 50)
	private String ipRegControl;
	
	@Column(length = 50)
	private String ipModControl;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codEstado", referencedColumnName = "codEstado")
	private Estado estadoControl;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codEstablecimiento", referencedColumnName = "codEstablecimiento")
	private Establecimiento establecimientoControl;
	
	@Column(length=5)
	private String contrCalExtHem;
	
	@Column(length=5)
	private String contrCalIntHem;
	
	@Column(length=5)
	private String contrCalIntBio;
	
	@Column(length=5)
	private String contrCalExtBio;
	
	@Column(length=5)
	private String otrosContrCal;

	public String getContrCalExtHem() {
		return contrCalExtHem;
	}

	public void setContrCalExtHem(String contrCalExtHem) {
		this.contrCalExtHem = contrCalExtHem;
	}

	public String getContrCalIntHem() {
		return contrCalIntHem;
	}

	public void setContrCalIntHem(String contrCalIntHem) {
		this.contrCalIntHem = contrCalIntHem;
	}

	public String getContrCalIntBio() {
		return contrCalIntBio;
	}

	public void setContrCalIntBio(String contrCalIntBio) {
		this.contrCalIntBio = contrCalIntBio;
	}

	public String getContrCalExtBio() {
		return contrCalExtBio;
	}

	public void setContrCalExtBio(String contrCalExtBio) {
		this.contrCalExtBio = contrCalExtBio;
	}

	public String getOtrosContrCal() {
		return otrosContrCal;
	}

	public void setOtrosContrCal(String otrosContrCal) {
		this.otrosContrCal = otrosContrCal;
	}

	public Establecimiento getEstablecimientoControl() {
		return establecimientoControl;
	}

	public void setEstablecimientoControl(Establecimiento establecimientoControl) {
		this.establecimientoControl = establecimientoControl;
	}

	public Estado getEstadoControl() {
		return estadoControl;
	}

	public void setEstadoControl(Estado estadoControl) {
		this.estadoControl = estadoControl;
	}

	public Long getIdControl() {
		return idControl;
	}

	public void setIdControl(Long idControl) {
		this.idControl = idControl;
	}

	public String getBk() {
		return Bk;
	}

	public void setBk(String bk) {
		Bk = bk;
	}

	public String getGotaGruesa() {
		return gotaGruesa;
	}

	public void setGotaGruesa(String gotaGruesa) {
		this.gotaGruesa = gotaGruesa;
	}

	public String getTotalControl() {
		return totalControl;
	}

	public void setTotalControl(String totalControl) {
		this.totalControl = totalControl;
	}

	public String getMesControl() {
		return mesControl;
	}

	public void setMesControl(String mesControl) {
		this.mesControl = mesControl;
	}

	public String getAnoControl() {
		return anoControl;
	}

	public void setAnoControl(String anoControl) {
		this.anoControl = anoControl;
	}

	public String getUsuarioControl() {
		return usuarioControl;
	}

	public void setUsuarioControl(String usuarioControl) {
		this.usuarioControl = usuarioControl;
	}

	public Timestamp getFechaRegControl() {
		return fechaRegControl;
	}

	public void setFechaRegControl(Timestamp fechaRegControl) {
		this.fechaRegControl = fechaRegControl;
	}

	public String getUsuarioModControl() {
		return usuarioModControl;
	}

	public void setUsuarioModControl(String usuarioModControl) {
		this.usuarioModControl = usuarioModControl;
	}

	public Timestamp getFechaModControl() {
		return fechaModControl;
	}

	public void setFechaModControl(Timestamp fechaModControl) {
		this.fechaModControl = fechaModControl;
	}

	public String getIpRegControl() {
		return ipRegControl;
	}

	public void setIpRegControl(String ipRegControl) {
		this.ipRegControl = ipRegControl;
	}

	public String getIpModControl() {
		return ipModControl;
	}

	public void setIpModControl(String ipModControl) {
		this.ipModControl = ipModControl;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "ControlCalidad [idControl=" + idControl + ", Bk=" + Bk + ", gotaGruesa=" + gotaGruesa
				+ ", totalControl=" + totalControl + ", mesControl=" + mesControl + ", anoControl=" + anoControl
				+ ", usuarioControl=" + usuarioControl + ", fechaRegControl=" + fechaRegControl + ", usuarioModControl="
				+ usuarioModControl + ", fechaModControl=" + fechaModControl + ", ipRegControl=" + ipRegControl
				+ ", ipModControl=" + ipModControl + ", estadoControl=" + estadoControl + ", establecimientoControl="
				+ establecimientoControl + ", contrCalExtHem=" + contrCalExtHem + ", contrCalIntHem=" + contrCalIntHem
				+ ", contrCalIntBio=" + contrCalIntBio + ", contrCalExtBio=" + contrCalExtBio + ", otrosContrCal="
				+ otrosContrCal + "]";
	}

	
}

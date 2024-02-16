package gob.ogti.laboratorio.entity;

import java.io.Serializable;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="ogti_laboratorio_estado")
public class Estado implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6912542272894489681L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idEstado;
	
	@Column(length = 10)
	private String codEstado;
	
	@Column(length = 10)
	private String descEstado;
	
	@Column(length = 50)
	private String usuarioRegEstado;
	
	@Column(length = 50)
	private Timestamp fechaRegEstado;
	
	@Column(length = 50)
	private String usuarioModEstado;
	
	@Column(length = 50)
	private Timestamp fechaModEstado;
	
	@Column(length = 50)
	private String ipRegEstado;
	
	@Column(length = 50)
	private String ipModEstado;

	public Long getIdEstado() {
		return idEstado;
	}

	public void setIdEstado(Long idEstado) {
		this.idEstado = idEstado;
	}

	public String getCodEstado() {
		return codEstado;
	}

	public void setCodEstado(String codEstado) {
		this.codEstado = codEstado;
	}

	public String getDescEstado() {
		return descEstado;
	}

	public void setDescEstado(String descEstado) {
		this.descEstado = descEstado;
	}

	public String getUsuarioRegEstado() {
		return usuarioRegEstado;
	}

	public void setUsuarioRegEstado(String usuarioRegEstado) {
		this.usuarioRegEstado = usuarioRegEstado;
	}

	public Timestamp getFechaRegEstado() {
		return fechaRegEstado;
	}

	public void setFechaRegEstado(Timestamp fechaRegEstado) {
		this.fechaRegEstado = fechaRegEstado;
	}

	public String getUsuarioModEstado() {
		return usuarioModEstado;
	}

	public void setUsuarioModEstado(String usuarioModEstado) {
		this.usuarioModEstado = usuarioModEstado;
	}

	public Timestamp getFechaModEstado() {
		return fechaModEstado;
	}

	public void setFechaModEstado(Timestamp fechaModEstado) {
		this.fechaModEstado = fechaModEstado;
	}

	public String getIpRegEstado() {
		return ipRegEstado;
	}

	public void setIpRegEstado(String ipRegEstado) {
		this.ipRegEstado = ipRegEstado;
	}

	public String getIpModEstado() {
		return ipModEstado;
	}

	public void setIpModEstado(String ipModEstado) {
		this.ipModEstado = ipModEstado;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Estado [idEstado=" + idEstado + ", codEstado=" + codEstado + ", descEstado=" + descEstado
				+ ", usuarioRegEstado=" + usuarioRegEstado + ", fechaRegEstado=" + fechaRegEstado
				+ ", usuarioModEstado=" + usuarioModEstado + ", fechaModEstado=" + fechaModEstado + ", ipRegEstado="
				+ ipRegEstado + ", ipModEstado=" + ipModEstado + "]";
	}

	

}

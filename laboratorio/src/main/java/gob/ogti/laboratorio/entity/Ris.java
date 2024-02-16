package gob.ogti.laboratorio.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ogti_laboratorio_ris")
public class Ris implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2793748814291094195L;
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idRis;
	
	@Column
    private String codRis;
	
	@Column
    private String descripcionRis;

	public long getIdRis() {
		return idRis;
	}

	public void setIdRis(long idRis) {
		this.idRis = idRis;
	}

	public String getCodRis() {
		return codRis;
	}

	public void setCodRis(String codRis) {
		this.codRis = codRis;
	}

	public String getDescripcionRis() {
		return descripcionRis;
	}

	public void setDescripcionRis(String descripcionRis) {
		this.descripcionRis = descripcionRis;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Ris [idRis=" + idRis + ", codRis=" + codRis + ", descripcionRis=" + descripcionRis + "]";
	}

	
	
}

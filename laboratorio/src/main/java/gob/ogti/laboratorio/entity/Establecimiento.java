package gob.ogti.laboratorio.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="ogti_laboratorio_establecimiento")
public class Establecimiento implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7646442811914676693L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEstablecimiento;
	
	@Column
    private String codEstablecimiento;
	
	@Column
    private String descripcionEstablecimiento;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codRis", referencedColumnName = "codRis")
	private Ris ris;
	
	
	@Column
    private String categoriaEstablecimiento;
	
	@Column
    private String direccionEstablecimiento;
	
	@Column
    private String latitudEstablecimiento;
	
	@Column
    private String longitudEstablecimiento;
	
	@Column
    private String distritoEstablecimiento;
	
	@Column
    private String laboratorio;

	public String getLaboratorio() {
		return laboratorio;
	}

	public void setLaboratorio(String laboratorio) {
		this.laboratorio = laboratorio;
	}

	@Override
	public String toString() {
		return "Establecimiento [idEstablecimiento=" + idEstablecimiento + ", codEstablecimiento=" + codEstablecimiento
				+ ", descripcionEstablecimiento=" + descripcionEstablecimiento + ", ris=" + ris
				+ ", categoriaEstablecimiento=" + categoriaEstablecimiento + ", direccionEstablecimiento="
				+ direccionEstablecimiento + ", latitudEstablecimiento=" + latitudEstablecimiento
				+ ", longitudEstablecimiento=" + longitudEstablecimiento + ", distritoEstablecimiento="
				+ distritoEstablecimiento + ", laboratorio=" + laboratorio + "]";
	}

	public long getIdEstablecimiento() {
		return idEstablecimiento;
	}

	public void setIdEstablecimiento(long idEstablecimiento) {
		this.idEstablecimiento = idEstablecimiento;
	}

	public String getCodEstablecimiento() {
		return codEstablecimiento;
	}

	public void setCodEstablecimiento(String codEstablecimiento) {
		this.codEstablecimiento = codEstablecimiento;
	}

	public String getDescripcionEstablecimiento() {
		return descripcionEstablecimiento;
	}

	public void setDescripcionEstablecimiento(String descripcionEstablecimiento) {
		this.descripcionEstablecimiento = descripcionEstablecimiento;
	}

	public Ris getRis() {
		return ris;
	}

	public void setRis(Ris ris) {
		this.ris = ris;
	}

	public String getCategoriaEstablecimiento() {
		return categoriaEstablecimiento;
	}

	public void setCategoriaEstablecimiento(String categoriaEstablecimiento) {
		this.categoriaEstablecimiento = categoriaEstablecimiento;
	}

	public String getDireccionEstablecimiento() {
		return direccionEstablecimiento;
	}

	public void setDireccionEstablecimiento(String direccionEstablecimiento) {
		this.direccionEstablecimiento = direccionEstablecimiento;
	}

	public String getLatitudEstablecimiento() {
		return latitudEstablecimiento;
	}

	public void setLatitudEstablecimiento(String latitudEstablecimiento) {
		this.latitudEstablecimiento = latitudEstablecimiento;
	}

	public String getLongitudEstablecimiento() {
		return longitudEstablecimiento;
	}

	public void setLongitudEstablecimiento(String longitudEstablecimiento) {
		this.longitudEstablecimiento = longitudEstablecimiento;
	}

	public String getDistritoEstablecimiento() {
		return distritoEstablecimiento;
	}

	public void setDistritoEstablecimiento(String distritoEstablecimiento) {
		this.distritoEstablecimiento = distritoEstablecimiento;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	

}

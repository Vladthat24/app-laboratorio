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
@Table(name="ogti_laboratorio_microbiologia")
public class Microbiologia implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 230956145515755517L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO, generator="native")
	@GenericGenerator(name="native",strategy="native")
	private Long idMicrobiologia;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codEstablecimiento", referencedColumnName = "codEstablecimiento")
	private Establecimiento establecimientoMic;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "codEstado", referencedColumnName = "codEstado")
	private Estado estadoMic;
	
	@Column(length = 5)
	private String examenCompletoOrina;
	
	@Column(length = 5)
	private String tincionGram;
	
	@Column(length = 5)
	private String investigacionDirectaHongos ;
	
	@Column(length = 5)
	private String tincionAzulMetileno;
	
	@Column(length = 5)
	private String investigacionDirectaAcaros;
	
	@Column(length = 5)
	private String urocultivoIdentAntibiograma;
	
	@Column(length = 5)
	private String coprocultivoIdentAntibiograma;
	
	@Column(length = 5)
	private String reaccionInflamatoria;
	
	@Column(length = 5)
	private String coprologicoFuncional;
	
	@Column(length = 5)
	private String testGraham;
	
	@Column(length = 5)
	private String investigacionSangreOcultaHecesThevenon;
	
	@Column(length = 5)
	private String examenParasitologHecesDirecto;
	
	@Column(length = 5)
	private String examenParasitologicoSeriadoTresMuestras;
	
	@Column(length = 5)
	private String examenDirectoSecrecionVaginal;
	
	@Column(length = 5)
	private String cultSecVaginal;
	
	@Column(length = 5)
	private String cultivoSecFaringea;
	
	@Column(length = 5)
	private String cultivoHeridas;
	
	@Column(length = 5)
	private String cultHongos;
	
	@Column(length = 5)
	private String cultSecUretal;
	
	@Column(length = 5)
	private String BkEsputo;
	
	@Column(length = 10)
	private String totalMic;
	
	@Column(length = 50)
	private String usuarioRegMic;
	
	@Column(length = 50)
	private Timestamp fechaRegMic;
	
	@Column(length = 50)
	private String usuarioModMic;
	
	@Column(length = 50)
	private Timestamp fechaModMic;
	
	@Column(length = 50)
	private String ipRegMic;
	
	@Column(length = 50)
	private String ipModMic;
	
	@Column(length = 50)
	private String anoMic;
	
	@Column(length = 50)
	private String mesMic;
	
	@Column(length = 5)
	private String proteinasOrina;
	
	@Column(length = 5)
	private String testCristalizacionHelecho;
	
	@Column(length = 5)
	private String cultivoMycobacteriumTb;

	public Long getIdMicrobiologia() {
		return idMicrobiologia;
	}

	public void setIdMicrobiologia(Long idMicrobiologia) {
		this.idMicrobiologia = idMicrobiologia;
	}

	public Establecimiento getEstablecimientoMic() {
		return establecimientoMic;
	}

	public void setEstablecimientoMic(Establecimiento establecimientoMic) {
		this.establecimientoMic = establecimientoMic;
	}

	public Estado getEstadoMic() {
		return estadoMic;
	}

	public void setEstadoMic(Estado estadoMic) {
		this.estadoMic = estadoMic;
	}

	public String getExamenCompletoOrina() {
		return examenCompletoOrina;
	}

	public void setExamenCompletoOrina(String examenCompletoOrina) {
		this.examenCompletoOrina = examenCompletoOrina;
	}

	public String getTincionGram() {
		return tincionGram;
	}

	public void setTincionGram(String tincionGram) {
		this.tincionGram = tincionGram;
	}

	public String getInvestigacionDirectaHongos() {
		return investigacionDirectaHongos;
	}

	public void setInvestigacionDirectaHongos(String investigacionDirectaHongos) {
		this.investigacionDirectaHongos = investigacionDirectaHongos;
	}

	public String getTincionAzulMetileno() {
		return tincionAzulMetileno;
	}

	public void setTincionAzulMetileno(String tincionAzulMetileno) {
		this.tincionAzulMetileno = tincionAzulMetileno;
	}

	public String getInvestigacionDirectaAcaros() {
		return investigacionDirectaAcaros;
	}

	public void setInvestigacionDirectaAcaros(String investigacionDirectaAcaros) {
		this.investigacionDirectaAcaros = investigacionDirectaAcaros;
	}

	public String getUrocultivoIdentAntibiograma() {
		return urocultivoIdentAntibiograma;
	}

	public void setUrocultivoIdentAntibiograma(String urocultivoIdentAntibiograma) {
		this.urocultivoIdentAntibiograma = urocultivoIdentAntibiograma;
	}

	public String getCoprocultivoIdentAntibiograma() {
		return coprocultivoIdentAntibiograma;
	}

	public void setCoprocultivoIdentAntibiograma(String coprocultivoIdentAntibiograma) {
		this.coprocultivoIdentAntibiograma = coprocultivoIdentAntibiograma;
	}

	public String getReaccionInflamatoria() {
		return reaccionInflamatoria;
	}

	public void setReaccionInflamatoria(String reaccionInflamatoria) {
		this.reaccionInflamatoria = reaccionInflamatoria;
	}

	public String getCoprologicoFuncional() {
		return coprologicoFuncional;
	}

	public void setCoprologicoFuncional(String coprologicoFuncional) {
		this.coprologicoFuncional = coprologicoFuncional;
	}

	public String getTestGraham() {
		return testGraham;
	}

	public void setTestGraham(String testGraham) {
		this.testGraham = testGraham;
	}

	public String getInvestigacionSangreOcultaHecesThevenon() {
		return investigacionSangreOcultaHecesThevenon;
	}

	public void setInvestigacionSangreOcultaHecesThevenon(String investigacionSangreOcultaHecesThevenon) {
		this.investigacionSangreOcultaHecesThevenon = investigacionSangreOcultaHecesThevenon;
	}

	public String getExamenParasitologHecesDirecto() {
		return examenParasitologHecesDirecto;
	}

	public void setExamenParasitologHecesDirecto(String examenParasitologHecesDirecto) {
		this.examenParasitologHecesDirecto = examenParasitologHecesDirecto;
	}

	public String getExamenParasitologicoSeriadoTresMuestras() {
		return examenParasitologicoSeriadoTresMuestras;
	}

	public void setExamenParasitologicoSeriadoTresMuestras(String examenParasitologicoSeriadoTresMuestras) {
		this.examenParasitologicoSeriadoTresMuestras = examenParasitologicoSeriadoTresMuestras;
	}

	public String getExamenDirectoSecrecionVaginal() {
		return examenDirectoSecrecionVaginal;
	}

	public void setExamenDirectoSecrecionVaginal(String examenDirectoSecrecionVaginal) {
		this.examenDirectoSecrecionVaginal = examenDirectoSecrecionVaginal;
	}

	public String getCultSecVaginal() {
		return cultSecVaginal;
	}

	public void setCultSecVaginal(String cultSecVaginal) {
		this.cultSecVaginal = cultSecVaginal;
	}

	public String getCultivoSecFaringea() {
		return cultivoSecFaringea;
	}

	public void setCultivoSecFaringea(String cultivoSecFaringea) {
		this.cultivoSecFaringea = cultivoSecFaringea;
	}

	public String getCultivoHeridas() {
		return cultivoHeridas;
	}

	public void setCultivoHeridas(String cultivoHeridas) {
		this.cultivoHeridas = cultivoHeridas;
	}

	public String getCultHongos() {
		return cultHongos;
	}

	public void setCultHongos(String cultHongos) {
		this.cultHongos = cultHongos;
	}

	public String getCultSecUretal() {
		return cultSecUretal;
	}

	public void setCultSecUretal(String cultSecUretal) {
		this.cultSecUretal = cultSecUretal;
	}

	public String getBkEsputo() {
		return BkEsputo;
	}

	public void setBkEsputo(String bkEsputo) {
		BkEsputo = bkEsputo;
	}

	public String getTotalMic() {
		return totalMic;
	}

	public void setTotalMic(String totalMic) {
		this.totalMic = totalMic;
	}

	public String getUsuarioRegMic() {
		return usuarioRegMic;
	}

	public void setUsuarioRegMic(String usuarioRegMic) {
		this.usuarioRegMic = usuarioRegMic;
	}

	public Timestamp getFechaRegMic() {
		return fechaRegMic;
	}

	public void setFechaRegMic(Timestamp fechaRegMic) {
		this.fechaRegMic = fechaRegMic;
	}

	public String getUsuarioModMic() {
		return usuarioModMic;
	}

	public void setUsuarioModMic(String usuarioModMic) {
		this.usuarioModMic = usuarioModMic;
	}

	public Timestamp getFechaModMic() {
		return fechaModMic;
	}

	public void setFechaModMic(Timestamp fechaModMic) {
		this.fechaModMic = fechaModMic;
	}

	public String getIpRegMic() {
		return ipRegMic;
	}

	public void setIpRegMic(String ipRegMic) {
		this.ipRegMic = ipRegMic;
	}

	public String getIpModMic() {
		return ipModMic;
	}

	public void setIpModMic(String ipModMic) {
		this.ipModMic = ipModMic;
	}

	public String getAnoMic() {
		return anoMic;
	}

	public void setAnoMic(String anoMic) {
		this.anoMic = anoMic;
	}

	public String getMesMic() {
		return mesMic;
	}

	public void setMesMic(String mesMic) {
		this.mesMic = mesMic;
	}

	public String getProteinasOrina() {
		return proteinasOrina;
	}

	public void setProteinasOrina(String proteinasOrina) {
		this.proteinasOrina = proteinasOrina;
	}

	public String getTestCristalizacionHelecho() {
		return testCristalizacionHelecho;
	}

	public void setTestCristalizacionHelecho(String testCristalizacionHelecho) {
		this.testCristalizacionHelecho = testCristalizacionHelecho;
	}

	public String getCultivoMycobacteriumTb() {
		return cultivoMycobacteriumTb;
	}

	public void setCultivoMycobacteriumTb(String cultivoMycobacteriumTb) {
		this.cultivoMycobacteriumTb = cultivoMycobacteriumTb;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Microbiologia [idMicrobiologia=" + idMicrobiologia + ", establecimientoMic=" + establecimientoMic
				+ ", estadoMic=" + estadoMic + ", examenCompletoOrina=" + examenCompletoOrina + ", tincionGram="
				+ tincionGram + ", investigacionDirectaHongos=" + investigacionDirectaHongos + ", tincionAzulMetileno="
				+ tincionAzulMetileno + ", investigacionDirectaAcaros=" + investigacionDirectaAcaros
				+ ", urocultivoIdentAntibiograma=" + urocultivoIdentAntibiograma + ", coprocultivoIdentAntibiograma="
				+ coprocultivoIdentAntibiograma + ", reaccionInflamatoria=" + reaccionInflamatoria
				+ ", coprologicoFuncional=" + coprologicoFuncional + ", testGraham=" + testGraham
				+ ", investigacionSangreOcultaHecesThevenon=" + investigacionSangreOcultaHecesThevenon
				+ ", examenParasitologHecesDirecto=" + examenParasitologHecesDirecto
				+ ", examenParasitologicoSeriadoTresMuestras=" + examenParasitologicoSeriadoTresMuestras
				+ ", examenDirectoSecrecionVaginal=" + examenDirectoSecrecionVaginal + ", cultSecVaginal="
				+ cultSecVaginal + ", cultivoSecFaringea=" + cultivoSecFaringea + ", cultivoHeridas=" + cultivoHeridas
				+ ", cultHongos=" + cultHongos + ", cultSecUretal=" + cultSecUretal + ", BkEsputo=" + BkEsputo
				+ ", totalMic=" + totalMic + ", usuarioRegMic=" + usuarioRegMic + ", fechaRegMic=" + fechaRegMic
				+ ", usuarioModMic=" + usuarioModMic + ", fechaModMic=" + fechaModMic + ", ipRegMic=" + ipRegMic
				+ ", ipModMic=" + ipModMic + ", anoMic=" + anoMic + ", mesMic=" + mesMic + ", proteinasOrina="
				+ proteinasOrina + ", testCristalizacionHelecho=" + testCristalizacionHelecho
				+ ", cultivoMycobacteriumTb=" + cultivoMycobacteriumTb + "]";
	}

	
}

package gob.ogti.laboratorio.dto;

public class reporteAnalisisClinicos {

	String exaNomEsta;
	
	String exaHematologia;
	
	String exaBioquimica;
	
	String exaInmunologia;
	
	String exaMicrobiologia;
	
	String exaAno;
	
	String exaMes;
	
	String totSumExa;
	
	String totSumMesExa;
	
	

	public String getTotSumMesExa() {
		return totSumMesExa;
	}

	public void setTotSumMesExa(String totSumMesExa) {
		this.totSumMesExa = totSumMesExa;
	}

	public String getExaNomEsta() {
		return exaNomEsta;
	}

	public void setExaNomEsta(String exaNomEsta) {
		this.exaNomEsta = exaNomEsta;
	}

	public String getExaHematologia() {
		return exaHematologia;
	}

	public void setExaHematologia(String exaHematologia) {
		this.exaHematologia = exaHematologia;
	}

	public String getExaBioquimica() {
		return exaBioquimica;
	}

	public void setExaBioquimica(String exaBioquimica) {
		this.exaBioquimica = exaBioquimica;
	}

	public String getExaInmunologia() {
		return exaInmunologia;
	}

	public void setExaInmunologia(String exaInmunologia) {
		this.exaInmunologia = exaInmunologia;
	}

	public String getExaMicrobiologia() {
		return exaMicrobiologia;
	}

	public void setExaMicrobiologia(String exaMicrobiologia) {
		this.exaMicrobiologia = exaMicrobiologia;
	}

	public String getExaAno() {
		return exaAno;
	}

	public void setExaAno(String exaAno) {
		this.exaAno = exaAno;
	}

	public String getExaMes() {
		return exaMes;
	}

	public void setExaMes(String exaMes) {
		this.exaMes = exaMes;
	}

	public String getTotSumExa() {
		return totSumExa;
	}

	public void setTotSumExa(String totSumExa) {
		this.totSumExa = totSumExa;
	}

	@Override
	public String toString() {
		return "reporteAnalisisClinicos [exaNomEsta=" + exaNomEsta + ", exaHematologia=" + exaHematologia
				+ ", exaBioquimica=" + exaBioquimica + ", exaInmunologia=" + exaInmunologia + ", exaMicrobiologia="
				+ exaMicrobiologia + ", exaAno=" + exaAno + ", exaMes=" + exaMes + ", totSumExa=" + totSumExa
				+ ", totSumMesExa=" + totSumMesExa + "]";
	}

	
	
}

package mintrabajo.dashboard.model;


import java.math.BigDecimal;

public class TotalSancion {
    Integer     periodicidad;
    String      labelPeriodicidad;
    String      labelFecha;
    BigDecimal  totSancionEjecu;
    BigDecimal  totSancionNoEje;
    BigDecimal  numProcesoEjecu;
    BigDecimal  numProcesoNoEje;
    
    public TotalSancion() {}

	public Integer getPeriodicidad() {
		return periodicidad;
	}

	public void setPeriodicidad(Integer periodicidad) {
		this.periodicidad = periodicidad;
	}

	public String getLabelPeriodicidad() {
		return labelPeriodicidad;
	}

	public void setLabelPeriodicidad(String labelPeriodicidad) {
		this.labelPeriodicidad = labelPeriodicidad;
	}

	public String getLabelFecha() {
		return labelFecha;
	}

	public void setLabelFecha(String labelFecha) {
		this.labelFecha = labelFecha;
	}

	public BigDecimal getTotSancionEjecu() {
		return totSancionEjecu;
	}

	public void setTotSancionEjecu(BigDecimal totSancionEjecu) {
		this.totSancionEjecu = totSancionEjecu;
	}

	public BigDecimal getTotSancionNoEje() {
		return totSancionNoEje;
	}

	public void setTotSancionNoEje(BigDecimal totSancionNoEje) {
		this.totSancionNoEje = totSancionNoEje;
	}

	public BigDecimal getNumProcesoEjecu() {
		return numProcesoEjecu;
	}

	public void setNumProcesoEjecu(BigDecimal numProcesoEjecu) {
		this.numProcesoEjecu = numProcesoEjecu;
	}

	public BigDecimal getNumProcesoNoEje() {
		return numProcesoNoEje;
	}

	public void setNumProcesoNoEje(BigDecimal numProcesoNoEje) {
		this.numProcesoNoEje = numProcesoNoEje;
	}
    
}

package mintrabajo.dashboard.model;


import java.math.BigDecimal;

public class SancionSectorEcono {
    private String rangoFecha;
    private String label;
    private BigDecimal numProcesosEjecu;
    private BigDecimal totalSancionEjecu;
    private BigDecimal numProcesosNoEjecu;
    private BigDecimal totalSancionNoEjecu;
    private Integer indicadorPeriodo;
    public SancionSectorEcono() {
    	
    }
	public String getRangoFecha() {
		return rangoFecha;
	}
	public void setRangoFecha(String rangoFecha) {
		this.rangoFecha = rangoFecha;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public BigDecimal getNumProcesosEjecu() {
		return numProcesosEjecu;
	}
	public void setNumProcesosEjecu(BigDecimal numProcesosEjecu) {
		this.numProcesosEjecu = numProcesosEjecu;
	}
	public BigDecimal getTotalSancionEjecu() {
		return totalSancionEjecu;
	}
	public void setTotalSancionEjecu(BigDecimal totalSancionEjecu) {
		this.totalSancionEjecu = totalSancionEjecu;
	}
	public BigDecimal getNumProcesosNoEjecu() {
		return numProcesosNoEjecu;
	}
	public void setNumProcesosNoEjecu(BigDecimal numProcesosNoEjecu) {
		this.numProcesosNoEjecu = numProcesosNoEjecu;
	}
	public BigDecimal getTotalSancionNoEjecu() {
		return totalSancionNoEjecu;
	}
	public void setTotalSancionNoEjecu(BigDecimal totalSancionNoEjecu) {
		this.totalSancionNoEjecu = totalSancionNoEjecu;
	}
	public Integer getIndicadorPeriodo() {
		return indicadorPeriodo;
	}
	public void setIndicadorPeriodo(Integer indicadorPeriodo) {
		this.indicadorPeriodo = indicadorPeriodo;
	}
}

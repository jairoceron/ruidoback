package mintrabajo.dashboard.services;


import java.math.BigDecimal;


public class SancionConsolidado {
    private String      rangoFecha;
    private String      label;
    private BigDecimal  numProcesos;
    private BigDecimal  totalSancion;
    private Integer     indicadorPeriodo;
    
    public SancionConsolidado() {
    	
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

	public BigDecimal getNumProcesos() {
		return numProcesos;
	}

	public void setNumProcesos(BigDecimal numProcesos) {
		this.numProcesos = numProcesos;
	}

	public BigDecimal getTotalSancion() {
		return totalSancion;
	}

	public void setTotalSancion(BigDecimal totalSancion) {
		this.totalSancion = totalSancion;
	}

	public Integer getIndicadorPeriodo() {
		return indicadorPeriodo;
	}

	public void setIndicadorPeriodo(Integer indicadorPeriodo) {
		this.indicadorPeriodo = indicadorPeriodo;
	}
}
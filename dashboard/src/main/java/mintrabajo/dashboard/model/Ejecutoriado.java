package mintrabajo.dashboard.model;

import java.math.BigDecimal;

public class Ejecutoriado {
    private BigDecimal numProcesos;
    private BigDecimal totalSancion;
    private String dirTerritorial;
    
    public Ejecutoriado() {}

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

	public String getDirTerritorial() {
		return dirTerritorial;
	}

	public void setDirTerritorial(String dirTerritorial) {
		this.dirTerritorial = dirTerritorial;
	}
}

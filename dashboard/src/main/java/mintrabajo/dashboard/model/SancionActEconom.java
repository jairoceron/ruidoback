package mintrabajo.dashboard.model;

import java.math.BigDecimal;

public class SancionActEconom {
    private  BigDecimal numeroProcesos;
    private  BigDecimal idActiEcon;
    private String descActivEcono;
    private BigDecimal sumaSancion;
    
    public SancionActEconom() {}

	public BigDecimal getNumeroProcesos() {
		return numeroProcesos;
	}

	public void setNumeroProcesos(BigDecimal numeroProcesos) {
		this.numeroProcesos = numeroProcesos;
	}

	public BigDecimal getIdActiEcon() {
		return idActiEcon;
	}

	public void setIdActiEcon(BigDecimal idActiEcon) {
		this.idActiEcon = idActiEcon;
	}

	public String getDescActivEcono() {
		return descActivEcono;
	}

	public void setDescActivEcono(String descActivEcono) {
		this.descActivEcono = descActivEcono;
	}

	public BigDecimal getSumaSancion() {
		return sumaSancion;
	}

	public void setSumaSancion(BigDecimal sumaSancion) {
		this.sumaSancion = sumaSancion;
	}
    
}

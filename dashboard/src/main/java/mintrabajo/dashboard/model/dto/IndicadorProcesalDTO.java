package mintrabajo.dashboard.model.dto;

import java.io.Serializable;

public class IndicadorProcesalDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -6100881849444847536L;
	private String territorialReparto;
	private Integer activos;
	private Integer finalizados;
	private Integer totales;
	private Integer primerMes;
	private Integer segundoMes;
	private Integer tercerMes;
	private Integer totalAvanzadas;
	private Double porcentajeAvance;
	public IndicadorProcesalDTO() {}
	public String getTerritorialReparto() {
		return territorialReparto;
	}
	public void setTerritorialReparto(String territorialReparto) {
		this.territorialReparto = territorialReparto;
	}
	public Integer getActivos() {
		return activos;
	}
	public void setActivos(Integer activos) {
		this.activos = activos;
	}
	public Integer getFinalizados() {
		return finalizados;
	}
	public void setFinalizados(Integer finalizados) {
		this.finalizados = finalizados;
	}
	public Integer getTotales() {
		return totales;
	}
	public void setTotales(Integer totales) {
		this.totales = totales;
	}
	public Integer getPrimerMes() {
		return primerMes;
	}
	public void setPrimerMes(Integer primerMes) {
		this.primerMes = primerMes;
	}
	public Integer getSegundoMes() {
		return segundoMes;
	}
	public void setSegundoMes(Integer segundoMes) {
		this.segundoMes = segundoMes;
	}
	public Integer getTercerMes() {
		return tercerMes;
	}
	public void setTercerMes(Integer tercerMes) {
		this.tercerMes = tercerMes;
	}
	public Integer getTotalAvanzadas() {
		return totalAvanzadas;
	}
	public void setTotalAvanzadas(Integer totalAvanzadas) {
		this.totalAvanzadas = totalAvanzadas;
	}
	public Double getPorcentajeAvance() {
		return porcentajeAvance;
	}
	public void setPorcentajeAvance(Double porcentajeAvance) {
		this.porcentajeAvance = porcentajeAvance;
	}
	
}

package mintrabajo.dashboard.entity;

import java.io.Serializable;

public class DashboardDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3168597308648697547L;
	private Long activos;
	private Long finalizados;
	private Long total;
	private Long despacho;
	private Long ivc;
	private Long rcc;
	private Long ivcRcc;
	private Long totalDespacho;
	private Long expedientesConCaducidad;
	private Long expedientesVencenSemana;
	private Long expedientesVencenMes;
	private Long expedientesVencenTrimestre;
	public DashboardDTO() {
		
	}
	public Long getActivos() {
		return activos;
	}
	public void setActivos(Long activos) {
		this.activos = activos;
	}
	public Long getFinalizados() {
		return finalizados;
	}
	public void setFinalizados(Long finalizados) {
		this.finalizados = finalizados;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public Long getDespacho() {
		return despacho;
	}
	public void setDespacho(Long despacho) {
		this.despacho = despacho;
	}
	public Long getIvc() {
		return ivc;
	}
	public void setIvc(Long ivc) {
		this.ivc = ivc;
	}
	public Long getRcc() {
		return rcc;
	}
	public void setRcc(Long rcc) {
		this.rcc = rcc;
	}
	public Long getIvcRcc() {
		return ivcRcc;
	}
	public void setIvcRcc(Long ivcRcc) {
		this.ivcRcc = ivcRcc;
	}
	public Long getTotalDespacho() {
		return totalDespacho;
	}
	public void setTotalDespacho(Long totalDespacho) {
		this.totalDespacho = totalDespacho;
	}
	public Long getExpedientesConCaducidad() {
		return expedientesConCaducidad;
	}
	public void setExpedientesConCaducidad(Long expedientesConCaducidad) {
		this.expedientesConCaducidad = expedientesConCaducidad;
	}
	public Long getExpedientesVencenSemana() {
		return expedientesVencenSemana;
	}
	public void setExpedientesVencenSemana(Long expedientesVencenSemana) {
		this.expedientesVencenSemana = expedientesVencenSemana;
	}
	public Long getExpedientesVencenMes() {
		return expedientesVencenMes;
	}
	public void setExpedientesVencenMes(Long expedientesVencenMes) {
		this.expedientesVencenMes = expedientesVencenMes;
	}
	public Long getExpedientesVencenTrimestre() {
		return expedientesVencenTrimestre;
	}
	public void setExpedientesVencenTrimestre(Long expedientesVencenTrimestre) {
		this.expedientesVencenTrimestre = expedientesVencenTrimestre;
	}	
		
}

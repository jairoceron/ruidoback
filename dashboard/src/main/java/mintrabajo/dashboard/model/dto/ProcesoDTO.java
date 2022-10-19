package mintrabajo.dashboard.model.dto;

import java.io.Serializable;

public class ProcesoDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8877736637314421399L;
	private Long numeroRadicado;
	private String territorialReparto;
	private String estado;
	private String procesoDecision1;
	private String procesoDecision2;
	private String motivoSancion;
	private String criterioSancion;
	private String procesoSancion;
	private String procesoSancionValorUnidad;
	private String querelladoId;
	private String querellado;
	private String conductaSancionInfra;
	private String querellanteId;
	private String querellante;
	
	public ProcesoDTO() {}

	public Long getNumeroRadicado() {
		return numeroRadicado;
	}

	public void setNumeroRadicado(Long numeroRadicado) {
		this.numeroRadicado = numeroRadicado;
	}

	public String getTerritorialReparto() {
		return territorialReparto;
	}

	public void setTerritorialReparto(String territorialReparto) {
		this.territorialReparto = territorialReparto;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getProcesoDecision1() {
		return procesoDecision1;
	}

	public void setProcesoDecision1(String procesoDecision1) {
		this.procesoDecision1 = procesoDecision1;
	}

	public String getProcesoDecision2() {
		return procesoDecision2;
	}

	public void setProcesoDecision2(String procesoDecision2) {
		this.procesoDecision2 = procesoDecision2;
	}

	public String getMotivoSancion() {
		return motivoSancion;
	}

	public void setMotivoSancion(String motivoSancion) {
		this.motivoSancion = motivoSancion;
	}

	public String getCriterioSancion() {
		return criterioSancion;
	}

	public void setCriterioSancion(String criterioSancion) {
		this.criterioSancion = criterioSancion;
	}

	public String getProcesoSancion() {
		return procesoSancion;
	}

	public void setProcesoSancion(String procesoSancion) {
		this.procesoSancion = procesoSancion;
	}

	public String getProcesoSancionValorUnidad() {
		return procesoSancionValorUnidad;
	}

	public void setProcesoSancionValorUnidad(String procesoSancionValorUnidad) {
		this.procesoSancionValorUnidad = procesoSancionValorUnidad;
	}

	public String getQuerelladoId() {
		return querelladoId;
	}

	public void setQuerelladoId(String queralladoId) {
		this.querelladoId = queralladoId;
	}

	public String getQuerellado() {
		return querellado;
	}

	public void setQuerellado(String querellado) {
		this.querellado = querellado;
	}

	public String getConductaSancionInfra() {
		return conductaSancionInfra;
	}

	public void setConductaSancionInfra(String conductaSancionInfra) {
		this.conductaSancionInfra = conductaSancionInfra;
	}

	public String getQuerellanteId() {
		return querellanteId;
	}

	public void setQuerellanteId(String querellanteId) {
		this.querellanteId = querellanteId;
	}

	public String getQuerellante() {
		return querellante;
	}

	public void setQuerellante(String querellante) {
		this.querellante = querellante;
	}
	
}

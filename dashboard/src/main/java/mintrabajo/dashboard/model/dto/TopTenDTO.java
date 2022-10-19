package mintrabajo.dashboard.model.dto;

import java.io.Serializable;
import java.util.List;

public class TopTenDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1394938611216096751L;
	private Long idDt;
	private boolean incluyente = false;
	private List<ValoresDTO> visitasReactivas;
	private List<ValoresDTO> querellados;
	private List<ValoresDTO> querellante;
	private List<ValoresDTO> incidencias;
	
	public TopTenDTO() {}

	public Long getIdDt() {
		return idDt;
	}

	public void setIdDt(Long idDt) {
		this.idDt = idDt;
	}

	public boolean isIncluyente() {
		return incluyente;
	}

	public void setIncluyente(boolean incluyente) {
		this.incluyente = incluyente;
	}

	public List<ValoresDTO> getVisitasReactivas() {
		return visitasReactivas;
	}

	public void setVisitasReactivas(List<ValoresDTO> visitasReactivas) {
		this.visitasReactivas = visitasReactivas;
	}

	public List<ValoresDTO> getQuerellados() {
		return querellados;
	}

	public void setQuerellados(List<ValoresDTO> querellados) {
		this.querellados = querellados;
	}

	public List<ValoresDTO> getQuerellante() {
		return querellante;
	}

	public void setQuerellante(List<ValoresDTO> querellante) {
		this.querellante = querellante;
	}

	public List<ValoresDTO> getIncidencias() {
		return incidencias;
	}

	public void setIncidencias(List<ValoresDTO> incidencias) {
		this.incidencias = incidencias;
	}
	
}

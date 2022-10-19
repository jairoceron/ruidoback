package mintrabajo.dashboard.model.dto;

import java.io.Serializable;
import java.util.Date;

public class ExpedienteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Long usuarioFk;
	private String usuarioUsername;
	private String usuarioNombre;
	private String procesoNatInvestigacion;
	private String territorialReparto;
	private Date procesoFechaRadicacion;
	private int activo;
	private int finalizado;
	
	public ExpedienteDTO() {}

	public Long getUsuarioFk() {
		return usuarioFk;
	}

	public void setUsuarioFk(Long usuarioFk) {
		this.usuarioFk = usuarioFk;
	}

	public String getUsuarioUsername() {
		return usuarioUsername;
	}

	public void setUsuarioUsername(String usuarioUsername) {
		this.usuarioUsername = usuarioUsername;
	}

	public String getUsuarioNombre() {
		return usuarioNombre;
	}

	public void setUsuarioNombre(String usuarioNombre) {
		this.usuarioNombre = usuarioNombre;
	}

	public String getProcesoNatInvestigacion() {
		return procesoNatInvestigacion;
	}

	public void setProcesoNatInvestigacion(String procesoNatInvestigacion) {
		this.procesoNatInvestigacion = procesoNatInvestigacion;
	}

	public String getTerritorialReparto() {
		return territorialReparto;
	}

	public void setTerritorialReparto(String territorialReparto) {
		this.territorialReparto = territorialReparto;
	}

	public Date getProcesoFechaRadicacion() {
		return procesoFechaRadicacion;
	}

	public void setProcesoFechaRadicacion(Date procesoFechaRadicacion) {
		this.procesoFechaRadicacion = procesoFechaRadicacion;
	}

	public int getActivo() {
		return activo;
	}

	public void setActivo(int activo) {
		this.activo = activo;
	}

	public int getFinalizado() {
		return finalizado;
	}

	public void setFinalizado(int finalizado) {
		this.finalizado = finalizado;
	}
		
}

package mintrabajo.dashboard.entity;

import java.io.Serializable;
import java.util.Date;

public class DashboardEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2650938474777487513L;
	private Long idExpediente;
	private String numeroRadicacion;
	private String origenActuacion;
	private String estadoProceso;
	private String naturalezaInvestigacion;
	private String resumenQuerellantes;
	private String resumenQuerellados;
	private String estadoActividad;
	private String perfilActivo;
	private String actividadActual;
	private String etapaActual;
	private String etapaActualDesc;//se ve repetida de la anterior
	private String flujoActual;
	private String cadenaFlujo;
	private String organigramaRadicado;
	private String grupoRepartoInicial;
	private String territorialRepartoInicial;
	private String usuarioReparto;
	private String organigramaNombreReparto;
	private String usuarioDirectorioActivo;
	private String usuarioEstado;
	private String ciuuQuerellado;
	private String ciuuCodigoQuerellado;
	private String sectorCriticoQuerellado;
	private String sectorCriticoDescQuerellado;
	private String tipoRecurso;
	private Date fechaRadicacion;
	private Date fechaHechos;
	private Date fechaHechosFin;
	private Date fechaPrescripcion;
	private Date fechaPreasignacionReparto;
	private Date fechaReparto;
	private Long valorSancion;
	private String tipoDecision;
	private String criterioGraduacionSancion;
	private String ejecutante;
	private String infraccion;
	private String tipoInfraccion;
	private String tipoSancion;
	private String materiaConducta;
	private Long flujoPk;
	
	public DashboardEntity() {
		super();
	}
	public Long getIdExpediente() {
		return idExpediente;
	}
	public void setIdExpediente(Long idExpediente) {
		this.idExpediente = idExpediente;
	}
	public String getNumeroRadicacion() {
		return numeroRadicacion;
	}
	public void setNumeroRadicacion(String numeroRadicacion) {
		this.numeroRadicacion = numeroRadicacion;
	}
	public String getOrigenActuacion() {
		return origenActuacion;
	}
	public void setOrigenActuacion(String origenActuacion) {
		this.origenActuacion = origenActuacion;
	}
	public String getEstadoProceso() {
		return estadoProceso;
	}
	public void setEstadoProceso(String estadoProceso) {
		this.estadoProceso = estadoProceso;
	}
	public String getNaturalezaInvestigacion() {
		return naturalezaInvestigacion;
	}
	public void setNaturalezaInvestigacion(String naturalezaInvestigacion) {
		this.naturalezaInvestigacion = naturalezaInvestigacion;
	}
	public String getResumenQuerellantes() {
		return resumenQuerellantes;
	}
	public void setResumenQuerellantes(String resumenQuerellantes) {
		this.resumenQuerellantes = resumenQuerellantes;
	}
	public String getResumenQuerellados() {
		return resumenQuerellados;
	}
	public void setResumenQuerellados(String resumenQuerellados) {
		this.resumenQuerellados = resumenQuerellados;
	}
	public String getEstadoActividad() {
		return estadoActividad;
	}
	public void setEstadoActividad(String estadoActividad) {
		this.estadoActividad = estadoActividad;
	}
	public String getPerfilActivo() {
		return perfilActivo;
	}
	public void setPerfilActivo(String perfilActivo) {
		this.perfilActivo = perfilActivo;
	}
	public String getActividadActual() {
		return actividadActual;
	}
	public void setActividadActual(String actividadActual) {
		this.actividadActual = actividadActual;
	}
	public String getEtapaActual() {
		return etapaActual;
	}
	public void setEtapaActual(String etapaActual) {
		this.etapaActual = etapaActual;
	}
	public String getEtapaActualDesc() {
		return etapaActualDesc;
	}
	public void setEtapaActualDesc(String etapaActualDesc) {
		this.etapaActualDesc = etapaActualDesc;
	}
	public String getFlujoActual() {
		return flujoActual;
	}
	public void setFlujoActual(String flujoActual) {
		this.flujoActual = flujoActual;
	}
	public String getCadenaFlujo() {
		return cadenaFlujo;
	}
	public void setCadenaFlujo(String cadenaFlujo) {
		this.cadenaFlujo = cadenaFlujo;
	}
	public String getOrganigramaRadicado() {
		return organigramaRadicado;
	}
	public void setOrganigramaRadicado(String organigramaRadicado) {
		this.organigramaRadicado = organigramaRadicado;
	}
	public String getGrupoRepartoInicial() {
		return grupoRepartoInicial;
	}
	public void setGrupoRepartoInicial(String grupoRepartoInicial) {
		this.grupoRepartoInicial = grupoRepartoInicial;
	}
	public String getTerritorialRepartoInicial() {
		return territorialRepartoInicial;
	}
	public void setTerritorialRepartoInicial(String territorialRepartoInicial) {
		this.territorialRepartoInicial = territorialRepartoInicial;
	}
	public String getUsuarioReparto() {
		return usuarioReparto;
	}
	public void setUsuarioReparto(String usuarioReparto) {
		this.usuarioReparto = usuarioReparto;
	}
	public String getOrganigramaNombreReparto() {
		return organigramaNombreReparto;
	}
	public void setOrganigramaNombreReparto(String organigramaNombreReparto) {
		this.organigramaNombreReparto = organigramaNombreReparto;
	}
	public String getUsuarioDirectorioActivo() {
		return usuarioDirectorioActivo;
	}
	public void setUsuarioDirectorioActivo(String usuarioDirectorioActivo) {
		this.usuarioDirectorioActivo = usuarioDirectorioActivo;
	}
	public String getUsuarioEstado() {
		return usuarioEstado;
	}
	public void setUsuarioEstado(String usuarioEstado) {
		this.usuarioEstado = usuarioEstado;
	}
	public String getCiuuQuerellado() {
		return ciuuQuerellado;
	}
	public void setCiuuQuerellado(String ciuuQuerellado) {
		this.ciuuQuerellado = ciuuQuerellado;
	}
	public String getCiuuCodigoQuerellado() {
		return ciuuCodigoQuerellado;
	}
	public void setCiuuCodigoQuerellado(String ciuuCodigoQuerellado) {
		this.ciuuCodigoQuerellado = ciuuCodigoQuerellado;
	}
	public String getSectorCriticoQuerellado() {
		return sectorCriticoQuerellado;
	}
	public void setSectorCriticoQuerellado(String sectorCriticoQuerellado) {
		this.sectorCriticoQuerellado = sectorCriticoQuerellado;
	}
	public String getSectorCriticoDescQuerellado() {
		return sectorCriticoDescQuerellado;
	}
	public void setSectorCriticoDescQuerellado(String sectorCriticoDescQuerellado) {
		this.sectorCriticoDescQuerellado = sectorCriticoDescQuerellado;
	}
	public String getTipoRecurso() {
		return tipoRecurso;
	}
	public void setTipoRecurso(String tipoRecurso) {
		this.tipoRecurso = tipoRecurso;
	}
	
	public Date getFechaRadicacion() {
		return fechaRadicacion;
	}
	public void setFechaRadicacion(Date fechaRadicacion) {
		this.fechaRadicacion = fechaRadicacion;
	}
	public Date getFechaHechos() {
		return fechaHechos;
	}
	public void setFechaHechos(Date fechaHechos) {
		this.fechaHechos = fechaHechos;
	}
	public Date getFechaHechosFin() {
		return fechaHechosFin;
	}
	public void setFechaHechosFin(Date fechaHechosFin) {
		this.fechaHechosFin = fechaHechosFin;
	}
	public Date getFechaPrescripcion() {
		return fechaPrescripcion;
	}
	public void setFechaPrescripcion(Date fechaPrescripcion) {
		this.fechaPrescripcion = fechaPrescripcion;
	}
	public Date getFechaPreasignacionReparto() {
		return fechaPreasignacionReparto;
	}
	public void setFechaPreasignacionReparto(Date fechaPreasignacionReparto) {
		this.fechaPreasignacionReparto = fechaPreasignacionReparto;
	}
	public Date getFechaReparto() {
		return fechaReparto;
	}
	public void setFechaReparto(Date fechaReparto) {
		this.fechaReparto = fechaReparto;
	}
	public Long getValorSancion() {
		return valorSancion;
	}
	public void setValorSancion(Long valorSancion) {
		this.valorSancion = valorSancion;
	}
	public String getTipoDecision() {
		return tipoDecision;
	}
	public void setTipoDecision(String tipoDecision) {
		this.tipoDecision = tipoDecision;
	}
	public String getCriterioGraduacionSancion() {
		return criterioGraduacionSancion;
	}
	public void setCriterioGraduacionSancion(String criterioGraduacionSancion) {
		this.criterioGraduacionSancion = criterioGraduacionSancion;
	}
	public String getEjecutante() {
		return ejecutante;
	}
	public void setEjecutante(String ejecutante) {
		this.ejecutante = ejecutante;
	}
	public String getInfraccion() {
		return infraccion;
	}
	public void setInfraccion(String infraccion) {
		this.infraccion = infraccion;
	}
	public String getTipoInfraccion() {
		return tipoInfraccion;
	}
	public void setTipoInfraccion(String tipoInfraccion) {
		this.tipoInfraccion = tipoInfraccion;
	}
	public String getTipoSancion() {
		return tipoSancion;
	}
	public void setTipoSancion(String tipoSancion) {
		this.tipoSancion = tipoSancion;
	}
	public String getMateriaConducta() {
		return materiaConducta;
	}
	public void setMateriaConducta(String materiaConducta) {
		this.materiaConducta = materiaConducta;
	}
	public Long getFlujoPk() {
		return flujoPk;
	}
	public void setFlujoPk(Long flujoPk) {
		this.flujoPk = flujoPk;
	}
		
	
}

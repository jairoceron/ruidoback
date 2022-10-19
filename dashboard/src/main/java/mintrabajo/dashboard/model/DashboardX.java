package mintrabajo.dashboard.model;



public class DashboardX {
    private String dirTerritorial;
    private Estado estado;
    private Naturaleza naturaleza;
    private Grupo grupo;
    private Expvencer expvencer;
    private String etapaProcesal;
    
    public DashboardX() {}

	public String getDirTerritorial() {
		return dirTerritorial;
	}

	public void setDirTerritorial(String dirTerritorial) {
		this.dirTerritorial = dirTerritorial;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public Naturaleza getNaturaleza() {
		return naturaleza;
	}

	public void setNaturaleza(Naturaleza naturaleza) {
		this.naturaleza = naturaleza;
	}

	public Grupo getGrupo() {
		return grupo;
	}

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

	public Expvencer getExpvencer() {
		return expvencer;
	}

	public void setExpvencer(Expvencer expvencer) {
		this.expvencer = expvencer;
	}

	public String getEtapaProcesal() {
		return etapaProcesal;
	}

	public void setEtapaProcesal(String etapaProcesal) {
		this.etapaProcesal = etapaProcesal;
	}
    
}

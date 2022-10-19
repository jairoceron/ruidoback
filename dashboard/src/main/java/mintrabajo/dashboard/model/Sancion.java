package mintrabajo.dashboard.model;


public class Sancion {
    private Integer idDirTerritorial;
    private String nombreDirTerritorial;
    private String estadoProceso;
    private Integer cantidad;
    private Double valorSanciones;
    
    public Sancion() {}

	public Integer getIdDirTerritorial() {
		return idDirTerritorial;
	}

	public void setIdDirTerritorial(Integer idDirTerritorial) {
		this.idDirTerritorial = idDirTerritorial;
	}

	public String getNombreDirTerritorial() {
		return nombreDirTerritorial;
	}

	public void setNombreDirTerritorial(String nombreDirTerritorial) {
		this.nombreDirTerritorial = nombreDirTerritorial;
	}

	public String getEstadoProceso() {
		return estadoProceso;
	}

	public void setEstadoProceso(String estadoProceso) {
		this.estadoProceso = estadoProceso;
	}

	public Integer getCantidad() {
		return cantidad;
	}

	public void setCantidad(Integer cantidad) {
		this.cantidad = cantidad;
	}

	public Double getValorSanciones() {
		return valorSanciones;
	}

	public void setValorSanciones(Double valorSanciones) {
		this.valorSanciones = valorSanciones;
	}
    
    
}

package mintrabajo.dashboard.model;


public class Estado {
    private Integer activos;
    private Integer finalizados;
    private Integer total;
    
    public Estado() {}

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

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
    
}

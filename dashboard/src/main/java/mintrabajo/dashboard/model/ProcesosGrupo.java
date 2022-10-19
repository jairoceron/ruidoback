package mintrabajo.dashboard.model;

import java.io.Serializable;

public class ProcesosGrupo implements Serializable{
    /**
	 * 
	 */
	private static final long serialVersionUID = -7325578161357222309L;
	private String territorial_reparto;
    private Long  pivc;
    private Long rcc;
    private Long act;
    private Long pivrcc;
    private Long riesgoslab;
    private Long todas;
    private Long inspecciones;
    
    public ProcesosGrupo () {}

	public String getTerritorial_reparto() {
		return territorial_reparto;
	}

	public void setTerritorial_reparto(String territorial_reparto) {
		this.territorial_reparto = territorial_reparto;
	}

	public Long getPivc() {
		return pivc;
	}

	public void setPivc(Long pivc) {
		this.pivc = pivc;
	}

	public Long getRcc() {
		return rcc;
	}

	public void setRcc(Long rcc) {
		this.rcc = rcc;
	}

	public Long getAct() {
		return act;
	}

	public void setAct(Long act) {
		this.act = act;
	}

	public Long getPivrcc() {
		return pivrcc;
	}

	public void setPivrcc(Long pivrcc) {
		this.pivrcc = pivrcc;
	}

	public Long getRiesgoslab() {
		return riesgoslab;
	}

	public void setRiesgoslab(Long riesgoslab) {
		this.riesgoslab = riesgoslab;
	}

	public Long getTodas() {
		return todas;
	}

	public void setTodas(Long todas) {
		this.todas = todas;
	}

	public Long getInspecciones() {
		return inspecciones;
	}

	public void setInspecciones(Long inspecciones) {
		this.inspecciones = inspecciones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}   

}


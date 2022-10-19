package mintrabajo.dashboard.model.dto;

import java.io.Serializable;
import java.util.List;

public class FuncionPreventivaDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 675553147929920921L;
	private Long idDt;
	private boolean incluyente = false;
	private List<ValoresDTO> funcionPreventiva;
	
	public FuncionPreventivaDTO() {}

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

	public List<ValoresDTO> getFuncionPreventiva() {
		return funcionPreventiva;
	}

	public void setFuncionPreventiva(List<ValoresDTO> funcionPreventiva) {
		this.funcionPreventiva = funcionPreventiva;
	}
	
}

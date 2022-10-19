package mintrabajo.dashboard.model.dto;

import java.io.Serializable;

public class ValoresDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3032944469116400962L;
	private int value;
	private String name;
	
	public ValoresDTO() {}
	public ValoresDTO(int value, String name) {
		this.value = value;
		this.name = name;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}

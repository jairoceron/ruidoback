package mintrabajo.dashboard.model.dto;

import java.io.Serializable;

public class ListDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5131347390614776272L;
	private String id;
	private String value;
	private String idAlt;
	
	public ListDTO() {}
	
	public ListDTO(String id, String value) {
		this.id = id;
		this.value = value;
	}
	public ListDTO(String id, String value, String idAlt) {
		this.id = id;
		this.value = value;
		this.idAlt = idAlt;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getIdAlt() {
		return idAlt;
	}

	public void setIdAlt(String idAlt) {
		this.idAlt = idAlt;
	}
	
}

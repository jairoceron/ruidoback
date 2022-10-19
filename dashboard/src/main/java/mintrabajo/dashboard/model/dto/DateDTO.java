package mintrabajo.dashboard.model.dto;

import java.io.Serializable;
import java.util.Date;

public class DateDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7033432890088312279L;
	private Date from;
	private Date to;
	
	public DateDTO() {}
	public DateDTO(Date from, Date to) {
		this.from = from;
		this.to = to;
	}

	public Date getFrom() {
		return from;
	}

	public void setFrom(Date from) {
		this.from = from;
	}

	public Date getTo() {
		return to;
	}

	public void setTo(Date to) {
		this.to = to;
	}
	
	
}

package mintrabajo.dashboard.model.dto;

import java.io.Serializable;
import java.util.List;

public class ParametrosDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -875637933072626779L;
	private List<ListDTO> dts;
	private List<ListDTO> userStatus;
	private List<DateDTO> actDate;
	private List<DateDTO> weekly;
	private List<DateDTO> monthly;
	private List<DateDTO> quarterly;
	private List<DateDTO> biannual;
	private List<DateDTO> yearly;
	private List<ListDTO> flow;
	private List<ListDTO> criticalSectors;
	private List<ListDTO> ciiu;
	private List<ListDTO> absolutory;
	private List<ListDTO> sancionatory;
	private List<ListDTO> matter;
	private List<ListDTO> infringement;
	private List<ListDTO> executor;

	public ParametrosDTO() {
	}

	public List<ListDTO> getDts() {
		return dts;
	}

	public void setDts(List<ListDTO> dts) {
		this.dts = dts;
	}

	public List<ListDTO> getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(List<ListDTO> userStatus) {
		this.userStatus = userStatus;
	}

	public List<DateDTO> getActDate() {
		return actDate;
	}

	public void setActDate(List<DateDTO> actDate) {
		this.actDate = actDate;
	}

	public List<DateDTO> getWeekly() {
		return weekly;
	}

	public void setWeekly(List<DateDTO> weekly) {
		this.weekly = weekly;
	}

	public List<DateDTO> getMonthly() {
		return monthly;
	}

	public void setMonthly(List<DateDTO> monthly) {
		this.monthly = monthly;
	}

	public List<DateDTO> getQuarterly() {
		return quarterly;
	}

	public void setQuarterly(List<DateDTO> quarterly) {
		this.quarterly = quarterly;
	}

	public List<DateDTO> getBiannual() {
		return biannual;
	}

	public void setBiannual(List<DateDTO> biannual) {
		this.biannual = biannual;
	}

	public List<DateDTO> getYearly() {
		return yearly;
	}

	public void setYearly(List<DateDTO> yearly) {
		this.yearly = yearly;
	}

	public List<ListDTO> getFlow() {
		return flow;
	}

	public void setFlow(List<ListDTO> flow) {
		this.flow = flow;
	}

	public List<ListDTO> getCriticalSectors() {
		return criticalSectors;
	}

	public void setCriticalSectors(List<ListDTO> criticalSectors) {
		this.criticalSectors = criticalSectors;
	}

	public List<ListDTO> getCiiu() {
		return ciiu;
	}

	public void setCiiu(List<ListDTO> ciiu) {
		this.ciiu = ciiu;
	}

	public List<ListDTO> getAbsolutory() {
		return absolutory;
	}

	public void setAbsolutory(List<ListDTO> absolutory) {
		this.absolutory = absolutory;
	}

	public List<ListDTO> getSancionatory() {
		return sancionatory;
	}

	public void setSancionatory(List<ListDTO> sancionatory) {
		this.sancionatory = sancionatory;
	}

	public List<ListDTO> getMatter() {
		return matter;
	}

	public void setMatter(List<ListDTO> matter) {
		this.matter = matter;
	}

	public List<ListDTO> getInfringement() {
		return infringement;
	}

	public void setInfringement(List<ListDTO> infringement) {
		this.infringement = infringement;
	}

	public List<ListDTO> getExecutor() {
		return executor;
	}

	public void setExecutor(List<ListDTO> executor) {
		this.executor = executor;
	}
	
}

package mintrabajo.dashboard.singleton;

import java.util.Date;
import java.util.HashMap;


import mintrabajo.dashboard.entity.DashboardDTO;

public class DashboardDataSingleton {
	private static DashboardDataSingleton instance;
	private static Long dashboardCreationTime;
	private static final Long validTime = 7200000L;
	private static DashboardDTO dashboardDTO;
	private static HashMap<Long, DashboardDTO> dashboardsDTO;
	private static HashMap<Long, Long> dashboardsDTOCreatedTime;
	private DashboardDataSingleton() {
		dashboardsDTO = new HashMap<Long, DashboardDTO>();
		dashboardsDTOCreatedTime = new HashMap<Long, Long>();
	}
	
	public static DashboardDataSingleton getInstance() {
		if (instance == null ) {
			instance = new DashboardDataSingleton();
					
		}
		return instance;
	}
	
	public  void setDashBoard(DashboardDTO dto) {
		Date date = new Date(); 
		dashboardCreationTime = date.getTime();	
		dashboardDTO = dto;
	}
	public  void setDashBoard(DashboardDTO dto, Long idDt) {
		Date date = new Date(); 
		dashboardsDTOCreatedTime.put(idDt, date.getTime());	
		dashboardsDTO.put(idDt, dto);
	}
	public  DashboardDTO getDashBoard() {
		Date date = new Date(); 
		Long current = date.getTime();	
		if (dashboardDTO == null || current > (dashboardCreationTime+validTime) ) {
			return null;
		} else {
			return dashboardDTO;
		}
	}
	public  DashboardDTO getDashBoard(Long idDt) {
		Date date = new Date(); 
		Long current = date.getTime();	
		if (dashboardsDTO.isEmpty() || !dashboardsDTO.containsKey(idDt)  ||  current > (dashboardsDTOCreatedTime.get(idDt)+validTime)) {
			return null;
		} else {
			return dashboardsDTO.get(idDt);
		}
	}
}

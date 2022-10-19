package mintrabajo.dashboard.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import mintrabajo.dashboard.entity.DashboardDTO;
import mintrabajo.dashboard.entity.DashboardEntity;
import mintrabajo.dashboard.helper.DataHelper;
import mintrabajo.dashboard.helper.DateHelper;
import mintrabajo.dashboard.helper.ListHelper;
import mintrabajo.dashboard.model.dto.ExpedienteDTO;
import mintrabajo.dashboard.model.dto.ExpedienteDtsDTO;
import mintrabajo.dashboard.model.dto.FuncionPreventivaDTO;
import mintrabajo.dashboard.model.dto.IndicadorProcesalDTO;
import mintrabajo.dashboard.model.dto.ListDTO;
import mintrabajo.dashboard.model.dto.ParametrosDTO;
import mintrabajo.dashboard.model.dto.ProcesoDTO;
import mintrabajo.dashboard.model.dto.TopTenDTO;
import mintrabajo.dashboard.model.dto.ValoresDTO;
import mintrabajo.dashboard.repository.DashboardRepository;
import mintrabajo.dashboard.singleton.DashboardDataSingleton;

@Service
public class DashboardService {
	private DashboardRepository pr;
	private DashboardDataSingleton instance = DashboardDataSingleton.getInstance();

	@Autowired
	public void setPr(DashboardRepository pr) {
		this.pr = pr;
	}

	@Cacheable(value = "insumoDashboard")
	public List<DashboardEntity> insumoDashboard(Long idDt) {
		List<Object[]> liObj = idDt == 0 ? pr.insumoDashBoard() : pr.insumoDashBoard(idDt);
		List<DashboardEntity> entity = new ArrayList<>();
		// por ahora solo los 10 primeros registros
		for (int i = 0; i < liObj.size(); i++) {
			entity.add(DataHelper.objToDashboardEntity(liObj.get(i)));
		}
		return entity;
	}
	@Cacheable(value = "generarDashboardDTO")
	public DashboardDTO generarDashboardDTO() {

		DashboardDTO dashboardDTO = new DashboardDTO();
		dashboardDTO.setActivos(DataHelper.getLongFromCounter(pr.dashboardEstado(DataHelper.ESTADO_ACTIVO)));
		dashboardDTO.setFinalizados(DataHelper.getLongFromCounter(pr.dashboardEstado(DataHelper.ESTADO_FINALIZADO)));
		dashboardDTO.setTotal((dashboardDTO.getActivos() + dashboardDTO.getFinalizados()));
		dashboardDTO.setDespacho(DataHelper.getLongFromCounter(pr.dashboarDespacho(DataHelper.GRUPO_RL)));
		dashboardDTO.setIvc(DataHelper.getLongFromCounter(pr.dashboardOrganigrama(DataHelper.GRUPO_NL, "SI", "NO")));
		dashboardDTO.setRcc(DataHelper.getLongFromCounter(pr.dashboardOrganigrama(DataHelper.GRUPO_NL, "NO", "SI")));
		dashboardDTO.setIvcRcc(DataHelper.getLongFromCounter(pr.dashboardOrganigrama(DataHelper.GRUPO_NL, "SI", "SI")));
		dashboardDTO.setTotalDespacho(
				dashboardDTO.getDespacho() + dashboardDTO.getIvc() + dashboardDTO.getRcc() + dashboardDTO.getIvcRcc());
		dashboardDTO.setExpedientesConCaducidad(DataHelper.getLongFromCounter(pr.dashboardExpedientesConCaducidad()));
		dashboardDTO
				.setExpedientesVencenSemana(DataHelper.getLongFromCounter(pr.dashboardExpedientesConCaducidad(0, 7)));
		dashboardDTO.setExpedientesVencenMes(DataHelper.getLongFromCounter(pr.dashboardExpedientesConCaducidad(8, 30)));
		dashboardDTO.setExpedientesVencenTrimestre(
				DataHelper.getLongFromCounter(pr.dashboardExpedientesConCaducidad(31, 90)));
		instance.setDashBoard(dashboardDTO);
		return dashboardDTO;
	}
	
	
	@Cacheable(value = "generarDashboardDTOIdDt", key="#idDt")
	public DashboardDTO generarDashboardDTO(Long idDt) {

		DashboardDTO dashboardDTO = new DashboardDTO();
		dashboardDTO.setActivos(DataHelper.getLongFromCounter(pr.dashboardEstado(DataHelper.ESTADO_ACTIVO, idDt)));
		dashboardDTO
				.setFinalizados(DataHelper.getLongFromCounter(pr.dashboardEstado(DataHelper.ESTADO_FINALIZADO, idDt)));
		dashboardDTO.setTotal((dashboardDTO.getActivos() + dashboardDTO.getFinalizados()));
		dashboardDTO.setDespacho(DataHelper.getLongFromCounter(pr.dashboarDespacho(DataHelper.GRUPO_RL, idDt)));
		dashboardDTO
				.setIvc(DataHelper.getLongFromCounter(pr.dashboardOrganigrama(DataHelper.GRUPO_NL, "SI", "NO", idDt)));
		dashboardDTO
				.setRcc(DataHelper.getLongFromCounter(pr.dashboardOrganigrama(DataHelper.GRUPO_NL, "NO", "SI", idDt)));
		dashboardDTO.setIvcRcc(
				DataHelper.getLongFromCounter(pr.dashboardOrganigrama(DataHelper.GRUPO_NL, "SI", "SI", idDt)));
		dashboardDTO.setTotalDespacho(
				dashboardDTO.getDespacho() + dashboardDTO.getIvc() + dashboardDTO.getRcc() + dashboardDTO.getIvcRcc());
		dashboardDTO
				.setExpedientesConCaducidad(DataHelper.getLongFromCounter(pr.dashboardExpedientesConCaducidad(idDt)));
		dashboardDTO.setExpedientesVencenSemana(
				DataHelper.getLongFromCounter(pr.dashboardExpedientesConCaducidad(0, 7, idDt)));
		dashboardDTO.setExpedientesVencenMes(
				DataHelper.getLongFromCounter(pr.dashboardExpedientesConCaducidad(8, 30, idDt)));
		dashboardDTO.setExpedientesVencenTrimestre(
				DataHelper.getLongFromCounter(pr.dashboardExpedientesConCaducidad(31, 90, idDt)));
		instance.setDashBoard(dashboardDTO, idDt);
		return dashboardDTO;
	}
	
	
	@Cacheable("generarParametrosDashboard")
	public ParametrosDTO generarParametrosDashboard() {
		// traer DTS
		ParametrosDTO params = new ParametrosDTO();
		List<ListDTO> dts = ListHelper.getDtsFromObj(pr.traerDTs());
		List<ListDTO> userStatus = ListHelper.getUserStatusList();
		List<ListDTO> criticalSectors = ListHelper.getDtsFromObj(pr.traerSectoresCriticos());
		params.setDts(dts);
		params.setCiiu(ListHelper.getDtsFromObj(pr.traerCiiu()));
		params.setAbsolutory(ListHelper.getDtsFromObj(pr.traerAbsolutorios()));
		params.setSancionatory(ListHelper.getDtsFromObj(pr.traerSancionatorios()));
		params.setMatter(ListHelper.getDtsFromObj(pr.traerMaterias()));
		params.setInfringement(ListHelper.getDtsFromObj(pr.traerInfracciones()));
		params.setExecutor(ListHelper.getDtsFromObj(pr.traerEjecutantes()));
		params.setCriticalSectors(criticalSectors);
		params.setUserStatus(userStatus);
		params.setActDate(DateHelper.getActDate());
		params.setWeekly(DateHelper.getWeekly());
		params.setMonthly(DateHelper.getMonthly());
		params.setQuarterly(DateHelper.getQuarterly());
		params.setBiannual(DateHelper.getBiannual());
		params.setYearly(DateHelper.getYearly());
		params.setFlow(ListHelper.getFlowList());
		return params;

	}
	
	@Cacheable(value="traerTopTen", key = "#key")
	public TopTenDTO traerTopTen(Long idDt, Date from, Date to, Boolean incluyente, String key) {
		TopTenDTO top = new TopTenDTO();
		top.setIdDt(idDt);
		top.setIncluyente(incluyente);
		if(idDt != 0L) {
		top.setVisitasReactivas(
				ListHelper.getValoresDTOFromObj(incluyente ? pr.consultarVisitasReactivasIncluyentes(idDt, from, to)
						: pr.consultarVisitasReactivasExcluyentes(idDt, from, to)));
		top.setQuerellados(
				ListHelper.getValoresDTOFromObj(incluyente ? pr.consultarQuerelladosIncluyentes(idDt, from, to)
						: pr.consultarQuerelladosExcluyentes(idDt, from, to)));
		top.setQuerellante(
				ListHelper.getValoresDTOFromObj(incluyente ? pr.consultarQuerellantesIncluyentes(idDt, from, to)
						: pr.consultarQuerellantesExcluyentes(idDt, from, to)));
		top.setIncidencias(
				ListHelper.getValoresDTOFromObj(incluyente ? pr.consultarIncidenciasIncluyentes(idDt, from, to)
						: pr.consultarIncidenciasExcluyentes(idDt, from, to)));
		}else {
			top.setVisitasReactivas(
					ListHelper.getValoresDTOFromObj(incluyente ? pr.consultarVisitasReactivasIncluyentes(from, to)
							: pr.consultarVisitasReactivasExcluyentes(from, to)));
			top.setQuerellados(
					ListHelper.getValoresDTOFromObj(incluyente ? pr.consultarQuerelladosIncluyentes(from, to)
							: pr.consultarQuerelladosExcluyentes(from, to)));
			top.setQuerellante(
					ListHelper.getValoresDTOFromObj(incluyente ? pr.consultarQuerellantesIncluyentes(from, to)
							: pr.consultarQuerellantesExcluyentes(from, to)));
			top.setIncidencias(
					ListHelper.getValoresDTOFromObj(incluyente ? pr.consultarIncidenciasIncluyentes(from, to)
							: pr.consultarIncidenciasExcluyentes(from, to)));
		}
		return top;
	}
	@Cacheable(value = "traerFuncionPreventiva", key = "#key")
	public FuncionPreventivaDTO traerFuncionPreventiva(Long idDt, Date from, Date to, Boolean incluyente, String key) {
		FuncionPreventivaDTO dto = new FuncionPreventivaDTO();
		dto.setIdDt(idDt);
		dto.setIncluyente(incluyente);
		dto.setFuncionPreventiva(
				ListHelper.getValoresDTOFromObj(incluyente ? pr.consultarFuncionPreventivaIncluyentes(idDt, from, to)
						: pr.consultarFuncionPreventivaExcluyentes(idDt, from, to)));
		if (dto.getFuncionPreventiva().isEmpty()) {
			List<ValoresDTO> dt = new ArrayList<>();
			dt.add(new ValoresDTO(0, "ACTIVO"));
			dt.add(new ValoresDTO(0, "FINALIZADO"));
			dto.setFuncionPreventiva(dt);

		}
		return dto;
	}
	@Cacheable(value = "getExpedientes")
	public List<ExpedienteDTO> getExpedientes(Long idDt, String userStatus) {

		if (idDt == 0L && userStatus.equals("")) {
			return DataHelper.getExpedientesDTOFromObj(pr.consultarExpedientesPorUsuarioSinFiltro());
		} else if (userStatus.equals("")) {
			return DataHelper.getExpedientesDTOFromObj(pr.consultarExpedientesPorUsuarioConFiltroOrganigrama(idDt));
		} else if (idDt == 0L) {
			return DataHelper
					.getExpedientesDTOFromObj(pr.consultarExpedientesPorUsuarioConFiltroEstadoUsuario(userStatus));
		} else {
			return DataHelper.getExpedientesDTOFromObj(pr.consultarExpedientesPorUsuarioConFiltros(idDt, userStatus));
		}

	}
	
	@Cacheable(value = "getExpedientesDts")
	public List<ExpedienteDtsDTO> getExpedientesDts(Long idDt, String userStatus) {

		if (idDt == 0L && userStatus.equals("")) {
			return DataHelper.getExpedientesDtsDTOFromObj(pr.consultarExpedientesDtsSinFiltro());
		} else if (userStatus.equals("")) {
			return DataHelper.getExpedientesDtsDTOFromObj(pr.consultarExpedientesDtsConFiltroOrganigrama(idDt));
		} else if (idDt == 0L) {
			return DataHelper.getExpedientesDtsDTOFromObj(pr.consultarExpedientesDtsConFiltroEstadoUsuario(userStatus));
		} else {
			return DataHelper.getExpedientesDtsDTOFromObj(pr.consultarExpedientesDtsConFiltros(idDt, userStatus));
		}

	}
	
	@Cacheable(value = "getProcesoByFilters")
	public List<ProcesoDTO> getProcesoByFilters(Long idDt, Long flujoPk, String idQuerellado, String idQuerellante,  String numeroRadicado, String querellante, String querellado, String proceso ){
		idQuerellado = getLikeParamFromString(idQuerellado);
		idQuerellante = getLikeParamFromString(idQuerellante);
		numeroRadicado = getLikeParamFromString(numeroRadicado);
		querellante = getLikeParamFromString(querellante);
		querellado = getLikeParamFromString(querellado);
		proceso = getLikeParamFromString(proceso);
		if(idDt == 0L) {
			return DataHelper.getProcesoDTOFromObj((flujoPk == 0L)? pr.consultarProcesoSinIdDt(idQuerellado, idQuerellante, numeroRadicado, querellante, querellado, proceso): pr.consultarProcesoSinIdDt(flujoPk, idQuerellado, idQuerellante, numeroRadicado, querellante, querellado, proceso));
		}else {
			return DataHelper.getProcesoDTOFromObj((flujoPk == 0L)? pr.consultarProcesoConIdDt(idDt, idQuerellado, idQuerellante, numeroRadicado, querellante, querellado, proceso): pr.consultarProcesoConIdDt(idDt, flujoPk, idQuerellado, idQuerellante, numeroRadicado, querellante, querellado, proceso));
		}
	}
	private String getLikeParamFromString(String param) {
		if(param == null || param.trim().equals("")) {
			return "%%";
		} else {
			return "%"+param.trim()+"%";
		}
	}
	@Cacheable(value = "consultarIndicadorProceso", key="#key")
	public List<ListDTO> consultarIndicadorProceso(Long idDt, Date from, Date to, String key){
		List<ListDTO> dto = new ArrayList<ListDTO>();
		if(idDt == 0L) {
			dto = ListHelper.getDtsFromObj(pr.consultarIndicadorProcesos(from, to));
		} else {
			dto = ListHelper.getDtsFromObj(pr.consultarIndicadorProcesosPorDt(idDt, from, to));
		}
		return dto;
	}
	
	
	@Cacheable(value = "consultarIndicadoresProcesales", key="#key")
	public List<IndicadorProcesalDTO> consultarIndicadoresProcesales(Long idDt, Date from, Date to, String fecha, String key){
		List<IndicadorProcesalDTO> dto = new ArrayList<IndicadorProcesalDTO>();
		
		if(idDt == 0L) {
			dto = DataHelper.getIndicadorProcesalDtoFromObj(pr.consultarIndicadorProcesal(from, to, fecha));
		} else {
			dto = DataHelper.getIndicadorProcesalDtoFromObj(pr.consultarIndicadorProcesalPorDt(idDt, from, to, fecha));
		}
		return dto;
	}

}

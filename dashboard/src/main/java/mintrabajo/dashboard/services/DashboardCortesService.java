package mintrabajo.dashboard.services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import mintrabajo.dashboard.entity.DashboardDTO;
import mintrabajo.dashboard.entity.DashboardEntity;
import mintrabajo.dashboard.helper.DataHelper;
import mintrabajo.dashboard.model.dto.TipoDecisionDTO;
import mintrabajo.dashboard.repository.DashboardCortesRepository;

@Service
public class DashboardCortesService {
	private DashboardCortesRepository pr;

	@Autowired
	public void setPr(DashboardCortesRepository pr) {
		this.pr = pr;
	}

	@Cacheable(value = "generarDashboardCortesDTO", key = "#key")
	public DashboardDTO generarDashboardCortesDTO(Long idDt, Date from, Date to, Long flujo, String key) {

		DashboardDTO dashboardDTO = new DashboardDTO();
		// todos
		if (idDt == 0L && flujo == 0L) {
			dashboardDTO = DataHelper.dashboardDTOFromObj(pr.dashboardPorCortes(from, to).get(0));
		} // por flujo
		else if (idDt == 0L && flujo != 0L) {
			dashboardDTO = DataHelper.dashboardDTOFromObj(pr.dashboardPorCortes(from, to, flujo).get(0));
		} // por idDT
		else if (idDt != 0L && flujo == 0L) {
			dashboardDTO = DataHelper.dashboardDTOFromObj(pr.dashboardPorCortesIdDt(from, to, idDt).get(0));
		} // por flujo y dt
		else {
			dashboardDTO = DataHelper.dashboardDTOFromObj(pr.dashboardPorCortes(from, to, flujo, idDt).get(0));
		}
		return dashboardDTO;
	}

	@Cacheable(value = "generarInsumoDashboardCortesDTO", key = "#key")
	public List<DashboardEntity> generarInsumoDashboardCortesDTO(Long idDt, Date from, Date to, Long flujo,
			String key) {
		List<Object[]> liObj;
		List<DashboardEntity> entity = new ArrayList<>();
		// todos
		if (idDt == 0L && flujo == 0L) {
			liObj = pr.insumoDashBoardCortes(from, to);
		} // por flujo
		else if (idDt == 0L && flujo != 0L) {
			liObj = pr.insumoDashBoardCortes(from, to, flujo);
		} // por idDT
		else if (idDt != 0L && flujo == 0L) {
			liObj = pr.insumoDashBoardCortesIdDt(from, to, idDt);
		} // por flujo y dt
		else {
			liObj = pr.insumoDashBoardCortes(from, to, flujo, idDt);
		}
		for (int i = 0; i < liObj.size(); i++) {
			entity.add(DataHelper.objToDashboardEntity(liObj.get(i)));
		}
		return entity;
	}

	public List<TipoDecisionDTO> tipoDecision(Date from, Date to, Long idDt, String ejecutante, String infraccion,
			String motivoSancion, String ciiu, String sectorCritico, String materia, String estadoProceso,
			String naturaleza, String origen, String key) {
			List<TipoDecisionDTO> dto = new ArrayList<>();
			motivoSancion = motivoSancion.toUpperCase();
			origen = getLikeExcludeParamFromString(origen);
			naturaleza = getLikeExcludeParamFromString(naturaleza);
			estadoProceso = getLikeExcludeParamFromString(estadoProceso);
			ejecutante = getLikeExcludeParamFromString(ejecutante);
			infraccion = getLikeExcludeParamFromString(infraccion);
			ciiu = getLikeExcludeParamFromString(ciiu);
			sectorCritico=getLikeExcludeParamFromString(sectorCritico);
			materia = getLikeExcludeParamFromString(materia);


		if(idDt == 0L) {
			dto = DataHelper.getTipoDecisionDtoFromObj(pr.tipoDecisionSinDT(from, to, ejecutante, infraccion, motivoSancion, ciiu, sectorCritico, materia, estadoProceso, naturaleza, origen));
		}else {
			dto = DataHelper.getTipoDecisionDtoFromObj(pr.tipoDecisionConDT(from, to, idDt, ejecutante, infraccion, motivoSancion, ciiu, sectorCritico, materia, estadoProceso, naturaleza, origen));
		}
		return dto;
	}

	private String getLikeExcludeParamFromString(String param) {
		if (param == null || param.trim().equals("")) {
			return "%%";
		} else {
			return "%" + param.trim() + "%";
		}
	}

}

package mintrabajo.dashboard.helper;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import mintrabajo.dashboard.entity.DashboardDTO;
import mintrabajo.dashboard.entity.DashboardEntity;
import mintrabajo.dashboard.model.ProcesosGrupo;
import mintrabajo.dashboard.model.dto.ExpedienteDTO;
import mintrabajo.dashboard.model.dto.ExpedienteDtsDTO;
import mintrabajo.dashboard.model.dto.IndicadorProcesalDTO;
import mintrabajo.dashboard.model.dto.ProcesoDTO;
import mintrabajo.dashboard.model.dto.TipoDecisionDTO;

public class DataHelper {
	
	public static final String ESTADO_ACTIVO = "ACTIVO";
	public static final String ESTADO_FINALIZADO = "FINALIZADO";
	public static final String GRUPO_RL = "RIESGOS LABORALES";
	public static final String GRUPO_NL = "NORMAS LABORALES";
	private static final Long RENUENCIA = 15691L;
	private static final Long PAS = 3245L;
	private static final Long AP = 3218L;
	public static final String IDS_ABSOLUTORIOS = "(7, 8, 9, 10, 11, 12, 14, 21)";//ok
	public static final String IDS_SANCIONATORIOS = "(18, 20, 15, 19, 1, 2, 3, 4, 5, 6, 13, 16, 17, 22)";//ok
	public static final String IDS_ORIGEN = "('PERSONAL', 'DE OFICIO', 'ANONIMO')";//ok
	public static final String IDS_NATURALEZA = "('NORMAS LABORALES', 'RIESGOS LABORALES') ";//ok
	public static final String IDS_ESTADO_PROCESO = "('ACTIVO', 'FINALIZADO') ";//ok

	public static DashboardEntity objToDashboardEntity(Object[] obj) {
		DashboardEntity data= new DashboardEntity();
		int i = 0;
		data.setIdExpediente(longObj(obj[i]));
		i++;
		data.setNumeroRadicacion(stringObj(obj[i]));
		i++;
		data.setOrigenActuacion(stringObj(obj[i]));
		i++;
		data.setEstadoProceso(stringObj(obj[i]));
		i++;
		data.setNaturalezaInvestigacion(stringObj(obj[i]));
		i++;
		data.setResumenQuerellantes(stringObj(obj[i]));
		i++;
		data.setResumenQuerellados(stringObj(obj[i]));
		i++;
		data.setEstadoActividad(stringObj(obj[i]));
		i++;
		data.setPerfilActivo(stringObj(obj[i]));
		i++;
		data.setActividadActual(stringObj(obj[i]));
		i++;
		data.setEtapaActual(stringObj(obj[i]));
		i++;
		data.setEtapaActualDesc(stringObj(obj[i]));
		i++;
		data.setFlujoActual(stringObj(obj[i]));
		i++;
		data.setCadenaFlujo(stringObj(obj[i]));
		i++;
		data.setOrganigramaRadicado(stringObj(obj[i]));
		i++;
		data.setGrupoRepartoInicial(stringObj(obj[i]));
		i++;
		data.setTerritorialRepartoInicial(stringObj(obj[i]));
		i++;
		data.setUsuarioReparto(stringObj(obj[i]));
		i++;
		data.setOrganigramaNombreReparto(stringObj(obj[i]));
		i++;
		data.setUsuarioDirectorioActivo(stringObj(obj[i]));
		i++;
		data.setUsuarioEstado(stringObj(obj[i]));
		i++;
		data.setCiuuQuerellado(stringObj(obj[i]));
		i++;
		data.setCiuuCodigoQuerellado(stringObj(obj[i]));
		i++;
		data.setSectorCriticoQuerellado(stringObj(obj[i]));
		i++;
		data.setSectorCriticoDescQuerellado(stringObj(obj[i]));
		i++;
		data.setTipoRecurso(stringObj(obj[i]));
		i++;
		data.setFechaRadicacion(dateObj(obj[i]));
		i++;
		data.setFechaHechos(dateObj(obj[i]));
		i++;
		data.setFechaHechosFin(dateObj(obj[i]));
		i++;
		data.setFechaPrescripcion(dateObj(obj[i]));
		i++;
		data.setFechaPreasignacionReparto(dateObj(obj[i]));
		i++;
		data.setFechaReparto(dateObj(obj[i]));
		i++;
		data.setValorSancion(longObj(obj[i]));
		i++;
		data.setTipoDecision(stringObj(obj[i]));
		i++;
		data.setCriterioGraduacionSancion(stringObj(obj[i]));
		i++;
		data.setEjecutante(stringObj(obj[i]));
		i++;
		data.setInfraccion(stringObj(obj[i]));
		i++;
		data.setTipoInfraccion(stringObj(obj[i]));
		i++;
		data.setTipoSancion(stringObj(obj[i]));
		i++;
		data.setMateriaConducta(stringObj(obj[i]));
		i++;
		data.setFlujoPk(longObj(obj[i]));
		return data;
	}
	public static DashboardDTO dashboardDTOFromObj(Object[] obj) {
		DashboardDTO dto = new DashboardDTO();
		int i = 0;
		dto.setActivos(longObj(obj[i]));
		i++;
		dto.setFinalizados(longObj(obj[i]));
		dto.setTotal(dto.getActivos()+dto.getFinalizados());
		i++;
		dto.setDespacho(longObj(obj[i]));
		i++;
		dto.setIvc(longObj(obj[i]));
		i++;
		dto.setRcc(longObj(obj[i]));
		i++;
		dto.setIvcRcc(longObj(obj[i]));
		i++;
		dto.setExpedientesConCaducidad(longObj(obj[i]));
		i++;
		dto.setExpedientesVencenSemana(longObj(obj[i]));
		i++;
		dto.setExpedientesVencenMes(longObj(obj[i]));
		i++;
		dto.setExpedientesVencenTrimestre(longObj(obj[i]));
		dto.setTotalDespacho(0L);
		return dto;
	}
	
	public static List<ExpedienteDTO> getExpedientesDTOFromObj(List<Object[]> obj){
		List<ExpedienteDTO> dto = new ArrayList<>();
		Object[] data;
		ExpedienteDTO d;
		for(int i = 0; i < obj.size(); i++) {
			data = obj.get(i);
			d = new ExpedienteDTO();
			d.setUsuarioFk(longObj(data[0]));
			d.setUsuarioUsername(stringObj(data[1]));
			d.setUsuarioNombre(stringObj(data[2]));
			d.setProcesoNatInvestigacion(stringObj(data[3]));
			d.setTerritorialReparto(stringObj(data[4]));
			d.setProcesoFechaRadicacion(dateObj(data[5]));
			d.setActivo(intObj(data[6]));
			d.setFinalizado(intObj(data[7]));
			dto.add(d);
		}
		return dto;
	}
	public static List<ProcesosGrupo> getProcesoGrupoFromObj(List<Object[]> listaProceGr) {
        List<ProcesosGrupo> lg = new ArrayList<>();
        for (int m=0; m<listaProceGr.size(); m++) {
            Object[] obj = listaProceGr.get(m);
            ProcesosGrupo procesosGrupo = new ProcesosGrupo();
            procesosGrupo.setTerritorial_reparto(stringObj(obj[0]));
            procesosGrupo.setPivc(longObj(obj[1]));
            procesosGrupo.setRcc(longObj(obj[2]));
            procesosGrupo.setAct(longObj(obj[3]));
            procesosGrupo.setPivrcc(longObj(obj[4]));
            procesosGrupo.setRiesgoslab(longObj(obj[5]));
            procesosGrupo.setTodas(longObj(obj[6]));
            procesosGrupo.setInspecciones(longObj(obj[7]));
            lg.add(procesosGrupo);
        }

        return lg;
    }
	
	public static List<ExpedienteDtsDTO> getExpedientesDtsDTOFromObj(List<Object[]> obj){
		List<ExpedienteDtsDTO> dto = new ArrayList<>();
		Object[] data;
		ExpedienteDtsDTO d;
		for(int i = 0; i < obj.size(); i++) {
			data = obj.get(i);
			d = new ExpedienteDtsDTO();
			d.setTerritorialReparto(stringObj(data[0]));
			d.setActivo(intObj(data[1]));
			d.setFinalizado(intObj(data[2]));
			dto.add(d);
		}
		return dto;
	}
	
	public static List<ProcesoDTO> getProcesoDTOFromObj(List<Object[]> obj){
		List<ProcesoDTO> dto = new ArrayList<>();
		Object[] data;
		ProcesoDTO d;
		for(int i = 0; i < obj.size(); i++) {
			data = obj.get(i);
			d = new ProcesoDTO();
			d.setTerritorialReparto(stringObj(data[0]));
			d.setNumeroRadicado(longObj(data[1]));
			d.setEstado(stringObj(data[2]));
			d.setProcesoDecision1(stringObj(data[3]));
			d.setProcesoDecision2(stringObj(data[4]));
			d.setMotivoSancion(stringObj(data[5]));
			d.setCriterioSancion(stringObj(data[6]));
			d.setProcesoSancion(stringObj(data[7]));
			d.setProcesoSancionValorUnidad(stringObj(data[8]));
			d.setQuerelladoId(stringObj(data[9]));
			d.setQuerellado(stringObj(data[10]));
			d.setConductaSancionInfra(stringObj(data[11]));
			d.setQuerellanteId(stringObj(data[12]));
			d.setQuerellante(stringObj(data[13]));
			dto.add(d);
		}
		return dto;
	}
	
	public static List<IndicadorProcesalDTO> getIndicadorProcesalDtoFromObj(List<Object[]> obj){
		List<IndicadorProcesalDTO> dto = new ArrayList<IndicadorProcesalDTO>();
		Object[] data;
		IndicadorProcesalDTO d;
		for (int i = 0; i < obj.size(); i++) {
			data = obj.get(i);
			d = new IndicadorProcesalDTO();
			d.setTerritorialReparto(stringObj(data[0]));
			d.setActivos(intObj(data[1]));
			d.setFinalizados(intObj(data[2]));
			d.setTotales(intObj(data[3]));
			d.setPrimerMes(intObj(data[4]));
			d.setSegundoMes(intObj(data[5]));
			d.setTercerMes(intObj(data[6]));
			d.setTotalAvanzadas(intObj(data[7]));
			d.setPorcentajeAvance(doubleObj(data[8]));
			dto.add(d);
		}
		return dto;
	}
	public static List<TipoDecisionDTO> getTipoDecisionDtoFromObj(List<Object[]> obj){
		List<TipoDecisionDTO> dto = new ArrayList<TipoDecisionDTO>();
		Object[] data;
		TipoDecisionDTO d;
		for (int i = 0; i < obj.size(); i++) {
			data = obj.get(i);
			d = new TipoDecisionDTO();
			d.setEjecutoriadas(longObj(data[0]));
			d.setNoEjecutoriadas(longObj(data[1]));
			d.setEjecutoriadasValor(longObj(data[2]));
			d.setNoEjecutoriadasValor(longObj(data[3]));
			dto.add(d);
		}
		return dto;
	}
	private static Double doubleObj(Object obj) {
		if(obj == null) {
			return 0d;
		}else {
			try {
				return Double.parseDouble(obj.toString());
			}catch(Exception e) {
				return 0d;
			}
		}
	}
	private static String stringObj(Object obj) {
		if(obj == null) {
			return "";
		}else {
			return obj.toString();
		}
	}
	
	private static Long longObj(Object obj) {
		if(obj == null) {
			return 0L;
		} else {
			try {
				return Long.parseLong(obj.toString());
			} catch(Exception e) {
				return 0L;
			}
			
		}
	}
	private static Integer intObj(Object obj) {
		if(obj == null) {
			return 0;
		} else {
			try {
				return Integer.parseInt(obj.toString());
			} catch(Exception e) {
				return 0;
			}
			
		}
	}
	private static Date dateObj(Object obj) {
		if(obj == null) {
			return null;
		} else {
			try {
			return (Date) obj;
			}catch (Exception e) {
				return null;
			}
		}
	}
	
	public static Long getLongFromCounter(List<Object[]>  count) {
		try {
			Object[] obj = count.get(0);
			BigDecimal objs = (BigDecimal) obj[0];
			return objs.longValue();
		}catch (Exception e) {
			return 0L;
		}
		
	}
}

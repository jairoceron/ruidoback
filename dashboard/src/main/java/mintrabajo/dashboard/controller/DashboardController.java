package mintrabajo.dashboard.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mintrabajo.dashboard.entity.DashboardDTO;
import mintrabajo.dashboard.entity.DashboardEntity;
import mintrabajo.dashboard.exporter.ExcelExporter;
import mintrabajo.dashboard.helper.DateHelper;
import mintrabajo.dashboard.model.dto.ExpedienteDTO;
import mintrabajo.dashboard.model.dto.ExpedienteDtsDTO;
import mintrabajo.dashboard.model.dto.FuncionPreventivaDTO;
import mintrabajo.dashboard.model.dto.IndicadorProcesalDTO;
import mintrabajo.dashboard.model.dto.ListDTO;
import mintrabajo.dashboard.model.dto.ParametrosDTO;
import mintrabajo.dashboard.model.dto.ProcesoDTO;
import mintrabajo.dashboard.model.dto.TopTenDTO;
import mintrabajo.dashboard.services.DashboardService;

@RestController
@RequestMapping(path = "dashboard/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})

public class DashboardController {
	private DashboardService ps;

    @Autowired
    public void setPs(DashboardService ps) {
        this.ps = ps;
    }
    
    @GetMapping(path = "excel",produces="application/octet-stream")
    @ResponseBody
    public void dashboard(@RequestParam(name="idDt", required = false, defaultValue = "0") Long idDt, HttpServletResponse response) throws IOException  {
    	List<DashboardEntity> data =  ps.insumoDashboard(idDt);
    	response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
    	String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=dashboard_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        ExcelExporter exporter = new ExcelExporter(data);
        exporter.exportDashboard(response);
    }
    @GetMapping(path = "init",produces="application/json")
    @ResponseBody
    public DashboardDTO   dashboardDTO(@RequestParam("idDt") Long idDt) {
        
    	return idDt == 0 ? ps.generarDashboardDTO(): ps.generarDashboardDTO(idDt);
    }
    
    @GetMapping(path = "params",produces="application/json")
    @ResponseBody
    public ParametrosDTO getDashboardParams() {
        
    	return ps.generarParametrosDashboard();
    }
    
    @GetMapping(path = "topten",produces="application/json")
    @ResponseBody
    public TopTenDTO getTopTenDto(@RequestParam(name="idDt", required = false, defaultValue = "0")Long idDt, @RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("incluyente") Boolean incluyente) {
        
    	return ps.traerTopTen(idDt, DateHelper.stringDateToDate(from), DateHelper.stringDateToDate(to), incluyente, idDt+"_"+from+"_"+to+"_"+incluyente);
    }
    
    @GetMapping(path = "expedientes",produces="application/json")
    @ResponseBody
    public  List<ExpedienteDTO> getExpedientes(@RequestParam(name="idDt", required = false, defaultValue = "0") Long idDt, @RequestParam(name="userStatus", required = false, defaultValue = "") String userStatus) {
        
    	return ps.getExpedientes(idDt, userStatus);
    }
    
    @GetMapping(path = "expedientesDTS",produces="application/json")
    @ResponseBody
    public  List<ExpedienteDtsDTO> getExpedientesDts(@RequestParam(name="idDt", required = false, defaultValue = "0") Long idDt, @RequestParam(name="userStatus", required = false, defaultValue = "") String userStatus) {
        
    	return ps.getExpedientesDts(idDt, userStatus);
    }
    
    @GetMapping(path = "funcionPreventiva",produces="application/json")
    @ResponseBody
    public FuncionPreventivaDTO getFuncionPreventiva(@RequestParam("idDt") Long idDt, @RequestParam("from") String from, @RequestParam("to") String to, @RequestParam("incluyente") Boolean incluyente) {
        
    	return ps.traerFuncionPreventiva(idDt, DateHelper.stringDateToDate(from), DateHelper.stringDateToDate(to), incluyente, idDt+"_"+from+"_"+to+"_"+incluyente);
    }
    
    @GetMapping(path = "procesoFiltro",produces="application/json")
    @ResponseBody
    public List<ProcesoDTO> getProcesoDtoByFilters(@RequestParam(name="idDt", required = false, defaultValue = "0") Long idDt, @RequestParam("flujoPk") Long flujoPk, @RequestParam(name="idQuerellado", required = false, defaultValue = "") String idQuerellado, @RequestParam(name="idQuerellante", required = false, defaultValue = "") String idQuerellante, @RequestParam(name="numeroRadicado", required = false, defaultValue = "") String numeroRadicado, 
    		@RequestParam(name="querellante", required = false, defaultValue = "") String querellante, @RequestParam(name="querellado", required = false, defaultValue = "") String querellado, @RequestParam(name="proceso", required = false, defaultValue = "") String proceso){
    	return ps.getProcesoByFilters(idDt, flujoPk, idQuerellado, idQuerellante, numeroRadicado, querellante, querellado, proceso);
    }
    
    @GetMapping(path="indicadorProceso", produces="application/json")
    @ResponseBody
    public List<ListDTO> consultaIndicadorProceso(@RequestParam(name="idDt", required = false, defaultValue = "0") Long idDt, @RequestParam("from") String from, @RequestParam("to") String to){
    	return ps.consultarIndicadorProceso(idDt, DateHelper.stringDateToDate(from), DateHelper.stringDateToDate(to), idDt+"_"+from+"_"+to);
    }
    
    @GetMapping(path="indicadorProcesal", produces="application/json")
    @ResponseBody
    public List<IndicadorProcesalDTO> consultaIndicadorProcesal(@RequestParam(name="idDt", required = false, defaultValue = "0") Long idDt, @RequestParam("from") String from, @RequestParam("to") String to){
    	return ps.consultarIndicadoresProcesales(idDt, DateHelper.stringDateToDate(from), DateHelper.stringDateToDate(to), DateHelper.stringDateToString(from), idDt+"_"+from+"_"+to);
    }

}

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
import mintrabajo.dashboard.model.dto.TipoDecisionDTO;
import mintrabajo.dashboard.services.DashboardCortesService;

@RestController
@RequestMapping(path = "dashboard/cortes")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})

public class DashboardCortesController {
	private DashboardCortesService ps;

    @Autowired
    public void setPs(DashboardCortesService ps) {
        this.ps = ps;
    }
    
    @GetMapping(path = "excel",produces="application/octet-stream")
    @ResponseBody
    public void dashboard(@RequestParam(name="idDt", required = false, defaultValue = "0") Long idDt, @RequestParam("from") String from, @RequestParam("to") String to,@RequestParam(name="flujo", required = false, defaultValue = "0") Long flujo, HttpServletResponse response) throws IOException  {
    	List<DashboardEntity> data =  ps.generarInsumoDashboardCortesDTO(idDt, DateHelper.stringDateToDate(from), DateHelper.stringDateToDate(to), flujo, idDt+"_"+from+"_"+to+"_"+flujo);
    	response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
    	String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=dashboardCortes_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);
        ExcelExporter exporter = new ExcelExporter(data);
        exporter.exportDashboard(response);
    }
    @GetMapping(path = "init",produces="application/json")
    @ResponseBody
    public DashboardDTO   dashboardDTO(@RequestParam(name="idDt", required = false, defaultValue = "0") Long idDt, @RequestParam("from") String from, @RequestParam("to") String to,@RequestParam(name="flujo", required = false, defaultValue = "0") Long flujo) {
        
    	return ps.generarDashboardCortesDTO(idDt, DateHelper.stringDateToDate(from), DateHelper.stringDateToDate(to), flujo, idDt+"_"+from+"_"+to+"_"+flujo);
    }
    
    @GetMapping(path = "tipodecision",produces="application/json")
    @ResponseBody
    public List<TipoDecisionDTO> tipoDecision(@RequestParam(name="idDt", required = false, defaultValue = "0") Long idDt, @RequestParam("from") String from, @RequestParam("to") String to, @RequestParam(name="ejecutante", required = false, defaultValue = "") String ejecutante,@RequestParam(name="infraccion", required = false, defaultValue = "") String infraccion,
    		@RequestParam(name="motivoSancion", required = false, defaultValue = "") String motivoSancion, @RequestParam(name="ciiu", required = false, defaultValue = "") String ciiu,  @RequestParam(name="sectorCritico", required = false, defaultValue = "") String sectorCritico,@RequestParam(name="materia", required = false, defaultValue = "")  String materia, 
    		@RequestParam(name="estadoProceso", required = false, defaultValue = "") String estadoProceso,
    		@RequestParam(name="naturaleza", required = false, defaultValue = "") String naturaleza,@RequestParam(name="origen", required = false, defaultValue = "")  String origen) {
        

        return ps.tipoDecision(DateHelper.stringDateToDate(from), DateHelper.stringDateToDate(to), idDt, ejecutante, infraccion, motivoSancion,  ciiu,  sectorCritico,  materia,  estadoProceso,
    			 naturaleza,  origen, idDt+"_"+from+"_"+to+"_"+ejecutante+"_"+infraccion+"_"+motivoSancion+"_"+ciiu+"_"+sectorCritico+"_"+materia+"_"+estadoProceso+"_"+naturaleza+"_"+origen);
    }

}

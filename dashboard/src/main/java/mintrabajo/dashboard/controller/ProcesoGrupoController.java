package mintrabajo.dashboard.controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


import mintrabajo.dashboard.helper.DateHelper;
import mintrabajo.dashboard.model.ProcesosGrupo;
import mintrabajo.dashboard.services.ProcesoGrupoService;

@RestController
@RequestMapping(path = "dashboard/procesogrupo")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})

public class ProcesoGrupoController {
	private ProcesoGrupoService ps;

    @Autowired
    public void setPs(ProcesoGrupoService ps) {
        this.ps = ps;
    }
    
    @GetMapping(path = "init",produces="application/json")
    @ResponseBody
    public List<ProcesosGrupo>  procesosGrupDTO(@RequestParam(name="idDt", required = false, defaultValue = "0") Long idDt, @RequestParam("from") String from, @RequestParam("to") String to) {
        
    	return ps.procesosGrupDTO(idDt, DateHelper.stringDateToDate(from), DateHelper.stringDateToDate(to), idDt+"_"+from+"_"+to+"_");
    }
    

}

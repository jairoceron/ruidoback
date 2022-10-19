package mintrabajo.dashboard.controller;

import mintrabajo.dashboard.model.Sancion;
import mintrabajo.dashboard.services.ProcesoService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "dashboard/proceso/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})

public class ProcesoController {
    private ProcesoService ps;

    @Autowired
    public void setPs(ProcesoService ps) {
        this.ps = ps;
    }

    @PostMapping
    public Integer saveProceso(@RequestBody Integer calificacion) {
        return null;
    }

    @GetMapping(path = "historia1",produces="application/json")
    @ResponseBody
    public String  historia1(@RequestParam(name = "date_from", defaultValue = "2020")  String date_from, @RequestParam(name = "date_to", defaultValue = "2020")  String date_to) {
        ps.operacion(date_from, date_to);
        String retorno = " Termina ........<h1> Dashboard Terminado </h1>  ";
        return retorno;
    }

    @GetMapping(path = "consultaSancion",produces="application/json")
    @ResponseBody
    public String  historia2(@RequestParam(name = "date_from", defaultValue = "2020")  String date_from, @RequestParam(name = "date_to", defaultValue = "2020")  String date_to) {
        ps.consSancion(date_from, date_to);
        return "retorno";
    }

    @GetMapping(path = "fechaReparto",produces="application/json")
    @ResponseBody
    public String  fechaReparto(@RequestParam(name = "date_from", defaultValue = "2020")  String date_from, @RequestParam(name = "date_to", defaultValue = "2020")  String date_to) {
        ps.fechaReparto(date_from, date_to);
        return "retorno";
    }

    @GetMapping(path = "totalSancionDt",produces="application/json")
    @ResponseBody
    List<Sancion> totalSancionDt (@RequestParam(name = "numMeses", defaultValue = "-1")   Integer numMeses ) {
        return ps.totalSancionDt(numMeses);
    }

    @GetMapping(path = "estProcesoDt",produces="application/json")
    @ResponseBody
    List<Sancion> estProcesoDt (@RequestParam(name = "idFlujoPk", defaultValue = "15691")   Integer idFlujoPk, @RequestParam(name = "estado", defaultValue = "Activo")   String estado, @RequestParam(name = "numMeses", defaultValue = "-1")   Integer numMeses ) {
        return ps.estProcesoDt(idFlujoPk,estado,numMeses );
    }
    
  
}

package cimab.openaq.controller.ruido;
import cimab.openaq.dto.ruido.ChartLocalidad;
import cimab.openaq.entity.ruido.RuiLocalidad;
import cimab.openaq.entity.ruido.RuiSector;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.service.ruido.RuiLocalidadService;
import cimab.openaq.service.ruido.RuiSectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class RuiLocalidadController {
    private RuiLocalidadService rls;

    @Autowired
    public void setRls(RuiLocalidadService rls) {
        this.rls = rls;
    }

    @RequestMapping({"/consultaLocalidad"})
    public List<RuiLocalidad> consultaSector(@RequestBody RuiSector ruiSector ) {

        List<RuiLocalidad> listRuiLocalidad = rls.consultaLocalidad();
        return listRuiLocalidad;
    }

    @RequestMapping({"/chartlocalidad"})
    public List<ChartLocalidad> chartLocalidadList(@RequestBody ConsultaVisita consultaVisita ) {

        System.out.println("Consulta localidad ... " + consultaVisita) ;
        List<ChartLocalidad> listChartLocalidad = rls.chartLocalidad(consultaVisita);
        return listChartLocalidad;
    }

}

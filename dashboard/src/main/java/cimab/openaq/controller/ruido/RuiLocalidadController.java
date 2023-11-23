package cimab.openaq.controller.ruido;
import cimab.openaq.dto.ruido.ChartLocalidad;
import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.RuiLocalidad;
import cimab.openaq.entity.ruido.RuiSector;
import cimab.openaq.entity.ruido.RuidoLocalidad;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.service.ruido.PqrsService;
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
    private PqrsService ps;

    @Autowired
    public void setRls(RuiLocalidadService rls) {
        this.rls = rls;
    }

    @Autowired
    public void setPs(PqrsService ps) {
        this.ps = ps;
    }

    @RequestMapping({"/consultaLocalidadXXXX"})
    public List<RuiLocalidad> consultaSector(@RequestBody RuiSector ruiSector ) {

        List<RuiLocalidad> listRuiLocalidad = rls.consultaLocalidad();
        return listRuiLocalidad;
    }

    @RequestMapping({"/consultaLocalidad"})
    public List<RuidoLocalidad> consultaLocalidad(@RequestBody RuiSector ruiSector ) {

        List<RuidoLocalidad> listRuiLocalidad = rls.consultaRuidoLocalidad();
        return listRuiLocalidad;
    }

    @RequestMapping({"/consultaPorLocalidad"})
    public List<Pqrs> consultaPorLocalidad(@RequestBody ConsultaVisita consultaVisita  ) {

        List<Pqrs> listPqrs = ps.consultaPqrsLocalidad(consultaVisita);

        return listPqrs;

    }

    @RequestMapping({"/chartlocalidad"})
    public List<ChartLocalidad> chartLocalidadList(@RequestBody ConsultaVisita consultaVisita ) {


        List<ChartLocalidad> listChartLocalidad = rls.chartLocalidad(consultaVisita);

        return listChartLocalidad;
    }

    @RequestMapping({"/chartNormatividad"})
    public List<ChartLocalidad> chartNormatividad(@RequestBody ConsultaVisita consultaVisita ) {


        List<ChartLocalidad> listChartLocalidad = rls.chartNormatividad(consultaVisita);

        return listChartLocalidad;
    }

}

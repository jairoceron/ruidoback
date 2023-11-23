package cimab.openaq.controller.ruido;

import cimab.openaq.entity.ruido.*;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.service.ruido.PqrsService;
import cimab.openaq.service.ruido.RdoAsuntoService;
import cimab.openaq.service.ruido.RdoEstadoService;
import cimab.openaq.service.ruido.RdoEstadoTramiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class RdoEstadoController {
    private RdoEstadoService ras;
    private RdoEstadoTramiteService rets;
    private PqrsService ps;

    @Autowired
    public void setRas(RdoEstadoService ras) {
        this.ras = ras;
    }

    @Autowired
    public void setRets(RdoEstadoTramiteService rets) {
        this.rets = rets;
    }

    @Autowired
    public void setPs(PqrsService ps) {
        this.ps = ps;
    }

    @RequestMapping({"/consultaEstado"})
    public List<RdoEstadoTramite> consultaSector(@RequestBody RdoEstado rdoEstado ) {


        List<RdoEstadoTramite> listEstadoTramite = rets.consultaEstado();
        if (listEstadoTramite != null) {

        }

        return listEstadoTramite;
    }

    @RequestMapping({"/observacionTramite"})
    public List<ObserEstTramite> observacionTramite(@RequestBody RdoEstadoTramite rdoEstado ) {

        List<ObserEstTramite> listObsEstadoTramite = rets.listObservacionEstadoTramiteX(rdoEstado.getId());


        return listObsEstadoTramite;

    }

    @RequestMapping({"/consultaPorEstadoTramite"})
    public List<Pqrs> consultaEstadoTramite(@RequestBody ConsultaVisita consultaVisita ) {

         List<Pqrs> listRuiLocalidad = ps.consultaPqrsEstramite(consultaVisita);
         return listRuiLocalidad;
      //  return null;
    }

}

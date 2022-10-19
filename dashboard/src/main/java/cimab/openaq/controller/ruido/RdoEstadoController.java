package cimab.openaq.controller.ruido;

import cimab.openaq.entity.ruido.RdoAsunto;
import cimab.openaq.entity.ruido.RdoEstado;
import cimab.openaq.entity.ruido.RuiSector;
import cimab.openaq.service.ruido.RdoAsuntoService;
import cimab.openaq.service.ruido.RdoEstadoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class RdoEstadoController {
    private RdoEstadoService ras;

    @Autowired
    public void setRas(RdoEstadoService ras) {
        this.ras = ras;
    }

    @RequestMapping({"/consultaEstado"})
    public List<RdoEstado> consultaSector(@RequestBody RdoEstado rdoEstado ) {

        List<RdoEstado> listRuiLocalidad = ras.consultaEstado();
        return listRuiLocalidad;
    }
}

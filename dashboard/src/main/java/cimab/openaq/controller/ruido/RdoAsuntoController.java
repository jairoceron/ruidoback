package cimab.openaq.controller.ruido;
import cimab.openaq.entity.ruido.RdoAsunto;
import cimab.openaq.entity.ruido.RuiLocalidad;
import cimab.openaq.entity.ruido.RuiSector;
import cimab.openaq.service.ruido.RdoAsuntoService;
import cimab.openaq.service.ruido.RuiLocalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class RdoAsuntoController {
    private RdoAsuntoService ras;

    @Autowired
    public void setRas(RdoAsuntoService ras) {
        this.ras = ras;
    }

    @RequestMapping({"/consultaAsunto"})
    public List<RdoAsunto> consultaSector(@RequestBody RuiSector ruiSector ) {

        List<RdoAsunto> listRuiLocalidad = ras.consultaAsunto();


      //  ****
        return listRuiLocalidad;
    }
}

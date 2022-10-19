package cimab.openaq.controller.ruido;

import cimab.openaq.dataTransferObject.SensorMedicion;
import cimab.openaq.entity.rmcab.Variableambiental;
import cimab.openaq.entity.ruido.Estadotramite;
import cimab.openaq.service.Tablero.TableroService;
import cimab.openaq.service.ruido.EstadotramiteService;
import cimab.openaq.service.ruido.RuidoService;
import cimab.openaq.service.sbc.SbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class EstadotramiteController {
    private EstadotramiteService ts;

    @Autowired
    public void setTs(EstadotramiteService ts) {
        this.ts = ts;
    }


    @GetMapping(path = "listEstadoTramite",produces="application/json")
    @ResponseBody
    public List<Estadotramite> listEstadoTramite(@RequestParam(name = "marcaSensor", defaultValue = "0") int marcaSensor,
                                                    @RequestParam(name = "codigoSensor", defaultValue = "0") String codigoSensor,
                                                    @RequestParam(name = "promedio", defaultValue = "0") int promedio,
                                                    @RequestParam(name = "variable", defaultValue = "0") int variable,
                                                    @RequestParam(name = "fechaInicial", defaultValue = "31/08/2018") String fechaInicial,
                                                    @RequestParam(name = "fechaFinal", defaultValue = "31/08/2018") String fechaFinal
    ) {

        List<Estadotramite> listEstTramit = ts.listEstadoTramite();
        System.out.println("Listado estado de tramite ........... " + listEstTramit);
        return listEstTramit;
    }
}

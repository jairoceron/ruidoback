package cimab.openaq.controller.etiquetado;

import cimab.openaq.entity.etiqoracle.EvaEtiquetado;
import cimab.openaq.entity.etiqoracle.Informacionvehiculo;
import cimab.openaq.entity.etiquetado.Clasevehiculo;
import cimab.openaq.model.AuthenticationRequest;
import cimab.openaq.service.etiqoracle.EvaEtiquetadoService;
import cimab.openaq.service.etiquetado.ClasevehiculoService;
import cimab.openaq.service.ruido.EstadotramiteService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ClasevehiculoController {

    private ClasevehiculoService ts;
    private EvaEtiquetadoService es;

    @Autowired
    public void setEs(EvaEtiquetadoService es) {
        this.es = es;
    }

    @Autowired
    public void setTs(ClasevehiculoService ts) {
        this.ts = ts;
    }

    /// @GetMapping(path = "listClaseVehiculo",produces="application/json")
    // @ResponseBody
    @RequestMapping({"/listClaseVehiculo"})
    public List<Clasevehiculo> listEstadoTramite() {

        List<Clasevehiculo> listClaseVehiculo = ts.listClaseVehiculos();

        return listClaseVehiculo;

    }

    @RequestMapping({"/loadEvaEtiquetado"})
    public List<EvaEtiquetado> loadEvaEtiquetado() {

        List<EvaEtiquetado>  listEvaEtiquetado = es.listEvaEtiquetado();


        return listEvaEtiquetado;

    }

    @RequestMapping({"/loadEvaEtiquetadoConParametro"})
    public List<EvaEtiquetado> loadEvaEtiquetadoConParametro(@RequestBody Informacionvehiculo informacionVehiculo) {

        List<EvaEtiquetado>  listEvaEtiquetado = es.listEvaEtiquetado(informacionVehiculo);


        return listEvaEtiquetado;

    }


}

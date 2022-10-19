package cimab.openaq.controller.etiquetado;
import cimab.openaq.entity.etiquetado.Clasevehiculo;
import cimab.openaq.entity.etiquetado.Estandaremision;
import cimab.openaq.entity.etiquetado.Tipocombustible;
import cimab.openaq.model.AuthenticationRequest;
import cimab.openaq.service.etiquetado.ClasevehiculoService;
import cimab.openaq.service.etiquetado.EstandaremisionService;
import cimab.openaq.service.etiquetado.TipocombustibleService;
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
public class EstandaremisionController {
    private EstandaremisionService ts;

    @Autowired
    public void setTs(EstandaremisionService ts) {
        this.ts = ts;
    }


    @RequestMapping({"/listEstadoEmision"})
    public List<Estandaremision> listEstadoEmision(@RequestBody Integer idclasevehiculo) {
        System.out.println("Si ingresa al servicios ::: Listado estado de listClaseVehiculo ........... " );
        List<Estandaremision> listTipoCombustible = ts.listEstandarEmision(idclasevehiculo);
        System.out.println("Listado estado de listClaseVehiculo ........... " + listTipoCombustible);
        return listTipoCombustible;

    }
}

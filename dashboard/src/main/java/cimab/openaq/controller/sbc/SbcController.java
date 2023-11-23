package cimab.openaq.controller.sbc;

import cimab.openaq.dataTransferObject.SensorMedicion;
import cimab.openaq.dto.LatitudLongitud;
import cimab.openaq.dto.Param;
import cimab.openaq.entity.sbc.Sensoresestacion;
import cimab.openaq.service.sbc.SbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})

public class SbcController {
    private SbcService ts;

    @Autowired
    public void setTs(SbcService ts) {
        this.ts = ts;
    }

    @GetMapping(path = "consultaSesorBajoCosto")
    public List<SensorMedicion> consultaSesorBajoCosto(@RequestParam(name = "marcaSensor", defaultValue = "0") int marcaSensor,
                                                       @RequestParam(name = "codigoSensor", defaultValue = "0") String codigoSensor,
                                                       @RequestParam(name = "promedio", defaultValue = "0") int promedio,
                                                       @RequestParam(name = "variable", defaultValue = "0") int variable,
                                                       @RequestParam(name = "fechaInicial", defaultValue = "31/08/2018") String fechaInicial,
                                                       @RequestParam(name = "fechaFinal", defaultValue = "31/08/2018") String fechaFinal
    ) {


        return ts.consultaSesorBajoCosto(marcaSensor, codigoSensor,
                promedio, variable,
                fechaInicial, fechaFinal);
    }

    @GetMapping(path = "querySensoresPorMarca")
    List<String> querySensoresPorMarca(@RequestParam(name = "marcaSensor", defaultValue = "0") int marcaSensor) {

        return ts.querySensoresPorMarca(marcaSensor);
    }

    @GetMapping(path = "listaMarcasSensores")
    List<Param> listaMarcasSensores()  {

        return ts.listaMarcasSensores();
    }

    @GetMapping(path = "latlongPoligionoEstaciones")
    List<Sensoresestacion> latlongPoligionoEstaciones()  {


        return ts.latlongPoligionoEstaciones();
    }

    @GetMapping(path = "calidadDatosSBC")
    String calidadDatosSBC()  {


        return ts.calidadDatosSBC();
    }

}

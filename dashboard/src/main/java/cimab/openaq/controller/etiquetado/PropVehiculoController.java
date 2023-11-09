package cimab.openaq.controller.etiquetado;
import cimab.openaq.entity.etiqoracle.Informacionvehiculo;
import cimab.openaq.entity.etiqoracle.Propietariovehiculo;
import cimab.openaq.entity.etiqoracle.dto.Placa;
import cimab.openaq.entity.etiquetado.Cilindrada;
import cimab.openaq.entity.etiquetado.Estandaremision;
import cimab.openaq.entity.etiquetado.Pesovehiculo;
import cimab.openaq.entity.etiquetado.Tipocombustible;
import cimab.openaq.service.etiqoracle.InformacionvehiculoService;
import cimab.openaq.service.etiqoracle.PropietariovehiculoService;
import cimab.openaq.service.etiquetado.CilindradaService;
import cimab.openaq.service.etiquetado.EstandaremisionService;
import cimab.openaq.service.etiquetado.PesovehiculoService;
import cimab.openaq.service.etiquetado.TipocombustibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})

public class PropVehiculoController {
    private PropietariovehiculoService pvs;
    @Autowired
    public void setPvs(PropietariovehiculoService pvs) {
        this.pvs = pvs;
    }

    private InformacionvehiculoService ivs;
    @Autowired
    public void setPvs(InformacionvehiculoService ivs) {
        this.ivs = ivs;
    }

    @RequestMapping({"/guardaPropietarioVehiculo"})
    public Propietariovehiculo guardaPropVehiculo(@RequestBody Propietariovehiculo propietarioVehiculo) {

        System.out.println("Propietario Vehiculo :::: " + propietarioVehiculo) ;
        pvs.guardaPropVehiculo(propietarioVehiculo);
        return propietarioVehiculo;
    }

    @RequestMapping({"/listaPropietarioVehiculo"})
    public List<Propietariovehiculo> listaPropietarioVehiculo(@RequestBody String placa) {
        System.out.println("Ingresa a listado prop vehiculo ....... " + placa);

        List<Propietariovehiculo>  listPropVehiculo = pvs.listaaPropietarioVehiculooo(placa);

        return listPropVehiculo;
    }

    @RequestMapping({"/propietarioVehiculoPlaca"})
    public Propietariovehiculo propietarioVehiculoPlaca(@RequestBody Propietariovehiculo propietarioVehiculo) {
        Propietariovehiculo propietaVehiculoX = pvs.PropietariovehiculoXplaca(propietarioVehiculo.getPlaca());
        System.out.println("Datos del propietario del vehiculo ... " + propietaVehiculoX );
        return propietaVehiculoX;
    }


    @RequestMapping({"/guardaInformacionVehiculo"})
    public Informacionvehiculo guardaInformacionVehiculo(@RequestBody Informacionvehiculo informacionvehiculo) {
        System.out.println("ingresa al back :::  guardaInformacionVehiculo " + informacionvehiculo );
        ivs.gInfoVeh(informacionvehiculo);
        return informacionvehiculo;
    }

    @RequestMapping({"/consultaObjetoPlaca"})
    public Placa consultaObjetoPlaca(@RequestBody String placaSt) {
// ***************************
        System.out.println("Deuteronomio 9 ::: ....... consultaObjetoPlaca " +  placaSt);
        Placa placa = ivs.consultaObjetoPlaca(placaSt);

        System.out.println("Galatas 1 .. 10 :::  " + placa );
        return placa;
    }



}

package cimab.openaq.controller.etiquetado;

import cimab.openaq.entity.etiquetado.Cilindrada;
import cimab.openaq.entity.etiquetado.Estandaremision;
import cimab.openaq.entity.etiquetado.Pesovehiculo;
import cimab.openaq.entity.etiquetado.Tipocombustible;
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

public class PesovehiculoController {
    private PesovehiculoService ts;

    @Autowired
    public void setTs(PesovehiculoService ts) {
        this.ts = ts;
    }


    @RequestMapping({"/listPesovehiculo"})
    public List<Pesovehiculo> listPesovehiculo(@RequestBody Integer idclasevehiculo) {
        System.out.println("Si ingresa al servicios ::: Listado estado de listClaseVehiculo ........... " );
        List<Pesovehiculo> listPesovehiculo = ts.listPesovehiculo (idclasevehiculo);
        System.out.println("listPesovehiculo ........... " + listPesovehiculo);
        return listPesovehiculo;

    }
}

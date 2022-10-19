package cimab.openaq.controller.etiquetado;


import cimab.openaq.entity.etiquetado.Cilindrada;
import cimab.openaq.entity.etiquetado.Tipocombustible;
import cimab.openaq.service.etiquetado.CilindradaService;
import cimab.openaq.service.etiquetado.TipocombustibleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})

public class CilindradaController {
    private CilindradaService ts;

    @Autowired
    public void setTs(CilindradaService ts) {
        this.ts = ts;
    }


    @RequestMapping({"/listCilindrada"})
    public List<Cilindrada> listCilindrada(@RequestBody Integer idclasevehiculo) {
        System.out.println("Si ingresa al servicios ::: Listado estado de listClaseVehiculo ........... " );
        List<Cilindrada> listCilindrada = ts.listCilindrada(idclasevehiculo);
        System.out.println("Listado estado de listClaseVehiculo ........... " + listCilindrada);
        return listCilindrada;

    }

}

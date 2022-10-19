package cimab.openaq.controller.etiquetado;

import cimab.openaq.entity.etiquetado.Categoria;
import cimab.openaq.entity.etiquetado.Cilindrada;
import cimab.openaq.service.etiquetado.CategoriaService;
import cimab.openaq.service.etiquetado.CilindradaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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

public class CategoriaController {
    private CategoriaService ts;

    @Autowired
    public void setTs(CategoriaService ts) {
        this.ts = ts;
    }


    @RequestMapping({"/listCategoria"})
    public List<Categoria> listCategoria(@RequestBody Integer idclasevehiculo) {
        System.out.println("CAtegoria servicios ::: Listado estado de listClaseVehiculo ........... " );
        List<Categoria> listCategoria = ts.listCategoria(idclasevehiculo);
        System.out.println("Listado estado de listClaseVehiculo ........... " + listCategoria);
        return listCategoria ;

    }

}


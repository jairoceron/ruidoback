package cimab.openaq.controller.etiquetado;

import cimab.openaq.entity.etiqoracle.EvaEtiquetado;
import cimab.openaq.entity.etiqoracle.Informacionvehiculo;
import cimab.openaq.entity.etiqoracle.TipologiaVehicular;
import cimab.openaq.entity.etiquetado.Categoria;
import cimab.openaq.entity.etiquetado.Cilindrada;
import cimab.openaq.service.etiqoracle.TipologiaVehicularService;
import cimab.openaq.service.etiqoracle.util.FactorAmbiVehicular;
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
    private TipologiaVehicularService tvs;
    private FactorAmbiVehicular fva;

    @Autowired
    public void setTs(CategoriaService ts) {
        this.ts = ts;
    }

    @Autowired
    public void setFva(FactorAmbiVehicular fva) {
        this.fva = fva;
    }

    @Autowired
    public void setTvs(TipologiaVehicularService tvs) {
        this.tvs = tvs;
    }


    @RequestMapping({"/listCategoria"})
    public List<Categoria> listCategoria(@RequestBody Integer idclasevehiculo) {

        List<Categoria> listCategoria = ts.listCategoria(idclasevehiculo);

        return listCategoria ;

    }

    @RequestMapping({"/listTipologiaVehicular"})
    public List<TipologiaVehicular> listTipologiaVehicular(@RequestBody Integer idclasevehiculo) {

        List<TipologiaVehicular> listTipologiaVehicular = tvs.listTipologiaVehicular();

        return listTipologiaVehicular;

    }

    @RequestMapping({"/calculoFactosAmbiVehicular"})
    public EvaEtiquetado calculoFactosAmbiVehicular(@RequestBody Informacionvehiculo infoVehiculo) {


        EvaEtiquetado evaEtiquetado = fva.calculoFactosAmbiVehicular(infoVehiculo);

        return evaEtiquetado;
                //9999999999999999999999999999999999999999999999
    }

    @RequestMapping({"/calculoFactosAmbiVehicularTipologiaVehicular"})
    public List<EvaEtiquetado> calculoFactosAmbiVehicularTipologiaVehicular(@RequestBody Informacionvehiculo infoVehiculo) {


        List<EvaEtiquetado> listEvaEtiquetado = fva.calculoFactosAmbiVehicularTipologiaVehicular(infoVehiculo);

        return listEvaEtiquetado;
        //9999999999999999999999999999999999999999999999
    }

}


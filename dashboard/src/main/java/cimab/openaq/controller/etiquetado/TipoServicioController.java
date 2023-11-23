package cimab.openaq.controller.etiquetado;

import cimab.openaq.entity.etiquetado.Tipocombustible;
import cimab.openaq.entity.etiquetado.Tiposervicio;
import cimab.openaq.service.etiquetado.TipocombustibleService;
import cimab.openaq.service.etiquetado.TiposervicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class TipoServicioController {

    private TiposervicioService ts;

    @Autowired
    public void setTs(TiposervicioService ts) {
        this.ts = ts;
    }

    @RequestMapping({"/listTipoServicio"})
    public List<Tiposervicio> listTipoServicio(@RequestBody Integer idtiposervicio) {

        List<Tiposervicio> listTipoServicio = ts.listTipoServicio(idtiposervicio);

        return listTipoServicio;

    }

}


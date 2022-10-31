package cimab.openaq.controller.ruido;

import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.Visitas;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.service.ruido.PqrsService;
import cimab.openaq.service.ruido.RadicadoService;
import cimab.openaq.service.ruido.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cimab/ruido")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class RadicadoController {

    private RadicadoService rs;

    @Autowired
    public void setRs(RadicadoService rs) {
        this.rs = rs;
    }

    @RequestMapping({"/guardaRadicado"})
    public Pqrs guardaRadicado(@RequestBody Pqrs pqrs ) {

        Pqrs pqrsX = rs.guardarRadicado( pqrs);

        return pqrsX;
    }

    @RequestMapping({"/consultaRadicado"})
    public Pqrs consultaRadicado(@RequestBody Pqrs pqrs ) {

        Pqrs pqrsX = rs.consultaRadicado( pqrs);
        System.out.println("Consulta si esta llegado GDMPTLB :: " + pqrs + " listPqrs " ) ;
        return pqrsX;
    }


}

package cimab.openaq.controller.ruido;

import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.Visitas;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.service.ruido.PqrsService;
import cimab.openaq.service.ruido.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cimab/ruido")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class PqrsController {

    private PqrsService ps;

    @Autowired
    public void setPs(PqrsService ps) {
        this.ps = ps;
    }


    @RequestMapping({"/consultaDirecPqrs"})
    public List<Pqrs> consultaDirecPqrs(@RequestBody ConsultaVisita consultaVisita ) {

        return ps.consultaDirecPqrs(consultaVisita);
    }


}

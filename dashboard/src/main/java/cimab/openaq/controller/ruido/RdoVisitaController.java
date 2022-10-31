package cimab.openaq.controller.ruido;

import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.RdoProfesional;
import cimab.openaq.entity.ruido.RdoVisita;
import cimab.openaq.service.ruido.RdoProfesionalService;
import cimab.openaq.service.ruido.RdoVisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class RdoVisitaController {
    private RdoVisitaService ras;

    @Autowired
    public void setRas(RdoVisitaService ras) {
        this.ras = ras;
    }

    @RequestMapping({"/visitasPorRadicado"})
    public List<RdoVisita> visitasPorRadicado(@RequestBody Pqrs pqrs ) {
        List<RdoVisita> listVisita = ras.consultaVisita(pqrs.getRadicado());
        return listVisita;
    }

    @RequestMapping({"/guardaVisita"})
    public RdoVisita guardaVisita(@RequestBody RdoVisita rdoVisita  ) {
        RdoVisita rdoVisitaX = ras.guardaVisita(rdoVisita);
        return rdoVisitaX;
    }

    @RequestMapping({"/consultaVisitasProfesional"})
    public List<RdoVisita> consultaVisitasProfesional(@RequestBody String profesional  ) {
        List<RdoVisita> listRdoVisitaX = ras.consultaVisitaPorProfesional(profesional);
        System.out.println("lista ... de visitas ::: " + profesional  + " " + listRdoVisitaX);
        return listRdoVisitaX;
    }
}

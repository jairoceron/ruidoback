package cimab.openaq.controller.rmcab;

import cimab.openaq.entity.rmcab.Sbccalidad;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.service.rmcab.SbccalidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "cimab/ruido")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class SbccalidadController {

    private SbccalidadService ps;

    @Autowired
    public void setPs(SbccalidadService ps) {
        this.ps = ps;
    }

    @RequestMapping({"/consultaSbccalidad"})
    public List<Sbccalidad> consultaSbccalidad(@RequestBody ConsultaVisita consultaVisita ) {
        return ps.consultaSbccalidad(consultaVisita);
    }

    @RequestMapping({"/calidadPM1"})
    public List<Sbccalidad> calidadPM1(@RequestBody ConsultaVisita consultaVisita ) {
        return ps.calidadPM1(consultaVisita);
    }
}

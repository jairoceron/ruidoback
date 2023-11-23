package cimab.openaq.controller.sbc;

import cimab.openaq.entity.ruido.PqrsDTO;
import cimab.openaq.entity.sbc.Sensoresvariable;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.service.etiqoracle.EvaEtiquetadoService;
import cimab.openaq.service.sbc.SensoresvariableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})

public class SensoresvariableController {

    private SensoresvariableService ees;

    @Autowired
    public void setEes(SensoresvariableService ees) {
        this.ees = ees;
    }


    @RequestMapping({"/calidadMicroSensor"})
    public List<Sensoresvariable> calidadMicroSensor(@RequestBody ConsultaVisita consultaVisita ) {

        ees.calidadMicrosensor();

        return null;
    }


}

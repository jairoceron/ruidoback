package cimab.openaq.controller.etiquetado;

import cimab.openaq.entity.etiquetado.Estandaremision;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "eva/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})

public class EvaCiudadanoController {

    @RequestMapping({"/ciudadano"})
    public void evaCiudadano() {


    }

}

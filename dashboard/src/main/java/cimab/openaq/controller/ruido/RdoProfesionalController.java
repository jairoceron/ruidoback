package cimab.openaq.controller.ruido;

import cimab.openaq.entity.ruido.RdoEstado;
import cimab.openaq.entity.ruido.RdoProfesional;
import cimab.openaq.service.ruido.RdoEstadoService;
import cimab.openaq.service.ruido.RdoProfesionalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class RdoProfesionalController {
    private RdoProfesionalService ras;

    @Autowired
    public void setRas(RdoProfesionalService ras) {
        this.ras = ras;
    }

    @RequestMapping({"/consultaProfesional"})
    public List<RdoProfesional> consultaSector(@RequestBody RdoProfesional rdoProfesional ) {

        List<RdoProfesional> listProfesional = ras.consultaProfesional();
        return listProfesional;
    }
}

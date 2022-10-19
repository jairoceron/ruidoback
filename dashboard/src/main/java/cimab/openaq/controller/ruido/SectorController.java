package cimab.openaq.controller.ruido;

import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.RuiSector;
import cimab.openaq.service.ruido.RuiSectorService;
import cimab.openaq.service.ruido.RuidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class SectorController {
    private RuiSectorService rus;

    @Autowired
    public void setRus(RuiSectorService rus) {
        this.rus = rus;
    }

    @RequestMapping({"/consultaSector"})
    public List<RuiSector> consultaSector(@RequestBody RuiSector ruiSector ) {

        List<RuiSector> listRuiSector = rus.consultaSector();
        return listRuiSector;
    }
}

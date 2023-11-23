package mintrabajo.dashboard.controller;


import mintrabajo.dashboard.model.DashboardX;
import mintrabajo.dashboard.model.Resumen;
import mintrabajo.dashboard.services.DtService;
import mintrabajo.dashboard.services.ProcesoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "dashboard/dt/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class DtController {

    private DtService ds;

    @Autowired
    public void setDs(DtService ds) {
        this.ds = ds;
    }

    @GetMapping(path = "estProcesoGeneral",produces="application/json")
    @ResponseBody
    DashboardX estProcesoGeneral (@RequestParam(name = "idFlujoPk", defaultValue = "15691")   Integer idFlujoPk, @RequestParam(name = "dirTerrito", defaultValue = "Bogotá")   String dirTerrito, @RequestParam(name = "fechaCorte", defaultValue = "2020/01/01") String fechaCorte ) {


        DashboardX dash = ds.estProcesoGeneral(idFlujoPk,dirTerrito,fechaCorte );

        return dash;
    }

    @GetMapping(path = "descargaExcel",produces="application/json")
    @ResponseBody
    List<Resumen> descargaExcel (@RequestParam(name = "idFlujoPk", defaultValue = "15691")   Integer idFlujoPk, @RequestParam(name = "dirTerrito", defaultValue = "Bogotá")   String dirTerrito, @RequestParam(name = "fechaCorte", defaultValue = "2020/01/01") String fechaCorte ) {

        List<Resumen>  dash = ds.descargaExcel(idFlujoPk,dirTerrito,fechaCorte );


        return dash;
    }
}

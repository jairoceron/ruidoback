package mintrabajo.dashboard.controller;

import mintrabajo.dashboard.model.*;
import mintrabajo.dashboard.model.dto.ValoresDTO;
import mintrabajo.dashboard.services.SancionConsolidado;
import mintrabajo.dashboard.services.SancionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "dashboard/sancion/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})

public class SancionController {
    private SancionService ss;

    @Autowired
    public void setSs(SancionService ss) {
        this.ss = ss;
    }


    @GetMapping(path = "listaTerritorial",produces="application/json")
    @ResponseBody
    public List<ValoresDTO> listaTerritorial() {
        return ss.listaTerritorial();

    }



    @GetMapping(path = "procesosgrupo",produces="application/json")
    @ResponseBody
    public List<ProcesosGrupo> procesosgrupo() {

        return ss.procesosgrupo();
    }




    @GetMapping(path = "lista_plant_consolid",produces="application/json")
    @ResponseBody
    public List<SancionSectorEcono> lista_plant_consolid(@RequestParam(name = "periodo", defaultValue = "2") Integer periodo,
                                                         @RequestParam(name = "parametro_territorial", defaultValue = "2") Integer parametro_territorial,
                                                         @RequestParam(name = "naturaleza", defaultValue = "Todas") String naturaleza,
                                                         @RequestParam(name = "estadoProceso", defaultValue = "estadoProceso") String estadoProceso ,
                                                         @RequestParam(name = "plantilla", defaultValue = "plantilla") String plantilla ) {

        return ss.consultaGeneral(periodo, parametro_territorial, naturaleza, estadoProceso, plantilla );
    }

}

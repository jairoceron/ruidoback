package cimab.openaq.controller.datalake;

import cimab.openaq.entity.etiquetado.Categoria;
import cimab.openaq.entity.rmcaboracle.AllTabsColumns;
import cimab.openaq.service.etiquetado.CategoriaService;
import cimab.openaq.service.rmcaboracle.AllTabsColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})

public class ConstruccionEntityController {
    private AllTabsColumnsService ts;

    @Autowired
    public void setTs(AllTabsColumnsService ts) {
        this.ts = ts;
    }


    @RequestMapping({"/generarEntityTableName"})
    public List<AllTabsColumns> generarEntityTableName(@RequestBody String tableName) {
        System.out.println("CAtegoria servicios ::: Listado estado de listClaseVehiculo ........... " );
        List<AllTabsColumns> lisAllTabsCol = ts.listAllTabsColumns(tableName);
        System.out.println(">>> goria servicios ::: " + lisAllTabsCol);
        return lisAllTabsCol ;

    }
}

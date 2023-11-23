package cimab.openaq.controller.oracle;


import cimab.openaq.entity.etiqoracle.AllTabsColumns;
import cimab.openaq.service.etiqoracle.AllTabsColumnsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "giunal/makeentity/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class MakeEntityController {
    private AllTabsColumnsService ts;


    @Autowired
    public void setTs(AllTabsColumnsService ts) {
        this.ts = ts;
    }



    @RequestMapping({"/generarEntityXX"})
    public List<AllTabsColumns> generarEntityTableName(@RequestBody String tableName) {

           tableName = "HOJAVIDA_HOV";
           String claseTable = "HojavidaSara";


           List<AllTabsColumns> lisAllTabsCol = ts.listAllTabsColumns(tableName, claseTable);

        return null;

    }


}


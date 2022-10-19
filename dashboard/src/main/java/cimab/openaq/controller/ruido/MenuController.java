package cimab.openaq.controller.ruido;

import cimab.openaq.service.ruido.MenuService;
import cimab.openaq.service.ruido.RuidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})

public class MenuController {

    private MenuService ts;
    @Autowired
    public void setTs(MenuService ts) {
        this.ts = ts;
    }



}

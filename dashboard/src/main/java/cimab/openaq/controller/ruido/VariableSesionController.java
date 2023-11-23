package cimab.openaq.controller.ruido;
import cimab.openaq.dataTransferObject.VariableSesionI;
import cimab.openaq.model.AuthenticationRequest;
import cimab.openaq.repository.rmcab.MenuRepository;
import cimab.openaq.service.ruido.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(path = "cimab/ruido")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class VariableSesionController {


    private MenuService ts;

    @Autowired
    public void setTs(MenuService ts) {
        this.ts = ts;
    }

    private MenuRepository mr;

    @Autowired
    public void setMr(MenuRepository mr) {
        this.mr = mr;
    }


    //@GetMapping(path = "variableSesion")
    // @RequestMapping(path = "variableSesion")
    @RequestMapping({"/variableSesion"})
   // public VariableSesionI listFuncionariosRuido(@RequestParam(name = "username", defaultValue = "0") String username ) {


    public VariableSesionI listFuncionariosRuido(@RequestBody String username ) {

        VariableSesionI vSesion = new VariableSesionI();
        vSesion.setUsername(username);
        List<String> modulos = new ArrayList<>();
        modulos.add("ruido");
        modulos.add("etiquetado");

        // mr.listMenuModulo(username);

        List<String> menu = mr.listMenuModulo(username);

        vSesion.setModulo(modulos);
        vSesion.setMenu(menu);

        return  vSesion;
    }

}

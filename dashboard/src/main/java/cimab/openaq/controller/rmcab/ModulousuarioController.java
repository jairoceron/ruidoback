package cimab.openaq.controller.rmcab;

import cimab.openaq.entity.rmcab.Modulousuario;
import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.RdoVisita;
import cimab.openaq.service.rmcab.ModulousuarioService;
import cimab.openaq.service.ruido.RdoVisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class ModulousuarioController {
    private ModulousuarioService ras;

    @Autowired
    public void setRas(ModulousuarioService ras) {
        this.ras = ras;
    }

    @RequestMapping({"/cargaModuloUsuario"})
    public List<Modulousuario> cargaModuloUsuario(@RequestBody String usuario ) {
        List<Modulousuario> listModulousuario = ras.cargaModulos(usuario);
        return listModulousuario;
    }
}

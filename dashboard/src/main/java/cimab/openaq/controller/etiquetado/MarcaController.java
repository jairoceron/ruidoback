package cimab.openaq.controller.etiquetado;
import cimab.openaq.entity.etiquetado.Marca;
import cimab.openaq.entity.etiquetado.Tiposervicio;
import cimab.openaq.service.etiquetado.MarcaService;
import cimab.openaq.service.etiquetado.TiposervicioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class MarcaController {
    private MarcaService ts;

    @Autowired
    public void setTs(MarcaService ts) {
        this.ts = ts;
    }

    @RequestMapping({"/listMarca"})
    public List<Marca> listMarca(@RequestBody Integer idclasevehiculo) {
        System.out.println("Si ingresa al servicios ::: listado de marcas ........... " );
        List<Marca> listMarca = ts.listMarca(idclasevehiculo);
        // 66666666666666666666666
        System.out.println("Listado marcas ........... " + listMarca);
        return listMarca;

    }
}

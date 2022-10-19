package cimab.openaq.controller.rmcab;
import cimab.openaq.entity.rmcab.Variableambiental;
import cimab.openaq.service.Tablero.TableroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})

public class TableroController {

    private TableroService ts;

    @Autowired
    public void setTs(TableroService ts) {
        this.ts = ts;
    }


    @GetMapping(path = "calidadAire",produces="application/json")
    @ResponseBody
    public String calidadAire(@RequestParam(name = "date_from", defaultValue = "2020")  String date_from, @RequestParam(name = "date_to", defaultValue = "2020")  String date_to, @RequestParam(name = "parameter", defaultValue = "pm25")  String parameter) {

        String retorno = " Termina ........  ";
        return retorno;
    }

    @GetMapping(path = "listaEstaciones",produces="application/json")
    @ResponseBody
    public List<String> listaEstaciones() {
        return ts.listaEstaciones();
    }

    @GetMapping(path = "listaVariables",produces="application/json")
    @ResponseBody
    public List<String> listaVariables() {
        return ts.listaVariables();
    }


    @GetMapping(path = "listaDatosVarAmbiental",produces="application/json")
    @ResponseBody
    public List<Variableambiental> listaDatosVarAmbiental(@RequestParam(name = "variable", defaultValue = "CO")  String variable,
                                                          @RequestParam(name = "estacion", defaultValue = "Usaquen")  String estacion,
                                                          @RequestParam(name = "fechaInicial", defaultValue = "01/01/2018")  String fechaInicial,
                                                          @RequestParam(name = "fechaFinal", defaultValue = "11/10/2020")  String fechaFinal,
                                                          @RequestParam(name = "estadistico", defaultValue = "")  String estadistico
                                                          ) {
        return ts.listaDatosVarAmbiental(variable, estacion, fechaInicial, fechaFinal, estadistico);
    }

}

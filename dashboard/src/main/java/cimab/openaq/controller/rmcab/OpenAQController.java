package cimab.openaq.controller.rmcab;

import cimab.openaq.model.OpenAqFormat;
import cimab.openaq.service.OpenAQService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/sda/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class OpenAQController {
    private OpenAQService cs;

    @Autowired
    public void setCs(OpenAQService cs) {
        this.cs = cs;
    }


    @GetMapping(path = "calificacionparticipante")
    public  Integer  getCalificacionParticipante(@RequestParam(name = "idSample", defaultValue = "0")  int idSample, @RequestParam(name = "userCodProasecal", defaultValue = "0")  int userCodProasecal) {
        return null;
    }

    @GetMapping(path = "average",produces="application/json")
    @ResponseBody
    public String  average(@RequestParam(name = "date_from", defaultValue = "2020")  String date_from, @RequestParam(name = "date_to", defaultValue = "2020")  String date_to, @RequestParam(name = "parameter", defaultValue = "pm25")  String parameter) {


        cs.operacion(date_from, date_to, parameter);
        String retorno = " Termina ........  ";
        return retorno;
    }


    @GetMapping(path = "latest",produces="application/json")
    @ResponseBody
    public String  latest(@RequestParam(name = "city", defaultValue = "bogota")  String city, @RequestParam(name = "parameter", defaultValue = "pm25")  String parameter) {

        cs.latest(city, parameter);
        String retorno = " Termina ........  ";
        return retorno;
    }

    @GetMapping(path = "openAq",produces="application/json")
    @ResponseBody
    public List<OpenAqFormat> openAq() {
        List<OpenAqFormat> ltOpenAqFormat =  cs.openAq();

        return ltOpenAqFormat;
    }


}

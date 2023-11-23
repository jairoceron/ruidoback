package cimab.openaq.controller.etiquetado;

import cimab.openaq.entity.etiqoracle.Informacionvehiculo;
import cimab.openaq.entity.etiquetado.Pesovehiculo;
import cimab.openaq.repository.etiqoracle.InformacionvehiculoRepository;
import cimab.openaq.service.etiqoracle.InformacionvehiculoService;
import cimab.openaq.service.etiqoracle.PropietariovehiculoService;
import cimab.openaq.service.etiquetado.PesovehiculoService;
import cimab.openaq.service.etiquetado.fileXML.MetadataArchPDF;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class GenerarPDFEtiquetadoController {
    private PesovehiculoService ts;
    private PropietariovehiculoService pvs;


    private InformacionvehiculoService vs;
    @Autowired
    public void setVs(InformacionvehiculoService vs) {
        this.vs = vs;
    }

    @Autowired
    public void setTs(PesovehiculoService ts) {
        this.ts = ts;
    }

    @Autowired
    public void setPvs(PropietariovehiculoService pvs) {
        this.pvs = pvs;
    }


    @RequestMapping({"/generarPDFetiquetadooo"})
    public MetadataArchPDF generarPDFetiquetadooo(@RequestBody String placa) {
        MetadataArchPDF metadataArchPDF = pvs.listPropietarioVehiculo(placa);
        String json = "{ \"placa\": \"" + placa  + "\", \"java\": true }";

        return metadataArchPDF;

    }

    @RequestMapping({"/generarEtiquetadPrinterHolograma"})
    public MetadataArchPDF  generarEtiquetadPrinterHolograma(@RequestBody String placa) {

        MetadataArchPDF metadataArchPDF = pvs.generarEtiquetadPrinterHolograma(placa);
        return metadataArchPDF;

    }

    @RequestMapping({"/consultaDataInfoVehic"})
    public List<Informacionvehiculo>  consultaDataInfoVehic(@RequestBody Informacionvehiculo infoVehiculo) {


        return vs.listInformacionVehiculo(infoVehiculo);


    }

}


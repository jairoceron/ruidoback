package cimab.openaq.controller.etiquetado;

import cimab.openaq.entity.etiquetado.Pesovehiculo;
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
        System.out.println("GDMPTLB :: json ..... " + json );
        return metadataArchPDF;

    }

    @RequestMapping({"/generarEtiquetadPrinterHolograma"})
    public String generarEtiquetadPrinterHolograma(@RequestBody String placa) {
        System.out.println("lo que parece un reves es en realidad Dios preparandome para la plenitud de mi destino ... ");
        pvs.generarEtiquetadPrinterHolograma(placa);

        return placa;

    }

}


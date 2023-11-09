package cimab.openaq.controller.ruido;

import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.RdoTipopredio;
import cimab.openaq.entity.ruido.SectorReportadoPqrs;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.service.ruido.PqrsService;
import cimab.openaq.service.ruido.RdoEstadoService;
import cimab.openaq.service.ruido.RdoTipopredioService;
import cimab.openaq.service.ruido.SectorReportadoPqrsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cimab/ruido/")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class RdoTipopredioController {

    private RdoTipopredioService ras;
    private PqrsService pqs;
    private SectorReportadoPqrsService srs;

    @Autowired
    public void setRas(RdoTipopredioService ras) {
        this.ras = ras;
    }

    @Autowired
    public void setSrs(SectorReportadoPqrsService srs) {
        this.srs = srs;
    }

    @Autowired
    public void setPqs(PqrsService pqs) {
        this.pqs = pqs;
    }


    @RequestMapping({"/consultaTipopredio"})
    public List<SectorReportadoPqrs> consultaTipopredio(@RequestBody SectorReportadoPqrs sectorReportado ) {
        List<SectorReportadoPqrs> listRdoTipopredio = srs.listSectorReportado();
        return listRdoTipopredio;
    }

     public List<RdoTipopredio> consultaTipopredio(@RequestBody RdoTipopredio rdoTipopredio ) {
        List<RdoTipopredio> listRdoTipopredio = ras.consultaProfesional();
        return listRdoTipopredio;
    }

    @RequestMapping({"/consultaPorTipoPredioVisita"})
    public List<Pqrs> consultaPorTipoPredioVisita(@RequestBody ConsultaVisita consultaVisita ) {
        System.out.println("ConsultaVisita :: " + consultaVisita);
        List<Pqrs> listPqrsTipopredio = pqs.consultaTipoPredio(consultaVisita);
        return listPqrsTipopredio;
       // return null;
    }
}

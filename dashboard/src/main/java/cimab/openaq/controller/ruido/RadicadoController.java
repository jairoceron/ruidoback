package cimab.openaq.controller.ruido;

import cimab.openaq.dto.ruido.ChartGenerico;
import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.PqrsDTO;
import cimab.openaq.entity.ruido.Visitas;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.service.ruido.PqrsService;
import cimab.openaq.service.ruido.RadicadoService;
import cimab.openaq.service.ruido.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cimab/ruido")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class RadicadoController {

    private RadicadoService rs;

    @Autowired
    public void setRs(RadicadoService rs) {
        this.rs = rs;
    }

    @RequestMapping({"/guardaRadicado"})
    public Pqrs guardaRadicado(@RequestBody Pqrs pqrs ) {

        Pqrs pqrsX = rs.guardarRadicado( pqrs);
        return pqrsX;
    }



    @RequestMapping({"/updateRadicado"})
    public Pqrs updateRadicado(@RequestBody Pqrs pqrs ) {

        Pqrs pqrsX = rs.guardarRadicado( pqrs);
        return pqrsX;
    }

    @RequestMapping({"/consultaRadicado"})
    public Pqrs consultaRadicado(@RequestBody Pqrs pqrs ) {

        Pqrs pqrsX = rs.consultaRadicado( pqrs);

        return pqrsX;
    }



    @RequestMapping({"/chartEstadoTramite"})
    public List<ChartGenerico> chartEstadoTramite(@RequestBody ConsultaVisita consultaVisita) {
        List<ChartGenerico> listCharGeneri = rs.chartEstadoTramite(consultaVisita);
        return listCharGeneri;
    }

    @RequestMapping({"/chartNoEsCompetencia"})
    public List<ChartGenerico> chartNoEsCompetencia(@RequestBody ConsultaVisita consultaVisita) {
        List<ChartGenerico> listCharNoCompe = rs.chartNoEsCompetencia(consultaVisita);
        return listCharNoCompe;
    }


    @RequestMapping({"/chartProvisionalET"})
    public List<ChartGenerico> chartProvisionalET(@RequestBody ConsultaVisita consultaVisita) {
        List<ChartGenerico> listCharNoCompe = rs.chartProvisionalET(consultaVisita);
        return listCharNoCompe;
    }

    @RequestMapping({"/consultaOrganismoDeControl"})
    public List<Pqrs> consultaOrganismoDeControl(@RequestBody ConsultaVisita consultaVisita) {


        List<Pqrs> consultaOrganismoDeControl = rs.consultaOrganismoDeControl(consultaVisita);


        return consultaOrganismoDeControl;
    }

    @RequestMapping({"/visitaNoEfectivaReprograma"})
    public List<PqrsDTO> visitaNoEfectivaReprograma(@RequestBody ConsultaVisita consultaVisita) {


        List<PqrsDTO> listVisitaNoEfectiva = rs.visitaNoEfectivaReprograma(consultaVisita);

        return listVisitaNoEfectiva;
    }

    @RequestMapping({"/visitaPorPeticionario"})
    public List<PqrsDTO> visitaPorPeticionario(@RequestBody ConsultaVisita consultaVisita) {


        List<PqrsDTO> listVisitaNoEfectiva = rs.visitaPorPeticionario(consultaVisita);

        return listVisitaNoEfectiva;
    }

    @RequestMapping({"/visitaPorReporteAntecedente"})
    public List<PqrsDTO> visitaPorReporteAntecedente(@RequestBody ConsultaVisita consultaVisita) {


        List<PqrsDTO> listVisitaNoEfectiva = rs.reporteDeAntecedentes(consultaVisita);
        return listVisitaNoEfectiva;
    }

    @RequestMapping({"/visitaConsultaNoEsCompetencia"})
    public List<PqrsDTO> visitaConsultaNoEsCompetencia(@RequestBody ConsultaVisita consultaVisita) {


        List<PqrsDTO> listVisitaNoEfectiva = rs.visitaConsultaNoEsCompetencia(consultaVisita);
        return listVisitaNoEfectiva;
    }

}

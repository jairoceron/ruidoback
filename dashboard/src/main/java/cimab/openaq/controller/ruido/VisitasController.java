package cimab.openaq.controller.ruido;

import cimab.openaq.dataTransferObject.VariableSesionI;
import cimab.openaq.dto.ruido.ChartBarVertical2D;
import cimab.openaq.dto.ruido.ChartGenerico;
import cimab.openaq.entity.etiqoracle.EvaEtiquetado;
import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.PqrsDTO;
import cimab.openaq.entity.ruido.RdoVisita;
import cimab.openaq.entity.ruido.Visitas;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.service.etiqoracle.EvaEtiquetadoService;
import cimab.openaq.service.ruido.PqrsService;
import cimab.openaq.service.ruido.RuidoService;
import cimab.openaq.service.ruido.VisitaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "cimab/ruido")
@CrossOrigin(origins = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS})
public class VisitasController {

    private PqrsService ps;
    private VisitaService vs;

    private EvaEtiquetadoService ees;

    @Autowired
    public void setEes(EvaEtiquetadoService ees) {
        this.ees = ees;
    }

    @Autowired
    public void setPs(PqrsService ps) {
        this.ps = ps;
    }

    @Autowired
    public void setVs(VisitaService vs) {
        this.vs = vs;
    }

    @RequestMapping({"/consultaVisita"})
    public List<PqrsDTO> listFuncionariosRuido(@RequestBody ConsultaVisita consultaVisita ) {

        List<PqrsDTO> listPqrs = ps.consultaPqrs(consultaVisita);

        return listPqrs;
    }

    @RequestMapping({"/consultaDirecVisita"})
    public List<Visitas> listConsultaDirecVisita(@RequestBody ConsultaVisita consultaVisita ) {

        return vs.listConsultaDirecVisita(consultaVisita);


    }

    @RequestMapping({"/visitaPorRadicado"})
    public List<Visitas> visitaPorRadicado(@RequestBody ConsultaVisita consultaVisita ) {


        List<Visitas> listVisita = vs.visitasPorRadicado(consultaVisita);

        return listVisita;
    }

    @RequestMapping({"/guardaVisitaXX"})
    public Visitas guardaVisitaXX(@RequestBody Visitas visita  ) {
        Visitas rdoVisitaX = vs.guardaVisitaXX( visita);
        return rdoVisitaX;
    }

    @RequestMapping({"/consultaVisitasProfesionalXX"})
    public List<Visitas> consultaVisitasProfesional(@RequestBody String profesional  ) {
        List<Visitas> listRdoVisitaX = vs.consultaVisitaPorProfesional(profesional);

        return listRdoVisitaX;
    }

    @RequestMapping({"/cargaDataExcel"})
    public List<Visitas> cargaDataExcel(@RequestBody List<Visitas> listVisitas  ) {

        vs.cargaDataExcel(listVisitas);


        return null;
    }

    @RequestMapping({"/cargaDataExcelPQRS"})
    public List<Visitas> cargaDataExcelPQRS(@RequestBody List<Pqrs> listPqrs  ) {

        ps.cargaDataExcelPQRS(listPqrs);

        return null;
    }

    @RequestMapping({"/cargaDataExcelEtiquetado"})
    public List<EvaEtiquetado> cargaDataExcelEtiquetado(@RequestBody List<EvaEtiquetado> listEtaEtiquetado  ) {

        ees.cargaDataDeEVA(listEtaEtiquetado );

        return null;
    }

    @RequestMapping({"/chart2dTipoPredioCumpliNorma"})
    public List<ChartBarVertical2D> chart2dTipoPredioCumpliNorma(@RequestBody ConsultaVisita consultaVisita) {
        List<ChartBarVertical2D> listCharNoCompe = vs.chart2dTipoPredioCumpliNorma(consultaVisita);

        return listCharNoCompe;
    }



}

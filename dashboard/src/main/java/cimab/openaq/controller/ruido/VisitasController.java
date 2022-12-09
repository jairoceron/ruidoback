package cimab.openaq.controller.ruido;

import cimab.openaq.dataTransferObject.VariableSesionI;
import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.RdoVisita;
import cimab.openaq.entity.ruido.Visitas;
import cimab.openaq.model.ConsultaVisita;
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

    @Autowired
    public void setPs(PqrsService ps) {
        this.ps = ps;
    }

    @Autowired
    public void setVs(VisitaService vs) {
        this.vs = vs;
    }

    @RequestMapping({"/consultaVisita"})
    public List<Pqrs> listFuncionariosRuido(@RequestBody ConsultaVisita consultaVisita ) {
        List<Pqrs> listPqrs = ps.consultaPqrs(consultaVisita);
        System.out.println("Consulta 0022!!!! GDMPTLB :: " + consultaVisita + " listPqrs " + listPqrs) ;
        return listPqrs;
    }

    @RequestMapping({"/consultaDirecVisita"})
    public List<Visitas> listConsultaDirecVisita(@RequestBody ConsultaVisita consultaVisita ) {
        // List<Pqrs> listPqrs = ps.consultaPqrs(consultaVisita);
        // *********
        return vs.listConsultaDirecVisita(consultaVisita);

       // System.out.println("Consulta 0022!!!! GDMPTLB :: " + consultaVisita + " listPqrs " + listPqrs) ;
     //   return listPqrs;
    }

    @RequestMapping({"/visitaPorRadicado"})
    public List<Visitas> visitaPorRadicado(@RequestBody ConsultaVisita consultaVisita ) {


        List<Visitas> listVisita = vs.visitasPorRadicado(consultaVisita);
        // 'Aqui sacamos las visitas por radicado....
        System.out.println("Consulta 0033 GDMPTLB :: " + consultaVisita + " listPqrs " + listVisita) ;
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
        System.out.println("lista ... de visitas ::: " + profesional  + " " + listRdoVisitaX);
        return listRdoVisitaX;
    }

    @RequestMapping({"/cargaDataExcel"})
    public List<Visitas> cargaDataExcel(@RequestBody List<Visitas> listVisitas  ) {
        System.out.println("Carga los datos del archivo de Excel ::: " + listVisitas);
        vs.cargaDataExcel(listVisitas);

        //
        return null;
    }

    @RequestMapping({"/cargaDataExcelPQRS"})
    public List<Visitas> cargaDataExcelPQRS(@RequestBody List<Pqrs> listPqrs  ) {
        System.out.println("Carga los datos del archivo PRRS de Excel ::: " + listPqrs );
        ps.cargaDataExcelPQRS(listPqrs);

        //
        return null;
    }

}

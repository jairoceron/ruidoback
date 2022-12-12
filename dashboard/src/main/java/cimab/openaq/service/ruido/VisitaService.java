package cimab.openaq.service.ruido;

import cimab.openaq.dto.ruido.ChartBarVertical2D;
import cimab.openaq.dto.ruido.ChartGenerico;
import cimab.openaq.entity.ruido.Visitas;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.repository.rmcab.MenuRepository;
import cimab.openaq.repository.ruido.VisitaRepository;
import cimab.openaq.util.ListasChart;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Service
public class VisitaService {
    private VisitaRepository vr;

    @Autowired
    public void setVr(VisitaRepository vr) {
        this.vr = vr;
    }

    public List<Visitas> visitasPorRadicado(ConsultaVisita consultaVisita) {
        List<Visitas> listVisRadic = vr.listVisitasPorRadicado(consultaVisita.getRadicado());
        return listVisRadic;
    }

    public Visitas guardaVisitaXX(Visitas visitas) {
        System.out.println(" visitas " + visitas);
        Visitas visitaXX = vr.consultaSiYa_existe(visitas.getRadicado(), visitas.getProfesional_encargado(), visitas.getFechavisita());
        if (visitaXX == null) {
            vr.save(visitas);
        } else {
            visitas.setId(visitaXX.getId());
            if (!visitas.equals(visitaXX)) {
                vr.saveAndFlush(visitas);
            }
        }
return visitas;

    }

    public List<Visitas> consultaVisitaPorProfesional(String profesional) {
        List<Visitas> listVisitas =  vr.visitasPorProfesional(profesional);
        return listVisitas;
    }

    /* Carga directamente el archivo de excel utilizando el front */
    /* import * as XLSX from 'xlsx'; */
    public void cargaDataExcel(List<Visitas> listVisitas) {
        for (Visitas visita : listVisitas) {
            if (visita.getBarrio() != null) {
                if (visita.getBarrio().length() > 299 ) {
                    visita.setBarrio(visita.getBarrio().substring(0,298));
                }
            }
            if (visita.getDireccion() != null) {
                if (visita.getDireccion().length() > 299 ) {
                    visita.setDireccion(  visita.getDireccion().substring(0,298));
                }
            }
            if (visita.getCodigo_ciiu() != null) {
                if (visita.getCodigo_ciiu().length() > 299 ) {
                    visita.setCodigo_ciiu(  visita.getCodigo_ciiu().substring(0,298));
                }
            }
            if (visita.getActividad_a_realizar_segun_plan() != null) {
                if (visita.getActividad_a_realizar_segun_plan().length() > 299 ) {
                    visita.setActividad_a_realizar_segun_plan(  visita.getActividad_a_realizar_segun_plan().substring(0,298));
                }
            }
            if (visita.getActividad_especifica() != null) {
                if (visita.getActividad_especifica().length() > 299 ) {
                    visita.setActividad_especifica(  visita.getActividad_especifica().substring(0,298));
                }
            }
            if (visita.getArea_de_actividad_segun_sinupot() != null) {
                if (visita.getArea_de_actividad_segun_sinupot().length() > 299 ) {
                    visita.setArea_de_actividad_segun_sinupot(  visita.getArea_de_actividad_segun_sinupot().substring(0,298));
                }
            }
            if (visita.getEstado_de_la_visita() != null) {
                if (visita.getEstado_de_la_visita().length() > 299 ) {
                    visita.setEstado_de_la_visita(  visita.getEstado_de_la_visita().substring(0,298));
                }
            }
            if (visita.getCumplimiento_normativo() != null) {
                if (visita.getCumplimiento_normativo().length() > 299 ) {
                    visita.setCumplimiento_normativo(   visita.getCumplimiento_normativo().substring(0,298));
                }
            }
            if (visita.getDireccion__bis1() != null) {
                if (visita.getDireccion__bis1().length() > 299 ) {
                    visita.setDireccion__bis1(   visita.getDireccion__bis1().substring(0,298));
                }
            }
            if (visita.getDireccion__bis_() != null) {
                if (visita.getDireccion__bis_().length() > 299 ) {
                    visita.setDireccion__bis_(  visita.getDireccion__bis_().substring(0,298));
                }
            }

            if (visita.getEstado_de_la_visita() != null) {
                if (visita.getEstado_de_la_visita().length() > 299 ) {
                    visita.setEstado_de_la_visita(  visita.getEstado_de_la_visita().substring(0,298));
                }
            }
            if (visita.getHorario_de_la_visita() != null) {
                if (visita.getHorario_de_la_visita().length() > 299 ) {
                    visita.setHorario_de_la_visita(  visita.getHorario_de_la_visita().substring(0,298));
                }
            }
            if (visita.getGestion() != null) {
                if (visita.getGestion().length() > 299 ) {
                    visita.setGestion(  visita.getGestion().substring(0,298));
                }
            }
            if (visita.getLocalidad() != null) {
                if (visita.getLocalidad().length() > 299 ) {
                    visita.setLocalidad(  visita.getLocalidad().substring(0,298));
                }
            }
            if (visita.getNombre_comercial() != null) {
                if (visita.getNombre_comercial().length() > 299 ) {
                    visita.setNombre_comercial(   visita.getNombre_comercial().substring(0,298));
                }
            }
            if (visita.getObservaciones_al_motivo() != null) {
                if (visita.getObservaciones_al_motivo().length() > 299 ) {
                    visita.setObservaciones_al_motivo(  visita.getObservaciones_al_motivo().substring(0,298));
                }
            }
            if (visita.getObservaciones_de_area_de_activi() != null) {
                if (visita.getObservaciones_de_area_de_activi().length() > 299 ) {
                    visita.setObservaciones_de_area_de_activi(  visita.getObservaciones_de_area_de_activi().substring(0,298));
                }
            }
            if (visita.getProceso_actuacion_tecnica_o_res() != null) {
                if (visita.getProceso_actuacion_tecnica_o_res().length() > 299 ) {
                    visita.setProceso_actuacion_tecnica_o_res(   visita.getProceso_actuacion_tecnica_o_res().substring(0,298));
                }
            }
            if (visita.getProfesional_encargado()         != null) {
                if (visita.getProfesional_encargado().length() > 299 ) {
                    visita.setProfesional_encargado(   visita.getProfesional_encargado().substring(0,298));
                }
            }

            if (visita.getRadicado()         != null) {
                if (visita.getRadicado().length() > 299 ) {
                    visita.setRadicado(   visita.getRadicado().substring(0,298));
                }
            }
            if (visita.getRazon_social()         != null) {
                if (visita.getRazon_social().length() > 299 ) {
                    visita.setRazon_social(   visita.getRazon_social().substring(0,298));
                }
            }

            if (visita.getProfesional_encargado()  != null) {
                if (visita.getProfesional_encargado().length() > 299 ) {
                    visita.setProfesional_encargado(   visita.getProfesional_encargado().substring(0,298));
                }
            }

            if (visita.getProceso_actuacion_tecnica_o_res()  != null) {
                if (visita.getProceso_actuacion_tecnica_o_res().length() > 299 ) {
                    visita.setProceso_actuacion_tecnica_o_res(   visita.getProceso_actuacion_tecnica_o_res().substring(0,298));
                }
            }

            if (visita.getSolo_si_la_visita_fue_efectiva_()  != null) {
                if (visita.getSolo_si_la_visita_fue_efectiva_().length() > 299 ) {
                    visita.setSolo_si_la_visita_fue_efectiva_(   visita.getSolo_si_la_visita_fue_efectiva_().substring(0,298));
                }
            }

            if (visita.getRepresentante_legal()  != null) {
                if (visita.getRepresentante_legal().length() > 299 ) {
                    visita.setRepresentante_legal(   visita.getRepresentante_legal().substring(0,298));
                }
            }

            if (visita.getActividad_especifica()  != null) {
                if (visita.getActividad_especifica().length() > 299 ) {
                    visita.setActividad_especifica(   visita.getActividad_especifica().substring(0,298));
                }
            }

            if (visita.getProceso_actuacion_tecnica_o_res()  != null) {
                if (visita.getProceso_actuacion_tecnica_o_res().length() > 299 ) {
                    visita.setProceso_actuacion_tecnica_o_res(   visita.getProceso_actuacion_tecnica_o_res().substring(0,298));
                }
            }

            if (visita.getSolo_si_la_visita_no_fue_efecti()  != null) {
                if (visita.getSolo_si_la_visita_no_fue_efecti().length() > 299 ) {
                    visita.setSolo_si_la_visita_no_fue_efecti(   visita.getSolo_si_la_visita_no_fue_efecti().substring(0,298));
                }
            }

            if (visita.getGestion()  != null) {
                if (visita.getGestion().length() > 299 ) {
                    visita.setGestion(   visita.getGestion().substring(0,298));
                }
            }

            if (visita.getObservaciones_al_motivo()  != null) {
                if (visita.getObservaciones_al_motivo().length() > 299 ) {
                    visita.setObservaciones_al_motivo(   visita.getObservaciones_al_motivo().substring(0,298));
                }
            }

            if (visita.getDireccion__letra_()  != null) {
                if (visita.getDireccion__letra_().length() > 299 ) {
                    visita.setDireccion__letra_(   visita.getDireccion__letra_().substring(0,298));
                }
            }

            if (visita.getBarrio()  != null) {
                if (visita.getBarrio().length() > 299 ) {
                    visita.setBarrio(   visita.getBarrio().substring(0,298));
                }
            }



        }
        vr.saveAll(listVisitas);
    }

    public List<Visitas>  listConsultaDirecVisita(ConsultaVisita consultaVisita ) {
        System.out.println("consultaVisita :   " + consultaVisita);
        List<Visitas>  LVisita = vr.visitasPorDireccion(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal(), consultaVisita.getDireccion());
        System.out.println("xxxxxx:   " + LVisita);
        return LVisita;
/*
        List<Visitas> visitasPorDireccion(@Param("fechaInicial") String fechaInicial,
                @Param("fechaFinal") String fechaFinal ,
                @Param("direccion") String direccion);

 */
    }

    public List<ChartBarVertical2D>   chart2dTipoPredioCumpliNorma(ConsultaVisita  consultaVisita){

        List<String> lisTipoPredio = vr.visitasPorTipoPredio(consultaVisita.getFechaInicial(),
                consultaVisita.getFechaFinal() );

        List<ChartBarVertical2D> ltChar2D = new ArrayList<>();
        for (String tipoPredio : lisTipoPredio) {
            ChartBarVertical2D chart2D = new ChartBarVertical2D();
            List<Object[]> listObj = vr.visitasCategoriasPorTipoPredio(
                    consultaVisita.getFechaInicial(),
                    consultaVisita.getFechaFinal(),
                    tipoPredio);

            ListasChart listaChart = new ListasChart();
            List<ChartGenerico> ltChartGen = listaChart.genListaChartGenerico(listObj);
            chart2D.setName(tipoPredio);
            chart2D.setSeries(ltChartGen);
            ltChar2D.add(chart2D);
        }

        System.out.println("xxxxxx:   " + ltChar2D);
        return ltChar2D;

    }


}

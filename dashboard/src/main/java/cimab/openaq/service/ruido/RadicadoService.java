package cimab.openaq.service.ruido;

import cimab.openaq.dto.ruido.ChartGenerico;
import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.PqrsDTO;
import cimab.openaq.entity.ruido.Visitas;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.repository.ruido.PqrsRepository;
import cimab.openaq.repository.ruido.VisitaRepository;
import cimab.openaq.util.FechaVencimiento;
import cimab.openaq.util.ListasChart;
import cimab.openaq.util.Pqrs_PqrsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import static cimab.openaq.constantes.Constantes.*;

@Service
public class RadicadoService {
    private PqrsRepository pqr;
    private VisitaRepository vr;


    @Autowired
    public void setPqr(PqrsRepository pqr) {
        this.pqr = pqr;
    }

    @Autowired
    public void setVr(VisitaRepository vr) {
        this.vr = vr;
    }

    public Pqrs guardarRadicado(Pqrs pqrs) {

        Pqrs pqrsX = pqr.consultaPorRadicado(pqrs.getRadicado());
        if (!pqrsX.equals(pqrs)) {

            if (pqrs.getObjectid() != null) {
                if (!pqrs.getObjectid().equals(pqrsX.getObjectid())) {

                }
            }



            if (pqrs.getRadicado() != null) {
                if (!pqrs.getRadicado().equals(pqrsX.getRadicado())) {

                }
            }


            if (pqrs.getFecha_radicado() != null) {
                if (!pqrs.getFecha_radicado().equals(pqrsX.getFecha_radicado())) {
                    pqrsX.setFecha_radicado(pqrs.getFecha_radicado());
                }
            }   // timestamp NULL,


            if (pqrs.getAsunto_radicacion() != null) {
                if (!pqrs.getAsunto_radicacion().equals(pqrsX.getAsunto_radicacion())) {
                    pqrsX.setAsunto_radicacion(pqrs.getAsunto_radicacion());
                }
            }  // varchar(200) NULL,



            if (pqrs.getRazon_social_establecimiento() != null) {
                if (!pqrs.getRazon_social_establecimiento().equals(pqrsX.getRazon_social_establecimiento())) {
                    pqrsX.setRazon_social_establecimiento(pqrs.getRazon_social_establecimiento());
                }
            }  // varchar(200) NULL,



            if (pqrs.getSector_reportado() != null) {
                if (!pqrs.getSector_reportado().equals(pqrsX.getSector_reportado())) {
                    pqrsX.setSector_reportado(pqrs.getSector_reportado());
                }
            } // varchar(50) NULL,



            if (pqrs.getEntidad_de_control() != null) {
                if (!pqrs.getEntidad_de_control().equals(pqrsX.getEntidad_de_control())) {
                    pqrsX.setEntidad_de_control(pqrs.getEntidad_de_control());
                }
            }  // varchar(50) NULL,


            if (pqrs.getPeticionario() != null) {
                if (!pqrs.getPeticionario().equals(pqrsX.getPeticionario())) {
                    pqrsX.setPeticionario(pqrs.getPeticionario());
                }
            } // varchar(200) NULL,


            if (pqrs.getEstado_tramite() != null) {
                if (!pqrs.getEstado_tramite().equals(pqrsX.getEstado_tramite())) {
                    pqrsX.setEstado_tramite(pqrs.getEstado_tramite());
                }
            } // int2 NULL,


            if (pqrs.getObservaciones_estado_tramite() != null) {
                if (!pqrs.getObservaciones_estado_tramite().equals(pqrsX.getObservaciones_estado_tramite())) {
                    pqrsX.setObservaciones_estado_tramite(pqrs.getObservaciones_estado_tramite());
                }
            } // varchar(50) NULL,


            if (pqrs.getObservaciones_generales() != null) {
                if (!pqrs.getObservaciones_generales().equals(pqrsX.getObservaciones_generales())) {
                    pqrsX.setObservaciones_generales(pqrs.getObservaciones_generales());
                }
            } // varchar(256) NULL,


            if (pqrs.getProfesional_1ra_asignacion() != null) {
                if (!pqrs.getProfesional_1ra_asignacion().equals(pqrsX.getProfesional_1ra_asignacion())) {
                    pqrsX.setProfesional_1ra_asignacion(pqrs.getProfesional_1ra_asignacion());
                }
            } // varchar(50) NULL,


            if (pqrs.getFecha_1ra_asignacion() != null) {
                if (!pqrs.getFecha_1ra_asignacion().equals(pqrsX.getFecha_1ra_asignacion())) {
                    pqrsX.setFecha_1ra_asignacion(pqrs.getFecha_1ra_asignacion());
                }
            } // timestamp NULL,



            if (pqrs.getProfesional_2da_asignacion() != null) {
                if (!pqrs.getProfesional_2da_asignacion().equals(pqrsX.getProfesional_2da_asignacion())) {
                    pqrsX.setProfesional_2da_asignacion(pqrs.getProfesional_2da_asignacion());
                }
            } // varchar(50) NULL,


            if (pqrs.getFecha_2da_asignacion() != null) {
                if (!pqrs.getFecha_2da_asignacion().equals(pqrsX.getFecha_2da_asignacion())) {
                    pqrsX.setFecha_2da_asignacion(pqrs.getFecha_2da_asignacion());
                }
            } // timestamp NULL,


            if (pqrs.getProfesional_diligencia() != null) {
                if (!pqrs.getProfesional_diligencia().equals(pqrsX.getProfesional_diligencia())) {
                    pqrsX.setProfesional_diligencia(pqrs.getProfesional_diligencia());
                }
            } // varchar(50) NULL,


            if (pqrs.getX() != null) {
                if (!pqrs.getX() .equals(pqrsX.getX() )) {
                    pqrsX.setX(pqrs.getX());
                }
            } // numeric(38, 8) NULL,


            if (pqrs.getY() != null) {
                if (!pqrs.getY().equals(pqrsX.getY())) {
                    pqrsX.setY(pqrs.getY());
                }
            } // numeric(38, 8) NULL,


            if (pqrs.getDireccion() != null) {
                if (!pqrs.getDireccion().equals(pqrsX.getDireccion())) {
                    pqrsX.setDireccion(pqrs.getDireccion());
                }
            } // varchar(255) NULL,


            if (pqrs.getComplemento_direccion() != null) {
                if (!pqrs.getComplemento_direccion().equals(pqrsX.getComplemento_direccion())) {
                    pqrsX.setComplemento_direccion(pqrs.getComplemento_direccion());
                }
            } // varchar(255) NULL,


            if (pqrs.getLocalidad() != null) {
                if (!pqrs.getLocalidad().equals(pqrsX.getLocalidad())) {
                    pqrsX.setLocalidad(pqrs.getLocalidad());
                }
            }


            pqr.saveAndFlush(pqrsX);
        }


        return pqrs;
    }

    public Pqrs consultaRadicado(Pqrs pqrs) {
        Pqrs pqrsX = pqr.consultaPorRadicado(pqrs.getRadicado());
        return pqrsX;
    }

public List<ChartGenerico> chartEstadoTramite(ConsultaVisita consultaVisita) {

/*
    List<Object[]> listChartEsTramite = pqr.chartEstadoTramite(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal());
    List<ChartGenerico> listCharEstTramite = new ArrayList<>();
    for (Object[] objX : listChartEsTramite) {
        ChartGenerico chartGenerico = new ChartGenerico();
        String nombre = (String)objX[0];
        BigInteger valor = (BigInteger)objX[1];
        chartGenerico.setName(nombre);
        chartGenerico.setValue(valor.intValue());
        listCharEstTramite.add(chartGenerico);
    }

    return listCharEstTramite;

 */
    return null;
}

    public List<ChartGenerico> chartNoEsCompetencia(ConsultaVisita consultaVisita) {
        System.out.println("RadicadoService.java fecha inicial " + consultaVisita.getFechaInicial() );
        System.out.println("RadicadoService.java fecha final " + consultaVisita.getFechaFinal() );

        List<Object[]> listChartEsTramite = pqr.chartNoEsCompetencia(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal());
        List<ChartGenerico> listCharEstTramite = new ArrayList<>();
        for (Object[] objX : listChartEsTramite) {
            ChartGenerico chartGenerico = new ChartGenerico();
            String nombre = (String)objX[0];
            BigInteger valor = (BigInteger)objX[1];
            chartGenerico.setName(nombre);
            chartGenerico.setValue(valor.intValue());
            listCharEstTramite.add(chartGenerico);
        }

        return listCharEstTramite;


        //return null;
    }

    public List<ChartGenerico> chartProvisionalET(ConsultaVisita consultaVisita) {

        List<Object[]> listChartEsTramite = pqr.chartProvisionalET(consultaVisita.getFechaInicial(),
                consultaVisita.getFechaFinal(), ESTADO_TRAMITE_PROVISIONAL);
        ListasChart listaChart = new ListasChart();
        return listaChart.genListaChartGenerico(listChartEsTramite);


        //return null;
    }

    public List<Pqrs> consultaOrganismoDeControl(ConsultaVisita consultaVisita) {

        return pqr.consultaOrganismoControl(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal());
      //  return null;
    }

    public List<PqrsDTO> visitaConsultaNoEsCompetencia (ConsultaVisita consultaVisita) {

        System.out.println("!!!!!!!!!!!!!!!! visitaConsultaNoEsCompetencia " + consultaVisita );
        System.out.println("!!!!!!!!!!!!!!!! ESTADO_TRAMITE_NO_ES_COMPETENCIA " + ESTADO_TRAMITE_NO_ES_COMPETENCIA );

        List<Pqrs> listPqr = pqr.visitaConsultaNoEsCompetencia(consultaVisita.getFechaInicial(),
                consultaVisita.getFechaFinal(),
                ESTADO_TRAMITE_NO_ES_COMPETENCIA,
                consultaVisita.getObservacionEstadoTramite(),
                consultaVisita.getLocalidad());


        List<PqrsDTO> listPqrDTO = new ArrayList<>();
        for ( Pqrs pqrs : listPqr) {

            Pqrs_PqrsDTO pqrs_PqrsDTO  = new Pqrs_PqrsDTO();
            PqrsDTO pqrsDTO  = pqrs_PqrsDTO.conviertePqrsPqrsDTO(pqrs);
            FechaVencimiento fv = new FechaVencimiento();
            fv.addBanderaSegunFecha(pqrsDTO);
            listPqrDTO.add(pqrsDTO);
        }
        return listPqrDTO;
        // ffffffffffffffffffffffffffffffffffffffffff
    }

    public List<PqrsDTO> reporteDeAntecedentes (ConsultaVisita consultaVisita) {

        System.out.println(" CONSULTA VISITA " + consultaVisita );
        List<Pqrs> listPqr = pqr.reporteDeAntecedentes(consultaVisita.getFechaInicial(),
                consultaVisita.getFechaFinal(),
                Integer.valueOf(consultaVisita.getEstadoTramite()).intValue(),
                consultaVisita.getObservacionEstadoTramite());
        List<PqrsDTO> listPqrDTO = new ArrayList<>();
        for ( Pqrs pqrs : listPqr) {

            Pqrs_PqrsDTO pqrs_PqrsDTO  = new Pqrs_PqrsDTO();
            PqrsDTO pqrsDTO  = pqrs_PqrsDTO.conviertePqrsPqrsDTO(pqrs);
            FechaVencimiento fv = new FechaVencimiento();
            fv.addBanderaSegunFecha(pqrsDTO);
            listPqrDTO.add(pqrsDTO);
        }
        return listPqrDTO;
        // ffffffffffffffffffffffffffffffffffffffffff
    }
    public List<PqrsDTO> visitaPorPeticionario (ConsultaVisita consultaVisita) {
        List<Pqrs> listPqr = pqr.consultaPorPeticionario(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal(), consultaVisita.getPeticionario());
        List<PqrsDTO> listPqrDTO = new ArrayList<>();
        for ( Pqrs pqrs : listPqr) {

            Pqrs_PqrsDTO pqrs_PqrsDTO  = new Pqrs_PqrsDTO();
            PqrsDTO pqrsDTO  = pqrs_PqrsDTO.conviertePqrsPqrsDTO(pqrs);
            FechaVencimiento fv = new FechaVencimiento();
            fv.addBanderaSegunFecha(pqrsDTO);
            listPqrDTO.add(pqrsDTO);
        }
        return listPqrDTO;
        // ffffffffffffffffffffffffffffffffffffffffff


    }

    public List<PqrsDTO> visitaNoEfectivaReprograma (ConsultaVisita consultaVisita) {

        List<Visitas>  listVisita = vr.visitasNoEfectivaReprogramas(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal(), VISITA_NO_EF_REP);
        List<PqrsDTO> listPqrsDTO  = new ArrayList<>();
        FechaVencimiento fv = new FechaVencimiento();
        for ( Visitas visita : listVisita) {
            System.out.println("Visita ::  " +   visita);

            String chorizoRadicados = visita.getRadicado_atendido();
            StringTokenizer st = new StringTokenizer(chorizoRadicados,"; ");
            while (st.hasMoreTokens()) {
                String radicado = st.nextToken();
               // System.out.println();
                PqrsDTO pqrsDTO = new PqrsDTO();
                pqrsDTO.setRadicado(radicado);






                Pqrs pqrsXX = pqr.consultaPorRadicado(radicado);
                if (pqrsXX != null) {

                    Pqrs_PqrsDTO pqrs_PqrsDTO = new Pqrs_PqrsDTO();
                    pqrsDTO = pqrs_PqrsDTO.conviertePqrsPqrsDTO(pqrsXX);

                    if (pqrsXX.getFecha_radicado() != null) {
                        pqrsDTO.setFecha_radicado(pqrsXX.getFecha_radicado());
                        fv.addBanderaSegunFecha(pqrsDTO);
                    }

                }
// ''''''''''''''''''''''''''''''*****************************************************
                pqrsDTO.setFechaVisita(visita.getFecha_hora());
                pqrsDTO.setDireccion(visita.getDireccion_completa());
                pqrsDTO.setEstadoVisita(visita.getEstado_visita());
                pqrsDTO.setCantidad_de_reprogramaciones(visita.getCantidad_de_reprogramaciones());
                pqrsDTO.setHorario(visita.getHorario());

               // 333333333333333
                listPqrsDTO.add(pqrsDTO);

            }



        }

        // return pqr.consultaOrganismoControl(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal());
          return listPqrsDTO;
    }

}

package cimab.openaq.service.ruido;


import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.entity.ruido.PqrsDTO;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.repository.ruido.PqrsRepository;
import cimab.openaq.util.FechaVencimiento;
import cimab.openaq.util.Pqrs_PqrsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static cimab.openaq.constantes.Constantes.CON_PROVISIONAL_ET;
import static cimab.openaq.constantes.Constantes.ESTADO_TRAMITE_PROVISIONAL;

@Service
public class PqrsService {

    private PqrsRepository pr;
    private RdoEstadoTramiteService ets;

    @Autowired
    public void setPr(PqrsRepository pr) {
        this.pr = pr;
    }

    @Autowired
    public void setEts(RdoEstadoTramiteService ets) {
        this.ets = ets;
    }

    public List<PqrsDTO> consultaPqrs(ConsultaVisita consultaVisita) {

        // List<Pqrs> objects = pr.findAll();
        List<Pqrs> listPqrs = null;
        System.out.println("----- objects :: consulta PROVISIONAL .... "  );
//****************
        List<PqrsDTO> listPqrsDTO = new ArrayList<PqrsDTO>();



        // return pr.listPqrs(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal());

        if (consultaVisita.getVistaSistema() != null) {
            if (consultaVisita.getVistaSistema().equals(CON_PROVISIONAL_ET)) {
                System.out.println("-  __ INGRESA especifica provisional....  ");

                System.out.println("*** Fecha Inicial  " + consultaVisita.getFechaInicial());
                System.out.println("*** Fecha Final    " + consultaVisita.getFechaFinal());



                listPqrs = pr.listPqrs(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal(), ESTADO_TRAMITE_PROVISIONAL);
                for (Pqrs pqrs : listPqrs ) {
                    Pqrs_PqrsDTO pqrs_PqrsDTO = new Pqrs_PqrsDTO();
                    FechaVencimiento fv = new FechaVencimiento();
                    PqrsDTO pqrsDTO = pqrs_PqrsDTO.conviertePqrsPqrsDTO(pqrs);
                    fv.addBanderaSegunFecha(pqrsDTO);
                    listPqrsDTO.add(pqrsDTO);
                }

              //  333333333333333
            }
        }

        return listPqrsDTO;



    }

    public void cargaDataExcelPQRS(List<Pqrs> listPqrs) {
         /*
        for (Pqrs pqrs : listPqrs ) {
            if (pqrs.getRadicado() != null) {
                if (pqrs.getRadicado().length() > 299) {
                    pqrs.setRadicado(pqrs.getRadicado().substring(0, 299));
                }
            }

            if (pqrs.getAsunto_de_radicacion() != null) {
                if (pqrs.getAsunto_de_radicacion().length() > 299) {
                    pqrs.setAsunto_de_radicacion(pqrs.getAsunto_de_radicacion().substring(0, 299));
                }
            }
            if (pqrs.getDireccion() != null) {
                if (pqrs.getDirecciones().length() > 299) {
                    pqrs.setDirecciones(pqrs.getDirecciones().substring(0, 299));
                }
            }
            if (pqrs.getComplemento_de_direcciones() != null) {
                if (pqrs.getComplemento_de_direcciones().length() > 299) {
                    pqrs.setComplemento_de_direcciones(pqrs.getComplemento_de_direcciones().substring(0, 299));
                }
            }
            if (pqrs.getRazon_social_del_establecimient()!= null) {
                if (pqrs.getRazon_social_del_establecimient().length() > 299) {
                    pqrs.setRazon_social_del_establecimient(pqrs.getRazon_social_del_establecimient().substring(0, 299));
                }
            }
            if (pqrs.getSector_reportado() != null) {
                if (pqrs.getSector_reportado().length() > 299) {
                    pqrs.setSector_reportado(pqrs.getSector_reportado().substring(0, 299));
                }
            }
            if (pqrs.getLocalidad() != null) {
                if (pqrs.getLocalidad().length() > 299) {
                    pqrs.setLocalidad(pqrs.getLocalidad().substring(0, 299));
                }
            }
            if (pqrs.getCausante_del_origen_quejoso() != null) {
                if (pqrs.getCausante_del_origen_quejoso().length() > 299) {
                    pqrs.setCausante_del_origen_quejoso(pqrs.getCausante_del_origen_quejoso().substring(0, 299));
                }
            }


            if (pqrs.getObservaciones_generales() != null) {
                if (pqrs.getObservaciones_generales().length() > 250) {
                    pqrs.setObservaciones_generales(pqrs.getObservaciones_generales().substring(0, 249));
                }
            }

        }
        pr.saveAll(listPqrs);
        */
    }



    public List<Pqrs> consultaDirecPqrs(ConsultaVisita consultaVisita) {
        System.out.println("Aqui vamos ...... " + consultaVisita);
        List<Pqrs> listPqrs= pr.pqrsPorDireccion(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal(), consultaVisita.getDireccion());
        // for (Pqrs pqrs : listPqrs ) {
            // System.out.println("Asunto: " + pqrs.getAsunto_radicacion());
       // }
        return listPqrs;
    }

    public List<Pqrs> consultaPqrsLocalidad(ConsultaVisita consultaVisita){
        System.out.println("Consulta ::: " + consultaVisita );
        return pr.pqrsPorLocalidad(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal(), consultaVisita.getLocalidad());
    }

    public List<Pqrs> consultaPqrsEstramite(ConsultaVisita consultaVisita){
        System.out.println("Consulta Visita >>> .... " + consultaVisita );

        int idEstadoTramite = ets.retornaIdEstadoTramite(consultaVisita.getEstadoTramite());
       // sss333333333333333

        return pr.consultaPqrsEstramiteVnk(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal(), idEstadoTramite);
    }

    public List<Pqrs> consultaTipoPredio(ConsultaVisita consultaVisita){
        return pr.consultaPqrsTipoPredio(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal(), consultaVisita.getTipoPredio());
    }

 }

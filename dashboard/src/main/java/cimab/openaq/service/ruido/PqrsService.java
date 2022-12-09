package cimab.openaq.service.ruido;


import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.repository.ruido.PqrsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PqrsService {

    private PqrsRepository pr;

    @Autowired
    public void setPr(PqrsRepository pr) {
        this.pr = pr;
    }

    public List<Pqrs> consultaPqrs(ConsultaVisita consultaVisita) {

      //  List<Pqrs> objects = pr.findAll();
      //  System.out.println("----- objects " + objects );
//****************
        return pr.listPqrs(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal());



    }

    public void cargaDataExcelPQRS(List<Pqrs> listPqrs) {
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
            if (pqrs.getDirecciones() != null) {
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
    }

    public List<Pqrs> consultaDirecPqrs(ConsultaVisita consultaVisita) {
        return pr.pqrsPorDireccion(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal(), consultaVisita.getDireccion());
    }

}

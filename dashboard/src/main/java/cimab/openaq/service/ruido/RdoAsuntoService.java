package cimab.openaq.service.ruido;

import cimab.openaq.entity.ruido.RdoAsunto;
import cimab.openaq.entity.ruido.RuiLocalidad;
import cimab.openaq.repository.ruido.RdoAsuntoRepository;
import cimab.openaq.repository.ruido.RuiLocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RdoAsuntoService {

    List<RdoAsunto> listAsunto = new ArrayList<>();
    private RdoAsuntoRepository ar;

    @Autowired
    public void setAr(RdoAsuntoRepository ar) {
        this.ar = ar;
    }

    public List<RdoAsunto> consultaAsunto() {

        return inicializaListAsunto();
        // return ar.listAsunto();
    }

    public List<RdoAsunto> inicializaListAsunto() {
        listAsunto = new ArrayList<>();
        RdoAsunto rdoAsunto = new RdoAsunto();

        rdoAsunto.setIdAsunto(1);
        rdoAsunto.setNombre("SEGUIMIENTO / ACLARATORIO");
        listAsunto.add(rdoAsunto);

        rdoAsunto = new RdoAsunto();
        rdoAsunto.setIdAsunto(2);
        rdoAsunto.setNombre("ESTUDIO DE RUIDO");
        listAsunto.add(rdoAsunto);

        rdoAsunto = new RdoAsunto();
        rdoAsunto.setIdAsunto(3);
        rdoAsunto.setNombre("ORGANISMO DE CONTROL (CONTRALORIA, PERSONERIA, PRODURADURIA)");
        listAsunto.add(rdoAsunto);

        rdoAsunto = new RdoAsunto();
        rdoAsunto.setIdAsunto(4);
        rdoAsunto.setNombre("DEPENDENCIA DE APOYO");
        listAsunto.add(rdoAsunto);

        rdoAsunto = new RdoAsunto();
        rdoAsunto.setIdAsunto(5);
        rdoAsunto.setNombre("ACCION POPULAR");
        listAsunto.add(rdoAsunto);

        rdoAsunto = new RdoAsunto();
        rdoAsunto.setIdAsunto(6);
        rdoAsunto.setNombre("EXPEDIENTE");
        listAsunto.add(rdoAsunto);

        rdoAsunto = new RdoAsunto();
        rdoAsunto.setIdAsunto(7);
        rdoAsunto.setNombre("#N/D");
        listAsunto.add(rdoAsunto);

        rdoAsunto = new RdoAsunto();
        rdoAsunto.setIdAsunto(8);
        rdoAsunto.setNombre("TUTELA");
        listAsunto.add(rdoAsunto);

        rdoAsunto = new RdoAsunto();
        rdoAsunto.setIdAsunto(9);
        rdoAsunto.setNombre("ENLACE AL CONCEJO");
        listAsunto.add(rdoAsunto);

        rdoAsunto = new RdoAsunto();
        rdoAsunto.setIdAsunto(10);
        rdoAsunto.setNombre("MEMORANDO");
        listAsunto.add(rdoAsunto);

        rdoAsunto = new RdoAsunto();
        rdoAsunto.setIdAsunto(11);
        rdoAsunto.setNombre("INFORMACION / INVITACION");
        listAsunto.add(rdoAsunto);

        rdoAsunto = new RdoAsunto();
        rdoAsunto.setIdAsunto(12);
        rdoAsunto.setNombre("QUEJA / SOLICITUD DE VISITA / QUERELLA");
        listAsunto.add(rdoAsunto);

        rdoAsunto = new RdoAsunto();
        rdoAsunto.setIdAsunto(13);
        rdoAsunto.setNombre("CERTIFICACION AUDITIVA");
        listAsunto.add(rdoAsunto);

        rdoAsunto = new RdoAsunto();
        rdoAsunto.setIdAsunto(14);
        rdoAsunto.setNombre("SISTEMA DISTRITAL PARA LA GESTION DE PETICIONES CIUDADANAS - SDQS");
        listAsunto.add(rdoAsunto);

        return listAsunto;
    }




}

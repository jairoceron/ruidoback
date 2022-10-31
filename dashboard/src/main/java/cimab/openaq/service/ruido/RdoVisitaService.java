package cimab.openaq.service.ruido;

import cimab.openaq.entity.ruido.RdoProfesional;
import cimab.openaq.entity.ruido.RdoVisita;
import cimab.openaq.repository.ruido.RdoProfesionalRepository;
import cimab.openaq.repository.ruido.RdoVisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RdoVisitaService {
    private RdoVisitaRepository ar;

    @Autowired
    public void setAr(RdoVisitaRepository ar) {
        this.ar = ar;
    }

    public List<RdoVisita> consultaVisita(String radicado) {
        return ar.listVisitasXRadicado(radicado);
    }

    public List<RdoVisita> consultaVisitaPorProfesional(String profesional) {

        return ar.visitasPorProfesional(profesional);
    }

    public RdoVisita guardaVisita(RdoVisita rdoVisita) {
        RdoVisita rdoVisitaX = ar.consultaSiYaExiste(rdoVisita.getRadicado(), rdoVisita.getProfesional(), rdoVisita.getFechavisita());
        if (rdoVisitaX == null) {
            ar.save(rdoVisita);
        } else {
            rdoVisita.setIdvisita(rdoVisitaX.getIdvisita());
            if (!rdoVisita.equals(rdoVisitaX)) {
                ar.saveAndFlush(rdoVisita);
            }
        }
        return rdoVisita;
    }
}

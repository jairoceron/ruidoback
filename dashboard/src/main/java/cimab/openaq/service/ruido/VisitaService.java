package cimab.openaq.service.ruido;

import cimab.openaq.entity.ruido.Visitas;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.repository.rmcab.MenuRepository;
import cimab.openaq.repository.ruido.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}

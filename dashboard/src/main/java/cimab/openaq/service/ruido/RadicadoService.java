package cimab.openaq.service.ruido;

import cimab.openaq.entity.ruido.Pqrs;
import cimab.openaq.repository.ruido.PqrsRepository;
import cimab.openaq.repository.ruido.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RadicadoService {
    private PqrsRepository pqr;


    @Autowired
    public void setPqr(PqrsRepository pqr) {
        this.pqr = pqr;
    }

    public Pqrs guardarRadicado(Pqrs pqrs) {
        System.out.println("Radicado Service ... " + pqrs);
        pqr.save(pqrs);
        return pqrs;
    }
}

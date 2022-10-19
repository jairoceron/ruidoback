package cimab.openaq.service.ruido;

import cimab.openaq.entity.ruido.RuiSector;
import cimab.openaq.repository.rmcab.MenuRepository;
import cimab.openaq.repository.ruido.RuiSectorRepository;
import cimab.openaq.repository.ruido.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RuiSectorService {
    private RuiSectorRepository rr;

    @Autowired
    public void setRr(RuiSectorRepository rr) {
        this.rr = rr;
    }

    public List<RuiSector> consultaSector() {
        return rr.listSector();
    }
}

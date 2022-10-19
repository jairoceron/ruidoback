package cimab.openaq.service.ruido;

import cimab.openaq.entity.ruido.RuiLocalidad;
import cimab.openaq.entity.ruido.RuiSector;
import cimab.openaq.repository.rmcab.MenuRepository;
import cimab.openaq.repository.ruido.RuiLocalidadRepository;
import cimab.openaq.repository.ruido.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RuiLocalidadService {
    private RuiLocalidadRepository lr;

    @Autowired
    public void setLr(RuiLocalidadRepository lr) {
        this.lr = lr;
    }

    public List<RuiLocalidad> consultaLocalidad() {
        return lr.listLocalidad();
    }

}

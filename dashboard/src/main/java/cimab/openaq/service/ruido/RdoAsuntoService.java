package cimab.openaq.service.ruido;

import cimab.openaq.entity.ruido.RdoAsunto;
import cimab.openaq.entity.ruido.RuiLocalidad;
import cimab.openaq.repository.ruido.RdoAsuntoRepository;
import cimab.openaq.repository.ruido.RuiLocalidadRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RdoAsuntoService {
    private RdoAsuntoRepository ar;

    @Autowired
    public void setAr(RdoAsuntoRepository ar) {
        this.ar = ar;
    }

    public List<RdoAsunto> consultaAsunto() {
        return ar.listAsunto();
    }

}

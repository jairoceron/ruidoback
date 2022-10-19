package cimab.openaq.service.ruido;

import cimab.openaq.entity.ruido.RdoAsunto;
import cimab.openaq.entity.ruido.RdoEstado;
import cimab.openaq.repository.ruido.RdoAsuntoRepository;
import cimab.openaq.repository.ruido.RdoEstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RdoEstadoService {
    private RdoEstadoRepository ar;

    @Autowired
    public void setAr(RdoEstadoRepository ar) {
        this.ar = ar;
    }

    public List<RdoEstado> consultaEstado() {
        return ar.listEstado();
    }
}

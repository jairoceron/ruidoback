package cimab.openaq.service.ruido;

import cimab.openaq.entity.ruido.RdoEstado;
import cimab.openaq.entity.ruido.RdoProfesional;
import cimab.openaq.repository.ruido.RdoEstadoRepository;
import cimab.openaq.repository.ruido.RdoProfesionalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RdoProfesionalService {
    private RdoProfesionalRepository ar;

    @Autowired
    public void setAr(RdoProfesionalRepository ar) {
        this.ar = ar;
    }

    public List<RdoProfesional> consultaProfesional() {
        return ar.listProfesional();
    }
}

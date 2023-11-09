package cimab.openaq.service.ruido;

import cimab.openaq.entity.ruido.RdoProfesional;
import cimab.openaq.entity.ruido.RdoTipopredio;
import cimab.openaq.repository.ruido.RdoProfesionalRepository;
import cimab.openaq.repository.ruido.RdoTipopredioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RdoTipopredioService {
    private RdoTipopredioRepository ar;

    @Autowired
    public void setAr(RdoTipopredioRepository ar) {
        this.ar = ar;
    }

    public List<RdoTipopredio> consultaProfesional() {
        return ar.listTipoPredio();
     //   return null;
    }
}

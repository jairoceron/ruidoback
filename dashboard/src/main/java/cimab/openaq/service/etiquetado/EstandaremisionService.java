package cimab.openaq.service.etiquetado;
import cimab.openaq.entity.etiquetado.Clasevehiculo;
import cimab.openaq.entity.etiquetado.Estandaremision;
import cimab.openaq.entity.etiquetado.Tipocombustible;
import cimab.openaq.repository.etiquetado.ClasevehiculoRepository;
import cimab.openaq.repository.etiquetado.EstandaremisionRepository;
import cimab.openaq.repository.etiquetado.TipocombustibleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstandaremisionService {
    private EstandaremisionRepository vr;

    @Autowired
    public void setVr(EstandaremisionRepository vr) {
        this.vr = vr;
    }

    public List<Estandaremision> listEstandarEmision(int idclasevehiculo) {
        return vr.listEstandarEmision(idclasevehiculo);
    }
}

package cimab.openaq.service.etiquetado;
import cimab.openaq.entity.etiquetado.Clasevehiculo;
import cimab.openaq.entity.etiquetado.Tipocombustible;
import cimab.openaq.entity.etiquetado.Tiposervicio;
import cimab.openaq.repository.etiquetado.ClasevehiculoRepository;
import cimab.openaq.repository.etiquetado.TipocombustibleRepository;
import cimab.openaq.repository.etiquetado.TiposervicioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiposervicioService {
    private TiposervicioRepository vr;

    @Autowired
    public void setVr(TiposervicioRepository vr) {
        this.vr = vr;
    }

    public List<Tiposervicio> listTipoServicio(int idclasevehiculo) {
        return vr.listTipoServicio();
    }
}

package cimab.openaq.service.etiquetado;
import cimab.openaq.entity.etiquetado.*;
import cimab.openaq.repository.etiquetado.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarcaService {
    private MarcaRepository vr;

    @Autowired
    public void setVr(MarcaRepository vr) {
        this.vr = vr;
    }

    public List<Marca> listMarca(int idClaseVehiculo) {
        return vr.listMarcaByIdClaseVehiculo(idClaseVehiculo);
    }
}

package cimab.openaq.service.etiquetado;

import cimab.openaq.entity.etiquetado.Cilindrada;
import cimab.openaq.entity.etiquetado.Clasevehiculo;
import cimab.openaq.entity.etiquetado.Estandaremision;
import cimab.openaq.repository.etiquetado.CilindradaRepository;
import cimab.openaq.repository.etiquetado.ClasevehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CilindradaService {
    private CilindradaRepository vr;

    @Autowired
    public void setVr(CilindradaRepository vr) {
        this.vr = vr;
    }

    public List<Cilindrada> listCilindrada(int idclasevehiculo) {
        return vr.listCilindrada(idclasevehiculo);
    }
}

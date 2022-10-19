package cimab.openaq.service.etiquetado;

import cimab.openaq.entity.etiquetado.Categoria;
import cimab.openaq.entity.etiquetado.Pesovehiculo;
import cimab.openaq.repository.etiquetado.CategoriaRepository;
import cimab.openaq.repository.etiquetado.PesovehiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PesovehiculoService {
    private PesovehiculoRepository vr;

    @Autowired
    public void setVr(PesovehiculoRepository vr) {
        this.vr = vr;
    }

    public List<Pesovehiculo> listPesovehiculo(int idclasevehiculo) {
        return vr.listPesovehiculo(idclasevehiculo);
    }
}

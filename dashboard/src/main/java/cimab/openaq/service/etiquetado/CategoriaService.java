package cimab.openaq.service.etiquetado;

import cimab.openaq.entity.etiquetado.Categoria;
import cimab.openaq.entity.etiquetado.Cilindrada;
import cimab.openaq.repository.etiquetado.CategoriaRepository;
import cimab.openaq.repository.etiquetado.CilindradaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoriaService {
    private CategoriaRepository vr;

    @Autowired
    public void setVr(CategoriaRepository vr) {
        this.vr = vr;
    }

    public List<Categoria> listCategoria(int idclasevehiculo) {
        return vr.listCategoria(idclasevehiculo);
    }
}

package cimab.openaq.service.rmcab;

import cimab.openaq.entity.rmcab.Modulousuario;
import cimab.openaq.repository.rmcab.ModulousuarioRepository;
import cimab.openaq.repository.ruido.PqrsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ModulousuarioService {
    private ModulousuarioRepository mur;

    @Autowired
    public void setMur(ModulousuarioRepository mur) {
        this.mur = mur;
    }

    public List<Modulousuario> cargaModulos(String usuario) {
        return mur.listModuloUsu(usuario);
    }
}

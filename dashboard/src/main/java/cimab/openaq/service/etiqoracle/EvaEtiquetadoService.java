package cimab.openaq.service.etiqoracle;

import cimab.openaq.entity.etiqoracle.EvaEtiquetado;
import cimab.openaq.repository.etiqoracle.EvaEtiquetadoRepository;
import cimab.openaq.repository.etiqoracle.EvaRecursosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EvaEtiquetadoService {
    private EvaEtiquetadoRepository vr;

    @Autowired
    public void setVr(EvaEtiquetadoRepository vr) {
        this.vr = vr;
    }

    public void cargaDataDeEVA(List<EvaEtiquetado> listEvaEtiquetado) {

        for (EvaEtiquetado evaEtie : listEvaEtiquetado) {
            System.out.println(" evaEtiquetado " + evaEtie);
            vr.save(evaEtie);
        }
    }


}

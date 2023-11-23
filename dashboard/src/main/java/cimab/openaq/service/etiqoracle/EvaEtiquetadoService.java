package cimab.openaq.service.etiqoracle;

import cimab.openaq.entity.etiqoracle.EvaEtiquetado;
import cimab.openaq.entity.etiqoracle.Informacionvehiculo;
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

            vr.save(evaEtie);
        }
    }

    public List<EvaEtiquetado> listEvaEtiquetado() {

        List<EvaEtiquetado> listEvatEtique = vr.listInformacionvehiculoTpVehicular();
        for (EvaEtiquetado evaEtiquetado :  listEvatEtique ) {
            String clase = evaEtiquetado.getClase();
            if (clase.length() > 10) {
                clase = clase.substring(0,9);
                evaEtiquetado.setClase(clase);
            }

        }

        return listEvatEtique;
    }

    public List<EvaEtiquetado> listEvaEtiquetado(Informacionvehiculo informacionvehiculo) {

        String tipologiaVehicular = informacionvehiculo.getTipologiaVehicular();

        List<EvaEtiquetado> listEvatEtique = vr.listInformacionvehiculoTpVehicular(tipologiaVehicular);
        for (EvaEtiquetado evaEtiquetado :  listEvatEtique ) {
            String clase = evaEtiquetado.getClase();
            if (clase.length() > 10) {
                clase = clase.substring(0,9);
                evaEtiquetado.setClase(clase);
            }

        }

        return listEvatEtique;
    }
}

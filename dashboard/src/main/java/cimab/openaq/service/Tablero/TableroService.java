package cimab.openaq.service.Tablero;

import cimab.openaq.entity.rmcab.Variableambiental;
import cimab.openaq.repository.rmcab.TableroRepository;
import cimab.openaq.util.UtilTablero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cimab.openaq.model.Constantes;

import java.util.List;

@Service
public class TableroService {

    private TableroRepository tr;

    @Autowired
    public void setTr(TableroRepository tr) {
        this.tr = tr;
    }

    public List<String> listaVariables() {
        return tr.listaVariables();
    }

    public List<String> listaEstaciones() {
        return tr.listaEstaciones();
    }


    public List<Variableambiental> listaDatosVarAmbiental(String variable, String estacion, String fechaInicial, String fechaFinal, String estadistico) {



        if (estadistico.equals(Constantes.ACUMULADO_DIARIO)) {
            List <Object[]> listObject = tr.listaDatosVarAmbientalAcumulado( variable, estacion,  fechaInicial,  fechaFinal);
            UtilTablero ut = new UtilTablero();
            return ut.cargaDatos(listObject);
        }

        if (estadistico.equals(Constantes.PROMEDIO_DIARIO )) {
            List <Object[]> listObject = tr.listaDatosVarAmbientalPromedio( variable, estacion,  fechaInicial,  fechaFinal);
            UtilTablero ut = new UtilTablero();
            return ut.cargaDatos(listObject);
        }

        return tr.listaDatosVarAmbiental( variable, estacion,  fechaInicial,  fechaFinal);


    }

}

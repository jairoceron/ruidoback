package cimab.openaq.service.ruido;

import cimab.openaq.dto.ruido.ChartLocalidad;
import cimab.openaq.entity.ruido.RuiLocalidad;
import cimab.openaq.entity.ruido.RuiSector;
import cimab.openaq.model.ConsultaVisita;
import cimab.openaq.repository.rmcab.MenuRepository;
import cimab.openaq.repository.ruido.RuiLocalidadRepository;
import cimab.openaq.repository.ruido.VisitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
@Service
public class RuiLocalidadService {
    private RuiLocalidadRepository lr;

    @Autowired
    public void setLr(RuiLocalidadRepository lr) {
        this.lr = lr;
    }

    public List<RuiLocalidad> consultaLocalidad() {
        return lr.listLocalidad();
    }

    public List<ChartLocalidad> chartLocalidad(ConsultaVisita consultaVisita) {
        List<ChartLocalidad> listCharLocalidad = new ArrayList<>();
        List<Object[]> listObjLocalidad = lr.chartLocalidad(consultaVisita.getFechaInicial(), consultaVisita.getFechaFinal());
        for (Object[] objX : listObjLocalidad ) {
            ChartLocalidad chartLocalidad = new ChartLocalidad();
            String localidad = (String)objX[0];
            BigInteger valor = (BigInteger)objX[1];
            chartLocalidad.setName(localidad);
            chartLocalidad.setValue(valor.intValue());
            listCharLocalidad.add(chartLocalidad);
        }

        return listCharLocalidad;
    }

    public List<ChartLocalidad> chartNormatividad(ConsultaVisita consultaVisita) {
        List<ChartLocalidad> listCharNormatividad = new ArrayList<>();
        List<Object[]> listObjNormatividad = lr.chartNormatividad(consultaVisita.getFechaInicial(),
                consultaVisita.getFechaFinal(), Integer.valueOf(consultaVisita.getLocalidad())
                ,consultaVisita.getTipoPredio());
        for (Object[] objX : listObjNormatividad ) {
            ChartLocalidad chartLocalidad = new ChartLocalidad();
            String localidad = (String)objX[0];
            BigInteger valor = (BigInteger)objX[1];
            chartLocalidad.setName(localidad);
            chartLocalidad.setValue(valor.intValue());
            listCharNormatividad.add(chartLocalidad);
        }

        return listCharNormatividad;
    }


}

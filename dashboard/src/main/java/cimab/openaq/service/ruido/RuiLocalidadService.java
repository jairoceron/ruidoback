package cimab.openaq.service.ruido;

import cimab.openaq.dto.ruido.ChartLocalidad;
import cimab.openaq.entity.ruido.RuiLocalidad;
import cimab.openaq.entity.ruido.RuiSector;
import cimab.openaq.entity.ruido.RuidoLocalidad;
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

    public List<RuidoLocalidad> listRuidoLocalidad = new ArrayList<>();

    @Autowired
    public void setLr(RuiLocalidadRepository lr) {
        this.lr = lr;
    }

    public List<RuiLocalidad> consultaLocalidad() {
        return lr.listLocalidad();

    }

    public List<RuidoLocalidad> consultaRuidoLocalidad() {
        listRuidoLocalidad = new ArrayList<>();
        RuidoLocalidad rLocalidad = new RuidoLocalidad();

        rLocalidad.setValue("ANTONIO NARIÑO");
        rLocalidad.setViewValue("ANTONIO NARIÑO");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("BARRIOS UNIDOS");
        rLocalidad.setViewValue("BARRIOS UNIDOS");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("BOSA");
        rLocalidad.setViewValue("BOSA");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("CHAPINERO");
        rLocalidad.setViewValue("CHAPINERO");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("CIUDAD BOLIVAR");
        rLocalidad.setViewValue("CIUDAD BOLIVAR");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("ENGATIVA");
        rLocalidad.setViewValue("ENGATIVA");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("FONTIBON");
        rLocalidad.setViewValue("FONTIBON");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("KENNEDY");
        rLocalidad.setViewValue("KENNEDY");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("LA CANDELARIA");
        rLocalidad.setViewValue("LA CANDELARIA");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("LOS MARTIRES");
        rLocalidad.setViewValue("LOS MARTIRES");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("NO REPORTA / NO APLICA");
        rLocalidad.setViewValue("NO REPORTA / NO APLICA");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("PUENTE ARANDA");
        rLocalidad.setViewValue("PUENTE ARANDA");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("RAFAEL URIBE URIBE");
        rLocalidad.setViewValue("RAFAEL URIBE URIBE");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("SAN CRISTOBAL");
        rLocalidad.setViewValue("SAN CRISTOBAL");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("SANTA FE");
        rLocalidad.setViewValue("SANTA FE");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("SUBA");
        rLocalidad.setViewValue("SUBA");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("SUMAPAZ");
        rLocalidad.setViewValue("SUMAPAZ");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("TEUSAQUILLO");
        rLocalidad.setViewValue("TEUSAQUILLO");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("TUNJUELITO");
        rLocalidad.setViewValue("TUNJUELITO");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("USAQUEN");
        rLocalidad.setViewValue("USAQUEN");
        listRuidoLocalidad.add(rLocalidad);


        rLocalidad = new RuidoLocalidad();
        rLocalidad.setValue("USME");
        rLocalidad.setViewValue("USME");
        listRuidoLocalidad.add(rLocalidad);

        return listRuidoLocalidad;


    }

    public List<ChartLocalidad> chartLocalidad(ConsultaVisita consultaVisita) {
        /*
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

         */
        return null;
    }

    public List<ChartLocalidad> chartNormatividad(ConsultaVisita consultaVisita) {
        /*
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

         */
        return null;
    }


}

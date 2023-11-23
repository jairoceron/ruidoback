package cimab.openaq.service.sbc;

import cimab.openaq.entity.sbc.Sensoresvariable;
import cimab.openaq.entity.sbc.dto.SensorVariableDTO;
import cimab.openaq.repository.sbc.SensoresestacionRepository;
import cimab.openaq.repository.sbc.SensoresvariableRepository;
import cimab.openaq.util.Microsensores;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static cimab.openaq.model.Constantes.*;

@Service
public class SensoresvariableService {
    private SensoresvariableRepository cs;
    private SensoresestacionRepository se;

    @Autowired
    public void setCs(SensoresvariableRepository cs) {
        this.cs = cs;
    }


    public void calidadMicrosensor() {

        // List<Sensoresvariable> limiteSuperiorPM10(int limSuperior)
        // List<Sensoresvariable> lisSensores = cs.limiteSuperiorPM10(LIM_SUP_PM_1_PROMEDIO_DIARIO);

      /*
        cs.actualizarCalidadPm1(LIM_SUP_PM_1_PROMEDIO_DIARIO);
        cs.actualizarCalidadPm25(LIM_SUP_PM2_5_PROMEDIO_DIARIO);
        cs.actualizarCalidadPm10(LIM_SUP_PM10_PROMEDIO_DIARIO);

        cs.actualizarCalidadValorNegativoPm1(LIM_SUP_PM_1_PROMEDIO_DIARIO);
        cs.actualizarCalidadValorNegativoPm25(LIM_SUP_PM2_5_PROMEDIO_DIARIO);
        cs.actualizarCalidadValorNegativoPm10(LIM_SUP_PM10_PROMEDIO_DIARIO);
*/


//List<Sensoresvariable>  consultaGrupoConsecutivosMismaData() ;


        String myTime = "2023-08-03T20:15:49";
        LocalDateTime ldt = LocalDateTime.parse(myTime);
        Timestamp initialTime = Timestamp.valueOf(ldt);



        java.util.Date date = new java.util.Date();
        Timestamp fechafinal =new Timestamp(date.getTime());

        List<Sensoresvariable> listSenVar = cs.consultaGrupoConsecutivosMismaData(initialTime, fechafinal);

        Sensoresvariable senVariableAnt = new Sensoresvariable();
        SensorVariableDTO svaDtoAnt  = new SensorVariableDTO();
        ArrayList<SensorVariableDTO> listArrSenVari = new ArrayList<>();
        for (Sensoresvariable senVariable : listSenVar) {
            Microsensores m = new Microsensores();
            SensorVariableDTO svaDto = m.convertirSensorVariableDTO(senVariable);

            if (svaDtoAnt.equals(svaDto)) {

                listArrSenVari.add(svaDto);
                if (listArrSenVari.size() >= NUM_DATOS_CONSECUTIVOS_MICROSENSORES) {

                }
            } else {
                listArrSenVari = new ArrayList<>();
            }
            svaDtoAnt = svaDto;
        }


    }


}

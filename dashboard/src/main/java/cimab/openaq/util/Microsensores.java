package cimab.openaq.util;

import cimab.openaq.entity.sbc.Sensoresvariable;
import cimab.openaq.entity.sbc.dto.SensorVariableDTO;

public class Microsensores {

    public SensorVariableDTO convertirSensorVariableDTO(Sensoresvariable svariable) {
        SensorVariableDTO sVarDTO = new SensorVariableDTO();
        sVarDTO.setMedicionfecha(svariable.getMedicionfecha());
        sVarDTO.setSensorcodigo(svariable.getSensorcodigo());
        sVarDTO.setSensormarca(svariable.getSensormarca());
        sVarDTO.setHumedad(svariable.getHumedad());
        sVarDTO.setTemperatura(svariable.getTemperatura());
        sVarDTO.setPm1(svariable.getPm1());
        sVarDTO.setPm10(svariable.getPm10());
        sVarDTO.setPm25(svariable.getPm25());
        return sVarDTO;
    }
}

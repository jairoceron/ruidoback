package cimab.openaq.entity.etiqoracle.dto;

import cimab.openaq.entity.etiqoracle.Informacionvehiculo;
import cimab.openaq.entity.etiqoracle.Propietariovehiculo;
import lombok.Data;

@Data
public class Placa {
    String placa;
    Informacionvehiculo informacionvehiculo;
    Propietariovehiculo propietariovehiculo;
}

package cimab.openaq.service.etiqoracle.util;

import cimab.openaq.entity.etiqoracle.Informacionvehiculo;
import cimab.openaq.entity.etiqoracle.Propietariovehiculo;

public class UtilInfoVehiculo {
    public void normalizarInfoVehiculo(Informacionvehiculo informacionVehiculo) {
        // se pasa el dato por referencia entonces no hay necesidad de hacer actualizaciones del objeto adicionales.
        informacionVehiculo.setPlaca(informacionVehiculo.getPlaca().toUpperCase());
    }
}

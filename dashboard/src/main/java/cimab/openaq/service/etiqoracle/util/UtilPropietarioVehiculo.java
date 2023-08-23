package cimab.openaq.service.etiqoracle.util;

import cimab.openaq.entity.etiqoracle.Propietariovehiculo;

import java.math.BigInteger;

public class UtilPropietarioVehiculo {

        public Propietariovehiculo normalizarPropVehiculo(Propietariovehiculo propietarioVehiculo) {

            propietarioVehiculo.setPlaca(propietarioVehiculo.getPlaca().toUpperCase());
            propietarioVehiculo.setNombre1(propietarioVehiculo.getNombre1().toUpperCase());
            propietarioVehiculo.setNombre2(propietarioVehiculo.getNombre2().toUpperCase());
            propietarioVehiculo.setApellido1(propietarioVehiculo.getApellido1().toUpperCase());
            propietarioVehiculo.setApellido2(propietarioVehiculo.getApellido2().toUpperCase());
            return propietarioVehiculo;
        }
}

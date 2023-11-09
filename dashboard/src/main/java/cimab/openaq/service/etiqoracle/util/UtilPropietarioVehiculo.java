package cimab.openaq.service.etiqoracle.util;

import cimab.openaq.entity.etiqoracle.Propietariovehiculo;

import java.math.BigInteger;

public class UtilPropietarioVehiculo {

        public Propietariovehiculo normalizarPropVehiculo(Propietariovehiculo propietarioVehiculo) {

            propietarioVehiculo.setPlaca(propietarioVehiculo.getPlaca().toUpperCase());

            if (propietarioVehiculo.getNombre1() != null) {
                propietarioVehiculo.setNombre1(propietarioVehiculo.getNombre1().toUpperCase());
            }


            if (propietarioVehiculo.getNombre2() != null) {
                propietarioVehiculo.setNombre2(propietarioVehiculo.getNombre2().toUpperCase());
            }

            if (propietarioVehiculo.getApellido1() != null) {
                propietarioVehiculo.setApellido1(propietarioVehiculo.getApellido1().toUpperCase());
            }

            if (propietarioVehiculo.getApellido2() != null) {
                propietarioVehiculo.setApellido2(propietarioVehiculo.getApellido2().toUpperCase());
            }
            return propietarioVehiculo;
        }
}

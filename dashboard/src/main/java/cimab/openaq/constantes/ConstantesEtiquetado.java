package cimab.openaq.constantes;

import cimab.openaq.entity.etiqoracle.Informacionvehiculo;

public  class ConstantesEtiquetado {


    public static Informacionvehiculo informacionvehiculoDefault(String placa) {
        Informacionvehiculo informacionVehiculo ;
        informacionVehiculo = new Informacionvehiculo();
        informacionVehiculo.setPlaca(placa);
        informacionVehiculo.setClaseVehiculo("Automovil");
        return informacionVehiculo;
    }
}

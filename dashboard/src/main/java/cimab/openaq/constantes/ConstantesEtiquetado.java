package cimab.openaq.constantes;

import cimab.openaq.entity.etiqoracle.Informacionvehiculo;

public  class ConstantesEtiquetado {

    public static String QRHOLOGRAMAETIQUETA = "QRHOLOGRAMAETIQUETA";
    public static String REPORTEGENETIQUETAD = "REPORTEGENETIQUETAD";
    public static String PACKG_REPO_SARA   = "cimab.openaq.repository.etiqoracle";
    public static String PACKG_ENTITY_SARA = "cimab.openaq.entity.etiqoracle";
    public static String PACKG_SERVICE_SARA= "cimab.openaq.service.etiqoracle";

    // Constantes.PACKG_REPO_SARA
    // Constantes.PACKG_ENTITY_SARA

    public static Informacionvehiculo informacionvehiculoDefault(String placa) {
        Informacionvehiculo informacionVehiculo ;
        informacionVehiculo = new Informacionvehiculo();
        informacionVehiculo.setPlaca(placa);
        informacionVehiculo.setClaseVehiculo("Automovil");
        return informacionVehiculo;
    }
}

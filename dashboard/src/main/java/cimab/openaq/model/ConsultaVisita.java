package cimab.openaq.model;

import lombok.Data;

import java.sql.Date;
import java.sql.Timestamp;

@Data
public class ConsultaVisita {
    /*
    * Clase que contiene los parámetros de la consulta.
    *
    * */

    Timestamp fechaInicial;
    Timestamp fechaFinal;
    String radicado;
    String direccion;
    String vistaSistema;    // la vista del sistema puede ser: "PQRS por Localidad" -- "Estado Del Trámite"  -- "Provisionales"
    String localidad;

    String tipoPredio;
    Boolean isCbCVencido;
    Boolean isCbCPxVenci;
    Boolean isCbCPxSinVe;
    String peticionario;

    String estadoTramite;
    String observacionEstadoTramite;


}

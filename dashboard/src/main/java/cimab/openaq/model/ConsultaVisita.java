package cimab.openaq.model;

import lombok.Data;

import java.sql.Date;

@Data
public class ConsultaVisita {
    /*
    * Clase que contiene los parámetros de la consulta.
    *
    * */

    Date fechaInicial;
    Date fechaFinal;
    String radicado;
    String direccion;
    String vistaSistema;    // la vista del sistema puede ser: "PQRS por Localidad" -- "Estado Del Trámite"  -- "Provisionales"
}

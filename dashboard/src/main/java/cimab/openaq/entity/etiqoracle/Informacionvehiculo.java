package cimab.openaq.entity.etiqoracle;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.Date;
import java.sql.Timestamp;

@Data
@NoArgsConstructor
@Entity
@NamedQuery(name = "Informacionvehiculo.findAll", query = "SELECT c FROM Informacionvehiculo c")
@Table(name = "eva_infovehic")
public class Informacionvehiculo {
    @Id
    @Column(name = "idevainfovehic")
    BigInteger idevainfovehic;

    @Column(name = "placa")
    String placa;

    @Column(name = "tipologiaVehicular")
    String tipologiaVehicular;

    @Column(name = "tipoServicio")
    String tipoServicio;

    @Column(name = "tipoCombustible")
    String tipoCombustible;

    @Column(name = "cilindraje")
    String cilindraje;

    @Column(name = "marca")
    String marca;

    @Column(name = "linea")
    String linea;

    @Column(name = "modelo")
    String modelo;

    @Column(name = "fechaImportacion")
    Date fechaImportacion;

    @Column(name = "capacidadCarga")
    String capacidadCarga;

    @Column(name = "capacidadPasajeros")
    String capacidadPasajeros;

    @Column(name = "claseVehiculo")
    String claseVehiculo;

    @Column(name = "numeroMotor")
    String numeroMotor;

    @Column(name = "vin")
    String vin;

    @Column(name = "ciudadMatricula")
    String ciudadMatricula;

    @Column(name = "vigenciaRTM")
    String vigenciaRTM;

    @Column(name = "tecnRedEmision")
    String tecnRedEmision;

    @Column(name = "estEmisiVehic")
    String estEmisiVehic;

    @Column(name = "subContEmision")
    String subContEmision;

    // https://docs.google.com/document/d/1uQ8F_9QMYL_y-4wru0hzFZit_BJ4dAV-/edit

    @Column(name = "DETERMIN_FAV")
    String determin_FAV;

    @Column(name = "ASOC_FAV_COLOR")
    String asoc_FAV_COLOR;

    @Column(name = "DENSIDAD_HUMO")
    BigDecimal densidad_HUMO;

    @Column(name = "CUM_LIM_D_HUMO")
    String cum_LIM_D_HUMO;

    @Column(name = "CON_MAT_PARTIC")
    BigDecimal con_MAT_PARTIC;

    @Column(name = "CON_NUM_PARTIC")
    BigDecimal con_NUM_PARTIC;

    @Column(name = "COLOR_ETIQUETA")
    String color_ETIQUETA;

    @Column(name = "FECHA_ETIQUETA")
    Timestamp fecha_ETIQUETA;


    @Column(name = "FECHA_VIG_FIN_ETIQUETA")
    Timestamp fecha_VIG_FIN_ETIQUETA;
/*

*/

}

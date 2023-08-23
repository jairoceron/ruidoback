package cimab.openaq.entity.etiqoracle;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Date;

@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="Informacionvehiculo.findAll", query="SELECT c FROM Informacionvehiculo c")
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


}

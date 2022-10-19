package cimab.openaq.entity.rmcab;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Timestamp;

public class Variableambiental_rmcab {
    @Id
    @Column(name="id")
    private Integer id;

    @Column(name="variable")
    private String variable;

    @Column(name="codigoestacion")
    private Integer codigoestacion;

    @Column(name="latitud")
    private Float latitud;

    @Column(name="longitud")
    private Float longitud;

    @Column(name="nombreestacion")
    private String nombreestacion;

    @Column(name="fechaobservacion")
    private Timestamp fechaobservacion;

    @Column(name="mesobservacion")
    private Integer mesobservacion;

    @Column(name="diaobservacion")
    private Integer diaobservacion;

    @Column(name="anioobservacion")
    private Integer anioobservacion;

    @Column(name="departamento")
    private String departamento;

    @Column(name="municipio")
    private String municipio;

    @Column(name="valorobservado")
    private Float valorobservado;

    @Column(name="fuenteinformacion")
    private String fuenteinformacion;

    // variable varchar(200) NOT NULL,
    // codigoestacion int4 NULL,
    // latitud float8 NULL,
    // longitud float8 NULL,
    // nombreestacion varchar(230) NULL,
    // fechaobservacion timestamp NULL,
    // mesobservacion int4 NULL,
    // diaobservacion int4 NULL,
    // anioobservacion int4 NULL,
    // departamento varchar(230) NULL,
    // municipio varchar(230) NULL,
    // valorobservado float8 NULL,
    // fuenteinformacion varchar(250) NULL
}

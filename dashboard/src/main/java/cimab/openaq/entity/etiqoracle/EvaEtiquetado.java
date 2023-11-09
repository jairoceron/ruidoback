package cimab.openaq.entity.etiqoracle;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;

@Data
@NoArgsConstructor
@IdClass(EvaEtiquetadoPK.class)
@Entity
@NamedQuery(name="EvaEtiquetado.findAll", query="SELECT c FROM EvaEtiquetado c")
@Table(name = "EVA_ETIQUETADO")
public class EvaEtiquetado {

    @Id
    @Column(name = "CLASEPAPA")
    String clasepapa;  //  VARCHAR(160),

    @Id
    @Column(name = "CLASE")
    String clase;  //  VARCHAR(160),

    @Id
    @Column(name = "COMBUSTIBLE")
    String combustible;  // 	 VARCHAR(160),

    @Id
    @Column(name = "MODELO")
    String modelo;  // 	 VARCHAR(160),

    @Id
    @Column(name = "ESTANDAREMISION")
    String estandaremision;  // 	 VARCHAR(160),

    @Id
    @Column(name = "CILINDRADA")
    String cilindrada;  // 	 VARCHAR(160),

    @Id
    @Column(name = "INDICEETIQUETADO")
    Integer indiceetiquetado;  //  NUMBER(6),

    @Column(name = "FE_CO")
    BigDecimal fe_co;  //  NUMBER(10,4),

    @Column(name = "FE_THC")
    BigDecimal fe_thc;  // 	NUMBER(10,4),

    @Column(name = "FE_NOx")
    BigDecimal fe_nox;  //  NUMBER(10,4),

    @Column(name = "FE_PM")
    BigDecimal fe_pm;  //  NUMBER(10,4),

    @Column(name = "FE_CO2")
    BigDecimal fe_co2;  //  NUMBER(10,4),

    @Column(name = "FE_CH4")
    BigDecimal fe_ch4;  //  NUMBER(10,4),

    @Column(name = "FE_CO2eq")
    BigDecimal fe_co2eq;  //  NUMBER(10,4),

    @Column(name = "PN")
    BigDecimal pn;  //  NUMBER(10,4),

    @Column(name = "PM_LLSP")
    BigDecimal pm_llsp;  //  NUMBER(10,4),

    @Column(name = "OPA")
    BigDecimal opa;  //  NUMBER(10,4),

    @Column(name = "FAV")
    BigDecimal fav;  //  NUMBER(10,4),

    @Column(name = "ETIQUETADO")
    String etiquetado;  // VARCHAR(160)
}

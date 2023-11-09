package cimab.openaq.entity.etiqoracle;

import org.hibernate.annotations.GenericGenerator;
import java.math.BigInteger;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;
@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="PqrsOracle.findAll", query="SELECT c FROM PqrsOracle c")
@Table(name = "pqrs")

public class PqrsOracle{

    @Id
    @Column(name = "OBJECTID")
    BigInteger  OBJECTID;

    @Column(name = "COMPLEMENTO_DIRECCION")
    String  COMPLEMENTO_DIRECCION;

    @Column(name = "LOCALIDAD")
    String  LOCALIDAD;

    @Column(name = "SHAPE")
    String  SHAPE;

    @Column(name = "RADICADO")
    String  RADICADO;

    @Column(name = "FECHA_RADICADO")
    String  FECHA_RADICADO;

    @Column(name = "ASUNTO_RADICACION")
    String  ASUNTO_RADICACION;

    @Column(name = "RAZON_SOCIAL_ESTABLECIMIENTO")
    String  RAZON_SOCIAL_ESTABLECIMIENTO;

    @Column(name = "SECTOR_REPORTADO")
    String  SECTOR_REPORTADO;

    @Column(name = "ENTIDAD_DE_CONTROL")
    String  ENTIDAD_DE_CONTROL;

    @Column(name = "PETICIONARIO")
    String  PETICIONARIO;

    @Column(name = "ESTADO_TRAMITE")
    BigInteger  ESTADO_TRAMITE;

    @Column(name = "OBSERVACIONES_ESTADO_TRAMITE")
    String  OBSERVACIONES_ESTADO_TRAMITE;

    @Column(name = "OBSERVACIONES_GENERALES")
    String  OBSERVACIONES_GENERALES;

    @Column(name = "PROFESIONAL_1RA_ASIGNACION")
    String  PROFESIONAL_1RA_ASIGNACION;

    @Column(name = "FECHA_1RA_ASIGNACION")
    String  FECHA_1RA_ASIGNACION;

    @Column(name = "PROFESIONAL_2DA_ASIGNACION")
    String  PROFESIONAL_2DA_ASIGNACION;

    @Column(name = "FECHA_2DA_ASIGNACION")
    String  FECHA_2DA_ASIGNACION;

    @Column(name = "PROFESIONAL_DILIGENCIA")
    String  PROFESIONAL_DILIGENCIA;

    @Column(name = "X")
    BigInteger  X;

    @Column(name = "Y")
    BigInteger  Y;

    @Column(name = "DIRECCION")
    String  DIRECCION;

} 

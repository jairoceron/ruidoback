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
//@Data
//@NoArgsConstructor
//@Entity
//@NamedQuery(name="Gdmptlb.findAll", query="SELECT c FROM Gdmptlb c")
//@Table(name = "GDMPTLB")

public class Gdmptlb{

   // @Column(name = "COMPLEMENTO_DIRECCION")
    String  COMPLEMENTO_DIRECCION;

   // @Column(name = "LOCALIDAD")
    String  LOCALIDAD;

  //  @Column(name = "SHAPE")
    String  SHAPE;

  //  @Column(name = "SYS_NC00023$")
    String  SYS_NC00023$;

  //  @Column(name = "SYS_NC00024$")
    BigInteger  SYS_NC00024$;

  //  @Column(name = "SYS_NC00025$")
    BigInteger  SYS_NC00025$;

 //   @Column(name = "SYS_NC00026$")
    String  SYS_NC00026$;

  //  @Column(name = "SYS_NC00027$")
    String  SYS_NC00027$;

  //  @Column(name = "SYS_NC00028$")
    String  SYS_NC00028$;

  //  @Column(name = "SYS_NC00029$")
    String  SYS_NC00029$;

  //  @Column(name = "SYS_NC00030$")
    String  SYS_NC00030$;

 //   @Column(name = "SYS_NC00031$")
    String  SYS_NC00031$;

 //   @Column(name = "SYS_NC00032$")
    String  SYS_NC00032$;

  //  @Column(name = "SYS_NC00033$")
    String  SYS_NC00033$;

 //   @Column(name = "SYS_NC00034$")
    String  SYS_NC00034$;

  //  @Column(name = "SYS_NC00035$")
    String  SYS_NC00035$;

  //  @Column(name = "SYS_NC00036$")
    BigInteger  SYS_NC00036$;

//    @Column(name = "SYS_NC00037$")
    String  SYS_NC00037$;

//    @Column(name = "OBJECTID")
    BigInteger  OBJECTID;

  //  @Column(name = "RADICADO")
    String  RADICADO;

 //   @Column(name = "FECHA_RADICADO")
    String  FECHA_RADICADO;

//    @Column(name = "ASUNTO_RADICACION")
    String  ASUNTO_RADICACION;

 //   @Column(name = "RAZON_SOCIAL_ESTABLECIMIENTO")
    String  RAZON_SOCIAL_ESTABLECIMIENTO;

//    @Column(name = "SECTOR_REPORTADO")
    String  SECTOR_REPORTADO;

 ///   @Column(name = "ENTIDAD_DE_CONTROL")
    String  ENTIDAD_DE_CONTROL;

 //   @Column(name = "PETICIONARIO")
    String  PETICIONARIO;

 //   @Column(name = "ESTADO_TRAMITE")
    BigInteger  ESTADO_TRAMITE;

  //  @Column(name = "OBSERVACIONES_ESTADO_TRAMITE")
    String  OBSERVACIONES_ESTADO_TRAMITE;

  //  @Column(name = "OBSERVACIONES_GENERALES")
    String  OBSERVACIONES_GENERALES;

 //   @Column(name = "PROFESIONAL_1RA_ASIGNACION")
    String  PROFESIONAL_1RA_ASIGNACION;

 //   @Column(name = "FECHA_1RA_ASIGNACION")
    String  FECHA_1RA_ASIGNACION;

  //  @Column(name = "PROFESIONAL_2DA_ASIGNACION")
    String  PROFESIONAL_2DA_ASIGNACION;

  //  @Column(name = "FECHA_2DA_ASIGNACION")
    String  FECHA_2DA_ASIGNACION;

  //  @Column(name = "PROFESIONAL_DILIGENCIA")
    String  PROFESIONAL_DILIGENCIA;

  //  @Column(name = "X")
    BigInteger  X;

   // @Column(name = "Y")
    BigInteger  Y;

 //   @Column(name = "DIRECCION")
    String  DIRECCION;

} 

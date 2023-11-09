package cimab.openaq.entity.etiqoracle;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="Propietariovehiculo.findAll", query="SELECT c FROM Propietariovehiculo c")
@Table(name = "eva_propvehi")
public class Propietariovehiculo {

    @Id
    @Column(name = "idevapropvehi")
    BigInteger idevapropvehi;

    @Column(name = "nombre1")
    String nombre1;

    @Column(name = "nombre2")
    String nombre2;

    @Column(name = "apellido1")
    String apellido1;

    @Column(name = "apellido2")
    String apellido2;

    @Column(name = "placa")
    String placa;

    @Column(name = "identificacion")
    String identificacion;

    @Column(name = "tipoidentifica")
    BigInteger tipoidentifica;

    @Column(name = "email")
    String email;

    @Column(name = "telefono")
    String telefono;
}

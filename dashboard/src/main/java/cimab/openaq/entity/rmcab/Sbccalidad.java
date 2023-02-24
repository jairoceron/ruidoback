package cimab.openaq.entity.rmcab;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="Sbccalidad.findAll", query="SELECT c FROM Sbccalidad c")
@Table(name="SBCCALIDAD")
public class Sbccalidad {

    @Id
    @Column(name="idsbccalidad")
    Integer idsbccalidad;

    @Column(name="variable")
    String variable;

    @Column(name="valormaximo")
    Float valormaximo;

    @Column(name="valorminimo")
    Float valorminimo;


}
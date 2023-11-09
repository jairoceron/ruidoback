package cimab.openaq.entity.etiqoracle;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;


@Data
@NoArgsConstructor
@Entity
@IdClass(EvaRecursosKey.class)

@NamedQuery(name="EvaRecursos.findAll", query="SELECT c FROM EvaRecursos c")
@Table(name = "EVA_RESOURCES")
public class EvaRecursos {

    @Id
    @Column(name = "clave")
    String clave;

    @Id
    @Column(name = "sistemaoperativo")
    String sistemaoperativo;

    @Column(name = "valor")
    String valor;

    @Column(name = "fecha")
    Timestamp fecha;
}

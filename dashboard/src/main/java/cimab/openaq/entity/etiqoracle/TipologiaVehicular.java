package cimab.openaq.entity.etiqoracle;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="TipologiaVehicular.findAll", query="SELECT c FROM TipologiaVehicular c")
@Table(name = "TipologiaVehicular")
public class TipologiaVehicular {
    @Id
    @Column(name = "idtipologiavehicular")
    Integer idtipologiavehicular;

    @Column(name = "nombre")
    String nombre;

}

package mintrabajo.dashboard.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@Entity
public class Valor {

    @Id
    @Column(name="VALOR_PK")
    private Integer VALOR_PK;

    @Column(name="VALOR_ESTADO")
    private String VALOR_ESTADO;

    @Column(name="VALOR_NOMBRE")
    private String VALOR_NOMBRE;

}

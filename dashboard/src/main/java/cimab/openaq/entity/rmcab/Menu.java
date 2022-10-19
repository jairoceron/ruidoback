package cimab.openaq.entity.rmcab;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import java.io.Serializable;

/**
 * The persistent class for the calificacion database table.
 *
 */
@Data
@NoArgsConstructor
@Entity
@NamedQuery(name="Menu.findAll", query="SELECT c FROM Menu c")
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;

    @GenericGenerator(
            name = "Menu",
            strategy = "org.hibernate.id.enhanced.SequenceStyleGenerator",
            parameters = {
                    @org.hibernate.annotations.Parameter(name = "sequence_name", value = "menu_idmenu_seq"),
                    @org.hibernate.annotations.Parameter(name = "initial_value", value = "1"),
                    @org.hibernate.annotations.Parameter(name = "increment_size", value = "1")}
    )

    @Id
    @Column(name = "idmenu")
    private String idmenu;

    @Column(name = "modulo")
    private String modulo;

    @Column(name = "perfil")
    private String perfil;

    @Column(name = "indice")
    private String indice;

}
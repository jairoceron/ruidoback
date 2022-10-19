package cimab.openaq.entity.rmcab;

import javax.persistence.Column;
import javax.persistence.Id;
import java.sql.Timestamp;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The persistent class for the calificacion database table.
 *
 */
@Data
@NoArgsConstructor
@Entity
@IdClass(ModuloUsuarioPK.class)
@NamedQuery(name="Modulousuario.findAll", query="SELECT c FROM Modulousuario c")
public class Modulousuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="usuario")
    private String usuario;

    @Id
    @Column(name="modulo")
    private String modulo;
}

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
@Embeddable
public class ModuloUsuarioPK implements Serializable {
    String usuario;
    String modulo;
}

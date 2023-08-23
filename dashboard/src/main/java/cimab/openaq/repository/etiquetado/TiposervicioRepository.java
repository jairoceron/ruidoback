package cimab.openaq.repository.etiquetado;

import cimab.openaq.entity.etiquetado.Tipocombustible;
import cimab.openaq.entity.etiquetado.Tiposervicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TiposervicioRepository  extends JpaRepository<Tiposervicio, Long> {

    @Query(value = "select * from sda_e_tiposervicio where idtiposerv = :idtiposerv ",
            nativeQuery = true)
    List<Tiposervicio> listTipoServicioById(int idtiposerv);

    @Query(value = "select * from sda_e_tiposervicio order by idtiposerv",
            nativeQuery = true)
    List<Tiposervicio> listTipoServicio();

}

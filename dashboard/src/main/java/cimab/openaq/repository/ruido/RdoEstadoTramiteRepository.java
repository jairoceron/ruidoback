package cimab.openaq.repository.ruido;

import cimab.openaq.entity.ruido.RdoEstadoTramite;
import cimab.openaq.entity.ruido.RdoProfesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdoEstadoTramiteRepository  extends JpaRepository<RdoEstadoTramite, Integer> {

    @Query(value = "select * from sde.rdo_estado_tramite order by nombre ",
            nativeQuery = true)
    List<RdoEstadoTramite> listEstadoTramitePqr();

}
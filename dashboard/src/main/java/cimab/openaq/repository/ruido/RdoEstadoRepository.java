package cimab.openaq.repository.ruido;

import cimab.openaq.entity.ruido.RdoEstado;
import cimab.openaq.entity.ruido.RuiLocalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdoEstadoRepository extends JpaRepository<RdoEstado, Integer> {

    @Query(value = "select * from sde.rdo_estado order by nombre ",
            nativeQuery = true)
    List<RdoEstado> listEstado();

}
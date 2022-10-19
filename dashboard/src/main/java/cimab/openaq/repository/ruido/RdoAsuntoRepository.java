package cimab.openaq.repository.ruido;

import cimab.openaq.entity.ruido.RdoAsunto;
import cimab.openaq.entity.ruido.RuiLocalidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdoAsuntoRepository  extends JpaRepository<RdoAsunto, Integer> {

    @Query(value = "select * from sde.rdo_asunto order by nombre ",
            nativeQuery = true)
    List<RdoAsunto> listAsunto();

}
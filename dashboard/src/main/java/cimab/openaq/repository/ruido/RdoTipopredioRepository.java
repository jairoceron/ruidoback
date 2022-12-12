package cimab.openaq.repository.ruido;

import cimab.openaq.entity.ruido.RdoTipopredio;
import cimab.openaq.entity.ruido.RuiSector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdoTipopredioRepository extends JpaRepository<RdoTipopredio, Integer> {

    @Query(value = "select * from sde.rdo_tipopredio order by nombre ",
            nativeQuery = true)
    List<RdoTipopredio> listTipoPredio();

}

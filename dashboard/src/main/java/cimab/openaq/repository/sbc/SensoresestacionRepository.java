package cimab.openaq.repository.sbc;

import cimab.openaq.entity.sbc.Sensoresestacion;
import cimab.openaq.entity.sbc.Sensoresvariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SensoresestacionRepository extends JpaRepository<Sensoresestacion, Long> {

    @Query(value = "select * from sensores_estacion where longitud > 4.5 and longitud < 5.0 order by latitud, longitud ",
            nativeQuery = true)
    List<Sensoresestacion> consultaSesorBajoCosto();

}

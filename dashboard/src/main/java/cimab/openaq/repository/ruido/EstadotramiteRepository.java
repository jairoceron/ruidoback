package cimab.openaq.repository.ruido;

import cimab.openaq.entity.rmcab.Variableambiental;
import cimab.openaq.entity.ruido.Estadotramite;
import cimab.openaq.entity.ruido.Visitas;
import cimab.openaq.entity.sbc.Sensoresestacion;
import cimab.openaq.entity.sbc.Sensoresvariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface  EstadotramiteRepository extends JpaRepository<Estadotramite, Integer> {

    @Query(value = "select * from estadotramite ",
            nativeQuery = true)
    List<Estadotramite> listEstadoTramite();

}

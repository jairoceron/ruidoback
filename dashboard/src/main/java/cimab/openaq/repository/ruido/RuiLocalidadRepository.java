package cimab.openaq.repository.ruido;

import cimab.openaq.entity.ruido.RuiLocalidad;
import cimab.openaq.entity.ruido.RuiSector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuiLocalidadRepository extends JpaRepository<RuiLocalidad, Integer> {

    @Query(value = "select * from sde.rdo_localidad order by nombre ",
            nativeQuery = true)
    List<RuiLocalidad> listLocalidad();

}
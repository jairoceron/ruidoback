package cimab.openaq.repository.ruido;

import cimab.openaq.entity.ruido.RuiLocalidad;
import cimab.openaq.entity.ruido.RuiSector;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface RuiLocalidadRepository extends JpaRepository<RuiLocalidad, Integer> {

    @Query(value = "select * from sde.rdo_localidad order by nombre ",
            nativeQuery = true)
    List<RuiLocalidad> listLocalidad();

    @Query(value = "select  localidad, count(1) from sde.pqrs p  " +
            "where p.localidad in (select nombre from sde.rdo_localidad)  " +
            "and p.fecha_del_radicado between :fechaInicial and :fechaFinal " +
            "group by p.localidad order by count(1) desc  ",
            nativeQuery = true)
    List<Object[]> chartLocalidad(Date fechaInicial, Date fechaFinal);

}
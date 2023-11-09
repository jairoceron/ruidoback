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

    @Query(value = "select * from sde.localidades  ",
            nativeQuery = true)
    List<RuiLocalidad> listLocalidad();
   // **********

    @Query(value = "select  localidad, count(1) from sde.pqrs p  " +
            "where p.localidad in (select nombre from sde.rdo_localidad)  " +
            "and p.fecha_radicado between :fechaInicial and :fechaFinal " +
            "group by p.localidad order by count(1) desc  ",
            nativeQuery = true)
    List<Object[]> chartLocalidad(Date fechaInicial, Date fechaFinal);


    @Query(value = "select cumplimiento_normativo  , count(1) from sde.visitas p  " +
            "where p.localidad = (select nombre from sde.rdo_localidad l where l.idlocalidad = :localidad) " +
            "and tipo_predio_generador_emision  = :tipoPredio " +
            "and p.fecha_hora between :fechaInicial and :fechaFinal " +
            "group by p.cumplimiento_normativo order by count(1) desc   ",
            nativeQuery = true)
    List<Object[]> chartNormatividad(Date fechaInicial, Date fechaFinal, int localidad, String tipoPredio);

}
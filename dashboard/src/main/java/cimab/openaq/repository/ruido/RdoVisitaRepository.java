package cimab.openaq.repository.ruido;

import cimab.openaq.entity.ruido.RdoProfesional;
import cimab.openaq.entity.ruido.RdoVisita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdoVisitaRepository extends JpaRepository<RdoVisita, Integer> {

    @Query(value = "select * from sde.rdo_visita v where v.radicado = :radicado order by v.fechavisita  ",
            nativeQuery = true)
    List<RdoVisita> listVisitasXRadicado(String radicado);

    @Query(value = "select * from sde.rdo_visita v where v.radicado = :radicado and profesional = :profesional and fechavisita = :fechavisita order by v.fechavisita   ",
            nativeQuery = true)
    RdoVisita consultaSiYaExiste(String radicado, String profesional, java.sql.Timestamp fechavisita);

    @Query(value = "select * from sde.rdo_visita v, " +
            "   sde.rdo_profesional rp where " +
            "   rp.username = :profesional and " +
            "   v.profesional = rp.nombre " +
            "    order by fechavisita desc ",
            nativeQuery = true)
    List<RdoVisita> visitasPorProfesional(String profesional);

}
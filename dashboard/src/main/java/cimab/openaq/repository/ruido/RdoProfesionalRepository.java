package cimab.openaq.repository.ruido;

import cimab.openaq.entity.ruido.RdoEstado;
import cimab.openaq.entity.ruido.RdoProfesional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RdoProfesionalRepository  extends JpaRepository<RdoProfesional, Integer> {

    @Query(value = "select * from sde.rdo_profesional order by nombre ",
            nativeQuery = true)
    List<RdoProfesional> listProfesional();

}
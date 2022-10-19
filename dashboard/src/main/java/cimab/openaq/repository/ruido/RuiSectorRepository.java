package cimab.openaq.repository.ruido;

import cimab.openaq.entity.ruido.RuiSector;
import cimab.openaq.entity.ruido.Visitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RuiSectorRepository  extends JpaRepository<RuiSector, Integer> {

    @Query(value = "select * from sde.rdo_sector order by nombre ",
            nativeQuery = true)
    List<RuiSector> listSector();

}

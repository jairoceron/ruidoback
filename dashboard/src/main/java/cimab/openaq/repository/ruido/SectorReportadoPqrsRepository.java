package cimab.openaq.repository.ruido;

import cimab.openaq.entity.ruido.SectorReportadoPqrs;
import cimab.openaq.entity.ruido.Visitas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SectorReportadoPqrsRepository extends JpaRepository<SectorReportadoPqrs, Long> {


    @Query(value = "select * from sector_reportado_pqrs ",
            nativeQuery = true)
    List<SectorReportadoPqrs> listSectorReportado();

}

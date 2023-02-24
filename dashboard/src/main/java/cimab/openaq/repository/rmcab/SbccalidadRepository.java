package cimab.openaq.repository.rmcab;

import cimab.openaq.entity.rmcab.Sbccalidad;
import cimab.openaq.entity.rmcab.Variableambiental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SbccalidadRepository  extends JpaRepository<Sbccalidad, Long> {

    @Query(value = "select * from Sbccalidad ",
            nativeQuery = true)
    List<Sbccalidad> listSbccalidad();

    @Query(value = "select * from Sbccalidad where variable = 'PM1' ",
            nativeQuery = true)
    Sbccalidad listSbccalidadPM1();

}

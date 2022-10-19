package cimab.openaq.repository.ruido;
import cimab.openaq.entity.rmcab.Variableambiental;
import cimab.openaq.entity.ruido.Visitas;
import cimab.openaq.entity.sbc.Sensoresestacion;
import cimab.openaq.entity.sbc.Sensoresvariable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface  VisitaRepository  extends JpaRepository<Visitas, Long> {



    @Query(value = "select profesional_encargado from sde.visitas group by profesional_encargado ",
            nativeQuery = true)
    List<String> listFuncionariosRuido();

    @Query(value = "select * from sde.visitas where radicado = :idRadicado",
            nativeQuery = true)
    List<Visitas> listVisitasPorRadicado(String idRadicado);

}

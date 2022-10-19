package cimab.openaq.repository.rmcab;

import cimab.openaq.entity.rmcab.Variableambiental;
import cimab.openaq.entity.rmcab.Variableambiental_rmcab;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  TableroRepository extends JpaRepository<Variableambiental, Long> {

    @Query(value = "select id , variable, codigoestacion, latitud, longitud " +
            " nombreestacion , fechaobservacion, mesobservacion, diaobservacion, anioobservacion " +
            " departamento ,  municipio, valorobservado " +
            " fuenteinformacion from variableambiental", nativeQuery = true)
    List<Object[]> dashboardEstado(@Param("estado") String estado);

    @Query(value = "select * from variableambiental", nativeQuery = true)
    List<Variableambiental_rmcab> lista();

    @Query(value = "select variable from variableambiental group by variable order by variable", nativeQuery = true)
    List<String> listaVariables();

    @Query(value = "select nombreestacion from variableambiental group by  nombreestacion order by nombreestacion", nativeQuery = true)
    List<String> listaEstaciones();


    @Query(value = "select * from variableambiental " +
            "    where variable = :variable and  nombreestacion = :estacion and " +
            " fechaobservacion between TO_DATE( :fechaInicial,'DD/MM/YYYY')  and TO_DATE( :fechaFinal,'DD/MM/YYYY') " +
            " order by fechaobservacion desc", nativeQuery = true)
    List<Variableambiental> listaDatosVarAmbiental(String variable, String estacion, String fechaInicial, String fechaFinal);

    @Query(value = "select fuenteinformacion, variable, latitud, longitud, codigoestacion, nombreestacion , anioobservacion ,mesobservacion , diaobservacion , SUM(valorobservado) as suma " +
            "from variableambiental v " +
            "where variable = :variable and  nombreestacion = :estacion and " +
            "             fechaobservacion between TO_DATE( :fechaInicial,'DD/MM/YYYY')  and TO_DATE( :fechaFinal,'DD/MM/YYYY') " +
            "group by fuenteinformacion, variable,  latitud, longitud,  codigoestacion, nombreestacion , anioobservacion ,mesobservacion , diaobservacion " +
            " having count(1) > 16 " +
            "order by  fuenteinformacion,codigoestacion, nombreestacion , anioobservacion ,mesobservacion , diaobservacion", nativeQuery = true)
    List<Object[]> listaDatosVarAmbientalAcumulado(String variable, String estacion, String fechaInicial, String fechaFinal);

    @Query(value = "select fuenteinformacion, variable, latitud, longitud, codigoestacion, nombreestacion , anioobservacion ,mesobservacion , diaobservacion,  avg(valorobservado) as promedio " +
            "from variableambiental v " +
            " where variable = :variable and  nombreestacion = :estacion and " +
            "             fechaobservacion between TO_DATE( :fechaInicial,'DD/MM/YYYY')  and TO_DATE( :fechaFinal,'DD/MM/YYYY')  " +
            "group by fuenteinformacion, variable,  latitud, longitud,  codigoestacion, nombreestacion , anioobservacion ,mesobservacion , diaobservacion " +
            " having count(1) > 16  " +
            "order by  fuenteinformacion,codigoestacion, nombreestacion , anioobservacion ,mesobservacion , diaobservacion;", nativeQuery = true)
    List<Object[]> listaDatosVarAmbientalPromedio(String variable, String estacion, String fechaInicial, String fechaFinal);


}



package cimab.openaq.repository.etiqoracle;

import cimab.openaq.entity.etiqoracle.EvaEtiquetado;
import cimab.openaq.entity.etiqoracle.EvaEtiquetadoPK;
import cimab.openaq.entity.etiqoracle.EvaRecursos;
import cimab.openaq.entity.etiqoracle.EvaRecursosKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface  EvaEtiquetadoRepository extends JpaRepository<EvaEtiquetado, EvaEtiquetadoPK> {

    @Query(value = "SELECT * FROM EVA_ETIQUETADO ee WHERE  " +
            " upper(COMBUSTIBLE) LIKE %:combustible% " ,
            nativeQuery = true)
    List<EvaEtiquetado> listInformacionvehiculoGrado6(String combustible );
    @Query(value = "SELECT * FROM EVA_ETIQUETADO ee WHERE UPPER(ee.clase) LIKE  %:clase% " +
    " AND upper(COMBUSTIBLE) LIKE %:combustible% " +
    " AND upper(MODELO) LIKE  %:modelo% AND cilindrada LIKE  %:cilindraje% ",
            nativeQuery = true)
    List<EvaEtiquetado> listInformacionvehiculoGrado5(String clase, String combustible , String modelo, String cilindraje);

    @Query(value = "SELECT * FROM EVA_ETIQUETADO ee WHERE UPPER(ee.clase) LIKE  %:clase% AND upper(MODELO) LIKE  %:modelo% AND cilindrada LIKE  %:cilindraje%  ",
            nativeQuery = true)
    List<EvaEtiquetado> listInformacionvehiculoGrado4(String clase, String modelo, String cilindraje);

    @Query(value = "SELECT * FROM EVA_ETIQUETADO ee WHERE UPPER(ee.clase) LIKE  %:clase% AND upper(MODELO) LIKE  %:modelo%   ",
            nativeQuery = true)
    List<EvaEtiquetado> listInformacionvehiculoGrado3(String clase, String modelo);

    @Query(value = "SELECT * FROM EVA_ETIQUETADO ee WHERE UPPER(ee.clase) LIKE  %:clase%   ",
            nativeQuery = true)
    List<EvaEtiquetado> listInformacionvehiculoGrado2(String clase);


    @Query(value = "select * from eva_recursos e  ",
            nativeQuery = true)
    List<EvaRecursos> listInformacionvehiculo();


    @Query(value = "select * from EVA_RESOURCES e WHERE clave = :clave AND sistemaoperativo = :sistemaOperativo  ",
            nativeQuery = true)
    EvaRecursos consultaClaveRecurso(String clave, String sistemaOperativo);
}

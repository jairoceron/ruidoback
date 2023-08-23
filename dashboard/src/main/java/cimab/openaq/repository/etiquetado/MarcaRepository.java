package cimab.openaq.repository.etiquetado;

import cimab.openaq.entity.etiquetado.Marca;
import cimab.openaq.entity.etiquetado.Tiposervicio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

import java.util.List;

@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

    @Query(value = "select * from sda_e_marca where idmarca = :idmarca ",
            nativeQuery = true)
    List<Marca> listMarcaById(int idmarca);

    @Query(value = "select * from sda_e_marca where idclasevehiculo = :idclasevehiculo ",
            nativeQuery = true)
    List<Marca> listMarcaByIdClaseVehiculo(int idclasevehiculo);



    @Query(value = "select * from sda_e_marca order by nombre",
            nativeQuery = true)
    List<Marca> listMarca();

}

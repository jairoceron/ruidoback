package cimab.openaq.repository.etiquetado;

import cimab.openaq.entity.etiquetado.Pesovehiculo;
import cimab.openaq.entity.etiquetado.Tipocombustible;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface PesovehiculoRepository  extends JpaRepository<Pesovehiculo, Long> {

    @Query(value = "select * from sda_e_pesovehiculo where idclasevehiculo = :idclasevehiculo ",
            nativeQuery = true)
    List<Pesovehiculo> listPesovehiculo(int idclasevehiculo );

}

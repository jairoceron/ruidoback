package cimab.openaq.repository.etiquetado;

import cimab.openaq.entity.etiquetado.Categoria;
import cimab.openaq.entity.etiquetado.Cilindrada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import java.util.List;


import java.util.List;

import org.springframework.stereotype.Repository;


@Repository
public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

    @Query(value = "select * from sda_e_categoria ",
            nativeQuery = true)
    List<Categoria> listCategoriaX();

    @Query(value = "select * from sda_e_categoria where idclasevehiculo = :idclasevehiculo ",
            nativeQuery = true)
    List<Categoria> listCategoria(int idclasevehiculo );

}

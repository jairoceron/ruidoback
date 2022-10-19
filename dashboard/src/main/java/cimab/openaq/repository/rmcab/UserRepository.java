package cimab.openaq.repository.rmcab;

import cimab.openaq.entity.rmcab.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query(value = "select * from userx", nativeQuery = true)
    List<User> listaUsuarios();

    @Query(value = "select * from userx where username = :usuario", nativeQuery = true)
    List<User> listaModulosUsuarios(String usuario);

    User findByUsername(String username);

}



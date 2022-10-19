package cimab.openaq.service.security;

import cimab.openaq.entity.rmcab.User;
import cimab.openaq.repository.rmcab.ModulousuarioRepository;
import cimab.openaq.repository.rmcab.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MyUserDetailsService implements UserDetailsService {

    private UserRepository ur;
    private ModulousuarioRepository mr;

    @Autowired
    public void setUr(UserRepository ur) {
        this.ur = ur;
    }

    @Autowired
    public void setMr(ModulousuarioRepository mr) {
        this.mr = mr;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("usuario ::::   >  " + username);
        /*
        List<User> listUsers = ur.listaUsuarios();
        System.out.println(listUsers);

//        List<Modulousuario> listModuloUsu = mr.listModuloUsu(s);
 //       System.out.println(listModuloUsu);

        return new org.springframework.security.core.userdetails.User("foo", "foo",
                new ArrayList<>());

         */
        User user = ur.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException(username);
        }
        return new MyUserPrincipal(user);

    }
}
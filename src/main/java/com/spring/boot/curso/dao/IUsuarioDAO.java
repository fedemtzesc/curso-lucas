package com.spring.boot.curso.dao;

import com.spring.boot.curso.models.Usuario;

import java.util.List;

// DAO significa Data Access Object
public interface IUsuarioDAO {
    List<Usuario> getUsuarios();

    void eliminar(Long id);

}

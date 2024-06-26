package com.spring.boot.curso.controllers;

import com.spring.boot.curso.dao.UsuarioDAOImp;
import com.spring.boot.curso.models.JSONClass;
import com.spring.boot.curso.models.Usuario;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {
    //Aqui declaramos el objeto para hacer logging
    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UsuarioDAOImp usuarioDatoImp;

    // ##### LISTADO DE METODOS SENCILLOS
    @RequestMapping(value="text")
    public String prueba(){
        return "prueba";
    }

    @RequestMapping(value="list")
    public List lista(){
        return List.of("Kiwi", "Manzana", "Piña", "Durazno", "Uva", "Mandarina", "Fresa", "Toronja", "Ponche", "Raiz", "Manzana", "Limon");
    }

    @RequestMapping(value="dict")
    public JSONClass dict(){
        return new JSONClass("Federico", "Martinez", 50);
    }

    @RequestMapping(value="dictlist")
    public List<JSONClass> dictlist(){
        List<JSONClass> JSONList = new ArrayList();
        JSONList.add(new JSONClass("Federico", "Martinez", 50));
        JSONList.add(new JSONClass("Yolanda", "Belmares", 45));
        JSONList.add(new JSONClass("Valeria", "Martinez", 11));
        // Ejemplos de logging
        logger.info("DICCIONARIO INFO!");
        logger.warn("DICCIONARIO WARN!");
        logger.error("DICCIONARIO ERROR!");
        logger.debug("DICCIONARIO DEBUG!");
        return JSONList;
    }

    @RequestMapping(value = "api/usuarios", method = RequestMethod.GET)
    public List<Usuario> getListaUsuarios(){
        return usuarioDatoImp.getUsuarios();
    }

    @RequestMapping(value = "api/arreglo/usuarios")
    public Usuario[] getArrayUsuarios(){
        Usuario[] usuarios = new Usuario[5];

        for(int i=0;i<5;i++){
            Usuario usrTmp = new Usuario();
            usrTmp.setId((long)i);
            usrTmp.setNombre("Nombre " + i);
            usrTmp.setApellido("Apellido " + i);
            usrTmp.setEmail("email" + i + "@mail.com");
            usrTmp.setTelefono("Telefono " + i);
            usrTmp.setPassword("Password " + i);
            usuarios[i] = usrTmp;
        }

        return usuarios;
    }

    @DeleteMapping(value = "api/usuarios/{id}")
    public void eliminar(@PathVariable Long id){
        usuarioDatoImp.eliminar(id);
    }

}

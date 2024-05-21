package com.proyectogestion.gestiondepagos.servicio;

import com.proyectogestion.gestiondepagos.modelo.Entidad;
import com.proyectogestion.gestiondepagos.repositorio.EntidadRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class EntidadServicio implements IEntidadServicio {
    @Autowired
    private EntidadRepositorio entidadRepositorio;

    @Override
    public List<Entidad> listarEntidades() {
        return entidadRepositorio.findAll();
    }

    @Override
    public Entidad buscarEntidadPorId(Integer id_Entidad) {
        Entidad entidad = entidadRepositorio.findById(id_Entidad).orElse(null);
        return entidad;
    }

    @Override
    public Entidad registrarEntidad(Entidad entidad) {
        return entidadRepositorio.save(entidad);
    }

    @Override
    public void eliminarEntidad(Entidad entidad) {
        entidadRepositorio.delete(entidad);
    }

    @Override
    public void iniciarSesion(String nombre_entidad, Long cuit_entidad, String contrasena) {
        //como funciona el inicio de sesión.
    }
}

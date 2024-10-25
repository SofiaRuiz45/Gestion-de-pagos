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
//se utiliza para realizar las acciones de eliminar y modificar
    @Override
    public Entidad buscarEntidadPorId(Integer id_Entidad) {
        Entidad entidad = entidadRepositorio.findById(id_Entidad).orElse(null);
        return entidad;
    }

    @Override
    public Entidad registrarEntidad(Entidad entidad){
        return entidadRepositorio.save(entidad);
    }
    @Override
    public void eliminarEntidad(Entidad entidad) {
        entidadRepositorio.delete(entidad);
    }

    @Override
    public Entidad iniciarSesion(String correoElectronicoEntidad, Long cuitEntidad, String contrasena) {
        // Se busca la entidad por correo y cuit
        Entidad entidad = entidadRepositorio.findByCorreoElectronicoEntidadAndCuitEntidad(correoElectronicoEntidad, cuitEntidad);

        // Si la entidad no existe o la contraseña es incorrecta, retornamos null
        if (entidad == null || entidad.getContrasena() == null || !entidad.getContrasena().equals(contrasena)) {
            return null;
        }

        // Si todo está correcto, retornamos la entidad
        return entidad;
    }

}

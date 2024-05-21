package com.proyectogestion.gestiondepagos.servicio;

import com.proyectogestion.gestiondepagos.modelo.Entidad;

import java.util.List;

public interface IEntidadServicio {
    //1ro nomas de prueba
    public List<Entidad> listarEntidades();

    public Entidad buscarEntidadPorId(Integer id_Entidad);

    public Entidad registrarEntidad(Entidad entidad);

    public void eliminarEntidad(Entidad entidad);

    public void iniciarSesion(String nombre_entidad, Long cuit_entidad, String contrasena);
}

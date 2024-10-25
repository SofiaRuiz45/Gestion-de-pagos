package com.proyectogestion.gestiondepagos.servicio;
import com.proyectogestion.gestiondepagos.modelo.Entidad;
import java.util.List;

public interface IEntidadServicio {
    //1ro nomas de prueba
    public List<Entidad> listarEntidades();

    public Entidad buscarEntidadPorId(Integer id_entidad);

    public Entidad registrarEntidad(Entidad entidad);

    public void eliminarEntidad(Entidad entidad);

    public Entidad iniciarSesion(String correo_entidad, Long cuit_entidad, String contrasena);
}

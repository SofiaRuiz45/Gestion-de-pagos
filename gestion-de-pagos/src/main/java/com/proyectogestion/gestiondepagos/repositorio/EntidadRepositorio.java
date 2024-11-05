package com.proyectogestion.gestiondepagos.repositorio;

import com.proyectogestion.gestiondepagos.modelo.Entidad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EntidadRepositorio extends JpaRepository <Entidad, Integer>{

    //para buscar la entidad por correo y cuit
    Entidad findByCorreoElectronicoEntidadAndCuitEntidad(String correoElectronicoEntidad, Long cuitEntidad);

    Entidad findByNombreEntidad(String nombreEntidad);
}

package com.proyectogestion.gestiondepagos.modelo;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Entidad {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//orden acorde al diagrama y se arreglaron los atributos.
    Integer id_entidad;
    String nombreEntidad;
    Long cuitEntidad;
    String correoElectronicoEntidad;
    Long telefono_entidad;
    String razon_social_entidad;
    String direccion_entidad;
    String contrasena;



}

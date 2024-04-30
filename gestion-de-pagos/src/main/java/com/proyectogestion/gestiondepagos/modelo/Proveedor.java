package com.proyectogestion.gestiondepagos.modelo;

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

public class Proveedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_proveedor;
    String nombre;
    Long cuit_proveedor;
    String direccion_proveedor;
    Long telefono_proveedor;
    String razon_social;
    String correo_electronico;
}

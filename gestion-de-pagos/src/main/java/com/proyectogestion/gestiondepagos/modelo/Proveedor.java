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
   private Integer id_proveedor;
    String nombre_proveedor;
    private String rubro;
    private Long cuit_proveedor;
    private String direccion_proveedor;
    private Long telefono_proveedor;
    private String razon_social_proveedor;
    private String correo_electronico_proveedor;
}

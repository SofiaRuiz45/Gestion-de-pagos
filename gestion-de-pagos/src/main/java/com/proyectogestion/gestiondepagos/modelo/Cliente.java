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

public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   private Integer id_cliente;
    String nombre_cliente;
    private String rubro;
    private Long cuit_cliente;
    private String direccion_cliente;
    private Long telefono_cliente;
    private String razon_social_cliente;
    private String correo_electronico_cliente;
}

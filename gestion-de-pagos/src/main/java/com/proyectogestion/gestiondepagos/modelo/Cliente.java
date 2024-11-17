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
    Integer id_cliente;
    //ver si es necesario cambiar los nombres sacando guión bajo
    String nombreCliente;
    String rubro;
    Long cuitCliente;
    String direccion_cliente;
    Long telefono_cliente;
    String razon_social_cliente;
    String correo_electronico_cliente;
}

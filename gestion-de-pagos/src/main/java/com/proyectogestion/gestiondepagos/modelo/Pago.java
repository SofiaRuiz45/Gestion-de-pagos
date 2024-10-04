package com.proyectogestion.gestiondepagos.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.time.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_pago;
    Integer num_factura;
    LocalDate fecha_pago;
    @ManyToOne
    @JoinColumn(name= "datos_cliente")
    Cliente datos_cliente;

    @ManyToOne
    @JoinColumn(name = "datos_entidad")
    Entidad datos_entidad;

    String descripcion;
    String estado_pago;
    double precio_unitario;
    double subtotal;
    double total;
    String forma_de_pago;

}
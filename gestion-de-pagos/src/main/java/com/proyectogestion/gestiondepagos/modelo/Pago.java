package com.proyectogestion.gestiondepagos.modelo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    //Proveedor datos_proveedor;
    //Entidad datos_entidad;
    String descripcion;
    String estado_pago;
    double precio_unitario;
    double subtotal;
    double total;

}
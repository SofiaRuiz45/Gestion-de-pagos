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
    long nro_pago;
    LocalDate fecha_pago;
    String tipo_pago;
    double monto;
    Integer id_entidad;
    Integer id_proveedor;
}
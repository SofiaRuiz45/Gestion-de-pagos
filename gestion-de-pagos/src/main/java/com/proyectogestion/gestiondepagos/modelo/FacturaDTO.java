package com.proyectogestion.gestiondepagos.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class FacturaDTO {
    private Long cuitCliente;
    //hacer por defecto a la entidad con menor id
    private Long cuitEntidad;
    private double monto_factura;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date fecha_factura;
    private String numeroFactura;
}

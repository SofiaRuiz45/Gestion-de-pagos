package com.proyectogestion.gestiondepagos.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Factura {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_factura;
    Double monto_factura;
    Date fecha_factura;
    Integer numeroFactura;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    Cliente cliente;
    //se establecio correctamente la relación entre las clases

    public Integer getNumeroCliente() {
        return cliente != null ? cliente.getId_cliente() : null;
    }

    // Método para obtener el id del cliente (por si lo necesitas en algún momento)
    public Integer getClienteId() {
        return cliente != null ? cliente.getId_cliente() : null;
    }
}

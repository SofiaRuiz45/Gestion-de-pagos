package com.proyectogestion.gestiondepagos.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
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
    //se define el formato: año/mes/día
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date fecha_factura;

    @Column(unique = true)
    Integer numeroFactura;
    @ManyToOne
    @JoinColumn(name = "id_cliente")
    Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "id_entidad")
    Entidad entidad;

    //revisar su funcionalidad y si son de utilidad
    public Integer getNumeroCliente() {
        return cliente != null ? cliente.getId_cliente() : null;
    }
}

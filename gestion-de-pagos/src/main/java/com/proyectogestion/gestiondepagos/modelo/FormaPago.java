package com.proyectogestion.gestiondepagos.modelo;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "pago")
public class FormaPago {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_formaPago;
    String metodo; //tarjeta, efectivo, transferencia....
    double monto; //monto especifico por cada metodo de pago

    Integer nro_operacion;
    @ManyToOne
    @JoinColumn(name = "id_pago")
    @JsonBackReference
    Pago pago;


    //obtengo el id del pago
    public Integer getIdPago(){
        return pago != null ? pago.getId_pago(): null;
    }
    @Override
    public String toString() {
        return "FormaPago{" +
                "id_formaPago=" + id_formaPago +
                ", metodo='" + metodo + '\'' +
                ", monto=" + monto +
                ", nro_operacion=" + nro_operacion +
                '}';
    }
}

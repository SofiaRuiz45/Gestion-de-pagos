package com.proyectogestion.gestiondepagos.modelo;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString(exclude = "formas_de_pago")

public class Pago {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_pago;
    @Column(unique = true)
    Integer numeroPago;
    @ManyToOne
    @JoinColumn(name = "id_factura")
    Factura factura;
    //se define el formato: año/mes/día
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date fecha_pago;
    //modificación del estado cuando la "deuda" de factura este en 0
    String estadoPago;

    @OneToMany(mappedBy = "pago", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonManagedReference
    List<FormaPago> formas_de_pago = new ArrayList<>();
    double total;

    @Override
    public String toString() {
        StringBuilder formasPagoStr = new StringBuilder();
        if (formas_de_pago != null) {
            for (FormaPago forma : formas_de_pago) {
                formasPagoStr.append(forma.toString()).append(", ");
            }
        }
        return "Pago{" +
                "id_pago=" + id_pago +
                ", numeroPago=" + numeroPago +
                ", fecha_pago=" + fecha_pago +
                ", estado_pago='" + estadoPago + '\'' +
                ",factura= "+ factura +"\'"+
                ", total=" + total +
                ", formas_de_pago=[" + formasPagoStr.toString() + "]" +
                '}';
    }

}
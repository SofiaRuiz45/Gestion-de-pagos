package com.proyectogestion.gestiondepagos.modelo;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Comprobante {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id_comprobante;
    LocalDate fecha_emision;
    /*a partir de este atributo obtendremos todo lo necesario */
   /* @ManyToOne
    @JoinColumn(name = "detalle_comprobante")
    Integer detalle_comprobante;*/
}

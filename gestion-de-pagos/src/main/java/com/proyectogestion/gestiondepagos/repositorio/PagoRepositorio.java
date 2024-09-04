package com.proyectogestion.gestiondepagos.repositorio;

import com.proyectogestion.gestiondepagos.modelo.Pago;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagoRepositorio extends JpaRepository<Pago, Integer> {
}

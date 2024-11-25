package com.proyectogestion.gestiondepagos.controlador;


import com.proyectogestion.gestiondepagos.modelo.Pago;
import com.proyectogestion.gestiondepagos.servicio.PagoServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("gestion-de-pagos")
@CrossOrigin(value = "http://localhost:3000")
public class PagoControlador {
    private static final Logger logger = LoggerFactory.getLogger(PagoControlador.class);

    @Autowired
    private PagoServicio pagoServicio;

    @GetMapping("/pagos/pagos-realizados")
    public List<Pago> obtenerPagos() {
        var pagos = pagoServicio.verPagosRealizados();
        pagos.forEach(pago -> logger.info(pago.toString()));
        return pagos;
    }

    //registrar un pago
    @PostMapping("/pagos/realizar-pago")
    public Pago realizarPago(@RequestBody Pago pago) {
        logger.info("Pago a agregar: " + pago);
        Pago pagoGuardado = pagoServicio.realizarPago(pago);
        return pagoGuardado;
    }

    //busqueda de pago por nombre de cliente
    @GetMapping("/pagos/cliente/{nombreCliente}")
    public List<Pago> obtenerPagosPorCliente(@RequestParam("nombreCliente") String nombreCliente) {
        return pagoServicio.buscarPagosPorCliente(nombreCliente);
    }

    //busqueda de pago por nombre de entidad
    @GetMapping("/pagos/entidad/{nombreEntidad}")
    public List<Pago> obtenerPagosPorEntidad(@RequestParam("nombreEntidad") String nombreEntidad) {
        return pagoServicio.buscarPagoPorEntidad(nombreEntidad);
    }

    //busqueda por estado de pago
    @GetMapping("/pagos/estado/{estadoPago}")
    public List<Pago> obtenerPagosPorEstado(@PathVariable("estadoPago") String estadoPago) {
        return pagoServicio.buscarPagosPorEstado(estadoPago);
    }

    @GetMapping("/pagosContadosPorEstado/{estadoPago}")
    public ResponseEntity<Long> contarPagosEstado(@PathVariable String estadoPago) {
        Long cantidadPagos = pagoServicio.contarPagosPorEstado(estadoPago);
        return ResponseEntity.ok(cantidadPagos);
    }

    @GetMapping("/ultimosPagos")
    //se obtienen los ultimos en base a la fecha que se realizó el pago
    //la cantidad se manda asi --> url/ultimosPagos?cantidad=5
    public ResponseEntity<List<Pago>> obtenerPagos(@RequestParam(defaultValue = "5") int cantidad){
        List <Pago> ultimosPagos = pagoServicio.obtenerUltimosPagos(cantidad);
        return ResponseEntity.ok(ultimosPagos);
    }
}

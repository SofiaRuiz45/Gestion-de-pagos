package com.proyectogestion.gestiondepagos.controlador;

import com.proyectogestion.gestiondepagos.excepcion.RecursoNoEncontradoEx;
import com.proyectogestion.gestiondepagos.modelo.Entidad;
import com.proyectogestion.gestiondepagos.servicio.EntidadServicio;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("gestion-de-pagos")
/*se va a recibir peticiones del puerto 3000*/
@CrossOrigin(value= "http://localhost:3000")
public class EntidadControlador {
    private static final Logger logger =
            LoggerFactory.getLogger(EntidadControlador.class);
    @Autowired
    private EntidadServicio entidadServicio;

    @GetMapping("/entidad")
    public List<Entidad> obtenerEntidades(){
        var entidades = entidadServicio.listarEntidades();
        //
        entidades.forEach((entidad -> logger.info(entidad.toString())));
        return entidades;
    }

    @PostMapping("/entidad")
    public Entidad agregarEntidad(@RequestBody Entidad entidad) {
        logger.info("Entidad a agregar: " + entidad);
        return entidadServicio.registrarEntidad(entidad);
    }
    @GetMapping("/entidad/{id}")
    public ResponseEntity<Entidad> obtenerEnditadPorId(@PathVariable Integer id){
        Entidad entidad = entidadServicio.buscarEntidadPorId(id);
        return null;
        //if(entidad == null)
    }
    //actualizar entidad
    @PutMapping("/entidad/{id}")
    public ResponseEntity<Entidad> actualizarEntidad
            (@PathVariable Integer id, @RequestBody Entidad entidadRecibido) {
        Entidad entidad = entidadServicio.buscarEntidadPorId(id);
        if (entidad == null)
            throw new RecursoNoEncontradoEx("El id no existe");
        //validaciónn antes de ingesar a la BD
        entidad.setNombre_entidad(entidadRecibido.getNombre_entidad());
        entidad.setCuit_entidad(entidadRecibido.getCuit_entidad());
        entidad.setCorreo_electronico_entidad(entidadRecibido.getCorreo_electronico_entidad());
        entidad.setTelefono_entidad(entidadRecibido.getTelefono_entidad());
        entidad.setRazon_social_entidad(entidadRecibido.getRazon_social_entidad());
        entidad.setDireccion_entidad(entidadRecibido.getDireccion_entidad());
        entidadServicio.registrarEntidad(entidad);
        return ResponseEntity.ok(entidad);
        //ver tema de la contraseña
    }
        @DeleteMapping("/entidad/{id}")
                public  ResponseEntity<Map<String, Boolean>>
                eliminarEntidad(@PathVariable Integer id){
            Entidad entidad = entidadServicio.buscarEntidadPorId(id);
            if(entidad == null)
                throw new RecursoNoEncontradoEx("id no encontrado");
            entidadServicio.eliminarEntidad(entidad);
            //respuesta JSON {"eliminado" : "true"}
            Map<String, Boolean> respuesta = new HashMap<>();
            respuesta.put("eliminado", Boolean.TRUE);
            return  ResponseEntity.ok(respuesta);
        }
    }

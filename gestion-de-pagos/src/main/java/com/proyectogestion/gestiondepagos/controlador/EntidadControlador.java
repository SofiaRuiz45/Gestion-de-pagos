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

    @PostMapping("/iniciarSesion")
    public ResponseEntity<Map<String, Object>> iniciarSesion(@RequestBody Map<String, Object> requestBody) {
        // Verificar que el requestBody contiene las claves necesarias
        if (!requestBody.containsKey("correoElectronicoEntidad") || !requestBody.containsKey("cuitEntidad") || !requestBody.containsKey("contrasena")) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "Faltan credenciales necesarias");
            return ResponseEntity.status(400).body(errorResponse);
        }

        // Extraer valores del requestBody
        String correo = (String) requestBody.get("correoElectronicoEntidad");
        Long cuit = null;
        try {
            cuit = Long.valueOf(requestBody.get("cuitEntidad").toString());
        } catch (NumberFormatException e) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "El valor de CUIT es inválido");
            return ResponseEntity.status(400).body(errorResponse);
        }
        String contrasena = (String) requestBody.get("contrasena");

        // Verificar si los valores no son nulos
        if (correo == null || cuit == null || contrasena == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "Las credenciales proporcionadas son inválidas");
            return ResponseEntity.status(400).body(errorResponse);
        }

        // Búsqueda de la entidad
        Entidad entidad = entidadServicio.iniciarSesion(correo, cuit, contrasena);

        // Si la entidad no existe
        if (entidad == null) {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("mensaje", "Credenciales incorrectas o entidad no registrada");
            return ResponseEntity.status(401).body(errorResponse);
        }

        // Si las credenciales son correctas
        Map<String, Object> successResponse = new HashMap<>();
        successResponse.put("mensaje", "Inicio de sesión exitoso.");
        successResponse.put("entidad", entidad);
        return ResponseEntity.ok(successResponse);
    }


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
        entidad.setCuitEntidad(entidadRecibido.getCuitEntidad());
        entidad.setCorreoElectronicoEntidad(entidadRecibido.getCorreoElectronicoEntidad());
        entidad.setTelefono_entidad(entidadRecibido.getTelefono_entidad());
        entidad.setRazon_social_entidad(entidadRecibido.getRazon_social_entidad());
        entidad.setDireccion_entidad(entidadRecibido.getDireccion_entidad());
        entidadServicio.registrarEntidad(entidad);
        return ResponseEntity.ok(entidad);
        //ver tema de la contraseña
    }

    //para eliminar entidades por id
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

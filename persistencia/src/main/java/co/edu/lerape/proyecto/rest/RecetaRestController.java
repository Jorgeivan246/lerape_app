package co.edu.lerape.proyecto.rest;

import co.edu.lerape.proyecto.dto.Mensaje;
import co.edu.lerape.proyecto.entidades.Receta;
import co.edu.lerape.proyecto.servicios.RecetaServicio;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/recetas")
public class RecetaRestController {

    @Autowired
    private RecetaServicio recetaServicio;

    @GetMapping("/listar")
    public ResponseEntity listar() {
        List<Receta> listaRecetas = recetaServicio.listarRecetas();
        return ResponseEntity.status(200).body(listaRecetas);
    }

    @GetMapping("/obtener/{id}")
    public ResponseEntity obtenerReceta(@PathVariable("id") String idReceta) {
        try {
            Receta receta = recetaServicio.obtenerReceta(idReceta);

            return ResponseEntity.status(200).body(receta);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }

    }


    @PostMapping("/crear")
    public ResponseEntity<Mensaje> crearReceta(@RequestBody Receta receta) {
        try {
            recetaServicio.registrarReceta(receta);
            return ResponseEntity.status(200).body(new Mensaje("La receta  se creo correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @PostMapping("/actualizar")
    public ResponseEntity<Mensaje> actualizarReceta(@RequestBody Receta receta) {
        try {
            recetaServicio.actualizarReceta(receta);
            return ResponseEntity.status(200).body(new Mensaje("La receta se ha actualizado correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Mensaje> eliminar(@PathVariable("id") String id) {
        try {
            recetaServicio.eliminarReceta(id);
            return ResponseEntity.status(200).body(new Mensaje("La receta se elimino correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @PostMapping("/crear/favorita")
    public  ResponseEntity<Mensaje> registrarRecetaFavoritaUsuario(@PathVariable Receta re)
    {
        try {
            recetaServicio.registrarRecetaFavoritaUsuario(re);
            return ResponseEntity.status(200).body(new Mensaje("El usuario  agrego la receta correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }


    @GetMapping("/obtener/favoritas/{id}")
    public ResponseEntity obtenerRecetasFavoritas( @PathVariable("id") String email)
    {
        try {
            List<Receta> recetasFav = recetaServicio.listarRecetasFavoritas(email);

            return ResponseEntity.status(200).body(recetasFav);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @DeleteMapping("eliminar/favoritas/{id}")
    public ResponseEntity<Mensaje> eliminarRecetasFavoritas(@PathVariable("id") String email)
    {
        try {
            recetaServicio.eliminarRecetasFavoritasUsuario(email);
            return ResponseEntity.status(200).body(new Mensaje("La receta se elimino correctamente"));
        } catch (Exception e) {
            return ResponseEntity.status(500).body(new Mensaje(e.getMessage()));
        }
    }

    @PostMapping("actualizar/favorita")
    public ResponseEntity<Mensaje> actualizarRecetaFavorita(@RequestBody Receta receta)
    {
        try{
                recetaServicio.actualizarRecetaFavorita(receta);
            return ResponseEntity.status(200).body(new Mensaje("La receta se ha actualizado correctamente"));
        }catch (Exception e)
        {
            return ResponseEntity.status(200).body(new Mensaje(e.getMessage()));
        }
    }





}

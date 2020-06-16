package com.dosalamos.centromedicoapi.controllers;

import com.dosalamos.centromedicoapi.models.Perfil;
import com.dosalamos.centromedicoapi.models.Rol;
import com.dosalamos.centromedicoapi.models.Usuario;
import com.dosalamos.centromedicoapi.services.PerfilService;
import com.dosalamos.centromedicoapi.services.RolService;
import com.dosalamos.centromedicoapi.services.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/usuario")
@Slf4j
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;
    @Autowired
    private RolService rolService;
    @Autowired
    private PerfilService perfilService;

    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable String id) {
        try {
            return ResponseEntity.ok(usuarioService.findById(Integer.parseInt(id)).get());
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping
    public ResponseEntity<Usuario> postCrearUsuario(@RequestBody Map<String, String> body) {
        try {

            Date date = new Date();
            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Rol rol = rolService.findById(Integer.parseInt(body.get("rol"))).get();

            Perfil perfil = new Perfil(
                    body.get("nombre"),
                    body.get("apellidoPaterno"),
                    body.get("apellidoMaterno"),
                    body.get("direccion"),
                    body.get("email"),
                    body.get("telefono"),
                    body.get("fechaNacimiento"),
                    dateFormat.format(date),
                    dateFormat.format(date)
            );

            perfil = perfilService.save(perfil);

            Usuario usuario = new Usuario(
                    body.get("nombreUsuario"),
                    body.get("contrasena"),
                    rol,
                    perfil,
                    dateFormat.format(date),
                    dateFormat.format(date)
            );

            return ResponseEntity.ok(usuarioService.save(usuario));
        } catch (Exception e) {
            return ResponseEntity.badRequest().build();
        }
    }
}

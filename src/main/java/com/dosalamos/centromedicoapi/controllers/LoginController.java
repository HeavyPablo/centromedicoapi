package com.dosalamos.centromedicoapi.controllers;

import com.dosalamos.centromedicoapi.models.Usuario;
import com.dosalamos.centromedicoapi.services.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/login")
@Slf4j
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class LoginController {

    @Autowired
    private UsuarioService usuarioService;

    @PostMapping
    public ResponseEntity<Usuario> login(@RequestBody Map<String, String> body) {
        String nombreUsuario = body.get("nombreUsuario");
        String contrasena = body.get("contrasena");

        Optional<Usuario> usuario = usuarioService.findByNombreUsuario(nombreUsuario);

        if (!usuario.isPresent() || !usuario.get().getContrasena().equals(contrasena)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.ok(usuario.get());
    }
}

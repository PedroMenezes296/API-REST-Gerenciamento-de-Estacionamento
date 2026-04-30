package com.mballem.demo_park_api.web.controller;

import com.mballem.demo_park_api.entity.Usuario;
import com.mballem.demo_park_api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

    private final UsuarioService usuarioService;

    // encapsular o objeto ususario e dps vai ser tranformado em json e enviado para o cliente,
    // criar um json com os campos do objeto usuario
    @PostMapping
    public ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        Usuario user = usuarioService.salvar(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(user);
        //codigo 201
    }

    @GetMapping("/{id}") //estamos enviando um valor que seria o id que queremos
    public ResponseEntity<Usuario> getById(@PathVariable Long id){
        // @PathVariable vai pegar o json e passar para long
        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.ok().body(user);
        //codigo 201
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Usuario> updatePassword(@PathVariable Long id, @RequestBody Usuario usuario){
        // @PathVariable vai pegar o json e passar para long
        Usuario user = usuarioService.editarSenha(id, usuario.getPassword());
        return ResponseEntity.ok().body(user);
        //codigo 201
    }

    @GetMapping //estamos enviando um valor que seria o id que queremos
    public ResponseEntity<List<Usuario>> getAll(@PathVariable Long id){
        // @PathVariable vai pegar o json e passar para long
        List<Usuario> users = usuarioService.buscarTodos();
        return ResponseEntity.ok().body(users);
        //codigo 201
    }
}

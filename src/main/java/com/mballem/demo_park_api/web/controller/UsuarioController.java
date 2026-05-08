package com.mballem.demo_park_api.web.controller;

import com.mballem.demo_park_api.entity.Usuario;
import com.mballem.demo_park_api.service.UsuarioService;
import com.mballem.demo_park_api.web.dto.UsuarioCreateDto;
import com.mballem.demo_park_api.web.dto.UsuarioResponseDto;
import com.mballem.demo_park_api.web.dto.UsuarioSenhaDto;
import com.mballem.demo_park_api.web.dto.mapper.UsuarioMapper;
import jakarta.validation.Valid;
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
    public ResponseEntity<UsuarioResponseDto> create(@Valid @RequestBody UsuarioCreateDto CreateDto){
        Usuario user = usuarioService.salvar(UsuarioMapper.toUsuario(CreateDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(UsuarioMapper.toDto(user));
        //codigo 201
    }

    @GetMapping("/{id}") //estamos enviando um valor que seria o id que queremos
    public ResponseEntity<UsuarioResponseDto> getById(@PathVariable Long id){
        // @PathVariable vai pegar o json e passar para long
        Usuario user = usuarioService.buscarPorId(id);
        return ResponseEntity.ok().body(UsuarioMapper.toDto(user));
        //codigo 201
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Void> updatePassword(@PathVariable Long id, @RequestBody UsuarioSenhaDto dto){
        // @PathVariable vai pegar o json e passar para long
        Usuario user = usuarioService.editarSenha(id, dto.getSenhaAtual(), dto.getNovaSenha(),dto.getConfirmaSenha());
        return ResponseEntity.noContent().build();
        //codigo 201
    }

    @GetMapping //estamos enviando um valor que seria o id que queremos
    public ResponseEntity<List<UsuarioResponseDto>> getAll(){
        // @PathVariable vai pegar o json e passar para long
        List<Usuario> users = usuarioService.buscarTodos();
        return ResponseEntity.ok().body(UsuarioMapper.toListDto(users));
        //codigo 201
    }
}

package br.com.TaskFlow.taskflow_api.controller;

import br.com.TaskFlow.taskflow_api.dto.UserCreateDto;
import br.com.TaskFlow.taskflow_api.dto.UserResponseDto;
import br.com.TaskFlow.taskflow_api.dto.UserUpdateDto;
import br.com.TaskFlow.taskflow_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping
    public ResponseEntity<List<UserResponseDto>> listar(){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResponseDto> buscar(@PathVariable Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(userId));
    }

    @PostMapping
    public ResponseEntity<UserResponseDto> criar(@Valid @RequestBody UserCreateDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResponseDto> atualizar(@PathVariable Long userId,@Valid @RequestBody UserUpdateDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(userId, dto));
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable Long userId){
        service.deleta(userId);
        return ResponseEntity.noContent().build();
    }
}

package br.com.TaskFlow.taskflow_api.controller;

import br.com.TaskFlow.taskflow_api.dto.TaskCreateDto;
import br.com.TaskFlow.taskflow_api.dto.TaskResponseDto;
import br.com.TaskFlow.taskflow_api.dto.TaskUpdateDto;
import br.com.TaskFlow.taskflow_api.entity.Task;
import br.com.TaskFlow.taskflow_api.entity.User;
import br.com.TaskFlow.taskflow_api.enums.Prioridade;
import br.com.TaskFlow.taskflow_api.enums.Status;
import br.com.TaskFlow.taskflow_api.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("tasks")
public class TaskController {

    @Autowired
    private TaskService service;

    @GetMapping
    public ResponseEntity<List<TaskResponseDto>> listar(@RequestParam(required = false) Prioridade prioridade,@RequestParam(required = false) Status staus ,@RequestParam(required = false) LocalDate data, @RequestParam(required = false) Long userId){
        return ResponseEntity.status(HttpStatus.OK).body(service.listar(prioridade, staus, data, userId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<TaskResponseDto> buscar(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(service.buscar(id));
    }

    @PostMapping
    public ResponseEntity<TaskResponseDto> criar(@Valid @RequestBody TaskCreateDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(dto));
    }

    @PutMapping("/{taskId}")
    public ResponseEntity<TaskResponseDto> atualizar(@PathVariable Long taskId, @Valid @RequestBody TaskUpdateDto dto){
        return ResponseEntity.status(HttpStatus.OK).body(service.atualizar(taskId, dto));
    }

    @DeleteMapping("/{taskId}")
    public ResponseEntity<Void> delete(@PathVariable Long taskId){
        service.delete(taskId);
        return ResponseEntity.noContent().build();
    }
}

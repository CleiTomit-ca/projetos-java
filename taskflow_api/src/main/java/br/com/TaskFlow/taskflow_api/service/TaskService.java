package br.com.TaskFlow.taskflow_api.service;

import br.com.TaskFlow.taskflow_api.dto.TaskCreateDto;
import br.com.TaskFlow.taskflow_api.dto.TaskResponseDto;
import br.com.TaskFlow.taskflow_api.dto.TaskUpdateDto;
import br.com.TaskFlow.taskflow_api.entity.Task;
import br.com.TaskFlow.taskflow_api.entity.User;
import br.com.TaskFlow.taskflow_api.enums.Prioridade;
import br.com.TaskFlow.taskflow_api.enums.Status;
import br.com.TaskFlow.taskflow_api.exception.IdTaskNotFindingException;
import br.com.TaskFlow.taskflow_api.exception.IdUserNotFindingException;
import br.com.TaskFlow.taskflow_api.repository.TaskRepository;
import br.com.TaskFlow.taskflow_api.repository.UserRepository;
import br.com.TaskFlow.taskflow_api.specification.TaskSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TaskService {
    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private UserRepository userRepository;

    public List<TaskResponseDto> listar(Prioridade prioridade, Status status, LocalDate dataCriacao, Long userId){
        User user = null;
        if (userId != null) {
            user = userRepository.findById(userId)
                    .orElseThrow(() -> new IdUserNotFindingException("Usuario não encontrado"));
        }
        Specification<Task> spec = Specification
                .where(TaskSpecification.porPrioridade(prioridade))
                .and(TaskSpecification.porStatus(status))
                .and(TaskSpecification.porDataCriacao(dataCriacao))
                .and(TaskSpecification.porUser(user));

        List<Task> taskList = taskRepository.findAll(spec);

        return taskList.stream()
                .map(t -> new TaskResponseDto(t.getId(), t.getTitulo(), t.getDescricao(), t.getPrioridade(), t.getStatus(), t.getUser(), t.getDataCriacao()))
                .toList();
    }

    public TaskResponseDto buscar(Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IdTaskNotFindingException("Tarefa não encontrada"));
        return new TaskResponseDto(task.getId(), task.getTitulo(), task.getDescricao(), task.getPrioridade(), task.getStatus(), task.getUser(), task.getDataCriacao());
    }

    public TaskResponseDto criar(TaskCreateDto dto){
        User user = null;
        if (dto.userId() != null) {
            user = userRepository.findById(dto.userId())
                    .orElseThrow(() -> new IdUserNotFindingException("Usuario não encontrado"));
        }
        Task task = new Task();
        task.setTitulo(dto.titulo());
        task.setDescricao(dto.descricao());
        task.setPrioridade(dto.prioridade());
        task.setStatus(dto.status());
        task.setUser(user);
        task.setDataCriacao(LocalDate.now());
        Task taskSave = taskRepository.save(task);
        return new TaskResponseDto(taskSave.getId(), taskSave.getTitulo(), taskSave.getDescricao(), taskSave.getPrioridade(), task.getStatus(), taskSave.getUser(), taskSave.getDataCriacao());
    }

    public TaskResponseDto atualizar(Long id,TaskUpdateDto dto){
        User user = null;
        if (dto.userId() != null) {
            user = userRepository.findById(dto.userId())
                    .orElseThrow(() -> new IdUserNotFindingException("Usuario não encontrado"));
        }
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IdTaskNotFindingException("Tarefa não encontrada"));
        task.setTitulo(dto.titulo());
        task.setDescricao(dto.descricao());
        task.setPrioridade(dto.prioridade());
        task.setStatus(dto.status());
        task.setUser(user);
        Task taskSave = taskRepository.save(task);
        return new TaskResponseDto(taskSave.getId(), taskSave.getTitulo(), taskSave.getDescricao(), taskSave.getPrioridade(), task.getStatus(), taskSave.getUser(), taskSave.getDataCriacao());
    }

    public void delete(Long id){
        Task task = taskRepository.findById(id)
                .orElseThrow(() -> new IdTaskNotFindingException("Tarefa não encontrada"));
        taskRepository.delete(task);
    }
}

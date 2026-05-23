package br.com.TaskFlow.taskflow_api.repository;

import br.com.TaskFlow.taskflow_api.entity.Task;
import br.com.TaskFlow.taskflow_api.entity.User;
import br.com.TaskFlow.taskflow_api.enums.Prioridade;
import br.com.TaskFlow.taskflow_api.enums.Status;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface TaskRepository extends JpaRepository<Task, Long> , JpaSpecificationExecutor<Task> {

    Optional<Task> findById(Long id);
    List<Task> findByStatus(Status status);
    List<Task> findByPrioridade(Prioridade prioridade);
    List<Task> findByUser(User user);
    List<Task> findByDataCriacao(LocalDate dataCriacao);
}

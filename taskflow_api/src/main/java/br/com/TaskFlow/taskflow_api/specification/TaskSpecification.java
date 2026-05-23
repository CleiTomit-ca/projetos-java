package br.com.TaskFlow.taskflow_api.specification;

import br.com.TaskFlow.taskflow_api.entity.Task;
import br.com.TaskFlow.taskflow_api.entity.User;
import br.com.TaskFlow.taskflow_api.enums.Prioridade;
import br.com.TaskFlow.taskflow_api.enums.Status;
import org.springframework.data.jpa.domain.Specification;

import java.time.LocalDate;

public class TaskSpecification {

    public static Specification<Task> porPrioridade(Prioridade prioridade){
        return ((root, query, cb) ->
               prioridade == null ? null : cb.equal(root.get("prioridade"), prioridade));
    }

    public static Specification<Task> porStatus(Status status){
        return ((root, query, cb) ->
                status == null ? null : cb.equal(root.get("status"), status));
    }

    public static Specification<Task> porDataCriacao(LocalDate dataCriacao){
        return ((root, query, cb) ->
                dataCriacao == null ? null : cb.equal(root.get("dataCriacao"), dataCriacao));
    }

    public static Specification<Task> porUser(User user){
        return ((root, query, cb) ->
                user == null ? null : cb.equal(root.get("user"), user));
    }
}

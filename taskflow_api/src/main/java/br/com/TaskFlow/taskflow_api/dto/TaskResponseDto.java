package br.com.TaskFlow.taskflow_api.dto;

import br.com.TaskFlow.taskflow_api.entity.User;
import br.com.TaskFlow.taskflow_api.enums.Prioridade;
import br.com.TaskFlow.taskflow_api.enums.Status;
import java.time.LocalDate;

public record TaskResponseDto(
        Long id,
        String titulo,
        String descricao,
        Prioridade prioridade,
        Status status,
        User user,
        LocalDate date
) {
}

package br.com.TaskFlow.taskflow_api.dto;

import br.com.TaskFlow.taskflow_api.entity.Task;
import java.util.List;

public record UserResponseDto(
        Long id,
        String nome,
        String email,
        List<Task> taskList
) {
}

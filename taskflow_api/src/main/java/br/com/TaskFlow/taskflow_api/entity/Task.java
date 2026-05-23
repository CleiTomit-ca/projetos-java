package br.com.TaskFlow.taskflow_api.entity;

import br.com.TaskFlow.taskflow_api.enums.Prioridade;
import br.com.TaskFlow.taskflow_api.enums.Status;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tasks")
@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "título obrigatório")
    private String titulo;

    @NotBlank(message = "descrição obrigatória")
    private String descricao;
    private Prioridade prioridade;
    private Status status = Status.PENDING;

    @ManyToOne
    private User user;
    private LocalDate dataCriacao;
}

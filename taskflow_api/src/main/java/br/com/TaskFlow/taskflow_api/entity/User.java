package br.com.TaskFlow.taskflow_api.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
import java.util.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "nome obrigatório")
    private String nome;

    @NotBlank(message = "email obrigatório")
    private String email;

    @OneToMany
    List<Task> taskList = new ArrayList<>();
}

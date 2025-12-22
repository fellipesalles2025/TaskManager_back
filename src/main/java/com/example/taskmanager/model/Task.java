package com.example.taskmanager.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "tb_tasks")
@Data
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTask;

    @NotBlank(message = "O título não pode estar em branco")
    private String title;

    @NotBlank(message = "A descrição não pode estar em branco")
    private String description;

    @Column(name = "is_completed")
    private boolean isCompleted;

    @Column(name = "creation_date")
    private LocalDate creationDate;

    @PrePersist
    public void prePersist() {
        this.creationDate = LocalDate.now();
        this.isCompleted = false;
    }
}

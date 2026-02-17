package za.co.mafsoft.jee8.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import javax.json.bind.annotation.JsonbDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Entity
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotEmpty(message = "Task must not be empty")
    @Size(message = "Task should not be less than 10 characters", min = 10)
    private String task;
    @NotNull(message = "Due date must be set")
    @FutureOrPresent(message = "Due date should be a present or future date")
    @JsonbDateFormat(value = "yyyy-MM-dd")
    private LocalDate dueDate;
    private boolean completed;
    @JsonbDateFormat(value = "yyyy-MM-dd")
    @PastOrPresent(message = "Completed date should be a present or past date")
    private LocalDate dateCompleted;
    private LocalDateTime dateCreated;
    private LocalDateTime dateUpdated;

    @PrePersist
    private void init() {
        setDateCreated(LocalDateTime.now());
    }

    @PreUpdate
    private void onUpdate() {
        setDateUpdated(LocalDateTime.now());
    }
}

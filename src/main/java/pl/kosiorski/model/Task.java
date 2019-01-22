package pl.kosiorski.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.validation.constraints.NotEmpty;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks")
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "task_id")
  private Long id;

  @NotEmpty private String subject;

  @ManyToOne private Project project;

  @NotEmpty private String description;

  @ManyToOne private Status status;

  @ManyToOne private Priority priority;

  @ManyToOne private User user;

  @CreationTimestamp private LocalDateTime created;
}

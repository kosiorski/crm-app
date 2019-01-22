package pl.kosiorski.model;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "projects")
public class Project {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "project_id")
  private Long id;

  @NotBlank private String name;

  @NotBlank private String description;

  @NotBlank private String urlAddress;

  private String identifier;

  @OneToMany(mappedBy = "project")
  private List<Task> tasks = new ArrayList<>();

  @ManyToMany
  @JoinTable(
      name = "project_user",
      joinColumns = @JoinColumn(name = "project_id"),
      inverseJoinColumns = @JoinColumn(name = "user_id"))
  private List<User> users = new ArrayList<>();

  @CreationTimestamp private LocalDateTime created;

  private Boolean isActive;
}

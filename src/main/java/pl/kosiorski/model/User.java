package pl.kosiorski.model;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "users")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "user_id")
  private Long id;

  @Length(min = 5, message = "*Your login must have at least 5 characters")
  @NotEmpty(message = "*Please provide your login")
  @Column(nullable = false, unique = true)
  private String login;

  @Length(min = 5, message = "*Your password must have at least 5 characters")
  @NotEmpty(message = "*Please provide your password")
  private String password;

  @Email(message = "*Please provide a valid Email")
  @NotEmpty(message = "*Please provide an email")
  private String email;

  @NotEmpty(message = "*Please provide your first name")
  private String firstName;

  @NotEmpty(message = "*Please provide your last name")
  private String lastName;

  private Boolean isActive;

  @ManyToMany
  @JoinTable(
      name = "user_role",
      joinColumns = @JoinColumn(name = "user_id"),
      inverseJoinColumns = @JoinColumn(name = "role_id"))
  private Set<Role> roles;

  @ManyToMany(mappedBy = "users")
  private List<Project> projects = new ArrayList<>();

  @OneToMany(mappedBy = "user")
  private List<Task> tasks = new ArrayList<>();
}

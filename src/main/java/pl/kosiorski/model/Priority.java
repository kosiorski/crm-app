package pl.kosiorski.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "priorities")
public class Priority {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "priority_id")
  private Long id;

  @NotBlank private String name;

  private Boolean isActive;

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }
}

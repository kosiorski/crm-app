package pl.kosiorski.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Data
@Entity
@Table(name = "statuses")
public class Status {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "status_id")
  private Long id;

  @NotBlank private String name;

  private int sortOrder;

  private Boolean isActive;

  public Boolean getActive() {
    return isActive;
  }

  public void setActive(Boolean active) {
    isActive = active;
  }
}

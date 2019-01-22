package pl.kosiorski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kosiorski.model.Project;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Integer> {

  List<Project> findFirst5ByOrderByCreatedDesc();

  Project findById(Long id);

}

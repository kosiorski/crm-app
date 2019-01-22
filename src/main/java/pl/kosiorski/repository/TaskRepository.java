package pl.kosiorski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kosiorski.model.Task;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Integer> {

  List<Task> findAllByProjectId(Long id);

  Task findById(Long id);
}

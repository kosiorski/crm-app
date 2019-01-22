package pl.kosiorski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kosiorski.model.Priority;

import java.util.List;

public interface PriorityRepository extends JpaRepository<Priority, Integer> {

  List<Priority> findAllByIsActiveTrue();

  Priority findById(Long id);
}

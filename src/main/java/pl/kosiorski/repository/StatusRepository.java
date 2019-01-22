package pl.kosiorski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.kosiorski.model.Status;

import java.util.List;

public interface StatusRepository extends JpaRepository<Status, Integer> {
  List<Status> findAllByIsActiveTrue();

  Status findById(Long id);
}

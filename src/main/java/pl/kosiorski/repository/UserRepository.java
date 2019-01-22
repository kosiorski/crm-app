package pl.kosiorski.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.kosiorski.model.Project;
import pl.kosiorski.model.User;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

  User findByLogin(String login);

  List<User> getAllByProjects(Project project);

  @Query("SELECT u FROM User u JOIN u.projects p WHERE p.id=:id")
  List<User> findAllByProjectId(@Param("id") Long id);
}

package pl.kosiorski.service;

import pl.kosiorski.model.Project;
import pl.kosiorski.model.User;

import java.util.List;

public interface UserService {

  List<User> findAll();

  User findByUserName(String name);

  User findByLogin(String login);

  void saveUser(User user);

  List<User> findByProject(Project project);

  List<User> findByProjectId(Long id);

}

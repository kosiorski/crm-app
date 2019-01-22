package pl.kosiorski.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.kosiorski.model.Project;
import pl.kosiorski.model.Role;
import pl.kosiorski.model.User;
import pl.kosiorski.repository.RoleRepository;
import pl.kosiorski.repository.UserRepository;
import pl.kosiorski.service.UserService;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

  private UserRepository userRepository;
  private RoleRepository roleRepository;
  private BCryptPasswordEncoder bCryptPasswordEncoder;

  @Autowired
  public UserServiceImpl(
      UserRepository userRepository,
      RoleRepository roleRepository,
      BCryptPasswordEncoder bCryptPasswordEncoder) {
    this.userRepository = userRepository;
    this.roleRepository = roleRepository;
    this.bCryptPasswordEncoder = bCryptPasswordEncoder;
  }

  @Override
  public List<User> findAll() {
    return userRepository.findAll();
  }

  @Override
  public User findByUserName(String login) {
    return userRepository.findByLogin(login);
  }

  @Override
  public User findByLogin(String login) {
    return userRepository.findByLogin(login);
  }

  @Override
  public void saveUser(User user) {
    user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
    user.setIsActive(true);
    Role userRole = roleRepository.findByRole("ADMIN");
    user.setRoles(new HashSet<Role>(Collections.singletonList(userRole)));
    userRepository.save(user);
  }

  @Override
  public List<User> findByProject(Project project) {
    return userRepository.getAllByProjects(project);
  }

  @Override
  public List<User> findByProjectId(Long id) {
    return userRepository.findAllByProjectId(id);
  }
}

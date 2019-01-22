package pl.kosiorski.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.kosiorski.model.Project;
import pl.kosiorski.repository.ProjectRepository;
import pl.kosiorski.service.ProjectService;

import java.util.List;

@Service
public class ProjectServiceImpl implements ProjectService {

  private ProjectRepository projectRepository;

  @Autowired
  public ProjectServiceImpl(ProjectRepository projectRepository) {
    this.projectRepository = projectRepository;
  }

  @Override
  public List<Project> lastFive() {
    return projectRepository.findFirst5ByOrderByCreatedDesc();
  }

  @Override
  public List<Project> findAll() {
    return projectRepository.findAll();
  }

  @Override
  public Project save(Project project) {
    project.setIsActive(true);
    return projectRepository.save(project);
  }

  public String createIdentifier(String urlAddress) {
    return StringUtils.stripAccents(urlAddress).replace("\\s", "-");
  }

  @Override
  public Project findOne(Long id) {
    return projectRepository.findById(id);
  }
}

package pl.kosiorski.service;

import pl.kosiorski.model.Project;

import java.util.List;

public interface ProjectService {

  List<Project> lastFive();

  List<Project> findAll();

  Project save(Project project);

  String createIdentifier(String text);

  Project findOne(Long id);
}

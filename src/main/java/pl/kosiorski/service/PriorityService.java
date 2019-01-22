package pl.kosiorski.service;

import pl.kosiorski.model.Priority;

import java.util.List;

public interface PriorityService {
  List<Priority> findAll();

  List<Priority> findAllActive();

  Priority save(Priority priority);

  void changeActive(Long priorityId);
}

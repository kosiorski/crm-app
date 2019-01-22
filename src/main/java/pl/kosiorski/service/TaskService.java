package pl.kosiorski.service;

import pl.kosiorski.model.Task;

import java.util.List;

public interface TaskService {
  Task save(Task task);

  List<Task> findAllByProjectId(Long id);

  Task findOne(Long id);
}
